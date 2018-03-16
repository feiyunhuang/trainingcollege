package cn.edu.nju.trainingcollege.vo;

public class OrderVo {
    private String classname;
    private double price;
    private int memberid;
    private int memberlevel;
    private int discount;
    private String phone;
    private int coupon;
    private String begindate;

    public OrderVo(String classname, double price, int memberid, int memberlevel, int discount, String phone, int coupon, String begindate) {
        this.classname = classname;
        this.price = price;
        this.memberid = memberid;
        this.memberlevel = memberlevel;
        this.discount = discount;
        this.phone = phone;
        this.coupon = coupon;
        this.begindate = begindate;
    }

    public OrderVo(){}

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public int getMemberlevel() {
        return memberlevel;
    }

    public void setMemberlevel(int memberlevel) {
        this.memberlevel = memberlevel;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }
}
