public class FinallyDemo {
	public static void main(String[] args) {
		String str=null;
		int strLength=0;
		try{
			strLength=str.length();
			System.out.println("�����쳣���֮��");
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		finally{
		   System.out.println("ִ��finally����");	
		}
		System.out.println("�����˳�");
	}
}