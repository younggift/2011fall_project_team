import java.io.IOException;


public class Exercise02 {

	
	public static void main(String[] args) {
		try{
			System.out.println("������������");
			throw new IOException("�û����в����쳣");
			
		}
		catch(IOException e)
		{
			System.out.println("�Ѳ�����쳣");
		}
	}

}
