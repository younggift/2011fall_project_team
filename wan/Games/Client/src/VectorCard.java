import java.util.Scanner;
import java.util.Vector;
public class VectorCard
{
//	public static Vector vector;
            int CardThree[][]=new int[4][21];//��¼���Ƶ��������ͣ�һ�ţ����ţ����ţ�����
         Music music=new Music();
	public VectorCard()
	{
        
	}
	public  int run(Vector vector)
	{
 
            int n=vector.size();
            int[] cardrecord=new int[3]; //1,��¼���Ƶ���Ŀ��2��¼���Ƿ�Ϸ���3����¼�Ƶ����� 4����¼�ƵĴ�С
           for(int i=0;i<4;i++)
               for(int j=0;j<21;j++) {
             CardThree[i][j]=-1;
            }
            int[] PlayCard=new int [20];//ת��Ϊ������ڲ���
            for(int i=0;i<n;i++) 
            {
                  PlayCard[i]=(Integer)vector.get(i)-1;
             }
            PanduanThree(n, PlayCard);
            int panduan=PanduanTShunzi(n,PlayCard);
            switch(n)
            {
                case 1:
                    
                            if(PlayCard[0]/4==13&&PlayCard[0]%4==1)
                         {

                              
                             music.play(String.valueOf(17));
                                return 17;
                         }
                            else
                         {
                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=PlayCard[0]/4+3;
                             music.play(String.valueOf(PlayCard[0]/4+3));
                                
                                return PlayCard[0]/4+3;
                         }
                case 2:
                      
                            if(PlayCard[n-1]/4==13&&PlayCard[n-2]/4==13) 
                        {
                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=17;    
                            music.play("wangzha");
                                return 17;
                        }
                             else if(PlayCard[n-1]/4==PlayCard[n-2]/4&&PlayCard[n-2]/4!=13)
                        {
                             cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[1][0];   
                            music.play("dui"+CardThree[1][0]);
                                return CardThree[1][0];
                        }
                            else 
                                return 0;
                     
                case 3:
                           if(PlayCard[n-1]/4==PlayCard[n-2]/4&&PlayCard[n-3]/4==PlayCard[n-2]/4) 
                        {
                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=CardThree[2][0];        
                      new Thread(new Runnable() 
             {
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
                             return CardThree[2][0];
                             }
                            else
                                 return 0;
                case 4:

                      if(CardThree[0][0]!=-1&&CardThree[2][0]!=-1) 
                        {
                        music.play("sandaiyi");
                        return CardThree[2][0];

                        } 
                                   else if(CardThree[3][0]!=-1) 
                        {
                         music.play("zhadan");
                         return CardThree[3][0];
                         }
                         else 
                        return 0;
                    case 5:
                     if(panduan!=-1) 
                    {
	          music.play("shunzi");
                  return  panduan;
                    }
                else if(CardThree[1][0]!=-1&&CardThree[2][0]!=-1) 
                    {

			   music.play("sandaiyidui");
                           return CardThree[2][0];
                    }
            else 
             return 0;
                case 6:          
                     if(panduan!=-1) 
		 {
//             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
				music.play("shunzi");
                                return panduan;
		 }
	  else if(CardThree[3][0]!=-1&&CardThree[1][0]==-1) 
		 {
//		  JOptionPane.showMessageDialog(null,"��������ĸ�"+(CardThree[3][0])+"��"+CardThree[0][0]+"��"+CardThree[0][1],"ը��", JOptionPane.PLAIN_MESSAGE);
		  music.play("sidaier");
                  return CardThree[3][0];
		 }
	 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]) 
         {
			   music.play("liandui");
                           return CardThree[1][0];
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]) 
         {

			    music.play("feiji");
                            return CardThree[2][0];
         }
      else 
           return 0;                  

                case 7:  
         if(panduan!=-1) 
		 {
//             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
		      music.play("shunzi");
                      return panduan;
		 }
	      else 
             return 0;

   
                case 8:          
                if(panduan!=-1) 
			{
			  music.play("shunzi");
                          return panduan;
			}
		else if(CardThree[3][0]!=-1&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1) 
			{
	  	       music.play("sidailiangdui");
                           return CardThree[3][0];
			}

		 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]) 
         {
                  music.play("liandui");
                  return CardThree[1][0];
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]==-1) 
         {

			  music.play("feiji");
                          return CardThree[2][0];
         }
      else 
           return 0;
                case 9:           
      if(panduan!=-1) {
             music.play("shunzi");
             return panduan;
			   }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]) 
         {

			 music.play("feiji");
                         return CardThree[2][0];
         }
      else 
                             return 0;

                case 10:           
      if(panduan!=-1) 
			   {
			  music.play("shunzi");
                          return panduan;
			   }
		 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]) 
         {

			   music.play("liandui");
                           return CardThree[1][0];
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1) 
         {

			   music.play("feiji");
                           return CardThree[2][0];
//               JOptionPane.showMessageDialog(null,"������Ƿɻ���˫","�ɻ���˫", JOptionPane.PLAIN_MESSAGE);
         }
      else 
                             return 0;

   
                case 11:  
         if(panduan!=-1) 
		   {
		      music.play("shunzi");
                      return panduan;
                   }
         else 
             return 0;
                case 12:
         if(panduan!=-1) 
			  {
//             JOptionPane.showMessageDialog(null,"�������˳��"+(PlayCard[0]/4+3)+"��"+(PlayCard[0]/4+2+n),"˳��", JOptionPane.PLAIN_MESSAGE);
		  	   music.play("shunzi");
			   return panduan;
                          }
			  else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]&&CardThree[1][4]+1==CardThree[1][5]) 
         {

				 music.play("liandui");
                                 return CardThree[1][0];
         }   
		 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[2][2]+1==CardThree[2][3]) 
         {

			 music.play("feiji");
                         return CardThree[2][0];
         }	
                else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[1][0]==-1&&CardThree[1][1]==-1) 
         {

			music.play("feiji");
                      return CardThree[2][0];
//               JOptionPane.showMessageDialog(null,"����������ɻ�����","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
         }
			  else 
                    return 0;
   
                case 13:  
                    return 0;

   
                case 14:
         
		   if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]&&CardThree[1][4]+1==CardThree[1][5]&&CardThree[1][5]+1==CardThree[1][6]) 
         {

					  music.play("liandui");
                                          return CardThree[1][0];
         } 
		      else 
                       return 0;

   
                case 15:
         
		 if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[2][2]+1==CardThree[2][3]&&CardThree[2][3]+1==CardThree[2][4]) 
         {
			 music.play("feiji");
                         return CardThree[2][0];
         }	
		  else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1&&CardThree[1][2]!=-1) 
         {
			 music.play("feiji");
                         return CardThree[2][0];
			
         }
                  else 
                      return 0;
                case 16:       
		  	  	  if(CardThree[1][0]+1==CardThree[1][1]
					  &&CardThree[1][1]+1==CardThree[1][2]
					  &&CardThree[1][2]+1==CardThree[1][3]
					  &&CardThree[1][3]+1==CardThree[1][4]
					  &&CardThree[1][4]+1==CardThree[1][5]
					  &&CardThree[1][5]+1==CardThree[1][6]
					  &&CardThree[1][6]+1==CardThree[1][7]) 
         {

					 music.play("liandui");
                                         return CardThree[1][0];
         } 
                     else if(CardThree[2][0]+1==CardThree[2][1]
						 &&CardThree[2][1]+1==CardThree[2][2]
						 
                    &&CardThree[0][0]!=-1
						&&CardThree[0][1]!=-1
						&&CardThree[0][2]!=-1
						&&CardThree[0][3]!=-1) 
         {
	
			 music.play("feiji");
                         return CardThree[2][0];
//               JOptionPane.showMessageDialog(null,"��������ķɻ�����","�ɻ�����", JOptionPane.PLAIN_MESSAGE);
         }	

			  else 
                              return 0;

                case 17:
                  return 0;
                case 18:
        
          
		  	  	  if(CardThree[1][0]+1==CardThree[1][1]
					  &&CardThree[1][1]+1==CardThree[1][2]
					  &&CardThree[1][2]+1==CardThree[1][3]
					  &&CardThree[1][3]+1==CardThree[1][4]
					  &&CardThree[1][4]+1==CardThree[1][5]
					  &&CardThree[1][5]+1==CardThree[1][6]
					  &&CardThree[1][6]+1==CardThree[1][7]
					  &&CardThree[1][7]+1==CardThree[1][8]) 
         {

                           music.play("liandui");
                           return CardThree[1][0];
         }   
				 	 else if(CardThree[2][0]+1==CardThree[2][1]
						 &&CardThree[2][1]+1==CardThree[2][2]
						 &&CardThree[2][2]+1==CardThree[2][3]
						 &&CardThree[2][3]+1==CardThree[2][4]
						 &&CardThree[2][4]+1==CardThree[2][5]
                    &&CardThree[0][0]==-1)
 
         {

			 music.play("feiji");
                         return CardThree[2][0];
         }	

			  else 
                               return 0;
                case 19:
                    return 0;
                case 20:
        
		  	   if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]
				   &&CardThree[1][4]+1==CardThree[1][5]
				   &&CardThree[1][5]+1==CardThree[1][6]
				   &&CardThree[1][6]+1==CardThree[1][7]
				   &&CardThree[1][7]+1==CardThree[1][8]
				   &&CardThree[1][8]+1==CardThree[1][9]) 
         {
  
				 music.play("liandui");
                                 return CardThree[1][0];
//               JOptionPane.showMessageDialog(null,"�������ʮ����","ʮ����", JOptionPane.PLAIN_MESSAGE);
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

			 music.play("feiji");
                         return CardThree[2][0];
         }	
		 		 	 else if(CardThree[2][0]+1==CardThree[2][1]
						 &&CardThree[2][1]+1==CardThree[2][2]
						 &&CardThree[2][2]+1==CardThree[2][3]
						 
						 &&CardThree[1][0]!=-1&&CardThree[1][1]!=-1
							 &&CardThree[1][2]!=-1&&CardThree[1][3]!=-1) 
         {

			music.play("feiji");
                        return CardThree[2][0];
         }
			  else 
                                 return 0;
                default: return 0;
            }
	}
 void PanduanThree(int n,int[] PlayCard) {
      int pos1=0;
      int pos2=0;
      int pos3=0;
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
 int PanduanTShunzi(int n,int[] PlayCard) {
	int pos = 0;
 for(int j=0;j<n-1;j++) {
	 if(PlayCard[j]/4+1==PlayCard[j+1]/4)  pos++;
 }
 if(pos==n-1)  return PlayCard[0]/4+3;
  return -1;
 }
	public static void main(String[] args)
	{
	    Vector v=new Vector();   
            for(int i=0;i<11;i++)
                   v.add(i);

	}
}