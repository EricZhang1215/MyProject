package com.dxc.converter.constant;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dxc.utils.FileUtil;

@Component
public class VPMSConstant {

	// constant for VPMS restful API
	public static String VPM_FILE_NAME;
	@Value("${com.dxc.constant.VPM_FILE_NAME}")
    public void setVPM_FILE_NAME(String input) {
		VPM_FILE_NAME = input;
    }

	public static String CALLING_SYSTEM;
	@Value("${com.dxc.constant.CALLING_SYSTEM}")
    public void setCALLING_SYSTEM(String input) {
		CALLING_SYSTEM = input;
    }

	public static String CONTRACT_TYPE;
	@Value("${com.dxc.constant.CONTRACT_TYPE}")
    public void setCONTRACT_TYPE(String input) {
		CONTRACT_TYPE = input;
    }

	public static String REGION;
	@Value("${com.dxc.constant.REGION}")
    public void setREGION(String input) {
		REGION = input;
    }

	public static String LOCALE;
	@Value("${com.dxc.constant.LOCALE}")
    public void setLOCALE(String input) {
		LOCALE = input;
    }

	public static String LANGUAGE;
	@Value("${com.dxc.constant.LANGUAGE}")
    public void setLANGUAGE(String input) {
		LANGUAGE = input;
    }

	public static String SOURCE_BUSINESS;
	@Value("${com.dxc.constant.SOURCE_BUSINESS}")
    public void setSOURCE_BUSINESSE(String input) {
		SOURCE_BUSINESS = input;
    }
	
	public static String LOAD_PERCENT;
	@Value("${com.dxc.constant.LOAD_PERCENT}")
    public void setLOAD_PERCENT(String input) {
		LOAD_PERCENT = input;
    }
	public static String REFUND_AGE;
	@Value("${com.dxc.constant.REFUND_AGE}")
    public void setREFUND_AGE(String input) {
		REFUND_AGE = input;
    }
	public static String MORTALITY_CLASS;
	@Value("${com.dxc.constant.MORTALITY_CLASS}")
    public void setMORTALITY_CLASS(String input) {
		MORTALITY_CLASS = input;
    }

	public static String vpmsUrl;
	@Value("${com.dxc.vpms_url}")
    public void setVpmsUrl(String input) {
		vpmsUrl = input;
    }

	// template for VPMS restful API
	public static String PRMCAL_premiumRiskAmount;
	@Value("${com.dxc.template.PRMCAL.premiumRiskAmount}")
    public void setPremiumRiskAmount(String input) {
		PRMCAL_premiumRiskAmount = input;
    }
	public static String PRMCAL_quotedCashvalue;
	@Value("${com.dxc.template.PRMCAL.quotedCashvalue}")
    public void setCashvalue(String input) {
		PRMCAL_quotedCashvalue = input;
    }

	public static final String REG_EX= "\\{\\{([^}]*)\\}\\}";
	
    private static Map<String, Map<String, Integer>> templateMap = new HashMap<String, Map<String, Integer>>();
    private static Map<String, String> templateStringMap = new HashMap<String, String>();
    
	public static Map<String, Map<String, Integer>> getTemplateMap() {
		return templateMap;
	}

	public static Map<String, Integer> getIndexKeyMap(String templateFileName) {
		if (!getTemplateMap().containsKey(templateFileName)) {
			setIndexInMapByTemplate(templateFileName);
		}
		return getTemplateMap().get(templateFileName);
	}

	public static String getTemplateAsString(String templateFileName) {
		if (templateStringMap.containsKey(templateFileName)) {
			return templateStringMap.get(templateFileName);
		} else {
			try {
				String json_template = JSONObject
						.parseArray(FileUtil.loadTextFileContext("classpath:" + templateFileName, true)).toString();
				templateStringMap.put(templateFileName, json_template);
				return json_template;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}
	
	/**
	 * 
	 * @param templateFileName
	 */
	private static void setIndexInMapByTemplate(String templateFileName) {
		try {
	        Map<String,Integer> indexKeyMap = new HashMap<String,Integer>();
			JSONArray calculatePremiumArray = JSONObject
					.parseArray(FileUtil.loadTextFileContext("classpath:" + templateFileName, true));
			for (int i = 0; i < calculatePremiumArray.size(); i++) {
				if (calculatePremiumArray.getJSONArray(i).get(0).toString().equalsIgnoreCase("?=")) {
					indexKeyMap.put(calculatePremiumArray.getJSONArray(i).get(1).toString(), i);
				}
			}
			templateMap.put(templateFileName, indexKeyMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
