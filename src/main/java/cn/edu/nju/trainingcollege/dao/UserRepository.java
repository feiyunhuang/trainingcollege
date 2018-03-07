package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByMail(String mail);

}