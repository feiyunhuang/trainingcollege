package cn.edu.nju.trainingcollege.entity;

import cn.edu.nju.trainingcollege.entity.constant.OrderState;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "trainingorder", schema = "trainingcollege", catalog = "")
public class OrderEntity {
    private String id;
    private int userid;
    private String schoolid;
    private int teacherid;
    private double price;
    private int peoplenum;
    private double totalprice;
    private Timestamp createtime = new Timestamp(System.currentTimeMillis());
    private Timestamp topaytime = new Timestamp(System.currentTimeMillis());
    private Timestamp classbegintime=new Timestamp(System.currentTimeMillis());
    private String bankaccount;
    private int usecoupon;
    private OrderState orderstate=OrderState.TOPAY;
    private int chooseclass;
    private int firstclass;
    private int secondclass;
    private int thirdclass;


    public OrderEntity(String id, int userid, String schoolid, int teacherid, double price, int peoplenum, double totalprice, Timestamp createtime, Timestamp topaytime, Timestamp classbegintime, String bankaccount, int usecoupon, OrderState orderstate, int chooseclass, int firstclass, int secondclass, int thirdclass) {
        this.id = id;
        this.userid = userid;
        this.schoolid = schoolid;
        this.teacherid = teacherid;
        this.price = price;
        this.peoplenum = peoplenum;
        this.totalprice = totalprice;
        this.createtime = createtime;
        this.topaytime = topaytime;
        this.classbegintime = classbegintime;
        this.bankaccount = bankaccount;
        this.usecoupon = usecoupon;
        this.orderstate = orderstate;
        this.chooseclass = chooseclass;
        this.firstclass = firstclass;
        this.secondclass = secondclass;
        this.thirdclass = thirdclass;
    }

    public OrderEntity(){}

    @Id
    @Column(name = "id", nullable = false,length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid",nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "schoolid", nullable = false, length = 10)
    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    @Basic
    @Column(name = "teacherid", nullable = false)
    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "peoplenum",nullable = false)
    public int getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(int peoplenum) {
        this.peoplenum = peoplenum;
    }

    @Basic
    @Column(name = "totalprice", nullable = false)
    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Basic
    @Column(name = "createtime", nullable = false)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
    @Basic
    @Column(name = "topaytime", nullable = false)
    public Timestamp getTopaytime() {
        return topaytime;
    }

    public void setTopaytime(Timestamp topaytime) {
        this.topaytime = topaytime;
    }

    @Basic
    @Column(name = "classbegintime", nullable = false)
    public Timestamp getClassbegintime() {
        return classbegintime;
    }

    public void setClassbegintime(Timestamp classbegintime) {
        this.classbegintime = classbegintime;
    }

    @Basic
    @Column(name = "bankaccount", nullable = false, length = 20)
    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    @Basic
    @Column(name = "usecoupon", nullable = false)
    public int getUsecoupon() {
        return usecoupon;
    }

    public void setUsecoupon(int usecoupon) {
        this.usecoupon = usecoupon;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "orderstate", nullable = false, length = 10)
    public OrderState getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(OrderState orderstate) {
        this.orderstate = orderstate;
    }

    @Basic
    @Column(name = "chooseclass",nullable = false)
    public int getChooseclass() {
        return chooseclass;
    }

    public void setChooseclass(int chooseclass) {
        this.chooseclass = chooseclass;
    }

    @Basic
    @Column(name = "firstclass",nullable = false)
    public int getFirstclass() {
        return firstclass;
    }

    public void setFirstclass(int firstclass) {
        this.firstclass = firstclass;
    }
    @Basic
    @Column(name = "secondclass",nullable = false)
    public int getSecondclass() {
        return secondclass;
    }

    public void setSecondclass(int secondclass) {
        this.secondclass = secondclass;
    }

    @Basic
    @Column(name = "thirdclass",nullable = false)
    public int getThirdclass() {
        return thirdclass;
    }

    public void setThirdclass(int thirdclass) {
        this.thirdclass = thirdclass;
    }
}
