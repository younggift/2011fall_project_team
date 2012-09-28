/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class Comparecard {

   public  static boolean run(Vector last,Vector current)
   {
      Compare compare=new Compare();
       int lastSize=last.size();
      int[] lastcard=compare.run(last);
       int currentSize=current.size();
      
      int[] currentcard=compare.run(current);
      //上家是王炸
      if(last.isEmpty()) return true;
      //由于牌是唯一标志的，可以用于对玩家不出的操作
      else if(last.equals(current))
           return true;
      if(lastSize==2&&lastcard[1]==1) {
        //   MydispalyCard.Recodcard.removeAllElements();
              return false;
      }
      //本家是王炸
      else if(currentSize==2&&currentcard[1]==1) {
          // MydispalyCard.Recodcard.removeAllElements();   
          return true;
      }
      //如果当前玩家为炸弹，上家不是炸弹
      else if(currentSize==4&&currentcard[1]==2&&lastSize!=4)
          return true;
      else if(currentSize==4&&currentcard[1]==2&&lastSize==4&&lastcard[1]==1)    
          return true;
      //如果两个玩家的牌数不一致
     else if(currentSize!=lastSize)
           return false;
      else if(currentcard[0]!=lastcard[0])
          return false;     
     //类型相同，比较大小
     else if(currentcard[1]==lastcard[1]&&currentcard[2]>lastcard[2])
          return true;
     //其他情况，不行
      else
          return false;
   }
   public static void main(String[] args)
   {
       Vector last = new Vector();
       Vector current = new Vector();
       last.add(1);
       last.add(2);
       last.add(3);
       last.add(4);
       current.add(5);
       current.add(6);
       current.add(7);
       current.add(8);
        if(run(current,last))
             System.out.println("可以出牌");
         else
             System.out.println("不可以出牌");
   }
}
