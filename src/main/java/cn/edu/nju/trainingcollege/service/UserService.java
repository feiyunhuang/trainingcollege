package cn.edu.nju.trainingcollege.service;


import cn.edu.nju.trainingcollege.entity.ClassEntity;
import cn.edu.nju.trainingcollege.entity.OrderEntity;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import cn.edu.nju.trainingcollege.vo.ClassInfoVo;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
import cn.edu.nju.trainingcollege.vo.OrderVo;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    void register(String mail, String password, String name,String phone,String sex);

    UserEntity findByMail(String mail);

    boolean login(String mail, String password);

    UserInfoEntity getUserInfoById(int id);

    MemberInfoVo getMemberInfo(int id);

    ClassInfoVo getClassInfo(int id);

    OrderVo generateordervo(int classid, int userid);

    String createunchooseorder(int classid, int userid, int people, int coupon);

    String createchooseorder(int classid,int userid,int classnum,int people,int coupon);

    OrderEntity getorderByid(String id);

    boolean pay(String banksccount,String password,double price,String orderid);

    List<ClassEntity> searchclass(String label);

    void cancelmember(int userid);

    void exchangecoupon(int userid,int point);

    void modifyinfo(int userid,String name,String password,String phone);

    List<OrderEntity> getunpayorder(int userid);

    List<OrderEntity> getcancelorder(int userid);

    List<OrderEntity> getpayedorder(int userid);

    List<OrderEntity> getsuccessorder(int userid);

    List<OrderEntity> getdrawbackorder(int userid);

    void drawbackorder(String orderid)throws ParseException;
}
