/*�ں�Arrays���е�toString���÷�
 * System���arraycopy���÷�
 * public static void arraycopy(sourceArray,int index1,copyArray,int index2,int length)
 * ���Խ�����sourceArray������index1��ʼ���length��Ԫ���е����ݸ��Ƶ�copyArray�����У���������sourceArray�е�����ֵ
 * ��index1��index1+length-1Ԫ���е����ݸ��Ƶ�����copyArray��ĳЩԪ���У�����copyArray�ӵ�index2Ԫ�ؿ�ʼ�����Щ���ݡ�
 * �������copyArray���ܴ���¸��Ƶ����ݣ��������н������쳣
 * 
 */

import java.util.Arrays;

public class toString_test {

	
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6};
		int[] b={4,3,2,8,9,10,45};
		System.arraycopy(a,2,b,3,a.length-3);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

	}

}
