/* ���ַ��������������޸�����Ԫ��
 *public static int binarySearch(int[] a,int num)
 *����aָ����������һ�����ź��������
 * ������ҵ�num�򷵻� aָ������������numֵ��ͬԪ�ص�������
 * ���򷵻�һ������
 * 
 */

import java.util.Arrays;
public class BinarySearch_test {

	
	public static void main(String[] args) {
		int a[]={1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.binarySearch(a,5));
		System.out.println(Arrays.binarySearch(a,10));
	}

}
