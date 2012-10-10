//package test;


//package cn.edu.test;

import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

public final class VectorCard {
   int CardThree[][]=new int[4][21];//记录出牌的四种类型
   int[] PlayCard=new int [20];
   Vector v;
   int n;
   Music music=new Music();
    public VectorCard(Vector v){
for(int i=0;i<4;i++) 
for(int j=0;j<21;j++) {
    CardThree[i][j]=-1;
}
n=v.size();
for(int i=0;i<n;i++) {
    PlayCard[i]=(Integer)v.get(i)-1;
}
     this.run(n,PlayCard);
    }
   void run(int n,int[] PlayCard) {
	   this.PanduanThree(n,PlayCard);
	   if(n==1) {
		   if(PlayCard[0]/4==13&&PlayCard[0]%4==1)
		   {
			   JOptionPane.showMessageDialog(null,"你出的是单张"+(PlayCard[0]/4+3),"单张", JOptionPane.PLAIN_MESSAGE);
		       music.play(String.valueOf(17));
		   }
          else
			{
        JOptionPane.showMessageDialog(null,"你出的是单张"+(PlayCard[0]/4+3),"单张", JOptionPane.PLAIN_MESSAGE);
              music.play(String.valueOf(PlayCard[0]/4+3));
		   }
    }
    if(n==2) {
        if(PlayCard[n-1]/4==13&&PlayCard[n-2]/4==13) 
		{
			JOptionPane.showMessageDialog(null,"你出的是王炸","王炸", JOptionPane.PLAIN_MESSAGE);
			 music.play("wangzha");
		}
        else if(PlayCard[n-1]/4==PlayCard[n-2]/4&&PlayCard[n-2]/4!=13)
		{
			JOptionPane.showMessageDialog(null,"你出的是对子：对"+(PlayCard[n-1]/4+3),"对子", JOptionPane.PLAIN_MESSAGE);
            
			music.play("dui"+CardThree[1][0]);
		}
		else JOptionPane.showMessageDialog(null,"你出的牌不合法2","警告", JOptionPane.WARNING_MESSAGE);
    }
 else  if(n==3)  {
       if(PlayCard[n-1]/4==PlayCard[n-2]/4&&PlayCard[n-3]/4==PlayCard[n-2]/4) {
             JOptionPane.showMessageDialog(null,"你出的是"+CardThree[2][0]+"三不带","三个不带", JOptionPane.PLAIN_MESSAGE);
             new Thread(new Runnable() {

                    @Override
                    public void run() {
                       music.play("sange");
                       try{
                           Thread.sleep(300);
                       }
                       catch(InterruptedException e) {
                           
                       }
                       music.play(String.valueOf(CardThree[2][0]));
                    }
                }
                     ).start();
       }
             else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);
   }
 else  if(n==4)  {
       if(CardThree[3][0]!=-1) 
		   {
             JOptionPane.showMessageDialog(null,"你出的是炸弹"+(PlayCard[n-1]/4+3),"炸弹", JOptionPane.PLAIN_MESSAGE);
		     music.play("zhadan");
		   }
		 else if(CardThree[1][0]==-1&&CardThree[2][0]!=-1) 
	 {
           JOptionPane.showMessageDialog(null,"你出的是三个"+(CardThree[2][0])+"带一","三带一", JOptionPane.PLAIN_MESSAGE);
	        music.play("sandaiyi");
	 } 
			else JOptionPane.showMessageDialog(null,"你出的牌不合法"+n,"警告", JOptionPane.WARNING_MESSAGE);
   }
  else  if(n==5)  {         
      if(PanduanTShunzi(n,PlayCard)) 
	  {
             JOptionPane.showMessageDialog(null,"你出的是顺子"+(PlayCard[0]/4+3)+"到"+(PlayCard[0]/4+2+n),"顺子", JOptionPane.PLAIN_MESSAGE);
	          music.play("shunzi");
	  }
	 else if(CardThree[1][0]!=-1&&CardThree[2][0]!=-1) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[2][0]);
               JOptionPane.showMessageDialog(null,"你出的是三带一对","三带一对", JOptionPane.PLAIN_MESSAGE);
			   music.play("sandaiyidui");
         }
            else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);
   } 
     else  if(n==6)  {         
      if(PanduanTShunzi(n,PlayCard)) 
		 {
             JOptionPane.showMessageDialog(null,"你出的是顺子"+(PlayCard[0]/4+3)+"到"+(PlayCard[0]/4+2+n),"顺子", JOptionPane.PLAIN_MESSAGE);
				music.play("shunzi");
		 }
	  else if(CardThree[3][0]!=-1&&CardThree[1][0]==-1) 
		 {
		  JOptionPane.showMessageDialog(null,"你出的是四个"+(CardThree[3][0])+"带"+CardThree[0][0]+"和"+CardThree[0][1],"炸弹", JOptionPane.PLAIN_MESSAGE);
		  music.play("sidaier");
		 }
	 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
               JOptionPane.showMessageDialog(null,"你出的是三连队","三连队", JOptionPane.PLAIN_MESSAGE);
			   music.play("liandui");
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			
               JOptionPane.showMessageDialog(null,"你出的是飞机不带","飞机不带", JOptionPane.PLAIN_MESSAGE);
			    music.play("feiji");
         }
      else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
    else  if(n==7)  {
         if(PanduanTShunzi(n,PlayCard)) 
		 {
             JOptionPane.showMessageDialog(null,"你出的是顺子"+(PlayCard[0]/4+3)+"到"+(PlayCard[0]/4+2+n),"顺子", JOptionPane.PLAIN_MESSAGE);
		      music.play("shunzi");
		 }
		      else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
        else  if(n==8)  {         
      if(PanduanTShunzi(n,PlayCard)) 
			{
             JOptionPane.showMessageDialog(null,"你出的是顺子"+(PlayCard[0]/4+3)+"到"+(PlayCard[0]/4+2+n),"顺子", JOptionPane.PLAIN_MESSAGE);
			  music.play("shunzi");
			}
		else if(CardThree[3][0]!=-1&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1) 
			{
             JOptionPane.showMessageDialog(null,"你出的是四个"+(CardThree[3][0])+"带两对"+CardThree[1][0]+"和"+CardThree[1][1],"炸弹", JOptionPane.PLAIN_MESSAGE);
	  	       music.play("sidailiangdui");
			}

		 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
			 System.out.println(CardThree[1][3]);
                  music.play("liandui");
               JOptionPane.showMessageDialog(null,"你出的是四连队","四连队", JOptionPane.PLAIN_MESSAGE);
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]==-1) 
         {
             System.out.println(CardThree[0][0]);
             System.out.println(CardThree[0][1]);
			 System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			  music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是飞机带单","飞机带单", JOptionPane.PLAIN_MESSAGE);
         }
      else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
           else  if(n==9)  {         
      if(PanduanTShunzi(n,PlayCard)) 
			   {
             music.play("shunzi");
			 JOptionPane.showMessageDialog(null,"你出的是顺子"+(PlayCard[0]/4+3)+"到"+(PlayCard[0]/4+2+n),"顺子", JOptionPane.PLAIN_MESSAGE);
			   }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
             System.out.println(CardThree[2][2]);
			 music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是三飞机","飞机不带", JOptionPane.PLAIN_MESSAGE);
         }
      else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
           else  if(n==10)  {         
      if(PanduanTShunzi(n,PlayCard)) 
			   {
             JOptionPane.showMessageDialog(null,"你出的是顺子"+(PlayCard[0]/4+3)+"到"+(PlayCard[0]/4+2+n),"顺子", JOptionPane.PLAIN_MESSAGE);
			  music.play("shunzi");
			   }
		 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
			 System.out.println(CardThree[1][3]);
               System.out.println(CardThree[1][4]);
			   music.play("liandui");
               JOptionPane.showMessageDialog(null,"你出的是五连队","五连队", JOptionPane.PLAIN_MESSAGE);
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			   music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是飞机带双","飞机带双", JOptionPane.PLAIN_MESSAGE);
         }
      else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
       else  if(n==11)  {
         if(PanduanTShunzi(n,PlayCard)) 
		   {
             JOptionPane.showMessageDialog(null,"你出的是顺子"+(PlayCard[0]/4+3)+"到"+(PlayCard[0]/4+2+n),"顺子", JOptionPane.PLAIN_MESSAGE);
		      music.play("shunzi");
		   }
		   else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
          else  if(n==12)  {
         if(PanduanTShunzi(n,PlayCard)) 
			  {
             JOptionPane.showMessageDialog(null,"你出的是顺子"+(PlayCard[0]/4+3)+"到"+(PlayCard[0]/4+2+n),"顺子", JOptionPane.PLAIN_MESSAGE);
		  	   music.play("shunzi");
			  }
			  else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]&&CardThree[1][4]+1==CardThree[1][5]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
			 System.out.println(CardThree[1][3]);
               System.out.println(CardThree[1][4]);
			     System.out.println(CardThree[1][5]);
				 music.play("liandui");
               JOptionPane.showMessageDialog(null,"你出的是六连队","六连队", JOptionPane.PLAIN_MESSAGE);
         }   
				 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[2][2]+1==CardThree[2][3]) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
             System.out.println(CardThree[2][2]);
			 System.out.println(CardThree[2][3]);	
			 music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是四飞机","飞机不带", JOptionPane.PLAIN_MESSAGE);
         }	
		 		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[1][0]==-1&&CardThree[1][1]==-1) 
         {
             System.out.println(CardThree[0][0]);
             System.out.println(CardThree[0][1]);
			 System.out.println(CardThree[0][2]);
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			 System.out.println(CardThree[2][2]);
			music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是三飞机带单","飞机带单", JOptionPane.PLAIN_MESSAGE);
         }
			  else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
 else  if(n==13)  {
       JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
 else  if(n==14)  {
         
		   if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]&&CardThree[1][4]+1==CardThree[1][5]&&CardThree[1][5]+1==CardThree[1][6]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
			 System.out.println(CardThree[1][3]);
               System.out.println(CardThree[1][4]);
			     System.out.println(CardThree[1][5]);
				     System.out.println(CardThree[1][6]);
					  music.play("liandui");
               JOptionPane.showMessageDialog(null,"你出的是从"+(CardThree[1][0])+"开始七连队","七连队", JOptionPane.PLAIN_MESSAGE);
         } 
		      else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
    else  if(n==15)  {
         
		 if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[2][2]+1==CardThree[2][3]&&CardThree[2][3]+1==CardThree[2][4]) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
             System.out.println(CardThree[2][2]);
			 System.out.println(CardThree[2][3]);
			 System.out.println(CardThree[2][4]);
			 music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是五飞机","飞机不带", JOptionPane.PLAIN_MESSAGE);
         }	
		  else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1&&CardThree[1][2]!=-1) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			  System.out.println(CardThree[2][2]);
			
               JOptionPane.showMessageDialog(null,"你出的是三飞机带双","飞机带双", JOptionPane.PLAIN_MESSAGE);
         }
	}
	         else  if(n==16)  {
        
          
		  	  	  if(CardThree[1][0]+1==CardThree[1][1]
					  &&CardThree[1][1]+1==CardThree[1][2]
					  &&CardThree[1][2]+1==CardThree[1][3]
					  &&CardThree[1][3]+1==CardThree[1][4]
					  &&CardThree[1][4]+1==CardThree[1][5]
					  &&CardThree[1][5]+1==CardThree[1][6]
					  &&CardThree[1][6]+1==CardThree[1][7]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
			 System.out.println(CardThree[1][3]);
               System.out.println(CardThree[1][4]);
			     System.out.println(CardThree[1][5]);
				   System.out.println(CardThree[1][6]);
				     System.out.println(CardThree[1][7]);
					 music.play("liandui");
               JOptionPane.showMessageDialog(null,"你出的是八连队","八连队", JOptionPane.PLAIN_MESSAGE);
         }   
				 	 else if(CardThree[2][0]+1==CardThree[2][1]
						 &&CardThree[2][1]+1==CardThree[2][2]
						 
                    &&CardThree[0][0]!=-1
						&&CardThree[0][1]!=-1
						&&CardThree[0][2]!=-1
						&&CardThree[0][3]!=-1) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
             System.out.println(CardThree[2][2]);
			 System.out.println(CardThree[2][3]);	
			 music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是四飞机带单","飞机带单", JOptionPane.PLAIN_MESSAGE);
         }	

			  else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
   else if (n==17)
   {
JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);
   }
  else  if(n==18)  {
        
          
		  	  	  if(CardThree[1][0]+1==CardThree[1][1]
					  &&CardThree[1][1]+1==CardThree[1][2]
					  &&CardThree[1][2]+1==CardThree[1][3]
					  &&CardThree[1][3]+1==CardThree[1][4]
					  &&CardThree[1][4]+1==CardThree[1][5]
					  &&CardThree[1][5]+1==CardThree[1][6]
					  &&CardThree[1][6]+1==CardThree[1][7]
					  &&CardThree[1][7]+1==CardThree[1][8]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
			 System.out.println(CardThree[1][3]);
               System.out.println(CardThree[1][4]);
			     System.out.println(CardThree[1][5]);
				   System.out.println(CardThree[1][6]);
				     System.out.println(CardThree[1][7]);
                           music.play("liandui");
               JOptionPane.showMessageDialog(null,"你出的是九连队","九连队", JOptionPane.PLAIN_MESSAGE);
         }   
				 	 else if(CardThree[2][0]+1==CardThree[2][1]
						 &&CardThree[2][1]+1==CardThree[2][2]
						 &&CardThree[2][2]+1==CardThree[2][3]
						 &&CardThree[2][3]+1==CardThree[2][4]
						 &&CardThree[2][4]+1==CardThree[2][5]
                    &&CardThree[0][0]==-1)
 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
             System.out.println(CardThree[2][2]);
			 System.out.println(CardThree[2][3]);	
			 music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是六飞机","飞机不带", JOptionPane.PLAIN_MESSAGE);
         }	

			  else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
      else if (n==19)
   {
JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);
   }
            else  if(n==20)  {
        
		  	   if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]
				   &&CardThree[1][4]+1==CardThree[1][5]
				   &&CardThree[1][5]+1==CardThree[1][6]
				   &&CardThree[1][6]+1==CardThree[1][7]
				   &&CardThree[1][7]+1==CardThree[1][8]
				   &&CardThree[1][8]+1==CardThree[1][9]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
			 System.out.println(CardThree[1][3]);
               System.out.println(CardThree[1][4]);
			     System.out.println(CardThree[1][5]);
				 music.play("liandui");
               JOptionPane.showMessageDialog(null,"你出的是十连队","十连队", JOptionPane.PLAIN_MESSAGE);
         }   
				 	 else if(CardThree[2][0]+1==CardThree[2][1]
						 &&CardThree[2][1]+1==CardThree[2][2]
						 &&CardThree[2][2]+1==CardThree[2][3]
						 &&CardThree[2][3]+1==CardThree[2][4]
						&&CardThree[0][0]!=-1
						&&CardThree[0][1]!=-1
						&&CardThree[0][2]!=-1
						&&CardThree[0][3]!=-1
						 &&CardThree[0][4]!=-1) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
             System.out.println(CardThree[2][2]);
			 System.out.println(CardThree[2][3]);	
			 music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是五飞机","飞机带单", JOptionPane.PLAIN_MESSAGE);
         }	
		 		 	 else if(CardThree[2][0]+1==CardThree[2][1]
						 &&CardThree[2][1]+1==CardThree[2][2]
						 &&CardThree[2][2]+1==CardThree[2][3]
						 
						 &&CardThree[1][0]!=-1&&CardThree[1][1]!=-1
							 &&CardThree[1][2]!=-1&&CardThree[1][3]!=-1) 
         {
             System.out.println(CardThree[0][0]);
             System.out.println(CardThree[0][1]);
			 System.out.println(CardThree[0][2]);
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			 System.out.println(CardThree[2][2]);
			music.play("feiji");
               JOptionPane.showMessageDialog(null,"你出的是四飞机带双","飞机带双", JOptionPane.PLAIN_MESSAGE);
         }
			  else JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

   }
   }
  //判断n张牌中有个几个三张,几个两张
 void PanduanThree(int n,int[] PlayCard) {
      int pos1=0;
	  int pos2=0;
      int pos3=0;
	  int pos4=0;
     int k=0;
     for(int j=0;j<n;j++){
                  k=0;
         for(int i=j+1;i<n;i++) {
             if(PlayCard[j]/4==PlayCard[i]/4) {
                 k++;
   
             }
         }
		
         if(k==0)  {CardThree[0][pos1]=PlayCard[j]/4+3;pos1++;}
         if(k==1)  {CardThree[1][pos2]=PlayCard[j]/4+3;pos2++;
         j++;}
         if(k==2)  {CardThree[2][pos3]=PlayCard[j]/4+3;pos3++;
         j=j+2;}
	     if(k==3)  {CardThree[3][pos3]=PlayCard[j]/4+3;pos3++;
         j=j+3;
		 }
     }
     
    
  }
    //判断是否是顺子
boolean PanduanTShunzi(int n,int[] PlayCard) {
	int pos = 0;
 for(int j=0;j<n-1;j++) {
	 if(PlayCard[j]/4+1==PlayCard[j+1]/4)  pos++;
 }
 if(pos==n-1)  return true;
  return false;
 }
   public static void main(String[] args){
    
     
      Scanner sc = new Scanner(System.in);
     
       while(true){
        Vector v=new Vector();
         while(true){
           
        int n=sc.nextInt();
          if(n<0) break;
         v.add(n);
                 }
          new VectorCard(v);
         }
      
       }
  
   
}
