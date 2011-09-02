import java.util.Scanner;
public  class GuessNumber {   
public  static  void main(String[] args)  {
System.out.println("给你一个1到100之间的数，请你猜这个数");
int realNumber = (int) (Math.random()*100)+1;
int yourGuess =0;
System.out.println("请输入你猜的数： ");
Scanner input =new Scanner(System.in);
yourGuess = input.nextInt();
while(yourGuess!=realNumber) {
if(yourGuess>realNumber) {
System.out.println("你猜大了，再输入你猜的数");
yourGuess = input.nextInt();
}
else if(yourGuess<realNumber) 
	{
System.out.println("你猜小了，再输入你猜的数");
yourGuess = input.nextInt();
}
}
System.out.println("恭喜你猜对了");

}
}
