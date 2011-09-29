/*这是最近完成的扫雷程序，应该比前一个要完善*/
/********made by 宛江***********************/
import java.util.Scanner;

public class  Mineclearance
{
	int [][] lein;//用于记录点击后出现的情况，数字或10(雷）
	//系统自己初始化为0
	public int Roundlei(int i,int j,int length,int[][] leiz) //计算四周雷的数目
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
/*游戏开始，只运行一次*/
  void Start ()
	  {
	  lein=new int [100][100];
	  Scanner input =new Scanner(System.in);
	 	System.out.println("请输入雷阵的边长：");
	int  length=input.nextInt();
 
	char [][] leiz;
	leiz = new char[length+1][length+1];
	
   int i;
   int j;
   int LeiNumber = (int) (Math.random()*10)+1; //初级扫雷，雷的数目少于10
  int Num=LeiNumber;
  System.out.println("产生的雷数" +LeiNumber);
   for( i=0;i<length;i++)//对存储雷的二维数组进行初始化 
    for( j=0;j<length;j++)
    {
		
  
		 leiz[i][j] = 1;//初始界面用笑脸表示
	
	}
		
		for(i=0;i<length;i++)//对存储雷的二维数组进行输出

    for(j=0;j<length;j++)
	{
		
	System.out.print( leiz[i][j]+"\t" );
	   if(j==length-1)  {System.out.println();System.out.println();}  
	}

 
   while(LeiNumber>0)
	{   //产生不重复的随机雷
	     j=i;
	    int p=i;//
		int q=j;
       i = (int) (Math.random()*length);
		 j = (int) (Math.random()*length);
		
		 lein[i][j] = 10;  //表示此处有雷
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
if(Num==0)  System.out.println("恭喜你雷已全部扫出");
	   System.out.println("请输入点击的位置坐标");
	 
	int p1=100;
	int q=100;
 int  l=input.nextInt();
 int  d=input.nextInt();



 System.out.println();
System.out.println("请确定是左击1还是右击2");
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
	{ System.out.println("你触雷了，比赛结束");
System.out.println("请重新运行");
      break;
 }
else if(lein[l][d]==10&&p==2)   
	{
	if(lein[l][d]==10)  leiz[l][d]='旗';
        Num--;	
		System.out.println("恭喜你标记对了");
	}
else 
	   	  {
	leiz[l][d]=(char)('0'+lein[l][d]);
    ld--;
		  }
	
for(i=0;i<length;i++)//对存储雷的二维数组进行初始化 

    for(j=0;j<length;j++)
	{
		
	System.out.print( leiz[i][j]+"\t" );
	   if(j==length-1)  {System.out.println();System.out.println();}  
	}
	System.out.println("请不要重复输入，上次输入是"+l+"行"+d+"列");
 }

	  
	 
 }
	public static void main(String[] args) 

	{

	
		Mineclearance  WA= new Mineclearance();
	
		WA.Start();
		
	}
}

