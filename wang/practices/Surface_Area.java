import java.io.*;
class Math{
	
	public static double PI = 3.14;
	
}
class Cylinder{
	private float r;
	private float h;
	
	public Cylinder(float pr,float ph){
		r=pr;
		h=ph;
		
	}
	
	public void SetR(float pr,float ph){
		
		r=pr;
		h=ph;
		
	}
	
	public double Area(float r,float h){
		return (2*Math.PI*r+2*Math.PI*r*h);
	}
}
public class Surface_Area {

	
	public static void main(String[] args) throws IOException {
		float r,h;
		
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		r=Float.parseFloat(str);
		str = br.readLine();
		h=Float.parseFloat(str);
		Cylinder cylinder = new Cylinder(r,h);
		System.out.println("r = "+r);
		System.out.println("h = "+h);
		System.out.println(cylinder.Area(r, h));

	}

}
