/**
 * @author wanjiang
 *
 */
/**
 * @author wanjiang
 *
 */
public class test002 {

	public static void main(String[] args) {
	   int n=123,a=0,b=0,c=0,digsum=0;
	   a=n%10;  //个位
	   b=(n%100)/10; //个位
	   c=n/100; //百位
	   digsum=a+b+c;
	   System.out.println("Digsum("+n+")="+digsum);
	}
}