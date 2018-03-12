package cn.edu.nju.trainingcollege.service;


import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;

public interface UserService {

    void register(String mail, String password, String name,String phone,String sex);

    UserEntity findByMail(String mail);

    boolean login(String mail, String password);

    UserInfoEntity getUserInfoById(int id);


}
