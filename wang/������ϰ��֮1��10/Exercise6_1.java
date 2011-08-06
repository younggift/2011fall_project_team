class A {
  public A() {
    System.out.println("class A");
  }
}

class B {
  public B() {
    System.out.println("class B");
  }
}

class C extends A {
  B b = new B();
}

public class Exercise6_1 {
  public static void main(String args[]) {
    new C();
  }
}
