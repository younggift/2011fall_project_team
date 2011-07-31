import com.bruceeckel.simpletest.*;
public class leaf {
  static Test monitor =new Test();
  int i=0;
  leaf increment(){
	  i++;
	  return this;
  }
  void print(){
	  System.out.println("i= "+i);
  }
  public static void main(String[] args){
	  leaf x=new leaf();
	  x.increment().increment().increment().print();
	  monitor.expect(new String[]{
			  "i=3"
	  });
  }
}
