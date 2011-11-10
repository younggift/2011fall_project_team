import java.util.Scanner;
import java.util.Arrays;
class Input
{
	static Scanner input=new Scanner(System.in);



	public static int getInt()
	{
      return input.nextInt();
	}



	public static String getString()
	{
		return input.nextLine();
	}

}



class Game
{
	static final int size=100;
	static int line;
	static int row;
	static int bombnum;
	static int h=0;
	static int t=0;//计数，看是否把每个位置都遍历一遍
	static int Tt=0;//计数，看是否把正确的雷全部找到 
	static int Ft=0;//计数，标记错误的雷数


	
	static int[] a=new int[size];//暂存雷的行位置
	static int[] b=new int[size];//暂存雷的列位置
	static char[][] bomb=new char[size][size];
	static int show[][]=new int[size][size];
	static char[][] face=new char[size][size];//向用户展示扫雷界面



	
	public Game()
	{
		System.out.print("雷区的行数：");
		row=Input.getInt();
		System.out.print("雷区的列数：");
		line=Input.getInt();
		System.out.print("雷区的雷数：");
		bombnum=Input.getInt();

		for(int i=0;i<row;i++)//界面初始化
		{
			for(int j=0;j<line;j++)
				face[i][j]='+';
		}
	}


	public static void clear()//实现内存清理
	{

		Ft=0;
		Tt=0;
		for(int i=0;i<size;i++)
		{
			a[i]=0;
			b[i]=0;
			for(int j=0;j<size;j++)
			{
				bomb[i][j]='+';
				show[i][j]=0;
				//face[i][j]='+';
			}
		}
	}


	
	public static void rand()//产生随机数
	{
		while(h<bombnum)
		{
			a[h]=(int)(Math.random()*row);
			b[h]=(int)(Math.random()*line);
			for(int i=0;i<h;i++)
			{
				if(a[h]==a[i]&&b[h]==b[i])
				{
					h--;
					break;
				}
			}
			h++;
		}
		
	}



	
	public static  void setBomb()//布雷
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<line;j++)
			{
				bomb[i][j]='+';
			}
		}
		
		for(int i=0;i<bombnum;i++)
		{
			bomb[a[i]][b[i]]='*';
		}

	}


	
	
	public static void showBombNum()//展示非雷位置处的数字
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<line;j++)
			{
				if(bomb[i][j]!='*')
				{
					if(i==0&&j==0)
					{
						if(bomb[i+1][j]=='*') show[i][j]++;
						if(bomb[i+1][j+1]=='*') show[i][j]++;
						if(bomb[i][j+1]=='*')   show[i][j]++;
					}
					
					if(i==row-1&&j==0)
					{
						if(bomb[i-1][j]=='*') show[i][j]++;
						if(bomb[i-1][j+1]=='*')  show[i][j]++;
						if(bomb[i][j+1]=='*')    show[i][j]++;
					}
					
					if(i==0&&j==line-1)
					{
						if(bomb[i][j-1]=='*')   show[i][j]++;
						if(bomb[i+1][j-1]=='*')  show[i][j]++;
						if(bomb[i+1][j]=='*')    show[i][j]++;
					} 
					if(i==row-1&&j==line-1)
					{
						if(bomb[i][j-1]=='*')    show[i][j]++;
						if(bomb[i-1][j]=='*')    show[i][j]++;
						if(bomb[i-1][j-1]=='*')  show[i][j]++;
						
					}
					if(i==0&&j>0&&j<line-1)
					{
						if(bomb[i][j-1]=='*')   show[i][j]++;
						if(bomb[i][j+1]=='*')   show[i][j]++;
						if(bomb[i+1][j-1]=='*') show[i][j]++;
						if(bomb[i+1][j]=='*')   show[i][j]++;
						if(bomb[i+1][j+1]=='*') show[i][j]++;
					}
					if(i==row-1&&j>0&&j<line-1)
					{
						if(bomb[i][j-1]=='*')   show[i][j]++;
						if(bomb[i][j+1]=='*')   show[i][j]++;
						if(bomb[i-1][j-1]=='*') show[i][j]++;
						if(bomb[i-1][j]=='*')   show[i][j]++;
						if(bomb[i-1][j+1]=='*') show[i][j]++;
					}
					if(i>0&&i<row-1&&j==0)
					{
						if(bomb[i-1][j]=='*')   show[i][j]++;
						if(bomb[i+1][j]=='*')   show[i][j]++;
						if(bomb[i][j+1]=='*') show[i][j]++;
						if(bomb[i-1][j+1]=='*')   show[i][j]++;
						if(bomb[i+1][j+1]=='*') show[i][j]++;
						
					}
					if(i>0&&i<row-1&&j==line-1)
					{
						if(bomb[i-1][j]=='*')   show[i][j]++;
						if(bomb[i+1][j]=='*')   show[i][j]++;
						if(bomb[i][j-1]=='*')    show[i][j]++;
						if(bomb[i-1][j-1]=='*')   show[i][j]++;
						if(bomb[i+1][j-1]=='*')   show[i][j]++;
					}
					if(i>0&&i<row-1&&j>0&&j<line-1)
					{
						if(bomb[i-1][j]=='*')    show[i][j]++;
						if(bomb[i-1][j-1]=='*')  show[i][j]++;
						if(bomb[i+1][j-1]=='*')  show[i][j]++;
						if(bomb[i][j-1]=='*')    show[i][j]++;
						if(bomb[i+1][j]=='*')    show[i][j]++;
						if(bomb[i][j+1]=='*')    show[i][j]++;
						if(bomb[i-1][j+1]=='*')  show[i][j]++;
						if(bomb[i+1][j+1]=='*')  show[i][j]++;
						
					}
					
				}
				else show[i][j]=9;//是雷的位置处标记为1
			}
		}
	}





	public static void printMines()//界面展示
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.print(" ");
		for (int i = 0; i < line; i++) 
		{
			System.out.print(" "+i);
		}
		System.out.println();
		for (int i = 0; i < row; i++) 
		{
			System.out.print(i);
			for (int j = 0; j < line; j++)
			{
				System.out.print(" "+face[i][j]);
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}




	public static boolean XY(int x,int y)
	{
		if(x>=0&&y>=0&&x<row&&y<line)
			return true;
		else return false;
	}
	
	


	public static synchronized boolean Dig(int x, int y)//挖的操作
	{
		if(show[x][y]==9)
		{
			show();
			return true;//踩到地雷
		}
		else if(show[x][y]==0)
		{
			show(x,y);

			if(XY(x-1,y-1)&&face[x-1][y-1]=='+')
			{
				show(x-1,y-1);
				t++;
			}
			if(XY(x-1,y)&&face[x-1][y]=='+')
			{
				show(x-1,y);
				t++;
			}
			if(XY(x-1,y+1)&&face[x-1][y+1]=='+')
			{
				show(x-1,y+1);
				t++;
			}
			if(XY(x,y-1)&&face[x][y-1]=='+')
			{
				show(x,y-1);
				t++;
			}
			if(XY(x,y+1)&&face[x][y+1]=='+')
			{
				show(x,y+1);
				t++;
			}
			if(XY(x+1,y-1)&&face[x+1][y-1]=='+')
			{
				show(x+1,y-1);
				t++;
			}
			if(XY(x+1,y)&&face[x+1][y]=='+')
			{
				show(x+1,y);
				t++;
			}
			if(XY(x+1,y+1)&&face[x+1][y+1]=='+')
			{
				show(x+1,y+1);
				t++;
			}


		}
		else
		{
			face[x][y]=(char)(show[x][y]+'0');
		}
		printMines();
		return false;//没有踩到地雷
	}






	public static  void Mark(int x, int y)//做标记的操作
	{
		face[x][y]='#';
	}




	public static void show()//每进行一次操作(Mark||Dig)都向用户展示其当前结果
	{
		for(int i=0; i<row;i++)
		{
			for(int j=0;j<line; j++)
			{
				if(show[i][j]==9)
				{
					if(face[i][j]!='#')
					{
						face[i][j]='*';
					}
					else 
					{
						face[i][j]='@';
					}
				}
			}
		}
		printMines();
		System.out.println("胜败乃兵家常事，请大侠重新来过");
		
	}





	public static void show(int x,int y)
	{
		face[x][y]=(char)(show[x][y]+'0');
	}




	public static void BeginGame()//游戏进程
	{
		printMines();
		while(true)
		{
			
			Scanner scanner = new Scanner(System.in);
			String LINE = scanner.nextLine();
			String command = LINE.substring(0, 1);
			String args = LINE.substring(1, 3);
			if(command.equals("D"))
			{
				int x = Integer.valueOf(args.substring(0, 1));
				int y = Integer.valueOf(args.substring(1, 2));
				boolean flag = Dig(x, y);// 挖雷

				if(flag) break;
	
				t++;
			}
			else if(command.equals("M"))
			{
				int x = Integer.valueOf(args.substring(0, 1));
				int y = Integer.valueOf(args.substring(1, 2));
				Mark(x, y);//标记
				printMines();
				t++;
			}
			else System.out.println("error!");


		   if(t==row*line)
		   {
			   for(int i=0;i<row;i++)
			   {
				   for(int j=0;j<line;j++)
				   {
					    if(bomb[i][j]=='*')
					    {
						    if(face[i][j]!='#')
						    {
						       //System.out.println("胜败乃兵家常事，请大侠重新来过");
                               face[i][j]='@';//显示标记错误
							   Ft++;
						       //break;
						    }
						    else Tt++;
					    }
				   }
			   }
			   if(Tt==bombnum) System.out.println("恭喜过关！");
			   if(Ft>=1) show();

			   break;
		    }
		}

		
	}
}





class Dig_Mark     //提供进入游戏的一个界面，并附有扫雷规则
{
	Game game;
	public Dig_Mark()
	{
		this.game=new Game();
	}

	public static void rules()
	{
		System.out.println("欢迎进入扫雷程序！！！！");
		System.out.println("begin代表游戏开始，exit代表介绍");
		System.out.print("请选择：");
	}
	public void start()
	{
		System.out.println("请选择动作：D代表排雷(Dig)，M代表标雷(Mark) 例如M12");
	}
}






public class Clearbomb {
	

	
	public static void main(String[] args) {


        Dig_Mark.rules();
		Scanner read=new Scanner(System.in);
		String order=Input.getString();


		while(order.equals("begin"))
		{
			if(order.equals("exit")) break;

		     Dig_Mark set=new Dig_Mark();
		     set.start();
		     Game.rand();
		     Game.setBomb();
		     Game.showBombNum();
		     Game.BeginGame();
		     //System.out.println(Arrays.toString(Game.a));
		     Game.clear();
		     //System.out.println(Arrays.toString(Game.a));
			 order=read.nextLine();
		}


			 

	}

}