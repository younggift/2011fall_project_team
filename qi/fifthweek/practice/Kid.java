class Animal
{
	Animal()
	{
		System.out.println("Animal's constructor");
	}
	Animal(int num)
	{
		System.out.println("Animal's constructor= "+num);
	}
}

class Mankind extends Animal
{
	Mankind()
	{
		System.out.println("Mankind's constructor");
	}
	Mankind(int num)
	{
		System.out.println("Mankind's constructor= "+num);
	}
}

public class Kid extends Mankind
{
	Kid()
	{
		System.out.println("Kid's constructor");
	}
	Kid(int num)
	{
		System.out.println("Kid's constructor= "+num);
	}
	public static void main(String[] args)
	{
		System.out.println("start kid's constructor");
		Kid xiaohong=new Kid();
		Kid xiaoming=new Kid(19);
		System.out.println("end kid's constructor");
	}
};