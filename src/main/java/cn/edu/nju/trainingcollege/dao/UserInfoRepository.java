package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity,Integer> {

}
