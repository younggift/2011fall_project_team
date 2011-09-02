/* 二分法查找数组中有无给定的元素
 *public static int binarySearch(int[] a,int num)
 *其中a指定的数组是一个已排好序的数组
 * 如果能找的num则返回 a指定的数组中与num值相同元素的索引，
 * 否则返回一个负数
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
