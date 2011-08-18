class Outer{
	String out_string = "String in Outer";
	void useIner1(){
		Iner1 in1 = new Iner1();
		in1.print();
	}
	void useIner2(){
		Iner2 in2 = new Iner2();
		in2.print();
	}
	class Iner1{
		void print(){
			System.out.println("Iner1.print()");
			System.out.println("Outer.out_string="+out_string+"");
		}
	}
	static class Iner2{
		void print(){
			System.out.println("Iner2.print()");
			Outer outer = new Outer();
			System.out.println("Outer.out_string="+outer.out_string+"");
		}
	}
}
public class InnerClassDemo2 {
	public static void main(String[] args){
		Outer out = new Outer();
		out.useIner1();
		out.useIner2();
	}
}
