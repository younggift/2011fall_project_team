import javax.swing.JOptionPane;

public class TestCalculator
{
	public static void main(String[] args) 
	{
		String number1Read=JOptionPane.showInputDialog("第一个数: ");
        String number2Read=JOptionPane.showInputDialog("第二个数: ");
		double number1=Double.parseDouble(number1Read);
		double number2=Double.parseDouble(number2Read);
		
		String[] options={"+","-","*","/"};
		int option=JOptionPane.showOptionDialog(null,"请选择运算符号","四则运算",0,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);


		Calculator calcus=new Calculator(number1,number2);
		double calculatedAnswer=0.0;
		char operator=' ';
		boolean ok=true;

		if(option==0)
		{
			operator='+';
			calculatedAnswer=calcus.calculateSum();
		}
		else if(option==1)
		{
            
			calculatedAnswer=calcus.calculateDifference();  
			operator='-';
		}
		else if(option==2)
		{
			calculatedAnswer=calcus.calculateProduct();
			operator='*';
		}
		else if(option==3)
		{
			operator='/';
			if(number2==0.0) ok=false;
			else calculatedAnswer=calcus.calculateQuotient();
		}
		else ok=false;

		String result;
		if(ok) result=number1+" "+operator+" "+number2+"="+calculatedAnswer;
		else result="error";
		JOptionPane.showMessageDialog(null,result);
		System.exit(0);

	}
}


class Calculator
{
	private double number1;
	private double number2;
	
	public Calculator(double pnumber1,double pnumber2)
	{
		number1=pnumber1;
		number2=pnumber2;
	}
	public double getNumber1()
	{
		return number1;
	}
	public double getNumber2()
	{
		return number2;
	}
	public void setNumbers(double newNumber1,double newNumber2)
	{
		number1=newNumber1;
		number2=newNumber2;
	}
	public double calculateSum()
	{
		return number1+number2;
	}
	public double calculateDifference()
	{
		return number1-number2;
	}
	public double calculateProduct()
	{
		return number1*number2;
	}
	public double calculateQuotient()
	{
		return number1/number2;
	}
}
