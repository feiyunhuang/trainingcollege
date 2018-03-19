package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.OrderEntity;
import cn.edu.nju.trainingcollege.entity.constant.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,String> {

    List<OrderEntity> findByOrderstate(OrderState orderstate);

    List<OrderEntity> findByUseridAndOrderstate(int userid,OrderState orderState);


}
