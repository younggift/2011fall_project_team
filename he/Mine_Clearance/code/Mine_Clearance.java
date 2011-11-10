import java.lang.*;
import java.util.*;
//************************************************************//
//主类
class  Mine_Clearance

{
	public static void main(String[] args) 
	{
		//new PlayGame().Play();
		PlayGame playgame = new PlayGame();
		playgame.Play();
	}
}

//**********************************************************//
//布雷
class Mine
//用10*10数组表示雷区
//雷的产生方法：通过random产生
//有雷则在该外置赋值位负数，如-1
//非负数表述周围八个位置雷的数量
{
	//数据成员
	public final int row = 10,line = 10;
	public int[][] mine;
	//mine数组用来存储雷的分布信息
	public char[][] mine2;
	//mine2数组定义为char型用于界面输出，因为在某一位置可能进行插旗等操作得用char型
	
	public Mine()
		//构造函数
	{
		//this关键字加关键后就是通知系统变量mine是这个类中的mine变量
		//若不加this关键字,可能会报错。提示如：找不到符号等
		this.mine = new int[row][line];
		this.mine2 = new char[row][line];
		Initialize();
	}
	//构造方法结束

	//判断是否越界
	//本来我是想利用数组在存储时是储存在一段连续地址中，这一特点来判断越界情况
	//上面方法和下面这方法相比仅需考虑：头尾两种越界情况
	public boolean Over(int i,int j)
	{
		if(i>=row || i<0 || j>=line || j<0)
			return true;
		else
			return false;
	}
	//判断是否越界方法结束

	public void Initialize()
		//初始化雷
		{
			int i = 0,j = 0;
			for (i = 0;i < row;i++)
			{
				for(j = 0;j<line;j++)
				{this.mine[i][j] = 0;}
			}
			int sum = 0;
			while(sum < 10)
			{
				//通过Random方法确定雷的位置
				//下面的语句可以
				i = (int)(Math.random()*10);
				j = (int)(Math.random()*10);
				//先判断该处是否已经有雷，若无这步可能最终雷的数量比10少
				if(this.mine[i][j]==-1) continue;
				//else
					this.mine[i][j] = -1;
					sum++;
				//以下8个判断语句用来统计某一位置周围雷的个数
				//每产生一个雷就让周围八个位置计数，进行++操作
				if(!(this.Over(i-1,j))&&(this.mine[i-1][j]!=-1))
				{
					this.mine[i-1][j]++;
				}
				if(!(this.Over(i+1,j))&&(this.mine[i+1][j]!=-1))
				{
					this.mine[i+1][j]++;
				}
				if(!(this.Over(i,j+1))&&(this.mine[i][j+1]!=-1))
				{
					this.mine[i][j+1]++;
				}
				if((!this.Over(i,j-1))&&(this.mine[i][j-1]!=-1))
				{
					this.mine[i][j-1]++;
				}
				if((!this.Over(i-1,j-1))&&(this.mine[i-1][j-1]!=-1))
				{
					this.mine[i-1][j-1]++;
				}
				if((!this.Over(i+1,j-1))&&(this.mine[i+1][j-1]!=-1))
				{
					this.mine[i+1][j-1]++;
				}
				if((!this.Over(i-1,j+1))&&(this.mine[i-1][j+1]!=-1))
				{
					this.mine[i-1][j+1]++;
				}
				if((!this.Over(i+1,j+1))&&(this.mine[i+1][j+1]!=-1))
				{
					this.mine[i+1][j+1]++;
				}				
			}
			for(i = 0;i<row;i++)
			{
				for(j = 0;j<line;j++)
				{this.mine2[i][j] = '#';}

			}
		}
		//布雷方法结束

//输出界面方法
public void Print_limsurface(){
		System.out.println("------------------------");  
		//为每次输出界面画个框
		System.out.print(" ");
		for(int j=0;j<line;j++) System.out.print(" "+j);
		//打印出纵坐标，方便用户操作；
		System.out.println();
		for(int i=0;i<row;i++){
			System.out.print(i);  
			//打印出横坐标，方便用户操作；
			for(int j=0;j<line;j++)
				System.out.print(" "+this.mine2[i][j]);
			//打印出每一次挖雷操作后的界面；
			System.out.println("");
		}
		System.out.println("------------------------"); 
		//边框部分；
	}
	//输出界面方法结束

	public void Begin()
		//这个方法的名字再改
	//在该方法中进行的操作主要是接受用户输入，并对该输入进行相应的处理
	{
		//游戏退出当满足 踩到雷或成功挖了90次退出
		int Dignum = 0;
		//每调用一次Dig方法++
		//Item:
		for(Dignum = 0;Dignum < 90;Dignum++)
		{
		this.Print_limsurface();
		System.out.println("请输入要执行的操作！输入格式：要执行的操作+坐标，如要挖（3，4）位置的雷输入D34。");
		Scanner sc = new Scanner(System.in);
		//获取用户输入信息
		String input = sc.nextLine();
		//将输入的标记转换为String型
		String operate = input.substring(0,1);
		//获取要执行的操作
		String coordinate = input.substring(1);
		//获取操作对象
		int x = Integer.parseInt(coordinate.substring(0,1));
		int y = Integer.parseInt(coordinate.substring(1,2));
		//获取 x y
		if(operate.equals("D"))
		{
			Print_limsurface();
			boolean status = this.Dig(x,y);
			//用变量status来记录是否挖到雷
			if(!status)
			{break;}
			else
			{
				if(operate.equals("F"))
				{
					this.Flag(x,y);
				}
				else
				{System.out.println("INPUT ERROR!");}
			}
		}
		}
		System.out.println("同学 你过关了！");
		this. Initialize();
		}

	//挖雷方法开始
	public boolean Dig(int x,int y)
	{
		if(this.mine[x][y]==-1)
		{
			Explode();
			return false;
			//挖到雷则执行explode方法并返回false
			}
		else
		{
				this.mine2[x][y] = (char)(this.mine[x][y]+'0');
			return true;
		}
	}
	//挖雷方法结束

	//explode方法
	public void Explode()
	{
		int i = 0,j = 0;
		for (i = 0;i < this.row;i++)
		{
			for(j = 0;j < this.line;j++)
			{
				if(this.mine[i][j] == -1)
				{this.mine2[i][j] = '*';}
				else
				{this.mine2[i][j] = ' ';}
			}
		}
		this.Print_limsurface();
		System.out.println("同学你踩到雷了！");
		this.Initialize();
	}
	//explode方法结束

	//flag方法 用于插旗
	public void Flag(int x,int y)
	{
		this.mine2[x][y] = 'F';
	}
	//flag方法结束
}

//***************************************************************//
class PlayGame
{
	public Mine mine;

//构造函数
	public PlayGame()
	{
		this.mine = new Mine();
	}

	public void Help()
	{
		System.out.println("同学你现在在帮助页面");
		//System.out.println("游戏中共有10个雷，你可以进行的操作有 挖雷 插旗。");
		//System.out.println("如想挖坐标为（3,4）位置，请输入W34.");
		//System.out.println("如想在坐标为（3,4）位置插旗，请输入F34");

	}


	public void Play()
	{
		int option = 0;

		while(true)
		{
			System.out.println("请输入要进行的操作：0=帮助 1=开始游戏 2=退出游戏");
		    Scanner sc = new Scanner(System.in);
		    option = sc.nextInt();
			if(option == 0)
			{this.Help();}
			else if(option == 1)
			{this.mine.Begin();}
			else if(option == 2)
			{
				System.out.println("你已退出游戏！");
				System.exit(0);
			}
			else{System.out.println("Input Error!");}
		}
	}
}