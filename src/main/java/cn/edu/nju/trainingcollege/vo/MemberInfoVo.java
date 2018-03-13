package cn.edu.nju.trainingcollege.vo;

public class MemberInfoVo {
    private int id;
    private int point;
    private int level;
    private int accumulate;
    private String registdate;
    private String discount;
    private String name;
    private int coupon;

    public MemberInfoVo(int id, int point, int level, int accumulate, String registdate, String discount, String name, int coupon) {
        this.id = id;
        this.point = point;
        this.level = level;
        this.accumulate = accumulate;
        this.registdate = registdate;
        this.discount = discount;
        this.name = name;
        this.coupon = coupon;
    }

    public  MemberInfoVo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAccumulate() {
        return accumulate;
    }

    public void setAccumulate(int accumulate) {
        this.accumulate = accumulate;
    }

    public String getRegistdate() {
        return registdate;
    }

    public void setRegistdate(String registdate) {
        this.registdate = registdate;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }
}
