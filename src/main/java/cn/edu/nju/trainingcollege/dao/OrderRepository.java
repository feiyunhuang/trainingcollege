package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.OrderEntity;
import cn.edu.nju.trainingcollege.entity.constant.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

    List<OrderEntity> findByOrderstate(OrderState orderstate);

}
