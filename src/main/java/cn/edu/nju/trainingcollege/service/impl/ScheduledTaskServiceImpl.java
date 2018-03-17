package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.OrderRepository;
import cn.edu.nju.trainingcollege.entity.OrderEntity;
import cn.edu.nju.trainingcollege.entity.constant.OrderState;
import cn.edu.nju.trainingcollege.service.ScheduledTaskService;
import cn.edu.nju.trainingcollege.util.Helper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService {

    private  final OrderRepository orderRepository;

    public ScheduledTaskServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Scheduled(fixedRate = 3000)
    public void process() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
        System.out.println("扫描数据库中超过15分钟仍未支付订单");
        Helper helper =new Helper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp nowtime=new Timestamp(System.currentTimeMillis());
        System.out.println(sdf.format(nowtime));
        List<OrderEntity> unpayedlist=orderRepository.findByOrderstate(OrderState.TOPAY);
        for (OrderEntity unpayedorder  : unpayedlist){
            if(helper.compare_date(unpayedorder.getTopaytime(),nowtime)<=0){
                unpayedorder.setOrderstate(OrderState.CANCEL);
                orderRepository.save(unpayedorder);
            }
        }

        System.out.println(unpayedlist.size());
    }
}
