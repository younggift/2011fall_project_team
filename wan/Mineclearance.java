/*���������ɵ�ɨ�׳���Ӧ�ñ�ǰһ��Ҫ����*/
/********made by ��***********************/
import java.util.Scanner;

public class  Mineclearance
{
	int [][] lein;//���ڼ�¼�������ֵ���������ֻ�10(�ף�
	//ϵͳ�Լ���ʼ��Ϊ0
	public int Roundlei(int i,int j,int length,int[][] leiz) //���������׵���Ŀ
		{  int k=0;

	if(i==0){
			if(j==0) 
				{   if(leiz[i+1][j]==10)   k++;
                       if(leiz[i][j+1]==10)   k++;
                        if(leiz[i+1][j+1]==10) k++;
				}
		    if(j==length-1)
				{
                if(leiz[i+1][j-1]==10)k++;
				 if(leiz[i][j-1]==10)   k++;
                    if(leiz[i+1][j]==10)   k++;
				}
				else
			  {
					if(leiz[i+1][j]==10)   k++;
			  
		  if(leiz[i+1][j+1]==10) k++;
		  if(leiz[i+1][j]==10)   k++;
		  if(leiz[i][j+1]==10) k++;
		  if(leiz[i][j]==10)   k++;
			  }
	   }




	  else if(j==0&&i!=0)  {
		      if(i==length-1)  
		   {
	
			if(leiz[i][j+1]==10)   k++;
		  if(leiz[i-1][j+1]==10) k++;
		  if(leiz[i-1][j]==10)   k++;
		  }
		  else
		   {
			  		  if(leiz[i+1][j]==10)   k++;
		  if(leiz[i+1][j+1]==10) k++;
		  if(leiz[i][j+1]==10)   k++;
		  if(leiz[i-1][j+1]==10) k++;
		  if(leiz[i-1][j]==10)   k++;
		   }
	 }
	
	  else if(i==length-1&&j!=0)  {
		   if( j==length-1) 
			   {
		  if(leiz[i-1][j-1]==10)k++;
		  if(leiz[i][j-1]==10)   k++;
		 if(leiz[i-1][j]==10)   k++;
               }
		 else
		   {
		 if(leiz[i-1][j-1]==10)k++;
		  if(leiz[i][j-1]==10)   k++;
		  if(leiz[i][j+1]==10)   k++;
		  if(leiz[i-1][j+1]==10) k++;
		  if(leiz[i-1][j]==10)   k++;
		   }
	   }
	 else  if(j==length-1&&(i!=length-1||i!=0))
		{   
		  if(leiz[i-1][j-1]==10)k++;
		  if(leiz[i][j-1]==10)   k++;
		  if(leiz[i+1][j-1]==10) k++;
		  if(leiz[i+1][j]==10)   k++;
		  if(leiz[i-1][j]==10)   k++;
		}
		else
		{
		  if(leiz[i-1][j-1]==10)k++;
		  if(leiz[i][j-1]==10)   k++;
		  if(leiz[i+1][j-1]==10) k++;
		  if(leiz[i+1][j]==10)   k++;
		  if(leiz[i+1][j+1]==10) k++;
		  if(leiz[i][j+1]==10)   k++;
		  if(leiz[i-1][j+1]==10) k++;
		  if(leiz[i-1][j]==10)   k++;
		}
		 
		  return k;
		  
}
/*��Ϸ��ʼ��ֻ����һ��*/
  void Start ()
	  {
	  lein=new int [100][100];
	  Scanner input =new Scanner(System.in);
	 	System.out.println("����������ı߳���");
	int  length=input.nextInt();
 
	char [][] leiz;
	leiz = new char[length+1][length+1];
	
   int i;
   int j;
   int LeiNumber = (int) (Math.random()*10)+1; //����ɨ�ף��׵���Ŀ����10
  int Num=LeiNumber;
  System.out.println("����������" +LeiNumber);
   for( i=0;i<length;i++)//�Դ洢�׵Ķ�ά������г�ʼ�� 
    for( j=0;j<length;j++)
    {
		
  
		 leiz[i][j] = 1;//��ʼ������Ц����ʾ
	
	}
		
		for(i=0;i<length;i++)//�Դ洢�׵Ķ�ά����������

    for(j=0;j<length;j++)
	{
		
	System.out.print( leiz[i][j]+"\t" );
	   if(j==length-1)  {System.out.println();System.out.println();}  
	}

 
   while(LeiNumber>0)
	{   //�������ظ��������
	     j=i;
	    int p=i;//
		int q=j;
       i = (int) (Math.random()*length);
		 j = (int) (Math.random()*length);
		
		 lein[i][j] = 10;  //��ʾ�˴�����
		if(p!=i||q!=j) LeiNumber--;
   }

   for( i=0;i<length;i++)

    for( j=0;j<length;j++)
		if(lein[i][j] != 10)   
		{ 
		lein[i][j] =Roundlei( i, j,length,lein);
	       //System.out.println(leiz[i][j]);
		}
		System.out.println();

				System.out.println();
						System.out.println();
	  
int ld=length*length;
   while(ld>0)
	  {
if(Num==0)  System.out.println("��ϲ������ȫ��ɨ��");
	   System.out.println("����������λ������");
	 
	int p1=100;
	int q=100;
 int  l=input.nextInt();
 int  d=input.nextInt();



 System.out.println();
System.out.println("��ȷ�������1�����һ�2");
 int p=input.nextInt();
 if(lein[l][d]==0)
{ 
for(int m=l-1;m<l+2;m++)
for(int n=d-1;n<d+2;n++)
	{ leiz[m][n]=(char) (lein[m][n]+'0');
     ld--;
	}
}
else if(lein[l][d]==10&&p==1)  
	{ System.out.println("�㴥���ˣ���������");
System.out.println("����������");
      break;
 }
else if(lein[l][d]==10&&p==2)   
	{
	if(lein[l][d]==10)  leiz[l][d]='��';
        Num--;	
		System.out.println("��ϲ���Ƕ���");
	}
else 
	   	  {
	leiz[l][d]=(char)('0'+lein[l][d]);
    ld--;
		  }
	
for(i=0;i<length;i++)//�Դ洢�׵Ķ�ά������г�ʼ�� 

    for(j=0;j<length;j++)
	{
		
	System.out.print( leiz[i][j]+"\t" );
	   if(j==length-1)  {System.out.println();System.out.println();}  
	}
	System.out.println("�벻Ҫ�ظ����룬�ϴ�������"+l+"��"+d+"��");
 }

	  
	 
 }
	public static void main(String[] args) 

	{

	
		Mineclearance  WA= new Mineclearance();
	
		WA.Start();
		
	}
}

