
import java.util.Scanner;
public class Clear_Bomb {

	public static void main(String[] args) {
		final int SIZE = 5;
		//定义雷的数目
		
		char pbomb[][]=new char[SIZE+2][SIZE+2];
		//扩展扫雷区域，以便于记录每个位置周围的雷的数目
		
		char bomb[][]=new char[SIZE+1][SIZE+1];
		//雷区
		
		char BombShow[][]=new char[SIZE+1][SIZE+1];
		//待以向客户展现当前扫雷状况
		
		int a[]=new int[SIZE];
		int b[]=new int[SIZE];
		//产生横纵坐标的随机值，待以布雷
		
		Scanner s=new Scanner(System.in);
		print str=new print();
		
		int i;
		int h=0;
		int p,q;
		int m,n;//扫雷过程中所确定点击的位置
		
		int bombnum[][]=new int[SIZE+1][SIZE+1];
		//用以存放每个位置周围的雷的数目
		
		char tmp='0';
		
		while(h<SIZE)
		{
			a[h]=(int)(Math.random()*SIZE)+1;
			b[h]=(int)(Math.random()*SIZE)+1;
			for(i=0;i<h;i++)
			{
				if(a[h]==a[i]&&b[h]==b[i])
				{
					h--;
					break;
				}
			}
			h++;
			
		}
		//产生不重复的随机数组合
			
		for(p=0;p<SIZE+2;p++)
			for(q=0;q<SIZE+2;q++)
			{
				pbomb[p][q]='#';
			}
		for(i=0;i<SIZE;i++)
		{
			pbomb[a[i]][b[i]]='*';
		}
		//扩展下的雷区布置
		
		
		
		bomb[0][0]=' ';
		BombShow[0][0]=' ';
		for(p=1;p<=SIZE;p++)
		{
			tmp+=p-1;
			bomb[0][p]=tmp;
			bomb[p][0]=tmp;
			
			BombShow[0][p]=tmp;
			BombShow[p][0]=tmp;
			
			tmp='0';
		}
		
		
		for(p=1;p<=SIZE;p++)
			for(q=1;q<=SIZE;q++)
			{
				bomb[p][q]=pbomb[p][q];
				BombShow[p][q]='#';
			}
		//产生SIZE*SIZE的雷区
		
		
		for(p=0;p<=SIZE;p++)
			for(q=0;q<=SIZE;q++)
				bombnum[p][q]=0;
		//雷区每个位置周围的雷的数量初始化
		
		
		for(p=0;p<=SIZE;p++)
		{
			for(q=0;q<=SIZE;q++)
			{
				System.out.print(BombShow[p][q]);
			}
			System.out.println();
		}
		//展现扫雷界面
		
		
		for(p=1;p<=SIZE;p++)
		{
			for(q=1;q<=SIZE;q++)
			{
				if(pbomb[p][q]=='#')
				{
					if(pbomb[p-1][q]=='*')    bombnum[p][q]++;
				    if(pbomb[p+1][q]=='*')    bombnum[p][q]++;
				    if(pbomb[p][q-1]=='*')    bombnum[p][q]++;
				    if(pbomb[p][q+1]=='*')    bombnum[p][q]++;
				    if(pbomb[p-1][q-1]=='*')  bombnum[p][q]++;
				    if(pbomb[p-1][q+1]=='*')  bombnum[p][q]++;
				    if(pbomb[p+1][q-1]=='*')  bombnum[p][q]++;
				    if(pbomb[p+1][q+1]=='*')  bombnum[p][q]++;
				}
			}
		}
		
		//得到每个位置上的具体数字
		
		
		for(i=0;i<SIZE*SIZE-SIZE;i++)
		{
			  tmp='0';
		      System.out.print("请输入你想要挖雷的位置：\n");
		      System.out.println("(m代表第m行，n代表第n行,如４　５)");
		      m=s.nextInt();
		      n=s.nextInt();
		      if(bomb[m+1][n+1]=='*')
		      {
		    	  str.printtest(bomb);
		    	  //打印出雷区布局
		    	  break;
		      }
		      //如果扫到雷，直接跳出
		      
		      
		      else 
		      {
		    	  tmp+=bombnum[m+1][n+1];
		    	  BombShow[m+1][n+1]=tmp;
		    	  str.printtest(BombShow);
		    	  //打印当前扫雷情况
		      }
		}
		
		if(i==SIZE*SIZE-SIZE) 
			System.out.println("恭喜你通过");
		else 
			System.out.println("很遗憾，你失败了");
		
		
	
	}
}
