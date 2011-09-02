class IntegerException extends Exception 
{
	String message;
	public IntegerException(int m)
	{
		message="error";
	}
	public String toString()
	{
		return message;
	}
}
class People
{
	private int age=1;
	public void setAge(int age)throws IntegerException
	{
		if(age>=160||age<=0) 
		{
			throw new IntegerException(age);
		}
		else
		{
			this.age=age;
		}
	}
	public int getAge()
	{
		System.out.println("age:"+age);
		return age;
	}
}
public class Exception_test
{
	public static void main(String[] args) 
	{
		People people=new People();
		try{
			people.setAge(180);
			System.out.println(people.getAge());
		}
		catch(IntegerException e)
		{
			System.out.println(e.toString());
		}
	}
}
