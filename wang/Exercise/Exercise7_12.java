class Aprint{
	public Aprint(){
		print();
	}
		public void print(){
			System.out.println("wang print");
		}
		
	
}

class Bprint extends Aprint{
	int i=23;
	public void print(){
	System.out.println("i="+ i);
	}
}
public class Exercise7_12 {

	public static void main(String[] args) {
		Bprint x = new Bprint();
		x.print();
	}

}
