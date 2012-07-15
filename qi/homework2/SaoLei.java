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
		for(int i=0;i<row;i++)
            for(int j=0;j<column;j++){
                    this.lei[i][j]=0;                 
            }
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
	// 以下这段代码是每一次操作之后都要打印一下操作后的新界面；
	public void printJieMian(){
		System.out.println("------------");   //美观考虑，做了一个外框；
		System.out.print(" ");
		for(int j=0;j<column;j++) System.out.print(" "+j); //打印出纵坐标，方便用户操作；
		System.out.println();
		for(int i=0;i<row;i++){
			System.out.print(i);  //打印出横坐标，方便用户操作；
			for(int j=0;j<column;j++)
				System.out.print(" "+this.jiemian[i][j]);  //打印出每一次挖雷操作后的界面；
			System.out.print("\n");
		}
		System.out.println("------------");  //边框部分；
	}
	//以下代码部分是挖雷操作开始进入的程序；
	public void beginOperate(){
		int k;
		/*用一个for循环是为了统计该游戏合适成功，漏洞是用户需要在扫雷过后给你认为每一个是雷的位置插上小旗，也就是说
		只有用户能够成功操作了25次以后，你就挖雷成功了；*/
		for(k=0;k<25;k++){
			this.printJieMian(); //每次次挖雷操作之前先进行打印界面的工作，打印出上一次操作后的界面；
			System.out.print("请输入：W代表挖雷，P代表插旗，例如：W34表示挖该坐标为34的位置");  //给用户提示信息；
			//以下代码是为了读取出用户输入的关于怎样操作的字符串；
			Scanner string = new Scanner(System.in);  
			String line = string.nextLine();
			String instruction = line.substring(0, 1); //定义一个变量为了读取用户输入的字符串的子字符串，也就是W或者是P；
			String zuobiao = line.substring(1,3);   //定义一个变量为了读取用户输入的字符串的子字符串，也就是x和y的坐标； 这里substring的用法就不详细的说了，一定要注意括号中的两个参数；
			//以下做一个判断，看是挖雷还是插旗，即标注；
			if(instruction.equals("W")){
				int x = Integer.parseInt(zuobiao.substring(0,1));  //如果是挖雷，获取坐标串中的x坐标；
				int y = Integer.parseInt(zuobiao.substring(1,2));  //获取坐标串中的y坐标；
				//以下需要做一个判断，看是否踩到雷了；
				boolean flag = this.walei(x,y);
				if(flag){
					break;  //如果踩到了雷，循环结束；
				}
				//如果是插旗，进入下面程序；
			}else if(instruction.equals("P")){
					int x = Integer.parseInt(zuobiao.substring(0,1));  //同样获取x坐标；
					int y = Integer.parseInt(zuobiao.substring(1,2));  //获取y坐标；
					this.chaqi(x,y);  //x，y作为参数进入插旗的方法中；
			}else{
				System.out.println("Error!请重新输入:");  //如果不符合要求输入，显示这个结果；
			}
		}
		if(k==25){
			System.out.println("恭喜闯关成功");  //如果循环了25次，说明挖雷成功；
		}
		this.init();  //对于每一次游戏结束的时候，不管是成功了还是失败了，都要进行新一次游戏之前的布雷以及统计工作；
	}
	//以下程序是挖雷程序，判断是否踩到了雷，如果踩到了雷该怎么办；
	public boolean walei(int x,int y){
		if(this.lei[x][y]==-1){			
			explode();    //如果踩到了雷，执行爆炸方法；
			return true;   //同时返回值为真；
		}
		else{
			this.jiemian[x][y]=(char)(this.lei[x][y]+'0');  //如果不是雷，将该位置的坐标通过字符的形式赋给界面中的相应位置；
		}
		return false; //同时返回值为假；
	}
	//以下是爆炸方法的程序；
	public void explode(){    //如果踩到了雷，开始从头检索；
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++){
				if(this.lei[i][j]==-1){   //如果是雷；
					if(this.jiemian[i][j]!='P'){   //且没有被插旗；
						this.jiemian[i][j]='*';    //  则将代表雷的字符赋给这个位置；
					}
				}
			}
		this.printJieMian();   //同时打印出这个界面；
		System.out.println("很遗憾！游戏失败！");   //并深情地告诉用户游戏失败了；
	}
	//以下是插旗方法的程序；
	public void chaqi(int x,int y){
		this.jiemian[x][y]='P';     //通过传进来的x，y坐标给相应的位置赋为符号P；
	}
}
//以下定义一个PlayGame类；
class PlayGame{ 
	public Operate operate;
	public PlayGame(){
		this.operate = new Operate();
	}
	//以下是进入挖雷游戏时的一个初始化的界面；
	public void begin(){
		System.out.println("欢迎进入好玩的扫雷游戏：输入0退出，输入1开始游戏，输入2寻求帮助");
	}
	public void help(){
		System.out.println("很高兴给您提供帮助");
	}
	public void start(){
		int option=0;
		while(true){   //一直循环，直到用户输入0表示退出时程序结束；
			begin();
			System.out.print("请输入0或1或2：");
			Scanner input = new Scanner(System.in);
			option = input.nextInt();
			if(option==0){
				System.out.println("您已经退出游戏");
				System.exit(0);
			}else if(option==1){
				this.operate.beginOperate();
			}else if(option==2){
				help();
			}else{
				System.out.println("Error!请重新输入");
			}
		}
	}
}
//程序的主类；
public class SaoLei{
	public static void main(String[] args) {
		new PlayGame().start();    //开始挖雷游戏；
	}
}