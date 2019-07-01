package com.dxc.converter;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxc.converter.model.PRMCALIREC;
import com.dxc.utils.JacksonUtil;

/**
 * @Author yche2
 * @Date 3/22/2019 15:49
 * @Description TODO
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConverterServiceAppTest {
	
    @Test
    public void testRest() throws IOException {
        PRMCALIREC req = new PRMCALIREC();

        /********************测试数据*******************/
        PRMCALIREC.PREMIUM premium = new PRMCALIREC.PREMIUM();
        premium.setCNTBRANCH("SY");
        premium.setTTMPRCNO("081000243242");
        premium.setOCCDATE(BigInteger.valueOf(20190319));
        premium.setSRCEBUS("1");
        premium.setCNTCURR("CNY");
        premium.setBILLFREQ("01");
        premium.setBILLCURR("CNY");

        PRMCALIREC.PREMIUM.POLICYOWNER policyowner = new PRMCALIREC.PREMIUM.POLICYOWNER();
        policyowner.setOWNERSEL("02651759");
        policyowner.setDOB(BigInteger.valueOf(19880910));
        policyowner.setAGE(BigInteger.valueOf(30));
        policyowner.setCLTSEX("F");
        policyowner.setOCCUP("A001");

        PRMCALIREC.PREMIUM.INSUREDLIST insuredlist = new PRMCALIREC.PREMIUM.INSUREDLIST();
        PRMCALIREC.PREMIUM.INSUREDLIST.INSURED  insured = new PRMCALIREC.PREMIUM.INSUREDLIST.INSURED();
        insured.setLIFE("01");
        insured.setOCCUPD("V092");
        insured.setSEX("F");
        insured.setCLTDOB(BigInteger.valueOf(20180512));
        insured.setINSAGE(BigInteger.valueOf(15));

        PRMCALIREC.PREMIUM.INSUREDLIST.INSURED.PACKAGEINFO packageinfo = new PRMCALIREC.PREMIUM.INSUREDLIST.INSURED.PACKAGEINFO();
        packageinfo.setTOTPRE(BigDecimal.valueOf(0));
        packageinfo.setZTOTSI(BigInteger.valueOf(0));

        PRMCALIREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST coveragelist = new PRMCALIREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST();
        PRMCALIREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO coverageinfo = new PRMCALIREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO();
        coverageinfo.setCOVERAGE("01");
        coverageinfo.setCCDATE(BigInteger.valueOf(20190319));
        coverageinfo.setRIDER("00");
        coverageinfo.setZNPRDCODE("PWL03AA");
        coverageinfo.setSUMIN(BigInteger.valueOf(10100));
        coverageinfo.setZNRFAGE(BigInteger.valueOf(0));
        coverageinfo.setZNDISPER(BigDecimal.valueOf(1));
        coverageinfo.setRCESSAGE(BigInteger.valueOf(106));
        coverageinfo.setRCESSTRM(BigInteger.valueOf(0));
        coverageinfo.setPCESSAGE(BigInteger.valueOf(0));
        coverageinfo.setPCESSTRM(BigInteger.valueOf(20));
        coverageinfo.setZNJLAGE(BigInteger.valueOf(0));
        coveragelist.getCOVERAGEINFO().add(coverageinfo);

        insured.setCOVERAGELIST(coveragelist);
        insuredlist.getINSURED().add(insured);
        premium.setINSUREDLIST(insuredlist);
        req.setPREMIUM(premium);
//        /***************************************/
//        //rest传object的形式
//        String url = "http://127.0.0.1:8181/PRM/convert";
//        RestTemplate restTemplate = new RestTemplate();
//        PRMCALOREC res = restTemplate.postForObject(url, req, PRMCALOREC.class);
        //rest传json的形式
        String url2 = "http://127.0.0.1:8181/PRM/prmJsonConvert";
        String jsonStr = JacksonUtil.bean2Json(req);

        HttpPost httpPost = new HttpPost(url2);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        StringEntity entity = new StringEntity(jsonStr, "UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);

        String result = EntityUtils.toString(response.getEntity());

    }
}
