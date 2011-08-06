class Point
{
	int x=1;
	int y=2;
};
class Circle
{
	int x=5,y=6;
	Point point;
	void setXY(int x1,int y1)
	{
		x1=x;
		y1=y;
	}
	void setPoint(Point ref)
	{
		ref.x=x;
		ref.y=y;
	}

};
public class ParameterTest
{
	public static void main(String [] args)
	{
		Circle p=new Circle();
		int xValue=-1,yValue=-1;
		System.out.println("zhi chuan di£º");
		p.setXY(xValue,yValue);
		System.out.println("xValue="+xValue+",yValue="+yValue);

		Point point=new Point();
		p.setPoint(point);
		System.out.println("di zhi chuan di£º");
		System.out.println("point.x="+point.x+",point.y="+point.y);
	}
};