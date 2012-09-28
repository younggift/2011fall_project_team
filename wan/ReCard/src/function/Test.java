/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package function;
import java.util.Vector;

public class Test {
    public static void main(String[] args){
    Vector PlayCard=new Vector(); 
    Vector LeftCard=new Vector();
    for(int i=1;i<=20;i++){
        LeftCard.add(i);
    }
    LeftCard.set(2,55);
    LeftCard.set(4,55);
    LeftCard.set(5,55);
    LeftCard.set(9,55);
    for(int i=0;i<LeftCard.size();i++){
     //if((Integer)LeftCard.get(i)>25) LeftCard.remove(i);
    //System.out.println(LeftCard.get(i));
            LeftCard.removeElement(55);
    }
    for(int i=0;i<LeftCard.size();i++){
     //if((Integer)LeftCard.get(i)>25) LeftCard.remove(i);
    System.out.println(LeftCard.get(i));
    
    }
    System.out.println(LeftCard.get(2));
    System.out.println(LeftCard);
    System.out.println(LeftCard.size());
    }
    
}
