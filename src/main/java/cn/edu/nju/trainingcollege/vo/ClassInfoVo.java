package cn.edu.nju.trainingcollege.vo;

import java.util.List;

public class ClassInfoVo {
    private int id;
    private String name;
    private String schoolname;
    private String teachername;
    private String timeaweek;
    private int week;
    private int classnum;
    private int studentaclass;
    private double price;
    private String daytime;
    private String begintime;
    private String registdate;
    private String teacherdescription;
    private String description;

    public ClassInfoVo(){}

    public ClassInfoVo(int id, String name, String schoolname, String teachername, String timeaweek, int week, int classnum, int studentaclass, double price, String daytime, String begintime, String registdate, String teacherdescription, String description) {
        this.id = id;
        this.name = name;
        this.schoolname = schoolname;
        this.teachername = teachername;
        this.timeaweek = timeaweek;
        this.week = week;
        this.classnum = classnum;
        this.studentaclass = studentaclass;
        this.price = price;
        this.daytime = daytime;
        this.begintime = begintime;
        this.registdate = registdate;
        this.teacherdescription = teacherdescription;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTimeaweek() {
        return timeaweek;
    }

    public void setTimeaweek(String timeaweek) {
        this.timeaweek = timeaweek;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getClassnum() {
        return classnum;
    }

    public void setClassnum(int classnum) {
        this.classnum = classnum;
    }

    public int getStudentaclass() {
        return studentaclass;
    }

    public void setStudentaclass(int studentaclass) {
        this.studentaclass = studentaclass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getRegistdate() {
        return registdate;
    }

    public void setRegistdate(String registdate) {
        this.registdate = registdate;
    }

    public String getTeacherdescription() {
        return teacherdescription;
    }

    public void setTeacherdescription(String teacherdescription) {
        this.teacherdescription = teacherdescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
