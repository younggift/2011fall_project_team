/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydispalycard;

import CardAttendant.OnePerson;
import CardAttendant.ThreePerson;
import CardAttendant.TwoPerson;
import function.CreateCard;

/**
 *
 * @author wanjiang
 */
public class MydispalyCard {
   CreateCard creat;
   public static int[] card;
    public MydispalyCard() {
        
    creat=new CreateCard();
    card=creat.imgPath; 
    }
   
    public static void main(String[] args) {
       new  MydispalyCard();// TODO code application logic here
       new OnePerson(1,card);
       new TwoPerson(18,card);
       new ThreePerson(35,card);
    }
}
