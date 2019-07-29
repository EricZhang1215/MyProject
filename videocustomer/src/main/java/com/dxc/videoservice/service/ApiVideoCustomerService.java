package com.dxc.videoservice.service;

import com.dxc.videoservice.vo.MessageQueueVo;
import com.dxc.videoservice.vo.putMQVo;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.Map;

/**
 * 视频客服服务接口
 *
 * @author He Biao
 * @date 2018-08-27
 */
public interface ApiVideoCustomerService {

    /**
     * 获取会话sessionId
     * @param appId         小程序发送的appId;
     * @param phoneNumber   用户电话号码
     * @return
     */
    public Map<String,String> getSessionId(String appId, String phoneNumber);

    /**
     * 获取队列数据信息
     * @return
     */
    public Map<String,String> getMQMessage();

    /**
     * 接受理赔
     * @param mqVo
     * @return
     */
    public Map<String,String> putMQMessage(putMQVo mqVo);

    /**
     * 获取redis 消息数据
     * @param messageQueueVo
     * @return
    */
    public Map<String,String> getRedisMS(MessageQueueVo messageQueueVo);


    /**
     * 测试赋值redis信息
     * @param key
     * @param value
     * @return
     */
    public Map<String,String> setRedisMS(String key, String value);

    /**
     * 获取录音文件
     */
    public void downloadVideoFile();

    /**
     * 输出视频信息
     * @return
     */
    public HttpServletResponse getHistoryVideoRequset(HttpServletResponse response , String promp);


    /**
     * 保存来电呼入时间
     * @param sid
     * @return
     */
    public String setHsitroyVIdeoCallTime(String sid);
}
