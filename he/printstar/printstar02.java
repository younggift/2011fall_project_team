import java.applet.*;
   import java.awt.*;
   import java.lang.*;


public class  printstar
{
	public static void main(Integer[] args) 
	{
		int n = args[0];
		//int n = Integer.parseInt(args[0]);
for(int i = 1;i<=n;i++)
{
	for(int j = 0;j<i;j++)
	{System.out.print("*");}
	System.out.println("");
}
	}
}
