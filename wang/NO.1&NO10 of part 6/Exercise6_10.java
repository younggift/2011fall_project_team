
class Component1 {
  public Component1() {
    System.out.println("This is Component1");
  }
}
class Component2 {
  public Component2() {
    System.out.println("This is Component2");
  }
}

class Component3 {
  public Component3() {
    System.out.println("This is Component3");
  }
}

class Root {
  Component1 a = new Component1();
  Component2 b = new Component2();
  Component3 c = new Component3();
  public Root() {
    System.out.println("This is Root");
  }
}

class Stem extends Root {
  Component1 a = new Component1();
  Component2 b = new Component2();
  Component3 c = new Component3();
  public Stem() {
    System.out.println("Hello Stem");
  }
}

public class Exercise6_10 {
  public static void main(String args[]) {
    new Stem();
  }
}