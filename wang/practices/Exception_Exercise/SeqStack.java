public class SeqStack {
	
	int a[];
	int MAX;
	int top;
	
	
	SeqStack(int m)
	{
		MAX=m;
		a=new int[MAX];
		top=0;
	}
	
	public void push(int item)
	{
		try{
			if(top==MAX)
				throw new Exception("stackFull");
			a[top]=item;
			top++;
		}
		
		catch(Exception e)
		{
			System.out.println("exception:"+e.getMessage());
			System.exit(0);
		}
	}

	
	public static void main(String[] args) {
		
		SeqStack stack=new SeqStack(10);
		for(int i=0;i<11;i++)
		{
			stack.push(i);
		}
		
	}
	
	
		
}