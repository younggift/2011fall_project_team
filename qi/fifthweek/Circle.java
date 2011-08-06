
public class Circle {
	private int x;
	private int y;
	private int r;
	public Circle()
	{
		x = 0;
		y = 0;
		r = 0;
	}
	public Circle(int a,int b,int c)
	{
		x = a;
		y = b;
		r = c;
	}
	public void draw()
	{
		System.out.println("draw a circle at point: "+x+","+y);	
	}
	public void erase()
	{
		System.out.println("delete a circle");
		x = 0;
		y = 0;
		r = 0;
	}
	public static void main(String[] args) {
             
	}

}
