
public class String_Exercise {

	
	public static void main(String[] args) {
		String a = new String("Hello");
		System.out.println(a);
		System.out.println(a.indexOf('H'));
		System.out.println(a.toLowerCase());
		System.out.println(a.toUpperCase());
		System.out.println(a.equals("hello"));
		System.out.println(a.concat("World"));
		System.out.println(a.replace(a, "wangtuizhi"));
	}

}
