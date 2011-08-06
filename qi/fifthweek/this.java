class A
{
	int x=0,y=0,z=0;
	void init(int x,int y,int z)
	{
		this.x=x;
		this.y=y;
		this.z=z;
		System.out.println("x= "+x+",y="+y+",z="+z);
	}
	public static void main(String[] args)
	{
		A a=new A();
		a.init(1,2,3);
	}

};