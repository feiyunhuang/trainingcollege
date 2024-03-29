package cn.edu.nju.trainingcollege.entity;


import javax.persistence.*;

@Entity
@Table(name = "teacher", schema = "trainingcollege", catalog = "")
public class TeacherEntity {
    private int id;
    private String name;
    private String schoolid;
    private String description;

    public TeacherEntity(int id, String name, String schoolid, String description) {
        this.id = id;
        this.name = name;
        this.schoolid = schoolid;
        this.description = description;
    }

    public TeacherEntity(){}

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
    @Column(name = "name", nullable = false, length = 20)
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
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
