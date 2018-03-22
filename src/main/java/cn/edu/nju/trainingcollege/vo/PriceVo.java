package cn.edu.nju.trainingcollege.vo;

public class PriceVo {
    private double value;
    private String name;

    public PriceVo(double value, String name) {
        this.value = value;
        this.name = name;
    }

    public PriceVo() {

    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
