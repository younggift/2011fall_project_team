
public class Array_addition {

	
	public static void main(String[] args) {
		int[] a ={1,2,3};
		int[] b ={1,1,1};
		int l=a.length;
		for(int i=0;i<l;i++)
			a[i]+= b[i];
		for(int i=0;i<l-1;i++)
		{
		     System.out.print(a[i]+" ");
			
		}
		 System.out.println(a[l-1]);
	}

}
