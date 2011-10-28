import java.util.*;

class switchtest 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int opetion = 0;
		int i = 0;
		switch(opetion)
		{
			case 0:
				break;
			case 1:
			//	A:
			//{
				for(i = 0;i<opetion;i++)
				System.out.println("Hello World!");
				//break A;
			//}
			break;
			
			case 2:
			//	B:
			//{
				for(i = 0;i<opetion;i++)
				System.out.println("Hello World!");
			//	break B;
			//}
			break;
			
			default:
				System.out.println("ERROR!");

		}

		System.out.println("End!");
	}
}
