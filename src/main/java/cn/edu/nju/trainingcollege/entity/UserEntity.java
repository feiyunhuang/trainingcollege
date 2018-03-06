package cn.edu.nju.trainingcollege.entity;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "trainingcollege", catalog = "")
public class UserEntity {

    private String mail;
    private String password;
    private int id;

    public UserEntity() {
    }

    public UserEntity(int id,String mail, String password) {
        this.mail = mail;
        this.password = password;
        this.id = id;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 50)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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



}