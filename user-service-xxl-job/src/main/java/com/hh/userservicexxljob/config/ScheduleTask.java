package com.hh.userservicexxljob.config;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ScheduleTask
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/8/18 15:04
 * @Version 1.0
 **/
@Component
public class ScheduleTask {

    @XxlJob("scheduleTask")
    public ReturnT<String> jobExecute(String s) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(s + "开启xxl-job定时任务  ---------> " + sdf.format(new Date()));
            return new ReturnT(200, "任务完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IJobHandler.FAIL;
    }

}
