package cn.edu.nju.trainingcollege.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Helper {
    public static String timeToDateString(Timestamp time) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return fmt.format(time);
    }
}
