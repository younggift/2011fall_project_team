class Human
{
	public int sex;
	public int salary;
	public void manOrWoman(int sexValue)
	{
		switch(sexValue)
		{
			case 0:
				System.out.println("a man");
				break;
			case 1:
				System.out.println("a woman");
				break;
			default:
				System.out.println("not a man or a woman");
		}
	}
	public void employed(int salaryValue)
	{
		if(salaryValue==0)
			System.out.println("no job");
		else
			System.out.println("job and salary is "+salaryValue);
	}
}

class Kids extends Human
{
	int yearsOld;
	void printAge()
	{
		System.out.println("age= "+yearsOld);
	}
	public void employed(int salaryValue)
	{
		System.out.println("kids should study and no job");
	}
}
public class Extends {
	public static void main(String[] args) 
	{
		Human somePerson=new Human();
		somePerson.sex=1;
		somePerson.manOrWoman(somePerson.sex);
		somePerson.salary=5000;
		somePerson.employed(somePerson.salary);
		Kids someKid=new Kids();
		someKid.sex=0;
		someKid.manOrWoman(someKid.sex);
		someKid.salary=2000;
		someKid.employed(someKid.salary);
		someKid.yearsOld=3;
		someKid.printAge();
	}

}
