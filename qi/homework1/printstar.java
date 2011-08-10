import java.util.Scanner;


public class Print {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m =  input.nextInt(); 
		for(int j=0;j<=m;j++){
			for(int i=0;i<j;i++){
			    System.out.print("*");
			   }
			   System.out.println(" ");
			  }


	}

}
