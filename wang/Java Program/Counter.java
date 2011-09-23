class YesNoCounter
{
	private int numberOfYes=0;
	private int numberOfNo=0;
	
	public void increaseNumberOfYes()
	{
		numberOfYes++;
	}

	public void increaseNumberOfNo()
	{
		numberOfNo++;
	}

	public void increaseNumberOfYes(int increase)
	{
		numberOfYes+=increase;
	}

	public void increaseNumberOfNo(int increase)
	{
		numberOfNo+=increase;
	}

	public int getNumberOfYes()
	{
		return numberOfYes;
		
	}

	public int getNumberOfNo()
	{
		return numberOfNo;
		
	}
}

public class Counter
{
	public static void main(String[] args)
	{
		YesNoCounter counter=new YesNoCounter();
		counter.increaseNumberOfYes();
		counter.increaseNumberOfNo();
		counter.increaseNumberOfYes(29);
		counter.increaseNumberOfNo(45);
		System.out.println(counter.getNumberOfYes());
		System.out.println(counter.getNumberOfNo());
	}
}