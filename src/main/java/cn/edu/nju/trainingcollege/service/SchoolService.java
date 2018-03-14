package cn.edu.nju.trainingcollege.service;

import cn.edu.nju.trainingcollege.entity.ClassEntity;

import java.util.List;

public interface SchoolService {
    void register(String name,String password,String address,String mail);

    boolean login(String name,String password);

    List<ClassEntity> findMyClass(String schoolid);
}
