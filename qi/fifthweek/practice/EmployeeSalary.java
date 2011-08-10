class Employee
{
	void salary()
	{
		System.out.println("Employee salary");
	}
};
class Secretary extends Employee
{
	void salary()
	{
		System.out.println("Secretary salary");
	}
};
class Manager extends Employee
{
	void salary()
	{
		System.out.println("Manager salary");
	}
};
public class EmployeeSalary
{
	static void salaryOfEmployee(Secretary clerk)
	{
		clerk.salary();
	}
	static void salaryOfEmployee(Manager clerk)
	{
		clerk.salary();
	}
	public static void main(String[] args)
	{
		Secretary s=new Secretary();
		Manager m=new Manager();
		salaryOfEmployee(s);
		salaryOfEmployee(m);
	}
};