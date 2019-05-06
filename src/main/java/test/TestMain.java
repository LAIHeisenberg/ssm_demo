package test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {

    /**
    yyyy-MM-dd
    yyyy/MM/dd
    dd-MM-yyyy
    dd/MM/yyyy
    dd-MM-yy
    dd/MM/yy
    *
    HH:mm:ss
    HH:mm
    */

    public static void main(String[] args){

        String dateStr = "12/01/11 02:12";
        String dateStr2 = "2018-01-06 14:35:54";
        String dateStr3 = "2017/12/14 18:15";
        String dateStr4 = "12/12/2012 18:04:14";
        String dateStr5 = "07/12/15 17:44";
        String dateStr6 = "19-11-01 17:32:12";
        String dateStr7 = "2019年01月01日 23:59:59";
        String dateStr8 = "2019年11月27日";
        String dateStr9 = "2017/07/21";

        dateStr2Date(dateStr);
        dateStr2Date(dateStr2);
        dateStr2Date(dateStr3);
        dateStr2Date(dateStr4);
        dateStr2Date(dateStr5);
        dateStr2Date(dateStr6);
        dateStr2Date(dateStr7);
        dateStr2Date(dateStr8);
        dateStr2Date(dateStr9);
    }


    public static void dateStr2Date(String dateStr){

        System.out.print("输入的日期时间字符串: "+dateStr+"\t\t\t");

        String reg = "^(\\d{2,4})[-/年]?(\\d{2})[-/月]?(\\d{2,4})日?.?(\\d{2})?:?(\\d{2})?:?(\\d{2})?$";
        final int BASE_YEAR = 2000;
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(dateStr);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(),Locale.CHINA);
        if (matcher.find()){
            int year = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int day = Integer.parseInt(matcher.group(3));
            int hour = Integer.parseInt(matcher.group(4) == null ? "0":matcher.group(4));
            int minut = Integer.parseInt(matcher.group(5) == null ? "0":matcher.group(5));
            int second = Integer.parseInt(matcher.group(6) == null ? "0" :matcher.group(6));
            if (year <= 31){
                int tmp = year;
                year = day >= BASE_YEAR ? day : BASE_YEAR + day;
                day = tmp;
            }
            calendar.set(year,month-1,day,hour,minut,second);
        }

        Date time = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(time);
        calendar.getTimeInMillis();

        System.out.println("输出的时间日期格式: "+ format+ " 时间戳"+time.getTime());
    }


}
