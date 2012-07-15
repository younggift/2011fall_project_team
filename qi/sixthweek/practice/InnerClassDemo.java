class Outer{
	String out_string = "String in Outer";
	void useIner(){
		Iner in = new Iner();
		in.print();
	}
	class Iner{
		void print(){
			System.out.println("Iner.print()");
			System.out.println("use\'"+out_string+"\'");
		}
	}
}
public class InnerClassDemo {
	public static void main(String[] args){
		Outer out = new Outer();
		out.useIner();
	}
}
