package cn.edu.nju.trainingcollege.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static int random (int min,int max) {

        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }

    public static String GenerateId(){
        String result="";
        char [] character={'A','B','C','D','E','F','G','H',
                           'I','J','K','L','M','N','O','P',
                           'Q','R','S','T','U','V','W','X',
                           'Y','Z','1','2','3','4','5','6',
                           '7','8','9','0'};

        for(int i=0;i<7;i++){
            int s=random(0,35);
            result=result+character[s];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(GenerateId());
    }
}
