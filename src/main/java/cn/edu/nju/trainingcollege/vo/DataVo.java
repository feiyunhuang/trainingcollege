package cn.edu.nju.trainingcollege.vo;

import java.util.List;

public class DataVo {
    private List<String> orderstate;
    private List<String> weekday;

    private List<Integer> cancelnum;
    private List<Integer> payednum;
    private List<Integer> successnum;
    private List<Integer> drawbacknum;

    public DataVo(List<String> orderstate, List<String> weekday, List<Integer> cancelnum, List<Integer> payednum, List<Integer> successnum, List<Integer> drawbacknum) {
        this.orderstate = orderstate;
        this.weekday = weekday;
        this.cancelnum = cancelnum;
        this.payednum = payednum;
        this.successnum = successnum;
        this.drawbacknum = drawbacknum;
    }

    public DataVo() {
    }

    public List<String> getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(List<String> orderstate) {
        this.orderstate = orderstate;
    }

    public List<String> getWeekday() {
        return weekday;
    }

    public void setWeekday(List<String> weekday) {
        this.weekday = weekday;
    }

    public List<Integer> getCancelnum() {
        return cancelnum;
    }

    public void setCancelnum(List<Integer> cancelnum) {
        this.cancelnum = cancelnum;
    }

    public List<Integer> getPayednum() {
        return payednum;
    }

    public void setPayednum(List<Integer> payednum) {
        this.payednum = payednum;
    }

    public List<Integer> getSuccessnum() {
        return successnum;
    }

    public void setSuccessnum(List<Integer> successnum) {
        this.successnum = successnum;
    }

    public List<Integer> getDrawbacknum() {
        return drawbacknum;
    }

    public void setDrawbacknum(List<Integer> drawbacknum) {
        this.drawbacknum = drawbacknum;
    }
}
