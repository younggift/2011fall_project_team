import java.util.Scanner;
public  class GuessNumber {   
public  static  void main(String[] args)  {
System.out.println("����һ��1��100֮�����������������");
int realNumber = (int) (Math.random()*100)+1;
int yourGuess =0;
System.out.println("��������µ����� ");
Scanner input =new Scanner(System.in);
yourGuess = input.nextInt();
while(yourGuess!=realNumber) {
if(yourGuess>realNumber) {
System.out.println("��´��ˣ���������µ���");
yourGuess = input.nextInt();
}
else if(yourGuess<realNumber) 
	{
System.out.println("���С�ˣ���������µ���");
yourGuess = input.nextInt();
}
}
System.out.println("��ϲ��¶���");

}
}
