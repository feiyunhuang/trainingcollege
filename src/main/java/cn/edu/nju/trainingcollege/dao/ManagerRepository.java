package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerEntity,String> {

}
