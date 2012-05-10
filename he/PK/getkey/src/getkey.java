import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class getkey {

    //public static getString(){
   public static void main (String[] args){
       //showpic show = showpic();
        String input = "";
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)
                );
        try {
            input = stdin.readLine();
        }
        catch (IOException iox) {
            System.err.println(iox);
        }
        System.out.println(input);
        //return input;
    }
}
