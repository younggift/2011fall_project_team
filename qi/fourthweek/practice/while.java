public class Sum
{
	public static void main(String[] args)
	{
		System.out.println("\n** while statement **");
		int n=10,sum=0;
		while (n>0)
		{
			sum+=n;
			n--;
		}
		System.out.println("sum is "+sum);
		System.out.println("\n** do_while statement **");
		n=0;
		sum=0;
		do
		{
			sum+=n;
			n++;
		}
		while(n<=10);
		System.out.println("sum is "+sum);
		System.out.println("\n** for statement **");
		sum=0;
		for(int i=1;i<=10;i++)
			sum+=i;
		System.out.println("sum is "+sum);
	}
};