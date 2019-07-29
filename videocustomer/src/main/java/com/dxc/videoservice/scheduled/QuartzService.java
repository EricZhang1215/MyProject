package com.dxc.videoservice.scheduled;


import com.dxc.videoservice.service.ApiVideoCustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 视频客服定时轮询任务
 *
 * @author He Biao
 * @date 2018-08-28
 */
@Component
@Configurable
@EnableScheduling
public class QuartzService {

    public static final Logger LOGGER = LoggerFactory.getLogger(QuartzService.class);

    @Autowired
    ApiVideoCustomerService apiVideCustomerService;


    //每一秒执行一次
    @Scheduled(cron = "0/1 * * * * ?")
    public void timerToNow(){
        try {
            Map<String, String> mqMessage = apiVideCustomerService.getMQMessage();
            LOGGER.info("从腾讯平台获取队列消息入redis:{}", mqMessage.get("cmd"));
        } catch (Exception e) {
            LOGGER.error("定时轮询腾讯平台异常：", e);
        }
    }

    /**
     * 每三十分钟执行一次 "0 0/30 * * * ? "
     * 每晚11点开始执行 0 0 23 * * ?
     *
     * 如果生产两天服务器需要停止其中一个服务跑此任务
     *
     */
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void historyVideo(){
        try {
            //轮询录音下载
            apiVideCustomerService.downloadVideoFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
