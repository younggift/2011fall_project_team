/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.StringTokenizer;

/**
 *
 * @author Administrator
 */
public class Testing {
   CreateCard cr;
   public String user1="";
   public String user2="";
   public  String user3="";
   public  String dipai="";
   public  String dizhu="";//地主底牌
   public  int dizhu1;//产生的地主
   public  int[] card;
    public Testing() 
    {
       this.ChangeToString();
    }
    public void ChangeToString()
    {
        cr=new CreateCard();
        card=cr.imgPath;
        for(int i=1;i<card.length;i++)
        {
            if(i<18) user1+="|"+card[i];
          else if(i<35) user2+="|"+card[i];
          else if(i<52) user3+="|"+card[i];
          else dipai+="|"+card[i];
        }
    }
    public String SortString(String str)
    {
        String newString="";
      int[] arr=new int[20];
     StringTokenizer st = new StringTokenizer(str,"|");
     int i=0;
       while (st.hasMoreTokens())
       {
           arr[i]=Integer.parseInt(st.nextToken());
           i++;
       }
     CreateCard.maoPao(arr,0,19);
         for(int j=0;j<arr.length;j++)
    {
               newString+="|"+arr[j];
    }
           return newString;
    }
    public String CreatDizhu(int dizhu1) //根据提交的叫地主的情况随机产生地主
    {
         
           switch(dizhu1)
           {
               case 1:
                   return SortString(user1+dipai);
               
               case 2:
                   return SortString(user2+dipai);
           
               case 3:
                   return SortString(user3+dipai);
                   
                default:
                    System.exit(-1);
           }
          return null;
    }
   public static void main(String[] args)
	{
	   Testing test=new Testing();
	   System.out.println(test.user1);
	   System.out.println();
	   System.out.println();
	}
}
