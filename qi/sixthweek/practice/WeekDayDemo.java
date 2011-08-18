class Time implements WeekDays{
	void print(){
		System.out.println("MONDAY="+MONDAY);
		System.out.println("TUESDAY="+TUESDAY);
		System.out.println("WEDNESDAY="+WEDNESDAY);
		System.out.println("THURSDAY="+THURSDAY);
		System.out.println("FRIDAY="+FRIDAY);
		System.out.println("SATURDAY="+SATURDAY);
		System.out.println("SUNDAY="+SUNDAY);		
	}
}
public class WeekDayDemo implements WeekDays{
	public static void main(String[] args){
		Time t = new Time();
		t.print();
	}
}
