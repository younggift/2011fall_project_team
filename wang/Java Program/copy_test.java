/*��������Arrays���copyOf()��copyOfRange()�����������÷�
 * public static int/double/char[] copyOf(int/double/char[] original,int newLength)
 * ���԰�originalָ���������д�����0��ʼ��newLength��Ԫ�ظ��Ƶ�һ���������У���������������飬��������ĳ���ΪnewLength��
 * ���newLength��ֵ���� original�ĳ��ȣ� copyOf�������ص�������ĵ�newLength�������Ԫ��ȡĬ��ֵ0
 * 
 * public static int/double/char[] copyOfRange(int/double/char[] original,int from,int to)
 *  ���԰Ѳ���originalָ�������������from��to-1��Ԫ�ظ��Ƶ�һ���������У���������������飬������ĳ���Ϊto-from.
 *  ���to��ֵ��������original�ĳ��ȣ��������original.length-from������ʼ��Ԫ��ȡĬ��ֵ
 */

import java.util.Arrays;
public class copy_test {

	
	public static void main(String[] args) {
		
		int[] a={1,2,3,4,5};
		int[] b=Arrays.copyOf(a,4);
		int[] c=Arrays.copyOfRange(a,1,4);
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		
	}

}
