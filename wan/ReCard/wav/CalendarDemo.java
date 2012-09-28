import java.text.SimpleDateFormat;
import java.util.*;   
public class CalendarDemo {   
    
public String getDateTime(){   
 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");   
 Calendar starttime=Calendar.getInstance();   
 String time=dateFormat.format(starttime.getTime());   
 return time;   
}   
  
public String getDateString(){   
 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
 Calendar starttime=Calendar.getInstance();   
 String date=dateFormat.format(starttime.getTime());   
 return date ;   
    
    
}   
public String getDate(){   
 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");   
 Calendar starttime=Calendar.getInstance();   
 String time=dateFormat.format(starttime.getTime());   
 return time;   
}   
  
  
public static void main(String [] agrs){   
 CalendarDemo  s= new CalendarDemo();   
    
 System.out.println(s.getDate());   
 System.out.println(s.getDateString());   
 System.out.println(s.getDateTime());   
}   
}