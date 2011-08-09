class Student
{
	String name="Qi Jialiang";
	int age=19;
	public void getDetail()
	{
		System.out.println("name: "+name+"\n"+"age:" +age);
	}

};
public class GoodStudent extends Student
{
	String mentorTeacherName="Professor Yang";
	public void getDetail()
	{
		super.getDetail();
		System.out.println("his mentor teacher is : "+mentorTeacherName);
	}
	public static void main(String[] args)
	{
		GoodStudent gs=new GoodStudent();
		gs.getDetail();
	}
};