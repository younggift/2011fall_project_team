/*本例包含Arrays类的copyOf()和copyOfRange()两个方法的用法
 * public static int/double/char[] copyOf(int/double/char[] original,int newLength)
 * 可以把original指定的数组中从索引0开始的newLength个元素复制到一个新数组中，并返回这个新数组，且新数组的长度为newLength。
 * 如果newLength的值大于 original的长度， copyOf方法返回的新数组的第newLength索引后的元素取默认值0
 * 
 * public static int/double/char[] copyOfRange(int/double/char[] original,int from,int to)
 *  可以把参数original指定的数组从索引from至to-1的元素复制到一个新数组中，并返回这个新数组，新数组的长度为to-from.
 *  如果to的值打于数组original的长度，新数组第original.length-from索引开始的元素取默认值
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
