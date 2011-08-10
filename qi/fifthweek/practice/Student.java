public class Student
{
	public int id;
	public int age;
	public Student()
	{
		setdata(1272410006,19);
	}

	public Student(int id1,int age1)
	{
		setdata(id1,age1);
	}
	public void setdata(int id1,int age1)
	{
		id=id1;
		age=age1;
	}
	public void setdata(int id1)
	{
		id=id1;
	}	
	public static void main(String[] args)
	{
		Student qijialiang = new Student();
		qijialiang.setdata(1272410006);
		Student liming=new Student();
		liming.setdata(1272410090,20);
		System.out.print("Qijialiang的学号是"+qijialiang.id);
		System.out.println(",年龄是"+qijialiang.age);
		System.out.print("Liming的学号是"+liming.id);
		System.out.println(",年龄是"+liming.age);

	}

};