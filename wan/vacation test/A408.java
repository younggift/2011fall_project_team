
public class A408 {
private String s;//A408的成员变量（默认null)
	public static void main(String[] args) {
		A408 a = new A408();
		System.out.println(a.s);
		String str;
		str = new String("这是字符串对象");
		a.s ="hello,"+str;
		System.out.println(str);
		System.out.println(a.s);
		}

}
