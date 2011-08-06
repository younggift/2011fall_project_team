public class exercise9 {
  public static void main(String[] args) {
    int max = 100;             // Get the primes from 1 to max
    
    for(int i = 1; i < max; i++) {
      boolean prime = true;
      for(int j = 2; j < i; j++)
        if(i % j == 0) prime = false;
      
      if(prime==true)
        System.out.println(i);
    }
  }
}
