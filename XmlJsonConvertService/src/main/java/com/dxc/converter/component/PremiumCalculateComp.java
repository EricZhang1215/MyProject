package com.dxc.converter.component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dxc.converter.constant.VPMSConstant;
import com.dxc.converter.constant.VPMSOutputConstant;
import com.dxc.converter.enums.VPMSExceptionEnum;
import com.dxc.converter.exception.VPMSAPIException;
import com.dxc.converter.log.annotation.OperationLogDetail;
import com.dxc.converter.log.enums.OperationType;
import com.dxc.converter.log.enums.OperationUnit;
import com.dxc.converter.model.ERROR;
import com.dxc.converter.model.ObjectFactory;
import com.dxc.converter.model.PRMCALIREC;
import com.dxc.converter.model.PRMCALOREC;
import com.dxc.converter.model.PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.INSRSKAMNT;
import com.dxc.converter.model.PRMCALOREC.PREMIUM.OWNRSKAMNT;
import com.dxc.converter.model.REASON;
import com.dxc.utils.DyMethodUtil;

@Component
public class PremiumCalculateComp {

	Logger logger = LoggerFactory.getLogger(PremiumCalculateComp.class);

	@Autowired
    private void initRestTemplate(RestTemplateBuilder builder){
        this.restTemplate=builder.build();
    }
       
    private RestTemplate restTemplate;

    /**
	 * get the value from xml, and call the rest service in VPMS.
	 * 
	 * @param prmcalrq
	 * @return
	 */
	@OperationLogDetail(detail = "封装请求列表", level = 2, operationUnit = OperationUnit.COMPONENT, operationType = OperationType.UNKNOWN)
	public String[][] requestReady(PRMCALIREC prmcalrq, String templateFile) {
		try {
			String[][] coverage_array = null;
			PRMCALIREC.PREMIUM premium = prmcalrq.getPREMIUM();
			int insuredArraySize = premium.getINSUREDLIST().getINSURED().size();
			
			// template : map the value
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("premium", premium);
			map.put("VPMSConstant", VPMSConstant.class);
			
			for (int i = 0; i < insuredArraySize; i++) {
				PRMCALIREC.PREMIUM.INSUREDLIST.INSURED insured = premium.getINSUREDLIST().getINSURED().get(i);
				map.put("insured", insured);
				int coverageListSize = insured.getCOVERAGELIST().getCOVERAGEINFO().size();
				coverage_array = new String[insuredArraySize][coverageListSize];
				for (int j = 0; j < coverageListSize; j++) {
					PRMCALIREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO coverageinfo = insured
							.getCOVERAGELIST().getCOVERAGEINFO().get(j);
					map.put("coverageinfo", coverageinfo);
					StringBuffer sb = new StringBuffer();
					// compile for each coverage
					Matcher m = Pattern.compile(VPMSConstant.REG_EX).matcher(VPMSConstant.getTemplateAsString(templateFile));;
					while (m.find()) {
						String value_soap = DyMethodUtil.invokeMethod(m.group().substring(2, m.group().length()-2), map).toString();
						m.appendReplacement(sb, value_soap);
					}
					m.appendTail(sb);
					coverage_array[i][j] = sb.toString();
				}
			}
			return coverage_array;
		} catch (Exception e) {
			logger.error(e.getStackTrace().toString());
			throw new VPMSAPIException(VPMSExceptionEnum.UNKNOWN_EXCEPTION);
		}
	}
	
	/**
	 * Mapping the data value from PRMCALIREC to PRMCALOREC
	 * 
	 * @param prmcalirec
	 * @return
	 */
	private PRMCALOREC mappingDataObject(PRMCALIREC prmcalirec) {

		// Mapper the value from PRMCALIREC to PRMCALOREC
		Mapper mapper = new DozerBeanMapper();
		PRMCALOREC prmcalorec = mapper.map(prmcalirec, PRMCALOREC.class);
		List<PRMCALIREC.PREMIUM.INSUREDLIST.INSURED> insuredList = prmcalirec.getPREMIUM().getINSUREDLIST()
				.getINSURED();
		for (int i = 0; i < insuredList.size(); i++) {
			PRMCALIREC.PREMIUM.INSUREDLIST.INSURED input_insured = insuredList.get(i);
			PRMCALOREC.PREMIUM.INSUREDLIST.INSURED insured = mapper.map(input_insured,
					PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.class);
			prmcalorec.getPREMIUM().getINSUREDLIST().getINSURED().add(insured);

			List<PRMCALIREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO> coverageinfoList = input_insured
					.getCOVERAGELIST().getCOVERAGEINFO();
			for (int j = 0; j < coverageinfoList.size(); j++) {
				PRMCALIREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO input_coverageinfo = coverageinfoList
						.get(j);
				PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO coverageinfo = mapper.map(
						input_coverageinfo, PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.class);
				insured.getCOVERAGELIST().getCOVERAGEINFO().add(coverageinfo);
			}
		}
		return prmcalorec;
	}
	

