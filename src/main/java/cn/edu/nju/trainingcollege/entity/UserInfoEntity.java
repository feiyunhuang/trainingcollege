package cn.edu.nju.trainingcollege.entity;


import cn.edu.nju.trainingcollege.entity.constant.MemberState;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "userinfo", schema = "trainingcollege", catalog = "")
public class UserInfoEntity {

    private int id;
    private String name;
    private MemberState memberState=MemberState.VALID;
    private String sex;
    private String phonenum;
    private Timestamp registdate = new Timestamp(System.currentTimeMillis());

    public UserInfoEntity(){

    }

    public UserInfoEntity(int id, String name, MemberState memberState, String sex, String phonenum, Timestamp registdate) {
        this.id = id;
        this.name = name;
        this.memberState = memberState;
        this.sex = sex;
        this.phonenum = phonenum;
        this.registdate = registdate;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "memberstate", nullable = false, length = 10)
    public MemberState getMemberState() {
        return memberState;
    }

    public void setMemberState(MemberState memberState) {
        this.memberState = memberState;
    }

    @Column(name = "sex", nullable = false, length = 10)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "phonenum", nullable = false, length = 20)
    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Basic
    @Column(name = "registdate", nullable = false)
    public Timestamp getRegistdate() {
        return registdate;
    }

    public void setRegistdate(Timestamp registdate) {
        this.registdate = registdate;
    }

}
