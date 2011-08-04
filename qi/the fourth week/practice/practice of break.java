public class Break
{
	public static void main(String[] args)
	{
		int i=1,j;
		//label1:   //(1) 可同时去掉(1)或者(2)语句前的注释
		for (;i<4;i++)
		{
			System.out.println("i= "+i);
			System.out.println("OuterLoop "+i+" Up");
			//label2: //(2)
			for (j=1;j<4;j++)
			{
				System.out.print("InnerLoop and ");
				System.out.println("j= "+j);
				break;        //有(1)或(2)时需注释掉
				//break label1; //(1)
				//break label2; //(2)
			}
			System.out.println("OuterLoop "+i+" Down");
			System.out.println("____________________");
		}
		System.out.println("GameOver!");
	}
};