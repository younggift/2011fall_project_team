public class ExceptionCatch 
{
	public static void main(String[] args) 
	{
		try
			{
			System.out.println("try����");
			throw new Exception();
			}
		catch(Exception e)
		{
			System.err.println("catch����");
			e.printStackTrace();
		}
		finally
		{
			System.out.println("finally����");
		}
	}
}
