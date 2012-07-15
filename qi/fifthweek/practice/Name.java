public class  Name
{
	String name;
	public static void main(String[] args) 
	{
		Name person1=new Name();
		Name person2=new Name();
		person1.name="qijialiang";
		person2.name="liming";
		System.out.println();
		System.out.println("person1.name="+person1.name+"  person2.salary="+person2.name);
		person1=person2;
		System.out.println("person1.salary="+person1.name+"  person2.salary="+person2.name);
		person1.name="xiaoli";
		System.out.println("person1.salary="+person1.name+"  person2.salary="+person2.name);
		person2.name="maomao";
		System.out.println("person1.salary="+person1.name+"  person2.salary="+person2.name);
	}
};
