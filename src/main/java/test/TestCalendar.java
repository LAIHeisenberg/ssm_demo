package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestCalendar {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date d = sdf.parse("2019-03-04");


        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(d);

        calendar.add(Calendar.DAY_OF_MONTH, 7);

        System.out.println("d: "+sdf.format(calendar.getTime()));

        Calendar calendar2 = Calendar.getInstance(TimeZone.getDefault());
        Date now = calendar2.getTime();

        String format = sdf.format(now);
        System.out.println("now: "+ format);

        if(calendar2.after(calendar)){
            System.out.println("超过7天");
        }else if (calendar2.before(calendar)){
            System.out.println("小于7天");
        }else {
            System.out.println("--");
        }

    }

}
