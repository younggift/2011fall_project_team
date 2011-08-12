import java.io.*;
import java.math.*;
import java.util.*;
import java.text.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int i, id;
        BigInteger one, ans;
        one = BigInteger.valueOf(1);
        ans = BigInteger.valueOf(2);
        id = cin.nextInt();
        for(i = 1; i <= id; i ++){
            System.out.println(ans);
            ans = ans.multiply(ans.subtract(one)).add(one);
        }
        System.exit(0);
    }
}