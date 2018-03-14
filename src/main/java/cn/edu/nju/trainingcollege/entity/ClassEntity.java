package cn.edu.nju.trainingcollege.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "class", schema = "trainingcollege", catalog = "")
public class ClassEntity {

    private int id;
    private String name;
    private String schoolid;
    private String timeaweek;
    private int week;
    private int classnum;
    private int studentaclass;
    private double price;
    private int teacherid;
    private String daytime;
    private Timestamp registdate = new Timestamp(System.currentTimeMillis());
    private Timestamp begindate  = new Timestamp(System.currentTimeMillis());
    private String description;

    public ClassEntity(int id, String name, String schoolid, String timeaweek, int week, int classnum, int studentaclass, double price, int teacherid, String daytime, Timestamp registdate, Timestamp begindate, String description) {
        this.id = id;
        this.name = name;
        this.schoolid = schoolid;
        this.timeaweek = timeaweek;
        this.week = week;
        this.classnum = classnum;
        this.studentaclass = studentaclass;
        this.price = price;
        this.teacherid = teacherid;
        this.daytime = daytime;
        this.registdate = registdate;
        this.begindate = begindate;
        this.description = description;
    }

    public ClassEntity(){}

    @GeneratedValue
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

    @Basic
    @Column(name = "schoolid", nullable = false, length = 10)
    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    @Basic
    @Column(name = "timeaweek", nullable = false,length=10)
    public String getTimeaweek() {
        return timeaweek;
    }

    public void setTimeaweek(String timeaweek) {
        this.timeaweek = timeaweek;
    }

    @Basic
    @Column(name = "week", nullable = false)
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Basic
    @Column(name = "classnum", nullable = false)
    public int getClassnum() {
        return classnum;
    }

    public void setClassnum(int classnum) {
        this.classnum = classnum;
    }

    @Basic
    @Column(name = "studentaclass", nullable = false)
    public int getStudentaclass() {
        return studentaclass;
    }

    public void setStudentaclass(int studentaclass) {
        this.studentaclass = studentaclass;
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
    @Column(name = "teacherid", nullable = false)
    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    @Basic
    @Column(name = "daytime", nullable = false)
    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
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
    @Column(name = "begindate", nullable = false)
    public Timestamp getBegindate() {
        return begindate;
    }

    public void setBegindate(Timestamp begindate) {
        this.begindate = begindate;
    }

    @Basic
    @Column(name = "description", nullable = false,length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
