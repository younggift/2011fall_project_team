public class Circle
{
	private int x;
	private int y;
	private int r;
	public Circle(int x1,int y1,int r1)
	{
		x=x1;
		y=y1;
		r=r1;
	}
	public void set(int x1,int y1,int r1)
	{
		x=x1;
		y=y1;
		r=r1;
	}
	public void print()
	{
		System.out.println("x= "+x+", y= "+y+", r= "+r);
	}
	public static void main(String[] args)
	{
		Circle m=new Circle(1,2,3);
		m.print();
		Circle t=m;
		t.set(4,5,6);
		t.print();
		m.print();
		t=new Circle(7,8,9);
		t.print();
		m.print();
	}
};