	/**
	 * merge the rest response from VPMS, and generate the SOAP response for web
	 * service.
	 * 
	 * @param prmcalrq
	 * @param res_calculate
	 * @param req_calculate
	 * @return
	 */
	@OperationLogDetail(detail = "计算结果列表返回", level = 2, operationUnit = OperationUnit.COMPONENT, operationType = OperationType.UNKNOWN)
	public PRMCALOREC responseMerge(PRMCALIREC prmcalirec, String[][] res_premiumRiskAmount, String[][] res_cashvalue) {

		// create response and set value from request
		PRMCALOREC prmcalorec = mappingDataObject(prmcalirec);

		prmcalorec.setSTATUS("0");
		prmcalorec.setMOREIND("N");
		// PREMIUM ERROR is 0
		prmcalorec.getPREMIUM().setPDESC(null);
		prmcalorec.getPREMIUM().setERRCODE("0");

		ObjectFactory objectFactory = new ObjectFactory();
		BigDecimal total = new BigDecimal("0");
		List<REASON> reasons = new ArrayList<REASON>();
		List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED> insuredList = prmcalorec.getPREMIUM().getINSUREDLIST().getINSURED();
		for (int i = 0; i < insuredList.size(); i++) {
			PRMCALOREC.PREMIUM.INSUREDLIST.INSURED insured = insuredList.get(i);
			List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO> coverageInfoList = insuredList.get(i).getCOVERAGELIST().getCOVERAGEINFO();
			HashMap<String, BigInteger> insRskAmountMap = new HashMap<String, BigInteger>();
			for (int j = 0; j < coverageInfoList.size(); j++) {
				PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO coverageinfo = coverageInfoList.get(j);
				// 1. set premium
				JSONArray premiumRiskAmountArray = JSONArray.parseArray(res_premiumRiskAmount[i][j]);
				int premium_index = VPMSConstant.getIndexKeyMap(VPMSConstant.PRMCAL_premiumRiskAmount).get(VPMSOutputConstant.OUTPUT_PREMIUM).intValue();
				JSONArray premiumArray = premiumRiskAmountArray.getJSONArray(premium_index);
				if (premiumArray.getIntValue(1) == 0) {
					coverageinfo.setINSTPRM(premiumArray.getString(0));
				} else {
					// error handle
					prmcalorec.getPREMIUM().setPDESC(VPMSExceptionEnum.VPMS_PREMIUM_EXCEPTION.getErrorMsg() + ", 产品代码" + coverageinfo.getZNPRDCODE() + "，错误信息：" + premiumArray.getString(2) + " | " + premiumArray.getString(3));
					prmcalorec.getPREMIUM().setERRCODE(VPMSExceptionEnum.VPMS_PREMIUM_EXCEPTION.getErrorCode());
					return prmcalorec;
				}
				total = total.add(new BigDecimal(coverageinfo.getINSTPRM()));
				
				// 2. set risk amount to Map
				// "{\"ASCI\" : 300000,\"TSCI\" : 300000,\"ATCI\" : 300000,\"TQCI\" : 300000}"
				int riskAmount_index = VPMSConstant.getIndexKeyMap(VPMSConstant.PRMCAL_premiumRiskAmount).get(VPMSOutputConstant.OUTPUT_RISK_AMOUNT).intValue();
				JSONArray riskAmountArray = premiumRiskAmountArray.getJSONArray(riskAmount_index);
				if (riskAmountArray.getIntValue(1) == 0) {
					JSONObject riskAmountJson = JSONObject.parseObject(riskAmountArray.getString(0));
					Iterator<String> it = riskAmountJson.keySet().iterator();
					while(it.hasNext()) {
						String ZNPRDCODE = it.next();
						if (insRskAmountMap.containsKey(ZNPRDCODE)) {
							insRskAmountMap.put(ZNPRDCODE, riskAmountJson.getBigInteger(ZNPRDCODE).add(insRskAmountMap.get(ZNPRDCODE)));
						} else {
							insRskAmountMap.put(ZNPRDCODE, riskAmountJson.getBigInteger(ZNPRDCODE));
						}
					}				
				} else {
					// error handle
					prmcalorec.getPREMIUM().setPDESC(VPMSExceptionEnum.VPMS_RISKAMOUNT_EXCEPTION.getErrorMsg() + ", 产品代码" + coverageinfo.getZNPRDCODE() + "，错误信息：" + riskAmountArray.getString(2) + " | " + riskAmountArray.getString(3));
					prmcalorec.getPREMIUM().setERRCODE(VPMSExceptionEnum.VPMS_RISKAMOUNT_EXCEPTION.getErrorCode());
					return prmcalorec;
				}				

				// 3. set cash value
				if (null != res_cashvalue) {
					JSONArray response_jsonArray = JSONArray.parseArray(res_cashvalue[i][j]);
					int caseValue_index = VPMSConstant.getIndexKeyMap(VPMSConstant.PRMCAL_quotedCashvalue).get(VPMSOutputConstant.OUTPUT_QUOTED_CASEVALUE).intValue();
					JSONArray cashValue_jsonArray = response_jsonArray.getJSONArray(caseValue_index);
					if (cashValue_jsonArray.getIntValue(1) == 0) {
						// [[1,726.00],[2,2613.00],[3,4419.00],[4,6819.00],[5,9144.00],[6,11298.00],[7,13299.00],[8,15099.00],[9,16650.00],[10,17889.00],[11,19059.00],[12,19941.00],[13,20463.00],[14,20454.00],[15,19803.00],[16,18300.00],[17,15816.00],[18,12126.00],[19,6969.00],[20,0.00]]",
						JSONArray cashValueJson = JSONObject.parseArray(cashValue_jsonArray.getString(0));
						PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST cashvaluelist = objectFactory
								.createPRMCALORECPREMIUMINSUREDLISTINSUREDCOVERAGELISTCOVERAGEINFOCASHVALUELIST();
						for (int k = 0; k < cashValueJson.size(); k++) {
							PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST.CVYEAR cvyear = objectFactory
									.createPRMCALORECPREMIUMINSUREDLISTINSUREDCOVERAGELISTCOVERAGEINFOCASHVALUELISTCVYEAR();
							cvyear.setYEAR(cashValueJson.getJSONArray(k).getBigInteger(0));
							cvyear.setZDCSHVA(cashValueJson.getJSONArray(k).getString(1));
							cashvaluelist.getCVYEAR().add(cvyear);
						}

						coverageinfo.setCASHVALUELIST(cashvaluelist);
					} else {
						// error handle
						prmcalorec.getPREMIUM().setPDESC(VPMSExceptionEnum.VPMS_CASHVALUE_EXCEPTION.getErrorMsg() + ", 产品代码" + coverageinfo.getZNPRDCODE() + "，错误信息：" + cashValue_jsonArray.getString(2) + " | " + cashValue_jsonArray.getString(3));
						prmcalorec.getPREMIUM().setERRCODE(VPMSExceptionEnum.VPMS_CASHVALUE_EXCEPTION.getErrorCode());
						return prmcalorec;
					}
				}
				
				// 4. default
				coverageinfo.setBCESSAGE("");
				coverageinfo.setBCESSTRM("");

				coverageinfo.setPCESSAGE(coverageinfo.getPCESSAGE().equals("0") ? "" : coverageinfo.getPCESSAGE());
				coverageinfo.setPCESSTRM(coverageinfo.getPCESSTRM().equals("0") ? "" : coverageinfo.getPCESSTRM());
				coverageinfo.setRCESSAGE(coverageinfo.getRCESSAGE().equals("0") ? "" : coverageinfo.getRCESSAGE());
				coverageinfo.setRCESSTRM(coverageinfo.getRCESSTRM().equals("0") ? "" : coverageinfo.getRCESSTRM());				
			}

			// 4. get RSKAMNT from Map, and set RSKAMNT to PREMIUM		
			for(Map.Entry<String, BigInteger> entry : insRskAmountMap.entrySet()){
				INSRSKAMNT insrskamnt = objectFactory.createPRMCALORECPREMIUMINSUREDLISTINSUREDINSRSKAMNT();
				insrskamnt.setZNRSKCD02(entry.getKey());
				insrskamnt.setSUMINS02(entry.getValue());
				insured.getINSRSKAMNT().add(insrskamnt);
			}
		}
		prmcalorec.getPREMIUM().setTOTAL(total.setScale(2));

		return prmcalorec;
	}

	/**
	 * post restful API to VPMS Core system.
	 * 
	 * @param req_array
	 * @return
	 */
	@OperationLogDetail(detail = "访问VPMS-XE服务器", level = 3, operationUnit = OperationUnit.RESTAPI, operationType = OperationType.CALCULATE)
	public String[][] postCalculateRestAPI(String[][] req_array) {
		String[][] res_array = new String[req_array.length][req_array[0].length];
		for (int i = 0; i < req_array.length; i++) {
			for (int j = 0; j < req_array[i].length; j++) {
				logger.info("req_array[{}][{}]={}", i, j, req_array[i][j]);
				res_array[i][j] = restTemplate.postForEntity(VPMSConstant.vpmsUrl, req_array[i][j], String.class).getBody();
				logger.info("res_array[{}][{}]={}", i, j, res_array[i][j]);
			}
		}
		return res_array;
	}

	private REASON generateReason(String errorCode, String errorDesc) {

		ObjectFactory objectFactory = new ObjectFactory();
		REASON reason = objectFactory.createREASON();
		reason.setERRORDESC(errorDesc);
		reason.setERROREROR(errorCode);
		return reason;
	}
}
