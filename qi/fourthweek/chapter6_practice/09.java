
class BaseNonDefault {
  public BaseNonDefault(int i) {
	  System.out.println("i = "+i);
  }
}

class DerivedTwoConstructors extends BaseNonDefault {
  public DerivedTwoConstructors() {
    super(100);
  }
  public DerivedTwoConstructors(int i) {
    super(i);
  }
}

public class C_09{
  public static void main(String args[]) {
    new DerivedTwoConstructors();
    new DerivedTwoConstructors(50);
  }
} 