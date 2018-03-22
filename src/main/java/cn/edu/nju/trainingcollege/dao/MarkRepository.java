package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.MarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<MarkEntity,Integer> {

    List<MarkEntity> findByUserid(int userid);
}
