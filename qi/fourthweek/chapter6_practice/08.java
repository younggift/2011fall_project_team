class Base1 {
  public Base1() {
    System.out.println("Base1");
  }
}

class Derived1 extends Base1 {
  public Derived1() {
    System.out.println("Derived1");
  }
}

class Derived2 extends Derived1 {
  public Derived2() {
    System.out.println("Derived2");
  }
}

public class C_08 {
  public static void main(String args[]) {
    new Derived2();
  }
} 