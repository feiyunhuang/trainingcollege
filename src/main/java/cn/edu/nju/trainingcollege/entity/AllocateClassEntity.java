package cn.edu.nju.trainingcollege.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "allocateclass", schema = "trainingcollege", catalog = "")
public class AllocateClassEntity {
    private int id;
    private int classid;
    private String classname;
    private int userid;
    private String username;
    private int classnum;
    private Timestamp classbegintime  = new Timestamp(System.currentTimeMillis());
    private int week;
    private int classstate;
    private int score;


    public AllocateClassEntity(int id, int classid, String classname, int userid, String username, int classnum, Timestamp classbegintime, int week, int classstate, int score) {
        this.id = id;
        this.classid = classid;
        this.classname = classname;
        this.userid = userid;
        this.username = username;
        this.classnum = classnum;
        this.classbegintime = classbegintime;
        this.week = week;
        this.classstate = classstate;
        this.score = score;
    }

    public AllocateClassEntity() {
    }

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
    @Column(name = "classid", nullable = false)
    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    @Basic
    @Column(name = "classname", nullable = false, length = 50)
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name="classnum",nullable = false)
    public int getClassnum() {
        return classnum;
    }

    public void setClassnum(int classnum) {
        this.classnum = classnum;
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
    @Column(name="week",nullable = false)
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }


    @Basic
    @Column(name="classstate",nullable = false)
    public int getClassstate() {
        return classstate;
    }

    public void setClassstate(int classstate) {
        this.classstate = classstate;
    }


    @Basic
    @Column(name="score",nullable = false)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
