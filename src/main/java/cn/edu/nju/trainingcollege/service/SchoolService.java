package cn.edu.nju.trainingcollege.service;

public interface SchoolService {
    void register(String name,String password,String address,String mail);

    boolean login(String name,String password);
}
