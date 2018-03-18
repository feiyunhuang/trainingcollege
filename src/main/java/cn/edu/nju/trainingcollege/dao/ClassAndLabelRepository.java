package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.ClassAndLabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassAndLabelRepository extends JpaRepository<ClassAndLabelEntity,Integer> {

    List<ClassAndLabelEntity> findAllByLabel(String label);
}
