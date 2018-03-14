package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TeacherRepository extends JpaRepository<TeacherEntity,Integer> {

    List<TeacherEntity> findBySchoolid(String schoolid);
}
