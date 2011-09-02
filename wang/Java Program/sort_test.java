/*public static void sort(doublea a[])
 * 可以把参数a指定的 double 类型的数组按升序排序
 * public static void sort(double a[],int start,int end)
 * 可以把参数a指定的double类型的数组从索引start 至end-1的元素的值按升序排序
 * 
 */
import java.util.Arrays;
public class sort_test {

	
	public static void main(String[] args) {
		
		int a[]={12,32,1,31,56,11,7,29,18};
		int b[]={12,32,1,31,56,11,7,29,18};
		Arrays.sort(a);
		Arrays.sort(b,2,6);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
	}

}
