public class UseTryCatchDemo {
	public static void main(String[] args) {
		String str=null;
		int strLength=0;
		try{
			strLength=str.length();
		}
		catch(NullPointerException e){
			System.out.println("�����ַ������ȵ�ʱ������쳣");
		}
		System.out.println("strlength�ĳ���:"+strLength);

	}

}
