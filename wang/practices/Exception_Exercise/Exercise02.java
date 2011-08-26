import java.io.IOException;


public class Exercise02 {

	
	public static void main(String[] args) {
		try{
			System.out.println("程序正在运行");
			throw new IOException("用户自行产生异常");
			
		}
		catch(IOException e)
		{
			System.out.println("已捕获该异常");
		}
	}

}
