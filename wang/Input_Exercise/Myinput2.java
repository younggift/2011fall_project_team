import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Myinput2 {
		public static String readString(){
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in),1);
			String string =" ";
			try{
				string = br.readLine();
			}
			catch(IOException ex)
			{
				System.out.println(ex);
			}
			return string;
		    }
			public static int readInt()
			{
				return Integer.parseInt(readString());
			}
			public static double readDouble()
			{
				return Double.parseDouble(readString());
			}

}
