package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<ClassEntity,Integer> {
    List<ClassEntity> findBySchoolid(String schoolid);
}
