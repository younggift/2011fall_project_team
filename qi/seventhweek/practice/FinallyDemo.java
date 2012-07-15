public class FinallyDemo {
	public static void main(String[] args) {
		String str=null;
		int strLength=0;
		try{
			strLength=str.length();
			System.out.println("出现异常语句之后");
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		finally{
		   System.out.println("执行finally语句块");	
		}
		System.out.println("程序退出");
	}
}