/*public static void sort(doublea a[])
 * ���԰Ѳ���aָ���� double ���͵����鰴��������
 * public static void sort(double a[],int start,int end)
 * ���԰Ѳ���aָ����double���͵����������start ��end-1��Ԫ�ص�ֵ����������
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
