package cn.edu.nju.trainingcollege.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "mark", schema = "trainingcollege", catalog = "")
public class MarkEntity {

    private int id;
    private int userid;
    private int classid;
    private String classname;
    private Timestamp registdate = new Timestamp(System.currentTimeMillis());
    private int score;

    public MarkEntity(int id, int userid, int classid, String classname, Timestamp registdate, int score) {
        this.id = id;
        this.userid = userid;
        this.classid = classid;
        this.classname = classname;
        this.registdate = registdate;
        this.score = score;
    }

    public MarkEntity() {
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
    @Column(name = "userid",nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
    @Column(name = "registdate", nullable = false)
    public Timestamp getRegistdate() {
        return registdate;
    }

    public void setRegistdate(Timestamp registdate) {
        this.registdate = registdate;
    }


    @Basic
    @Column(name = "score",nullable = false)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
