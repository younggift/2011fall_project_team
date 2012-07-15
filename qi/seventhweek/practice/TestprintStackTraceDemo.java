
public class TestprintStackTraceDemo {
	public static void main(String[] args) {
	    try{
	    	method1();
	    }
	    catch(NullPointerException e){
	    	e.printStackTrace();
	    }
	}
	    static void method1(){
	    	method2();
	    }
	    static void method2(){
	        method3();	
	    }
	    static void method3(){
	    	String str=null;
	        int n=str.length();
	    }
}