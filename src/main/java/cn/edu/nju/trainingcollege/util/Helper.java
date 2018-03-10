package cn.edu.nju.trainingcollege.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static String timeToDateString(Timestamp time) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return fmt.format(time);
    }

    public static int getLevel(int accumulate) {
        return  1+accumulate/100;

    }

    public static int getDiscount(int accumulate) {

        int[] discount = {98, 95, 90, 88, 85, 8};
        if(accumulate>=0&&accumulate<=1000){return discount[0];}
        if(accumulate>1000&&accumulate<=2000){return discount[1];}
        if(accumulate>2000&&accumulate<=3000){return discount[2];}
        if(accumulate>3000&&accumulate<=4000){return discount[3];}
        if(accumulate>4000&&accumulate<=5000){return discount[4];}
        return discount[5];
    }

}
