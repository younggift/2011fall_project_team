class subString 
{
	public static void main(String[] args) 
	{
		String input = "D34";
		//String input = str.nextLine();
		String operate = input.substring(0,1);
		String coordinate = input.substring(1);
		int x = Integer.parseInt(coordinate.substring(0,1));
		int y = Integer.parseInt(coordinate.substring(1,2));
		System.out.println(operate);
		System.out.println(coordinate);
		System.out.println(x);
		System.out.println(y);

	}
}
