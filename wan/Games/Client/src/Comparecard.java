/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
      //�ϼ�����ը
      if(last.isEmpty()) return true;
      //��������Ψһ��־�ģ��������ڶ���Ҳ����Ĳ���
      else if(last.equals(current))
           return true;
      if(lastSize==2&&lastcard[1]==1) {
        //   MydispalyCard.Recodcard.removeAllElements();
              return false;
      }
      //��������ը
      else if(currentSize==2&&currentcard[1]==1) {
          // MydispalyCard.Recodcard.removeAllElements();   
          return true;
      }
      //�����ǰ���Ϊը�����ϼҲ���ը��
      else if(currentSize==4&&currentcard[1]==2&&lastSize!=4)
          return true;
      else if(currentSize==4&&currentcard[1]==2&&lastSize==4&&lastcard[1]==1)    
          return true;
      //���������ҵ�������һ��
     else if(currentSize!=lastSize)
           return false;
      else if(currentcard[0]!=lastcard[0])
          return false;     
     //������ͬ���Ƚϴ�С
     else if(currentcard[1]==lastcard[1]&&currentcard[2]>lastcard[2])
          return true;
     //�������������
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
             System.out.println("���Գ���");
         else
             System.out.println("�����Գ���");
   }
}
