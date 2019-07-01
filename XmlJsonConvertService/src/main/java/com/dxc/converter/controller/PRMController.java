package com.dxc.converter.controller;

import com.alibaba.fastjson.JSONObject;
import com.dxc.converter.model.PRMCALIREC;
import com.dxc.converter.model.PRMCALOREC;
import com.dxc.converter.service.PRMService;
import com.dxc.utils.JacksonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 4/8/2019
 *
 * @author qzhang52
 * @version 1.0
 */
@RestController
@RequestMapping("/PRM")
public class PRMController {
    private PRMService prmService;
    @Autowired
    public PRMController(PRMService prmService){
        this.prmService = prmService;
    }

    @PostMapping(value = "convert")
    public PRMCALOREC convertWithVPMS(@RequestBody PRMCALIREC prmcalirec) {
        return prmService.convertPRM(prmcalirec);
    }

    @PostMapping(value = "prmJsonConvert")
    public PRMCALOREC prmJsonConvertWithVPMS(@RequestBody String jsonStr) {
        PRMCALIREC prmcalirec = JacksonUtil.json2Bean(jsonStr, new TypeReference<PRMCALIREC>() {});
        return prmService.convertPRM(prmcalirec);
    }
}
