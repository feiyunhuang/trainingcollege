package cn.edu.nju.trainingcollege.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "registerapproval", schema = "trainingcollege", catalog = "")
public class RegisterApprovalEntity {
    private String id;
    private String name;
    private String password;
    private String mail;
    private Timestamp registdate = new Timestamp(System.currentTimeMillis());
    private String address;

    public RegisterApprovalEntity(String id, String name,String password,String mail, Timestamp registdate, String address) {
        this.id = id;
        this.name=name;
        this.password = password;
        this.mail=mail;
        this.registdate = registdate;
        this.address = address;
    }

    public RegisterApprovalEntity(){}

    @Id
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "registdate", nullable = false)
    public Timestamp getRegistdate() {
        return registdate;
    }

    public void setRegistdate(Timestamp registdate) {
        this.registdate = registdate;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
