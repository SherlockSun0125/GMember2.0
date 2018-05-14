import java.util.Date;
import cn.edu.hitwh.gmember.tools.DateTools;

public class DateTest {
    public static void main(String[] args){
        Date date=new Date();
        DateTools dateTools=new DateTools();
        String dateStr=dateTools.date2Str(date);
        System.out.println(date.toString());
        System.out.println(dateStr);
        Date date1=dateTools.str2Date(dateStr);
        System.out.println(date.toString());
    }


}
