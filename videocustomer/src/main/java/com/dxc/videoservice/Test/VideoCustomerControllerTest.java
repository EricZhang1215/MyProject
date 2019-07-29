package com.dxc.videoservice.Test;

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
import java.util.Map;


/**
 * 视频客服对外接口
 *
 * @author He Biao
 * @date 2018-08-23
 */

@RestController
@Api(value = "/videoCustomerTest", tags = {"视频客服"})
@RequestMapping(value = "/videoCustomerTest")
public class VideoCustomerControllerTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(VideoCustomerControllerTest.class);

    @Autowired
    ApiVideoCustomerService apiVideCustomerService;



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
