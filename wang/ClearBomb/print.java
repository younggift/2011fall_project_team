public class print {
	void printtest(char a[][])
	{
		for(int i=0;i<a.length;i++)
			{
			    for(int j=0;j<a[i].length;j++)
			    	System.out.print(a[i][j]);
			    System.out.print("\n");
			}
	}

}