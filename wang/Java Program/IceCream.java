import java.util.*;

public class IceCream
{
	private static Random rand=new Random();
	public static final String[] flavors={
		"Chocolate","Strawberry","Vanilla Fudge Swirl",
			"Mint Chip","Mocha Almond Fudge","Rum Raisin",
			"Praline Cream","Mud Pie"
	};
	public static String[] flavorSet(int n)
	{
		String[] results=new String[n];
		boolean[] picked=new boolean[flavors.length];
		for(int i=0;i<n;i++)
		{
			int t;
			do
			{
				t=rand.nextInt(flavors.length);
			}
			while (picked[t]);
			results[i]=flavors[t];
			picked[t]=true;

		}
		return  results;
	}

	public static void main(String[] args)
	{
		for(int i=0;i<20;i++)
		{
			System.out.println(
				"flavorSet(" + i + ")=");
			String[] f1=flavorSet(flavors.length);
			for(int j=0;j<f1.length;j++)
			{
				System.out.println("\t"+f1[j]);
			}
		}
	}
}
