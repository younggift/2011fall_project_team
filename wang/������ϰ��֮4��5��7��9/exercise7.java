import java.util.Random;

public class exercise7 {
	static Random w = new Random();  
	   
	  public static void main(String[] args) {
	    for(int i = 0; i < 25; i++){
	    	int a = w.nextInt();
		    int b = w.nextInt();
		    System.out.println("************************************");
		    System.out.println("a = " + a + ", b = " + b);
		    if(a < b)
		      System.out.println("a < b");
		    else if (a > b)
		      System.out.println("a > b");
		    else
		      System.out.println("a = b");
		    System.out.println("************************************");
	    	
	  }

	
	  }
	
}
