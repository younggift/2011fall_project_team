import java.util.Scanner;  
public class InputUtil {  
    private static Scanner scan = new Scanner(System.in);  
      
    public static int getInt(){  
        return scan.nextInt();  
    }  
      
    public static String getString(){  
        return scan.next();  
    }  
    public static String getLine() {  
        return scan.nextLine();  
    }  
}  