public class ExceptionCatch 
{
	public static void main(String[] args) 
	{
		try
			{
			System.out.println("tryÓï¾ä¿é");
			throw new Exception();
			}
		catch(Exception e)
		{
			System.err.println("catchÓï¾ä¿é");
			e.printStackTrace();
		}
		finally
		{
			System.out.println("finallyÓï¾ä¿é");
		}
	}
}
