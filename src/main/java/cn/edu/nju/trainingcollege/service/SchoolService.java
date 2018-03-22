package cn.edu.nju.trainingcollege.service;

import cn.edu.nju.trainingcollege.entity.ClassEntity;
import cn.edu.nju.trainingcollege.entity.OrderEntity;
import cn.edu.nju.trainingcollege.entity.SchoolEntity;
import cn.edu.nju.trainingcollege.entity.TeacherEntity;

import java.util.List;

public interface SchoolService {
    void register(String name,String password,String address,String mail);

    boolean login(String name,String password);

    List<ClassEntity> findMyClass(String schoolid);

    List<TeacherEntity> findAllTeacher(String schoolid);

    void addclass(String classname,String schoolid,String timeaweek,int week,int classnum,int studentaclass,double price,int teacherid,String daytime,String begindate,String description);

    SchoolEntity getschoolinfo(String schoolid);

    void modifyschoolinfo(String schoolid,String schoolname,String password,String mail,String address);

    void addteacher(String name,String description,String schoolid);

    void deleteteacher(int teacherid);

    List<OrderEntity> getclassorder(int classid);

    void addmark(int userid,int classid,String classname,int score);

}
