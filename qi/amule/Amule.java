import java.io.IOException;   
public class Amule{
	public static void add(String ed2k_link){
		 try {   
	            String exeFullPathName="C:/Mr.Qi/workspace/Amule.exe";   
	            String message="ed2k \"ed2k_link\"";  
	            String []cmd={exeFullPathName,message};   
	            Process proc=Runtime.getRuntime().exec(cmd);   
	        } catch (IOException e) {   
	            e.printStackTrace();   
	        }   
	}
    public static void main(String[] args) {   
    	
    }
} 