public class  ExceptionThrow
{
	public static void mb_throwException()
	{
		System.out.println("�������׳�ArithmeticException���͵��쳣");
		throw new ArithmeticException();
	}
	public static void mb_cathArrayException()
	{
		try
		{
			mb_throwException();
			System.out.println("��try����еĶ������");
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("����mb_cathArrayException��׽���쳣");
		}
		finally
		{
			System.out.println("����mb_cathArrayException��finally����");
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
			System.err.println("����main��׽���쳣");
		}
		finally
		{
			System.out.println("����main��finally����");
		}
		System.out.println("�쳣�������");
	}
}
