class OverloadingMethod
{
	void get(int i)
	{
		System.out.println("get a int data : ");
		System.out.println("i = "+i);
	}
	void get(int x,int y)
	{
		System.out.println("get two int datas :");
		System.out.println("x = "+x+",y = "+y);
	}
	void get(double d)
	{
		System.out.println("get a double data :");
		System.out.println("d = "+d);
	}
	void get(double d1,double d2)
	{
		System.out.println("get two double datas: ");
		System.out.println("d1 = "+d1+",d2 = "+d2);
	}
	void get(String s)
	{
		System.out.println("get a string ");
		System.out.println("s = "+s);
	}
};
public class OverloadingTest
{
	public static void main(String[] args)
	{
		OverloadingMethod overloaddata=new OverloadingMethod();
		overloaddata.get(1);
		overloaddata.get(2,3);
		overloaddata.get(4.5);
		overloaddata.get(4.5,6.7);
		overloaddata.get("qijialiang");
	}
};