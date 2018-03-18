package cn.edu.nju.trainingcollege.entity;


import javax.persistence.*;

@Entity
@Table(name = "classandlabel", schema = "trainingcollege", catalog = "")
public class ClassAndLabelEntity {
    private int id;
    private int classid;
    private String label;

    public ClassAndLabelEntity(int id, int classid, String label) {
        this.id = id;
        this.classid = classid;
        this.label = label;
    }

    public ClassAndLabelEntity(){}


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
    @Column(name = "label", nullable = false,length=20)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
