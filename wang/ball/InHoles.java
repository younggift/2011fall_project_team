public class InHoles {
	public boolean inHoleNo[]=new boolean[7];
	double holeX[]=new double[]{100,500,900};
	double holeY[]=new double[]{50,450};
	void inHole(double x,double y)
	{
		if(Math.hypot(x-100, y-50)<=22)  inHoleNo[1]=true;
		if(Math.hypot(x-100, y-450)<22)  inHoleNo[2]=true;
		if(Math.hypot(x-500, y-42.2)<=22) inHoleNo[3]=true;
		if(Math.hypot(x-500, y-457.8)<=22) inHoleNo[4]=true;
		if(Math.hypot(x-900, y-50)<=22)  inHoleNo[5]=true;
		if(Math.hypot(x-900, y-450)<=22) inHoleNo[6]=true;
	}
	void init()
	{
		for(int i=0;i<7;i++)  inHoleNo[i]=false;
	}
}
