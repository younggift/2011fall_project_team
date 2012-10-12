import java.util.ArrayList;
public class Compare
{
//	public static ArrayList vector;
         int CardThree[][]=new int[4][21];//记录出牌的四种类型，一张，两张，三张，四张
         Music music=new Music();
	public Compare()
	{
        
	}
	public  int[] run(ArrayList vector)
	{
 
            int n=vector.size();
            int[] cardrecord=new int[3]; //0记录牌是否合法；1；记录牌的类型 2，记录牌的大小
           for(int i=0;i<4;i++)
               for(int j=0;j<21;j++) {
             CardThree[i][j]=-1;
            }
            int[] PlayCard=new int [20];//转换为数组便于操作
            for(int i=0;i<n;i++) 
            {
                  PlayCard[i]=(Integer)vector.get(i)-1;
             }
            PanduanThree(n, PlayCard);
            int panduan=PanduanTShunzi(n,PlayCard);
            switch(n)
            {
                case 1:
                    
                            if(PlayCard[0]>52)
                         {
                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=PlayCard[0]/4+3+PlayCard[0]%4;
                              return cardrecord;
                         }
                            else
                         {
                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=PlayCard[0]/4+3;
                                return cardrecord;
                         }
                case 2:
                      
                            if(PlayCard[n-1]/4==13&&PlayCard[n-2]/4==13) 
                        {
                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=17;    
                           
                                return cardrecord;
                        }
                             else if(PlayCard[n-1]/4==PlayCard[n-2]/4&&PlayCard[n-2]/4!=13)
                        {
                             cardrecord[0]=1;
                             cardrecord[1]=2;
                             cardrecord[2]=CardThree[1][0];   
                           
                                return cardrecord;
                        }
                            else 
                                return cardrecord;
                     
                case 3:
                           if(PlayCard[n-1]/4==PlayCard[n-2]/4&&PlayCard[n-3]/4==PlayCard[n-2]/4) 
                        {
                             cardrecord[0]=1;
                             cardrecord[1]=1;
                             cardrecord[2]=CardThree[2][0];        
                                return cardrecord;
                         }
                            else
                                return cardrecord;
                case 4:

                      if(CardThree[0][0]!=-1&&CardThree[2][0]!=-1) 
                        {  
                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=CardThree[2][0];
                                 return cardrecord;

                        } 
                      else if(CardThree[3][0]!=-1) 
                        {
                              cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[3][0];                         
                                  return cardrecord;
                         }
                         else 
                        return cardrecord;
                    case 5:
                     if(panduan!=-1) 
                    {
                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=panduan;
                                 return  cardrecord;
                    }
                        else if(CardThree[1][0]!=-1&&CardThree[2][0]!=-1) 
                    {
                               cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[2][0];
                           return cardrecord;
                    }
                       else 
                            return cardrecord;
                case 6:          
                     if(panduan!=-1) 
		 {
                             cardrecord[0]=1;
                             cardrecord[1]=1;
                             cardrecord[2]=panduan;
                                return cardrecord;
		 }
	             else if(CardThree[3][0]!=-1&&CardThree[1][0]==-1) 
		 {		 
                              cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[3][0];
                                 return cardrecord;
		 }
	             else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]) 
                 {
                              cardrecord[0]=1;
                              cardrecord[1]=3;
                              cardrecord[2]=CardThree[1][0];
                           return cardrecord;
                 }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]) 
                 {
                            cardrecord[0]=1;
                              cardrecord[1]=4;
                              cardrecord[2]=CardThree[2][0];
                            return cardrecord;
                 }
                   else 
                     return cardrecord;                  

                case 7:  
                     if(panduan!=-1) 
		 {
                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=panduan;
                      return cardrecord;
		 }
	      else 
                     return cardrecord;

   
                case 8:          
                if(panduan!=-1) 
			{
                           cardrecord[0]=1;
                           cardrecord[1]=1;
                           cardrecord[2]=panduan;
                          return cardrecord;
			}
		else if(CardThree[3][0]!=-1&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1) 
			{
                              cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[3][0];
                           return cardrecord;
			}

		 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]) 
         {
                              cardrecord[0]=1;
                              cardrecord[1]=3;
                              cardrecord[2]=CardThree[1][0];
                          return cardrecord;
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]==-1) 
         {

                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=CardThree[2][0];
                          return cardrecord;
         }
                       else 
                          return cardrecord;
                case 9:           
                     if(panduan!=-1) {

                            cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=panduan;
                            return cardrecord;
			   }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]) 
         {

                         cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[2][0];
                         return cardrecord;
         }
      else 
                             return cardrecord;

                case 10:           
      if(panduan!=-1) 
			   {
                          cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=panduan;
                          return cardrecord;
			   }
		 else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]) 
         {
;
                           cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[1][0];
                           return cardrecord;
         }
		 	 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1) 
         {

			   music.play("feiji");
                           cardrecord[0]=1;
                              cardrecord[1]=3;
                              cardrecord[2]=CardThree[2][0];
                           return cardrecord;
//               JOptionPane.showMessageDialog(null,"你出的是飞机带双","飞机带双", JOptionPane.PLAIN_MESSAGE);
         }
      else 
                             return cardrecord;

   
                case 11:  
         if(panduan!=-1) 
		   {
                      cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=panduan;
                      return cardrecord;
                   }
         else 
             return cardrecord;
                case 12:
         if(panduan!=-1) 
			  {
                           cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=panduan;
			   return cardrecord;
                          }
			  else if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]&&CardThree[1][4]+1==CardThree[1][5]) 
         {

                                 cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[1][0];
                                 return cardrecord;
         }   
		 else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[2][2]+1==CardThree[2][3]) 
         {


                         cardrecord[0]=1;
                              cardrecord[1]=3;
                              cardrecord[2]=CardThree[2][0];
                         return cardrecord;
         }	
                else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[1][0]==-1&&CardThree[1][1]==-1) 
         {

                        cardrecord[0]=1;
                              cardrecord[1]=4;
                              cardrecord[2]=CardThree[2][0];
                      return  cardrecord;
         }
			  else 
                    return cardrecord;
   
                case 13:  
                    return cardrecord;

   
                case 14:
         
		   if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]&&CardThree[1][4]+1==CardThree[1][5]&&CardThree[1][5]+1==CardThree[1][6]) 
         {

                              cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=CardThree[1][0];
                                          return cardrecord;
         } 
		      else 
                       return cardrecord;

   
                case 15:
         
		 if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][1]+1==CardThree[2][2]&&CardThree[2][2]+1==CardThree[2][3]&&CardThree[2][3]+1==CardThree[2][4]) 
         {
                         cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=CardThree[2][0];
                         return cardrecord;
         }	
		  else if(CardThree[2][0]+1==CardThree[2][1]&&CardThree[2][0]+1==CardThree[2][1]&&CardThree[1][0]!=-1&&CardThree[1][1]!=-1&&CardThree[1][2]!=-1) 
         {
                         cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[2][0];
                         return cardrecord;
			
         }
                  else 
                      return cardrecord;
                case 16:       
		  	  	  if(CardThree[1][0]+1==CardThree[1][1]
					  &&CardThree[1][1]+1==CardThree[1][2]
					  &&CardThree[1][2]+1==CardThree[1][3]
					  &&CardThree[1][3]+1==CardThree[1][4]
					  &&CardThree[1][4]+1==CardThree[1][5]
					  &&CardThree[1][5]+1==CardThree[1][6]
					  &&CardThree[1][6]+1==CardThree[1][7]) 
         {

                                         cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=CardThree[1][0];
                                         return cardrecord;
         } 
                     else if(CardThree[2][0]+1==CardThree[2][1]
			&&CardThree[2][1]+1==CardThree[2][2]
						 
                           &&CardThree[0][0]!=-1
						&&CardThree[0][1]!=-1
						&&CardThree[0][2]!=-1
						&&CardThree[0][3]!=-1) 
         {
	
			 music.play("feiji");
                        cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[2][0];
                         return cardrecord;
//               JOptionPane.showMessageDialog(null,"你出的是四飞机带单","飞机带单", JOptionPane.PLAIN_MESSAGE);
         }	

			  else 
                              return cardrecord;

                case 17:
                  return cardrecord;
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

                           cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=CardThree[1][0];
                           return cardrecord;
         }   
				 	 else if(CardThree[2][0]+1==CardThree[2][1]
						 &&CardThree[2][1]+1==CardThree[2][2]
						 &&CardThree[2][2]+1==CardThree[2][3]
						 &&CardThree[2][3]+1==CardThree[2][4]
						 &&CardThree[2][4]+1==CardThree[2][5]
                    &&CardThree[0][0]==-1)
 
         {

                         cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[2][0];
                         return cardrecord;
         }	

			  else 
                               return cardrecord;
                case 19:
                    return cardrecord;
                case 20:
        
		  	   if(CardThree[1][0]+1==CardThree[1][1]&&CardThree[1][1]+1==CardThree[1][2]&&CardThree[1][2]+1==CardThree[1][3]&&CardThree[1][3]+1==CardThree[1][4]
				   &&CardThree[1][4]+1==CardThree[1][5]
				   &&CardThree[1][5]+1==CardThree[1][6]
				   &&CardThree[1][6]+1==CardThree[1][7]
				   &&CardThree[1][7]+1==CardThree[1][8]
				   &&CardThree[1][8]+1==CardThree[1][9]) 
         {

                                 cardrecord[0]=1;
                              cardrecord[1]=1;
                              cardrecord[2]=CardThree[1][0];
                                 return cardrecord;

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

                         cardrecord[0]=1;
                              cardrecord[1]=2;
                              cardrecord[2]=CardThree[2][0];
                         return cardrecord;
         }	
		 		 	 else if(CardThree[2][0]+1==CardThree[2][1]
						 &&CardThree[2][1]+1==CardThree[2][2]
						 &&CardThree[2][2]+1==CardThree[2][3]
						 
						 &&CardThree[1][0]!=-1&&CardThree[1][1]!=-1
							 &&CardThree[1][2]!=-1&&CardThree[1][3]!=-1) 
         {

                        cardrecord[0]=1;
                              cardrecord[1]=3;
                              cardrecord[2]=CardThree[2][0];
                        return cardrecord;
         }
			  else 
                                 return cardrecord;
                default: return cardrecord;
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
	    ArrayList v=new ArrayList();   
            for(int i=0;i<11;i++)
                   v.add(i);

	}
}