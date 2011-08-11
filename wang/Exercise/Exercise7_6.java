class Rodent {
	public String toString(){
		  return "Rodents";
	  }
  public void weight() {
    System.out.println("Rodent weight");
  }
  public void amount() {
    System.out.println("Rodent amount");
  }
  public void reproduce() {
    System.out.println("Hello Rodents");
  }
  
 
}

class Mouse extends Rodent {
	 public String tosString(){
		  return "Mouse";
	  }
  public void weight() {
    System.out.println("Mouse weight");
  }
  public void amount() {
    System.out.println("Mouse amount");
  }
  public void reproduce() {
    System.out.println("Hello Mice");
  }
 
  
}

class Gerbil extends Rodent {
	public String toString(){
		  return "Gerbil";
	  }
  public void weight() {
    System.out.println("Gerbil weight");
  }
  public void amount() {
    System.out.println("Gerbil amount");
  }
  public void reproduce() {
    System.out.println("Hello Gerbils");
  }
  
  
}

class Hamster extends Rodent {
	public String toString(){
		  return "Hamster";
	  }
  public void weight() {
    System.out.println("Hamster weight");
  }
  public void amount() {
    System.out.println("Hamster amount");
  }
  public void reproduce() {
    System.out.println("Hello Hamsters");
  }
  
  
}


public class Exercise7_6 {

	public static void main(String[] args) {
		Rodent[] rodents = {
			      new Mouse(),
			      new Gerbil(),
			      new Hamster(),
			    };
		//array of rodent
			    for(int i = 0; i < rodents.length; i++) {
			    	System.out.println(rodents[i]+":");
			      rodents[i].weight();
			      rodents[i].amount();
			      rodents[i].reproduce();
			      
			    }


	}

}
