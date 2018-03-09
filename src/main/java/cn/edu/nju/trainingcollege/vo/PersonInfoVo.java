package cn.edu.nju.trainingcollege.vo;

import cn.edu.nju.trainingcollege.entity.constant.MemberState;

import java.sql.Timestamp;

public class PersonInfoVo {
    private int id;
    private String mail;
    private String name;
    private String memberState;
    private double balance;
    private String registdate;
    private String portraitpath="../../static/portrait/timg.jpg";

    public PersonInfoVo(int id, String mail, String name, String memberState, double balance, String registdate, String portraitpath) {
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

    public String getMemberState() {
        return memberState;
    }

    public void setMemberState(String memberState) {
        this.memberState = memberState;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getRegistdate() {
        return registdate;
    }

    public void setRegistdate(String registdate) {
        this.registdate = registdate;
    }

    public String getPortraitpath() {
        return portraitpath;
    }

    public void setPortraitpath(String portraitpath) {
        this.portraitpath = portraitpath;
    }
}
