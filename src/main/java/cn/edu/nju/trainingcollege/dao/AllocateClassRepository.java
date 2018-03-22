package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.AllocateClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllocateClassRepository extends JpaRepository<AllocateClassEntity,Integer> {
    List<AllocateClassEntity> findByUserid(int userid);
}
