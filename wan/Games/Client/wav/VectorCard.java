//package test;


//package cn.edu.test;

import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

public final class VectorCard {
   int CardThree[][]=new int[4][21];//��¼���Ƶ���������
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
			   JOptionPane.showMessageDialog(null,"������ǵ���"+(PlayCard[0]/4+3),"����", JOptionPane.PLAIN_MESSAGE);
		       music.play(String.valueOf(17));
		   }
          else
			{
        JOptionPane.showMessageDialog(null,"������ǵ���"+(PlayCard[0]/4+3),"����", JOptionPane.PLAIN_MESSAGE);
              music.play(String.valueOf(PlayCard[0]/4+3));
		   }
    }
    if(n==2) {
        if(PlayCard[n-1]/4==13&&PlayCard[n-2]/4==13) 
		{
			JOptionPane.showMessageDialog(null,"���������ը","��ը", JOptionPane.PLAIN_MESSAGE);
			 music.play("wangzha");
		}
        else if(PlayCard[n-1]/4==PlayCard[n-2]/4&&PlayCard[n-2]/4!=13)
		{
			JOptionPane.showMessageDialog(null,"������Ƕ��ӣ���"+(PlayCard[n-1]/4+3),"����", JOptionPane.PLAIN_MESSAGE);
            
			music.play("dui"+CardThree[1][0]);
		}
		else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�2","����", JOptionPane.WARNING_MESSAGE);
    }
 else  if(n==3)  {
       if(PlayCard[n-1]/4==PlayCard[n-2]/4&&PlayCard[n-3]/4==PlayCard[n-2]/4) {
             JOptionPane.showMessageDialog(null,"�������"+CardThree[2][0]+"������","��������", JOptionPane.PLAIN_MESSAGE);
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
             else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);
   }
 else  if(n==4)  {
       if(CardThree[3][0]!=-1) 
		   {
             JOptionPane.showMessageDialog(null,"�������ը��"+(PlayCard[n-1]/4+3),"ը��", JOptionPane.PLAIN_MESSAGE);
		     music.play("zhadan");
		   }
		 else if(CardThree[1][0]==-1&&CardThree[2][0]!=-1) 
	 {
           JOptionPane.showMessageDialog(null,"�����������"+(CardThree[2][0])+"��һ","����һ", JOptionPane.PLAIN_MESSAGE);
	        music.play("sandaiyi");
	 } 
			else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�"+n,"����", JOptionPane.WARNING_MESSAGE);
   }
  else  if(n==5)  {         
      if(PanduanTShunzi(n,PlayCard)) 
	  {
             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
	          music.play("shunzi");
	  }
	 else if(CardThree[1][0]!=-1&&CardThree[2][0]!=-1) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[2][0]);
               JOptionPane.showMessageDialog(null,"�����������һ��","����һ��", JOptionPane.PLAIN_MESSAGE);
			   music.play("sandaiyidui");
         }
            else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);
   } 
     else  if(n==6)  {         
      if(PanduanTShunzi(n,PlayCard)) 
		 {
             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
				music.play("shunzi");
		 }
	  else if(CardThree[3][0]!=-1&&CardThree[1][0]==-1) 
		 {
		  JOptionPane.showMessageDialog(null,"��������ĸ�"+(CardThree[3][0])+"��"+CardThree[0][0]+"��"+CardThree[0][1],"ը��", JOptionPane.PLAIN_MESSAGE);
		  music.play("sidaier");
		 }
	 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
               JOptionPane.showMessageDialog(null,"�������������","������", JOptionPane.PLAIN_MESSAGE);
			   music.play("liandui");
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			
               JOptionPane.showMessageDialog(null,"������Ƿɻ�����","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
			    music.play("feiji");
         }
      else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
    else  if(n==7)  {
         if(PanduanTShunzi(n,PlayCard)) 
		 {
             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
		      music.play("shunzi");
		 }
		      else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
        else  if(n==8)  {         
      if(PanduanTShunzi(n,PlayCard)) 
			{
             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
			  music.play("shunzi");
			}
		else if(CardThree[3][0]!=-1&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1) 
			{
             JOptionPane.showMessageDialog(null,"��������ĸ�"+(CardThree[3][0])+"������"+CardThree[1][0]+"��"+CardThree[1][1],"ը��", JOptionPane.PLAIN_MESSAGE);
	  	       music.play("sidailiangdui");
			}

		 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]) 
         {
             System.out.println(CardThree[1][0]);
             System.out.println(CardThree[1][1]);
			 System.out.println(CardThree[1][2]);
			 System.out.println(CardThree[1][3]);
                  music.play("liandui");
               JOptionPane.showMessageDialog(null,"�������������","������", JOptionPane.PLAIN_MESSAGE);
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]==-1) 
         {
             System.out.println(CardThree[0][0]);
             System.out.println(CardThree[0][1]);
			 System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			  music.play("feiji");
               JOptionPane.showMessageDialog(null,"������Ƿɻ�����","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
         }
      else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
           else  if(n==9)  {         
      if(PanduanTShunzi(n,PlayCard)) 
			   {
             music.play("shunzi");
			 JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
			   }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
             System.out.println(CardThree[2][2]);
			 music.play("feiji");
               JOptionPane.showMessageDialog(null,"����������ɻ�","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
         }
      else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
           else  if(n==10)  {         
      if(PanduanTShunzi(n,PlayCard)) 
			   {
             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"�������������","������", JOptionPane.PLAIN_MESSAGE);
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			   music.play("feiji");
               JOptionPane.showMessageDialog(null,"������Ƿɻ���˫","�ɻ���˫", JOptionPane.PLAIN_MESSAGE);
         }
      else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
       else  if(n==11)  {
         if(PanduanTShunzi(n,PlayCard)) 
		   {
             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
		      music.play("shunzi");
		   }
		   else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
          else  if(n==12)  {
         if(PanduanTShunzi(n,PlayCard)) 
			  {
             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"�������������","������", JOptionPane.PLAIN_MESSAGE);
         }   
				 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[2][2]+1==CardThree[2][3]) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
             System.out.println(CardThree[2][2]);
			 System.out.println(CardThree[2][3]);	
			 music.play("feiji");
               JOptionPane.showMessageDialog(null,"��������ķɻ�","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"����������ɻ�����","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
         }
			  else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
 else  if(n==13)  {
       JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

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
               JOptionPane.showMessageDialog(null,"������Ǵ�"+(CardThree[1][0])+"��ʼ������","������", JOptionPane.PLAIN_MESSAGE);
         } 
		      else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

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
               JOptionPane.showMessageDialog(null,"���������ɻ�","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
         }	
		  else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1&&CardThree[1][2]!=-1) 
         {
             System.out.println(CardThree[2][0]);
             System.out.println(CardThree[2][1]);
			  System.out.println(CardThree[2][2]);
			
               JOptionPane.showMessageDialog(null,"����������ɻ���˫","�ɻ���˫", JOptionPane.PLAIN_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"������ǰ�����","������", JOptionPane.PLAIN_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"��������ķɻ�����","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
         }	

			  else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
   else if (n==17)
   {
JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"������Ǿ�����","������", JOptionPane.PLAIN_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"����������ɻ�","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
         }	

			  else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
      else if (n==19)
   {
JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"�������ʮ����","ʮ����", JOptionPane.PLAIN_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"���������ɻ�","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
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
               JOptionPane.showMessageDialog(null,"��������ķɻ���˫","�ɻ���˫", JOptionPane.PLAIN_MESSAGE);
         }
			  else JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

   }
   }
  //�ж�n�������и���������,��������
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
    //�ж��Ƿ���˳��
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
