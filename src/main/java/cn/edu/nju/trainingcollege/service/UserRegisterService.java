package cn.edu.nju.trainingcollege.service;


import cn.edu.nju.trainingcollege.entity.UserEntity;

public interface UserRegisterService {

    void register(String mail, String password, String name);

}
