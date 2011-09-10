//RePrintStar.java
import java.util.*;
public class RePrintStar{
  public static void main(String[] args){
    Scanner input=new Scanner(System.in);
	int line_num=input.nextInt();
	for(int i=1;i<=line_num;i++){
	  for(int j=0;j<i;j++){
	    System.out.print("*");
	  }
	  System.out.println();
	}
  }
}
