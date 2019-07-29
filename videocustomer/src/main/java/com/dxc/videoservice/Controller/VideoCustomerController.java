package com.dxc.videoservice.Controller;

import com.dxc.videoservice.constants.Constants;
import com.dxc.videoservice.service.ApiVideoCustomerService;
import com.dxc.videoservice.vo.MessageQueueVo;
import com.dxc.videoservice.vo.Result;
import com.dxc.videoservice.vo.UserVo;
import com.dxc.videoservice.vo.putMQVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


/**
 * 视频客服对外接口
 *
 * @author He Biao
 * @date 2018-08-23
 */

@RestController
@Api(value = "/videoCustomer", tags = {"视频客服"})
@RequestMapping(value = "/videoCustomer")
public class VideoCustomerController {

    public static final Logger LOGGER = LoggerFactory.getLogger(VideoCustomerController.class);

    @Autowired
    ApiVideoCustomerService apiVideCustomerService;

    /**
     * 返回sessionId给小程序
     * @param user
     * @return
     */
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "获取session会话")
    @RequestMapping(value = "/getSession", method = RequestMethod.POST)
    public Result<Object> getSession(@RequestBody UserVo user){
        Result<Object> res = new Result<Object>();
        try{
            if(StringUtils.isEmpty(user.getAppId())){
                res.setCode(Constants.RESULT_TYPE_FAILURE);
                res.setMsg(Constants.RESULT_MSG_FAILURE);
                res.setData("appId 不能为空");
                return res;
            }
            //获取session信息
            Map<String, String> sessionMap = apiVideCustomerService.getSessionId(user.getAppId(), user.getPhoneNumber());
            //解析返回信息
            if("0".equals(sessionMap.get("error"))){
                res.setCode(Constants.RESULT_TYPE_SUCCESS);
                res.setMsg(Constants.RESULT_MSG_SUCCESS);
                res.setData(sessionMap.get("session"));
            }else{
                res.setCode(Constants.RESULT_TYPE_FAILURE);
                res.setMsg(Constants.RESULT_MSG_FAILURE);
                res.setData(sessionMap.get("message"));
            }
        }catch (Exception e){
            LOGGER.error("查询获取session会话异常:",e);
            res.setCode(Constants.RESULT_TYPE_FAILURE);
            res.setMsg(Constants.RESULT_MSG_FAILURE);
        }
        return res;
    }

    /**
     * 获取队列消息
     * @return
     */
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "获取队列信息")
    @RequestMapping(value = "/getMQMessage", method = RequestMethod.GET)
    public Result<Object> getMQMessage(){
        Result<Object> res = new Result<Object>();
        try{
            Map<String, String> mqMessage = apiVideCustomerService.getMQMessage();
            if(mqMessage.isEmpty()){
                res.setCode(Constants.RESULT_TYPE_SUCCESS);
                res.setMsg(Constants.RESULT_MSG_SUCCESS);
                res.setData(mqMessage);
            }else{
                res.setCode(Constants.RESULT_TYPE_FAILURE);
                res.setMsg(Constants.RESULT_MSG_FAILURE);
                res.setData("获取队列信息异常");
            }
        }catch (Exception e){
            LOGGER.error("获取队列信息异常:",e);
            res.setCode(Constants.RESULT_TYPE_FAILURE);
            res.setMsg(Constants.RESULT_MSG_FAILURE);
        }
        return res;
    }


    /**
     * 获取队列消息
     * @param MQvo
     * @returng
     */
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "推送队列信息")
    @RequestMapping(value = "/putMQMessage", method = RequestMethod.POST)
    public Result<Object> putMQMessage(@RequestBody putMQVo MQvo){
        Result<Object> res = new Result<Object>();
        try {
            Map<String, String> mqMessage = apiVideCustomerService.putMQMessage(MQvo);
            if(mqMessage.get("code") != null){
                res.setCode(Integer.valueOf(mqMessage.get("code")));
                res.setMsg(Constants.RESULT_MSG_FAILURE);
            }else{
                res.setCode(Constants.RESULT_TYPE_SUCCESS);
                res.setMsg(Constants.RESULT_MSG_SUCCESS);
                res.setData(mqMessage);
            }
        } catch (Exception e) {
            LOGGER.error("putMQMessage.Exception:",e);
            res.setCode(Constants.RESULT_TYPE_FAILURE);
            res.setMsg(Constants.RESULT_MSG_FAILURE);
        }
        return res;
    }

    /**   规则方向：  客户------》腾讯平台----》座席
     * 1.河南的进入河南，深圳的进入深圳，
     * 2.然后安徽省(340000)、青海省(630000) 、湖北省(420000) 、甘肃省(620000) 、
     * 宁夏省(640000) 、陕西省(610000,陕西区域40000) 、山西省(140000,山西区域60000) 、河南省(410000,区域10000) 、
     * 河北省（130000） 、山东省（370000） 、辽宁省（210000）、吉林省（220000） 、
     * 黑龙江省（230000） 、内蒙古自治区（150000）、新疆自治区（650000）、
     * 天津市（120000）、大连市（210200）进入河南，
     * 3.其他进入深圳(440300)，包含：440300深圳、宁波330200、350200厦门、430000湖南、530000云南、
     * 450000广西、510000四川（30000四川区域）、500000重庆、320000江苏、
     * 350000福建、520000贵州、310000上海、370200青岛、330000浙江、
     * 360000江西、440000广东、460000海南、540000西藏、、北京市（110000）
     *
     * @param messageQueueVo
     */
   /* public void setCsOrgnPartyId(MessageQueueVo messageQueueVo){
        String[] arrayExt = {"10000","410000","340000","630000","420000","620000","640000","610000",
                "40000","140000","60000","10000","10000","130000","370000","210000","220000",
                "230000","150000","650000","120000","110000","210200"};
        String ext = messageQueueVo.getExt();
        int index = Arrays.binarySearch(arrayExt,ext);
        if(index>0 ){ messageQueueVo.setExt("410000");}
        else if ("440300" == ext || index < 0){  messageQueueVo.setExt("440300");}
    }*/


    /**
     * 获取redis消息
     * @param messageQueueVo
     * @return
     */
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "获取redis消息")
    @RequestMapping(value = "/getRedisMS" , method = RequestMethod.POST)
    public Result<Object> getRedisMS(@RequestBody MessageQueueVo messageQueueVo){
        Result<Object> res = new Result<Object>();
        try {
            Map<String, String> redisMS = apiVideCustomerService.getRedisMS(messageQueueVo);
            if(redisMS.get("code") != null){
                res.setCode(Integer.valueOf(redisMS.get("code")));
                res.setMsg(Constants.RESULT_MSG_FAILURE);
            }else{
                res.setCode(Constants.RESULT_TYPE_SUCCESS);
                res.setMsg(Constants.RESULT_MSG_SUCCESS);
                res.setData(redisMS);
            }
        } catch (Exception e) {
            LOGGER.error("获取redis消息异常",e);
            res.setCode(Constants.RESULT_TYPE_FAILURE);
            res.setMsg(Constants.RESULT_MSG_FAILURE);
        }
        return res;
    }

    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "测试赋值redis消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "redisKey", value = "缓存keys", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "redisValue", value = "缓存Value", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/setRedisMs" , method = RequestMethod.GET)
    public Result<Object> setRedisMs(String redisKey ,String redisValue){
        Result<Object> res = new Result<Object>();
        try {
            Map<String, String> redisMS = apiVideCustomerService.setRedisMS( redisKey, redisValue);
            res.setCode(Constants.RESULT_TYPE_SUCCESS);
            res.setMsg(Constants.RESULT_MSG_SUCCESS);
            res.setData(redisMS);
        } catch (Exception e) {
            LOGGER.error("获取redis消息异常",e);
            res.setCode(Constants.RESULT_TYPE_FAILURE);
            res.setMsg(Constants.RESULT_MSG_FAILURE);
        }
        return res;
    }

    /**
     * 获取历史录音文件
     * @param request
     * @param response
     */
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "获取历史视频信息")
    @RequestMapping(value = "/getHistoryVideo" , method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "callId", value = "AES加密参数", required = true, dataType = "String", paramType = "query")
    })
    public void getHistoryVideo(String callId,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("callId:{}",callId);
        //读取对应路径下的文件
        apiVideCustomerService.getHistoryVideoRequset(response, callId);
    }


}
