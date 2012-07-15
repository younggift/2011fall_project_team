public class UseTryCatchDemo2 {
	public static void main(String[] args) {
	     int[] array1={1,2,3};
	     try{
	    	 array1[3]=5;
	     }
	     catch(NullPointerException e){
	    	 System.out.println("在求字符串长度的时候产生空指针异常");
	     }
	     catch(ArrayIndexOutOfBoundsException e){
	    	 System.out.println("出现的错误是数组越界异常");
	     }
	    System.out.println("程序正常退出");    
	}
}