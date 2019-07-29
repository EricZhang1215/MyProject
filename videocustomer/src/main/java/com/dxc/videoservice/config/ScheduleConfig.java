package com.dxc.videoservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * 定义并发执行定时任务
 * @author He Biao
 * @date 2018-09-04
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //定义并发线程梳理
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(1));
    }

}
