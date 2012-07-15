public class LeapYear
{
	public static void main(String[] args)
	{
		int year=1900;
		if((year%4==0 && year%100!=0) || (year%400==0))
			System.out.println(year+" is a leap year.");
		else 
			System.out.println(year+" is not a leap year.");
		year=2000;
		boolean leap;
		if(year%4!=0)
			leap=false;
		else if(year %100 !=0)
			leap=true;
		else if(year%400!=0)
			leap=false;
		else
			leap=true;
		if(leap==true)
			System.out.println(year+" is a leap year.");
		else
			System.out.println(year+" is not a leap year.");
		year=2199;
		if(year%4==0)
		{
			if(year%100==0)
			{
				if(year%400==0)
					leap=true;
				else
					leap=false;
			}
			else
				leap=false;
		}
		else
			leap=false;
		if(leap==true)
			System.out.println(year+" is a leap year.");
		else
			System.out.println(year+" is not a leap year.");
	}
};