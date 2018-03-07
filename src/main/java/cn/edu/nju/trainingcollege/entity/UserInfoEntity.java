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
    private Timestamp registdate = new Timestamp(System.currentTimeMillis());
    private double balance=0;

    public UserInfoEntity(){

    }

    public UserInfoEntity(int id, String name, MemberState memberState, Timestamp registdate, double balance) {
        this.id = id;
        this.name = name;
        this.memberState = memberState;
        this.registdate = registdate;
        this.balance = balance;
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

    @Basic
    @Column(name = "registdate", nullable = false)
    public Timestamp getRegistdate() {
        return registdate;
    }

    public void setRegistdate(Timestamp registdate) {
        this.registdate = registdate;
    }

    @Basic
    @Column(name = "balance", nullable = false)
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
