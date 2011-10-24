import java.lang.*;
import java.util.*;
//************************************************************//
//主类
class  Mine_Clearance

{
	public static void main(String[] args) 
	{
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
	}
	//构造方法结束

	//判断是否越界
	//本来我是想利用数组在存储时是储存在一段连续地址中，这一特点来判断越界情况
	//上面方法和下面这方法相比仅需考虑：头尾两种越界情况
	public boolean over(int i,int j)
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
			int sum = 0;
			while(sum < 10)
			{
				//通过Random方法确定雷的位置
				//【http://wenku.baidu.com/view/c8376309f78a6529647d53cb.html】说的i = (int)Math.Random()*10;无法通过编译
				//下面的语句可以
				i = (int)Math.random()*10;
				j = (int)Math.random()*10;
				//先判断该处是否已经有雷，若无这步可能最终雷的数量比10少
				if(mine[i][j]==-1) continue;
				else mine[i][j] = -1;
				sum++;
				//以下8个判断语句用来统计某一位置周围雷的个数
				//每产生一个雷就让周围八个位置计数，进行++操作
				if(!this.over(i-1,j))
				{
					this.mine[i-1][j]++;
				}
				if(!this.over(i+1,j))
				{
					this.mine[i+1][j]++;
				}
				if(!this.over(i,j+1))
				{
					this.mine[i][j+1]++;
				}
				if(!this.over(i,j-1))
				{
					this.mine[i][j-1]++;
				}
				if(!this.over(i-1,j-1))
				{
					this.mine[i-1][j-1]++;
				}
				if(!this.over(i+1,j-1))
				{
					this.mine[i+1][j-1]++;
				}
				if(!this.over(i-1,j+1))
				{
					this.mine[i-1][j+1]++;
				}
				if(!this.over(i+1,j+1))
				{
					this.mine[i+1][j+1]++;
				}
			}
		}
		//布雷方法结束

//输出界面方法
public void Print_limsurface(){
		System.out.println("------------");  
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
		System.out.println("------------"); 
		//边框部分；
	}
	//输出界面方法结束

	public void begin()
		//这个方法的名字再改
	//在该方法中进行的操作主要是接受用户输入，并对该输入进行相应的处理
	{
	}

	//挖雷方法开始
	public boolean Dig(int x,int y)
	{
		if(this.mine[x][y]==-1)
		{
			explode();
			return false;
			//挖到雷则执行explode方法并返回false
			}
		else
		{
			if(this.mine[x][y]==0)
				//若mine[x][y]==0则挖其周围八个位置，这样就会在点到0时出现一片空白
			{
				if(!this.over(x-1,y))
				{Dig(x-1,y);}
				if(!this.over(x-1,y-1))
				{Dig(x-1,y-1);}
				if(!this.over(x-1,y+1))
				{Dig(x-1,y+1);}
				if(!this.over(x,y-1))
				{Dig(x,y-1);}
				if(!this.over(x,y+1))
				{Dig(x,y+1);}
				if(!this.over(x+1,y-1))
				{Dig(x+1,y-1);}
				if(!this.over(x+1,y+1))
				{Dig(x+1,y+1);}
				if(!this.over(x+1,y))
				{Dig(x+1,y);}
			}
			else
				//若mine[x][y]为数字则对mine2[x][y]重新赋值并返回ture
			{
				this.mine2[x][y] = (char)(this.mine[x][y]+'0');
				
			}
			return true;
		}
	}
	//挖雷方法结束

	//explode方法
	public void explode()
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
	}
	//explode方法结束

	//flag方法 用于插旗
	public void flag(int x,int y)
	{
		this.mine2[x][y] = 'F';
	}
	//flag方法结束
}

//***************************************************************//