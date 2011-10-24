public class  ExceptionThrow
{
	public static void mb_throwException()
	{
		System.out.println("产生并抛出ArithmeticException类型的异常");
		throw new ArithmeticException();
	}
	public static void mb_cathArrayException()
	{
		try
		{
			mb_throwException();
			System.out.println("在try与剧中的多余语句");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("方法mb_cathArrayException捕捉到异常");
		}
		finally
		{
			System.out.println("方法mb_cathArrayException的finally语句块");
		}
	}
	public static void main(String[] args) 
	{
		try
		{
			mb_cathArrayException();
		}
		catch(ArithmeticException e)
		{
			System.err.println("方法main捕捉到异常");
		}
		finally
		{
			System.out.println("方法main的finally语句块");
		}
		System.out.println("异常处理结束");
	}
}
