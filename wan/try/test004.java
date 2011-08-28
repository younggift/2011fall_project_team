
public class test004 {

	public static void main(String[] args) {
		double sum=1f,m=1f,l=1f,n=1f;
		do{
		m=1;
		l=l*n;
		n++;
sum=sum+m/l;
		}while(m/l>0);
		System.out.println(+sum);
	}

}
