/*内含Arrays类中的toString的用法
 * System类的arraycopy的用法
 * public static void arraycopy(sourceArray,int index1,copyArray,int index2,int length)
 * 可以将数组sourceArray从索引index1开始后的length个元素中的数据复制到copyArray数组中，即将数组sourceArray中的索引值
 * 从index1到index1+length-1元素中的数据复制到数组copyArray的某些元素中；数组copyArray从第index2元素开始存放这些数据。
 * 如果数组copyArray不能存放下复制的数据，程序运行将发生异常
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
