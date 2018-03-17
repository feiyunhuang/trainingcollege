package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.service.ScheduledTaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Override
    @Scheduled(fixedRate = 6000)
    public void process() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));

    }
}
