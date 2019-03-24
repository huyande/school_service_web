package com.school.schoolweb.task;

import com.school.schoolweb.service.CountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserCountJobs {
    @Autowired
    private CountInfoService userCountService;

    /**
     * 每天的 晚上三点进行更新操作
     */
    @Scheduled(cron = "0 0 3 * * ?")
    //@Scheduled(cron = "0/5 * * * * ? ")
    public void updataUserCount() {
        System.err.println("定时任务");
        userCountService.updataCountInfo("wxuser");
        userCountService.updataCountInfo("conf");
        userCountService.updataCountInfo("roast");
    }
}
