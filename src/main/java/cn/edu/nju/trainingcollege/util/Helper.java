package cn.edu.nju.trainingcollege.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Helper {
    public static String timeToDateString(Timestamp time) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return fmt.format(time);
    }

    public static String strtostr(String time) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
        Date date = fmt.parse(time);
        SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd");
        return fmt1.format(date);
    }

    public static Timestamp getTimeStamp(String time) {
        return Timestamp.valueOf(time + " 00:00:00.0");
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

    public static String generateSchoolid(){
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

    public static String generateOrderid(){
        String result="";
        char [] character={'A','B','C','D','E','F','G','H',
                'I','J','K','L','M','N','O','P',
                'Q','R','S','T','U','V','W','X',
                'Y','Z','1','2','3','4','5','6',
                '7','8','9','0'};

        for(int i=0;i<10;i++){
            int s=random(0,35);
            result=result+character[s];
        }
        return result;
    }

    public static String dayaweek(String[] a){

        int length=a.length;
        int mon=0;
        int tue=0;
        int wed=0;
        int thu=0;
        int fri=0;
        int sat=0;
        int sun=0;
        for(int i=0;i<length;i++){
            if(a[i].equals("mon")){
                mon=1;
            }
            if(a[i].equals("tue")){
                tue=1;
            }
            if(a[i].equals("wed")){
                wed=1;
            }
            if(a[i].equals("thu")){
                thu=1;
            }
            if(a[i].equals("fri")){
                fri=1;
            }
            if(a[i].equals("sat")){
                sat=1;
            }
            if(a[i].equals("sun")){
                sun=1;
            }
        }

        return ""+mon+tue+wed+thu+fri+sat+sun;
    }

    public static String daytostr(String day){
        List<String> week=new ArrayList<>();
        week.add("周一");
        week.add("周二");
        week.add("周三");
        week.add("周四");
        week.add("周五");
        week.add("周六");
        week.add("周日");
        String str=" ";
        for(int i=0;i<7;i++){
            if(day.charAt(i)=='1'){
                str=str+" "+week.get(i);
            }
        }
        return str;
    }

    public static Timestamp addfifteenmin(Timestamp time) throws ParseException {

        time.setTime(time.getTime() + 15*60*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return Timestamp.valueOf(sdf.format(time));

    }

    public static Timestamp minusnday(Timestamp time,int n) throws ParseException {

        time.setTime(time.getTime() - n*24*60*60*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return Timestamp.valueOf(sdf.format(time));

    }


    public static int compare_date(Timestamp dt1, Timestamp dt2) {



        try {
            if (dt1.getTime() > dt2.getTime()) {
//                System.out.println("dt1 在dt2后");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
//                System.out.println("dt1在dt2前");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }



    public static void main(String[] args) throws ParseException {

        Timestamp d1=new Timestamp(System.currentTimeMillis());
        for(int i=0;i<100000;i++){
            System.out.println(i);
        }
        Date date=new Date(System.currentTimeMillis());
        Timestamp d2=new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d1));
        System.out.println(sdf.format(date));
        System.out.println(sdf.format(d2));

        System.out.println(compare_date(d1,d2));
    }
}
