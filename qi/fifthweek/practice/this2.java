public class This1
{
	This1()
	{
		this(16,24f);
	}

	This1(float f)
	{
		System.out.println("f="+f);
	}
	This1(int i,float f)
	{
		this(24f);
		System.out.println("i="+i);
		System.out.println("i+f="+(f+i));
	}
	public static void main(String[] args)
	{
		This1 c=new This1();
	}
};