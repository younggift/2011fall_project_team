public class UseTryCatchDemo2 {
	public static void main(String[] args) {
	     int[] array1={1,2,3};
	     try{
	    	 array1[3]=5;
	     }
	     catch(NullPointerException e){
	    	 System.out.println("�����ַ������ȵ�ʱ�������ָ���쳣");
	     }
	     catch(ArrayIndexOutOfBoundsException e){
	    	 System.out.println("���ֵĴ���������Խ���쳣");
	     }
	    System.out.println("���������˳�");    
	}
}