package cn.edu.nju.trainingcollege.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

public class BankEntity {
    private String account;
    private String password;
    private double balance;

    public BankEntity(String account, String password, double balance) {
        this.account = account;
        this.password = password;
        this.balance = balance;
    }

    public BankEntity(){}

    @Id
    @Column(name = "account", nullable = false,length = 10)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 10)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Basic
    @Column(name = "balance", nullable = false)
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
