public class Continue
{
	public static void main(String[] args)
	{
		int i=1,j;
		//label1:   //(1) ��ͬʱȥ��(1)����(2)���ǰ��ע��
		for (;i<4;i++)
		{
			System.out.println("i= "+i);
			System.out.println("OuterLoop "+i+" Up");
			//label2: //(2)
			for (j=1;j<4;j++)
			{
				System.out.print("InnerLoop and ");
				System.out.println("j= "+j);
				if(j>1)
					continue; //��(1)��(2)ʱ��ע�͵�
					//continue label1; //(1)
				    //continue label2; //(2)
				System.out.println("InnerLoop "+j+" Down");
			}
			//continue label2;
			System.out.println("OuterLoop "+i+" Down");
			System.out.println("____________________");
		}
		System.out.println("GameOver!");
	}
};