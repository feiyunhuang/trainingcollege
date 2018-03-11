package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<SchoolEntity,Integer> {
}
