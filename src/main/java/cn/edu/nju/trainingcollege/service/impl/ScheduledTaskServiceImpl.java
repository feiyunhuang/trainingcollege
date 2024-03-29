package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.AllocateClassRepository;
import cn.edu.nju.trainingcollege.dao.ClassRepository;
import cn.edu.nju.trainingcollege.dao.OrderRepository;
import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.entity.AllocateClassEntity;
import cn.edu.nju.trainingcollege.entity.ClassEntity;
import cn.edu.nju.trainingcollege.entity.OrderEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import cn.edu.nju.trainingcollege.entity.constant.OrderState;
import cn.edu.nju.trainingcollege.service.ScheduledTaskService;
import cn.edu.nju.trainingcollege.util.Helper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService {

    private final OrderRepository orderRepository;
    private final AllocateClassRepository allocateClassRepository;
    private final ClassRepository classRepository;
    private final UserInfoRepository userInfoRepository;

    public ScheduledTaskServiceImpl(OrderRepository orderRepository, AllocateClassRepository allocateClassRepository, ClassRepository classRepository, UserInfoRepository userInfoRepository) {
        this.orderRepository = orderRepository;
        this.allocateClassRepository = allocateClassRepository;
        this.classRepository = classRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    @Scheduled(fixedRate = 1000*60)
    public void fifteenMinutesCancel() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
        System.out.println("扫描数据库中超过15分钟仍未支付订单");
        Helper helper =new Helper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp nowtime=new Timestamp(System.currentTimeMillis());
        System.out.println(sdf.format(nowtime));
        List<OrderEntity> unpayedlist=orderRepository.findByOrderstate(OrderState.TOPAY);
        System.out.println(unpayedlist.size());
        for (OrderEntity unpayedorder  : unpayedlist){
            if(helper.compare_date(unpayedorder.getTopaytime(),nowtime)<=0){
                unpayedorder.setOrderstate(OrderState.CANCEL);
                orderRepository.save(unpayedorder);
            }
        }
    }

    @Override
    @Scheduled(fixedRate = 1000*60*60*24)
    public void allocateClass() {
        Timestamp nowtime=new Timestamp(System.currentTimeMillis());
        Helper helper =new Helper();
        List<OrderEntity> payedlist=orderRepository.findByOrderstate(OrderState.PAYED);
        for (OrderEntity payedorder  : payedlist){
            if(helper.compare_date(payedorder.getClassbegintime(),nowtime)<=0) {
                payedorder.setOrderstate(OrderState.SUCCESS);
                AllocateClassEntity allocateClassEntity=new AllocateClassEntity();
                allocateClassEntity.setClassid(payedorder.getClassid());
                ClassEntity classEntity=classRepository.getOne(payedorder.getClassid());
                allocateClassEntity.setClassname(classEntity.getName());
                allocateClassEntity.setUserid(payedorder.getUserid());
                UserInfoEntity userInfoEntity=userInfoRepository.getOne(payedorder.getUserid());
                allocateClassEntity.setUsername(userInfoEntity.getName());
                if(payedorder.getChooseclass()==1){
                    if(payedorder.getFirstclass()==1){
                        allocateClassEntity.setClassnum(1);
                    }
                    if(payedorder.getSecondclass()==1){
                        allocateClassEntity.setClassnum(2);
                    }
                    if(payedorder.getThirdclass()==1){
                        allocateClassEntity.setClassnum(3);
                    }

                }
                else{allocateClassEntity.setClassnum(1);}

                allocateClassEntity.setClassbegintime(payedorder.getClassbegintime());
                allocateClassEntity.setWeek(classEntity.getWeek());
                allocateClassEntity.setClassstate(1);
                allocateClassEntity.setScore(0);
                allocateClassRepository.save(allocateClassEntity);
            }

        }
    }

}
