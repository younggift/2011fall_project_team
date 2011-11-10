import java.io.*;
public class Circle {
	int radius;
	public Circle()
	{
		radius=1;
	}
	public int getRadius()
	{
		return radius;
	}
	public void setRadius(int newradius)
	{
		radius=newradius;
	}
	public double circleArea()
	{
		return Math.PI*radius*radius;
	}
	public double circleLength()
	{
		return Math.PI*radius*2.0;
	}

}
