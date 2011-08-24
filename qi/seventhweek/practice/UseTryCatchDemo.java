public class UseTryCatchDemo {
	public static void main(String[] args) {
		String str=null;
		int strLength=0;
		try{
			strLength=str.length();
		}
		catch(NullPointerException e){
			System.out.println("在求字符串长度的时候产生异常");
		}
		System.out.println("strlength的长度:"+strLength);

	}

}
