package com.dxc.videoservice.Controller;

import io.swagger.annotations.Api;
import org.apache.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * 视频客服页面调用接口
 *
 * @author He Biao
 * @date 2018-09-02
 */
@RestController
@Api(value = "/view", tags = {"视频客服前端服务"})
@RequestMapping(value = "/view")
public class viewController {

    @ApiIgnore
    @RequestMapping(value = "/videoCenter", method = RequestMethod.GET)
    public ModelAndView videoCenter(String agentCode, String userId, String csOrgnPartyId){
        ModelAndView mv = new ModelAndView("/front/videoModule");
        mv.getModel().put("agentCode",agentCode);
        mv.getModel().put("userId",userId);
        mv.getModel().put("csOrgnPartyId",csOrgnPartyId);
        return mv;
    }

}
