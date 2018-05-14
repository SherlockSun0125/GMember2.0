package cn.edu.hitwh.gmember.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {
    public String date2Str(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("时间是"+simpleDateFormat);
        return simpleDateFormat.format(date);
    }

    public Date str2Date(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(stringDate);
//            System.out.println("date:"+date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
