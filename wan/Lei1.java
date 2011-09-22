import java.util.Scanner;
public class  Lei1
{
	 
  void Start () {
	  Scanner input =new Scanner(System.in);
	 	System.out.println("请输入雷阵的边长：");
	int  length=input.nextInt();
   
	
    
	Message[][] leiz;
	leiz = new Message[length][length];
	
   int i;
   int j;
   int LeiNumber = (int) (Math.random()*5)+1; //初级扫雷，雷的数目少于10
  int Num=LeiNumber;
  System.out.println("产生的雷数" +LeiNumber);
   for( i=0;i<length;i++)//对存储雷的二维数组进行初始化 
    for( j=0;j<length;j++)
    {
		leiz[i][j]=new Message();
         leiz[i][j].a = 1;
		 leiz[i][j].b = 0;
		 leiz[i][j].c = '旗';//初始化
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
	{   //产生随机雷
	   j=i;
	    int p=i;
		int q=j;
       i = (int) (Math.random()*length);
		 j = (int) (Math.random()*length);
		
		 leiz[i][j].b = '雷';  //表示此处有雷
		if(p!=i||q!=j) LeiNumber--;
   }
   while(Num>0)
	  {

	   System.out.println("请输入雷的位置坐标");
 int  l=input.nextInt();
 int  d=input.nextInt();
 System.out.println();
System.out.println("请确定是左击1还是右击2");
 int p=input.nextInt();
 
 int k=0;
 if(leiz[l-1][d-1].b=='雷')k++;
 if(leiz[l][d-1].b=='雷')   k++;
 if(leiz[l+1][d-1].b=='雷') k++;
 if(leiz[l+1][d].b=='雷')   k++;
 if(leiz[l][d+1].b==10)   k++;
 if(leiz[l-1][d+1].b=='雷') k++;
 if(leiz[l-1][d].b=='雷')   k++;
if(k==0)
	{ 
for(int m=l-1;m<l+2;m++)
for(int n=d-1;n<d+2;n++)
leiz[m][n].a='雷';
}
if(leiz[l][d].b=='雷'&&p==1)  { System.out.println("你触雷了，比赛结束");break;}
if(leiz[l][d].b=='雷'&&p==2)   
	{
	if(leiz[l][d].b=='雷')  leiz[l][d].a='旗';
        Num--;
		System.out.println("恭喜你标记对了");
	}
else 
		  {	 
for(i=0;i<length;i++)//对存储雷的二维数组进行初始化 

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
	public char Roundlei(int i,int j) //计算四周雷的数目
		{  int k=0;
		  if(leiz[i-1][j-1].b='雷')k++;
		  if(leiz[i][j-1].b=='雷')   k++;
		  if(leiz[i+1][j-1].b=='雷') k++;
		  if(leiz[i+1][j].b=='雷')   k++;
		  if(leiz[i+1][j+1].b=='雷') k++;
		  if(leiz[i][j+1].b==10)   k++;
		  if(leiz[i-1][j+1].b=='雷') k++;
		  if(leiz[i-1][j].b=='雷')   k++;
		  return k+48;
        }
   public void RoundO(int i,int j,char R)  //如果周围雷的数目是0
		{
			for(int m=i-1;m<i+2;m++)
				for(int n=j-1;n<j+2;n++)
				leiz[m][n].a='雷';
		}
		public void Biaoqi(int i,int j) //已经确定是雷，用旗标记
		{
        if(leiz[i][j].b=='雷')  leiz[i][j].a='旗';
		}
}*/