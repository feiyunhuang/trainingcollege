package cn.edu.nju.trainingcollege.entity;


import javax.persistence.*;

@Entity
@Table(name = "manager", schema = "trainingcollege", catalog = "")
public class ManagerEntity {
    private String name;
    private String password;


    public ManagerEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public ManagerEntity(){}

    @Id
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
