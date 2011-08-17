import java.util.Scanner;
class Operate{          //该程序进行的是布雷（也就是初始化雷区），排雷等相关的操作；
	public final int row = 5;   //以下为了初始化雷区要先定义一个5*5的二维数组；
	public final int column = 5;
	public int [][] lei;
	public char [][] jiemian;
	public Operate(){
		this.lei = new int[row][column];    //若为-1表示是雷，0表示周围无雷，其他正数表示周围雷的个数；
		this.jiemian = new char[row][column]; //若为'O'表示未点击（即未挖呢）'*'表示是雷 'P'表示插旗，标记为雷  '1'表示周围的雷数；
		init();
	}
	//以下这段是一个为了判断是否越界的方法；
	public boolean flag(int x,int y){
		if(x<0||x>=row||y<0||y>=column)  return false;
		else	
		return true;
	}
	//以下是对于界面的初始化；
	public void init(){
		int sum=0;
		while(sum<5){  //简单起见，就设定五个雷；
			int x;
			int y;
			x = (int)(Math.random()*5);  //随机产生雷的横纵坐标；
			y = (int)(Math.random()*5);
			if(this.lei[x][y] == -1) continue; //如果与之前产生的雷位置重复了就继续循环重新产生雷；
			this.lei[x][y] = -1; //-1即定为是雷；
			sum++;		//计数；	
		}
		//以下开始统计每个不是雷的位置的周围的雷数；
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				if(this.lei[i][j]!=-1){
					int number = 0;
					if(flag(i-1,j-1)){
						if(this.lei[i-1][j-1]==-1)
							number++;
					}
					if(flag(i-1,j)){
						if(this.lei[i-1][j]==-1)
							number++;
					}
					if(flag(i-1,j+1)){
						if(this.lei[i-1][j+1]==-1)
							number++;
					}
					if(flag(i,j-1)){
						if(this.lei[i][j-1]==-1)
							number++;
					}
					if(flag(i,j+1)){
						if(this.lei[i][j+1]==-1)
							number++;
					}
					if(flag(i+1,j-1)){
						if(this.lei[i+1][j-1]==-1)
							number++;
					}
					if(flag(i+1,j)){
						if(this.lei[i+1][j]==-1)
							number++;
					}
					if(flag(i+1,j+1)){
						if(this.lei[i+1][j+1]==-1)
							number++;
					}
					this.lei[i][j]=number;
				}				
			}
		}
		//以下先初始化界面，对于都是不确定是否有雷的位置，先都赋为'O';
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++){
				this.jiemian[i][j]='O';
			}
	}
	public void printJieMian(){
		System.out.println("------------");
		System.out.print(" ");
		for(int j=0;j<column;j++) System.out.print(" "+j);
		System.out.println();
		for(int i=0;i<row;i++){
			System.out.print(i);
			for(int j=0;j<column;j++)
				System.out.print(" "+this.jiemian[i][j]);
			System.out.print("\n");
		}
		System.out.println("------------");
	}
	public void beginOperate(){
		
	}
}
class PlayGame{
	public Operate operate;
	public void begin(){
		System.out.println("欢迎进入好玩的扫雷游戏：输入0退出，输入1开始游戏，输入2寻求帮助");
	}
	public void help(){
		System.out.println("很高兴给您提供帮助");
	}
	public void start(){
		int option=0;
		while(true){
			begin();
			System.out.print("请输入0或1或2：");
			Scanner input = new Scanner(System.in);
			option = input.nextInt();
			if(option==0){
				System.out.println("您已经退出游戏");
				System.exit(0);
			}
			if(option==1){
				this.operate.beginOperate();
			}
			if(option==2){
				help();
			}
			if(option!=0&&option!=1&&option!=2){
				System.out.println("error!请重新输入");
			}
		}
	}
}
public class SaoLei{
	public static void main(String[] args) {
		new PlayGame().start();
	}
}