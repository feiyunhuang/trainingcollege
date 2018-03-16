package cn.edu.nju.trainingcollege.entity.constant;

public enum OrderState {
    TOPAY,//等待支付，15分钟不付变为CANCEL
    CANCEL,
    PAYED,
    SUCCESS,
    DRAWBACK,

}
