package cn.edu.nju.trainingcollege.vo;

import cn.edu.nju.trainingcollege.entity.constant.MemberState;

import java.sql.Timestamp;

public class PersonInfoVo {
    private int id;
    private String mail;
    private String name;
    private MemberState memberState;
    private double balance;
    private Timestamp registdate;
    private String portraitpath="../../static/portrait/timg.jpg";

    public PersonInfoVo(int id, String mail, String name, MemberState memberState, double balance, Timestamp registdate, String portraitpath) {
        this.id = id;
        this.mail = mail;
        this.name = name;
        this.memberState = memberState;
        this.balance = balance;
        this.registdate = registdate;
        this.portraitpath = portraitpath;
    }

    public PersonInfoVo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberState getMemberState() {
        return memberState;
    }

    public void setMemberState(MemberState memberState) {
        this.memberState = memberState;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Timestamp getRegistdate() {
        return registdate;
    }

    public void setRegistdate(Timestamp registdate) {
        this.registdate = registdate;
    }

    public String getPortraitpath() {
        return portraitpath;
    }

    public void setPortraitpath(String portraitpath) {
        this.portraitpath = portraitpath;
    }
}
