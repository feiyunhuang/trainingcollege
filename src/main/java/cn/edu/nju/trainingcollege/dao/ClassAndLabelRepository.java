package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.ClassAndLabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassAndLabelRepository extends JpaRepository<ClassAndLabelEntity,Integer> {
}
