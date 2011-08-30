import java.util.Scanner;
public class PrintStar {

	public static void main(String[] args) {
		
		int i;
		int j;
                Scanner s=new Scanner(System.in);
                int n=s.nextInt();
		for(i=0;i<n;i++)
		{
			for(j=0;j<=i;j++)
			{
				if(j<i)
				System.out.print("*");
				else
					System.out.println("*");
			}
				
			}
			
	}

}
