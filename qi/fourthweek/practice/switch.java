public class Switch
{
	public static void main(String[] args) 
	{
		int num=0;
		int s=2;
		switch(s)
		{
			case 1:
				num=1;
				break;
			case 2:
				num=2;
				break;
			case 3:
				num=3;
				break;
			default:
				num=4;
		}
		System.out.println("num="+num);
	}
}