class Rodent {
  public void eat() {
    System.out.println("Rodent eat");
  }
  public void run() {
    System.out.println("Rodent run");
  }
  public void drink() {
    System.out.println("Rodent drink");
  }
  public String toString() {
    return "Rodent";
  }
}

class Mouse extends Rodent {
  public void eat() {
    System.out.println("Mouse eat");
  }
  public void run() {
    System.out.println("Mouse run");
  }
  public void drink() {
    System.out.println("Mouse drink");
  }
  public String toString() {
    return "Mouse";
  }
}

class Gerbil extends Rodent {
  public void eat() {
    System.out.println("Gerbil eat");
  }
  public void run() {
    System.out.println("Gerbil run");
  }
  public void drink() {
    System.out.println("Gerbil drink");
  }
  public String toString() {
    return "Gerbil";
  }
}

class Hamster extends Rodent {
  public void eat() {
    System.out.println("Hamster eat");
  }
  public void run() {
    System.out.println("Hamster run");
  }
  public void drink() {
    System.out.println("Hamster drink");
  }
  public String toString() {
    return "Hamster";
  }
}

public class Chapter7_6{
  public static void main(String args[]) {
    Rodent[] rodents = {
      new Mouse(),
      new Gerbil(),
      new Hamster(),
    };
    for(int i = 0; i < rodents.length; i++) {
      rodents[i].eat();
      rodents[i].run();
      rodents[i].drink();
      System.out.println(rodents[i]);
    }
  }
} 