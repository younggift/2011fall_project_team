import java.lang.*;
import java.util.*;
//************************************************************//
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
	public char[][] mine2;
	
	public Mine()
		//构造函数
	{
		//this关键字加关键后就是通知系统变量mine是这个类中的mine变量
		//若不加this关键字,可能会报错。提示如：找不到符号等
		this.mine = new int[row][line];
		this.mine2 = new char[row][line];
	}

	//判断是否越界
	//本来我是想利用数组在存储时是储存在一段连续地址中，这一特点来判断越界情况
	//上面方法和下面这方法相比仅需考虑：头尾两种越界情况
	public boolean over(int i,int j)
	{
		if(i+1>9 || i-1<0 || j+1>9 || j-1<0)
			return true;
		else
			return false;
	}

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

}

//**************************************************//
class Dig
{
}

//***************************************************//
class Flag
//插旗
{
}

//***************************************************//
class Timer
//用来计算完成扫雷任务的时间
{
}