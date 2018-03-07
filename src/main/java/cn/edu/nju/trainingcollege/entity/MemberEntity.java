package cn.edu.nju.trainingcollege.entity;


import javax.persistence.*;

@Entity
@Table(name = "member", schema = "trainingcollege", catalog = "")
public class MemberEntity {

    private int id;
    private int point=0;
    private int level=1;
    private int accumulate = 0;

    public MemberEntity(){

    }
    public MemberEntity(int id, int point, int level,int accumulate) {
        this.id = id;
        this.point = point;
        this.level = level;
        this.accumulate=accumulate;
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
    @Column(name = "point", nullable = false)
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    @Basic
    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Basic
    @Column(name = "accumulate", nullable = false)
    public int getAccumulate() {
        return accumulate;
    }

    public void setAccumulate(int accumulate) {
        this.accumulate = accumulate;
    }
}
