public class Constructor
{
	private int x;
	public Constructor()
	{
		x=24;
	}
	public Constructor(int x1)
	{
		x=x1;
	}
	public void print()
	{
		 System.out.println("x= "+x);
	}

	public static void main(String[] args)
	{
		Constructor c=new Constructor();
		c.print();
		Constructor c1=new Constructor(16);
		c1.print();
	}

};