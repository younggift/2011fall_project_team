import java.util.Scanner;
public class  Lei1
{
	 
  void Start () {
	  Scanner input =new Scanner(System.in);
	 	System.out.println("����������ı߳���");
	int  length=input.nextInt();
   
	
    
	Message[][] leiz;
	leiz = new Message[length][length];
	
   int i;
   int j;
   int LeiNumber = (int) (Math.random()*5)+1; //����ɨ�ף��׵���Ŀ����10
  int Num=LeiNumber;
  System.out.println("����������" +LeiNumber);
   for( i=0;i<length;i++)//�Դ洢�׵Ķ�ά������г�ʼ�� 
    for( j=0;j<length;j++)
    {
		leiz[i][j]=new Message();
         leiz[i][j].a = 1;
		 leiz[i][j].b = 0;
		 leiz[i][j].c = '��';//��ʼ��
		 {
		
	System.out.print( leiz[i][j].a+"\t" );
	   if(j==length-1)  {System.out.println();System.out.println();}  
	}
    } 
       

  
 
//while(true)
	// {
 
	//if(LeiNumber>0)  break;
	// }
   while(LeiNumber>0)
	{   //���������
	   j=i;
	    int p=i;
		int q=j;
       i = (int) (Math.random()*length);
		 j = (int) (Math.random()*length);
		
		 leiz[i][j].b = '��';  //��ʾ�˴�����
		if(p!=i||q!=j) LeiNumber--;
   }
   while(Num>0)
	  {

	   System.out.println("�������׵�λ������");
 int  l=input.nextInt();
 int  d=input.nextInt();
 System.out.println();
System.out.println("��ȷ�������1�����һ�2");
 int p=input.nextInt();
 
 int k=0;
 if(leiz[l-1][d-1].b=='��')k++;
 if(leiz[l][d-1].b=='��')   k++;
 if(leiz[l+1][d-1].b=='��') k++;
 if(leiz[l+1][d].b=='��')   k++;
 if(leiz[l][d+1].b==10)   k++;
 if(leiz[l-1][d+1].b=='��') k++;
 if(leiz[l-1][d].b=='��')   k++;
if(k==0)
	{ 
for(int m=l-1;m<l+2;m++)
for(int n=d-1;n<d+2;n++)
leiz[m][n].a='��';
}
if(leiz[l][d].b=='��'&&p==1)  { System.out.println("�㴥���ˣ���������");break;}
if(leiz[l][d].b=='��'&&p==2)   
	{
	if(leiz[l][d].b=='��')  leiz[l][d].a='��';
        Num--;
		System.out.println("��ϲ���Ƕ���");
	}
else 
		  {	 
for(i=0;i<length;i++)//�Դ洢�׵Ķ�ά������г�ʼ�� 

    for(j=0;j<length;j++)
	{
		
	System.out.print( leiz[i][j].a+"\t" );
	   if(j==length-1)  {System.out.println();System.out.println();}  
	}

		  }
	  }
	  }
	public static void main(String[] args) 

	{

	
		Lei1  WA= new Lei1();
	
		WA.Start();
		System.out.println("Hello World!");
	}
}
class   Message
{
	char a;
	char  b;
	char c;
}
/*class Fun
{ int length=1000;
	for(int i=0;i<length;i++)

    for(int j=0;j<length;j++)
		{
		leiz[i][j]=new Message();
	public void Display()
	{for(int i=0;i<length;i++)

    for(int j=0;j<length;j++)
		{
		
	System.out.print( leiz[i][j].a+"\t" );
		}
	}
	public char Roundlei(int i,int j) //���������׵���Ŀ
		{  int k=0;
		  if(leiz[i-1][j-1].b='��')k++;
		  if(leiz[i][j-1].b=='��')   k++;
		  if(leiz[i+1][j-1].b=='��') k++;
		  if(leiz[i+1][j].b=='��')   k++;
		  if(leiz[i+1][j+1].b=='��') k++;
		  if(leiz[i][j+1].b==10)   k++;
		  if(leiz[i-1][j+1].b=='��') k++;
		  if(leiz[i-1][j].b=='��')   k++;
		  return k+48;
        }
   public void RoundO(int i,int j,char R)  //�����Χ�׵���Ŀ��0
		{
			for(int m=i-1;m<i+2;m++)
				for(int n=j-1;n<j+2;n++)
				leiz[m][n].a='��';
		}
		public void Biaoqi(int i,int j) //�Ѿ�ȷ�����ף�������
		{
        if(leiz[i][j].b=='��')  leiz[i][j].a='��';
		}
}*/