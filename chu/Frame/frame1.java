import java.util.Scanner;
class Operate{          
	public final int row = 5;   
	public final int column = 5;
	public int [][] lei;
	public char [][] jiemian;
	public Operate(){
		this.lei = new int[row][column];    
		this.jiemian = new char[row][column]; 
		init();
	}
	
	public boolean flag(int x,int y){
		if(x<0||x>=row||y<0||y>=column)  return false;
		else	
		return true;
	}
	
	public void init(){
		for(int i=0;i<row;i++)
            for(int j=0;j<column;j++){
                    this.lei[i][j]=0;                 
            }
		int sum=0;
		while(sum<5){  
			int x;
			int y;
			x = (int)(Math.random()*5);  
			y = (int)(Math.random()*5);
			if(this.lei[x][y] == -1) continue; 
			this.lei[x][y] = -1; 
			sum++;		
		}
		
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
		int k;
		/*用一个for循环是为了统计该游戏合适成功，漏洞是用户需要在扫雷过后给你认为每一个是雷的位置插上小旗，也就是说
		只有用户能够成功操作了25次以后，你就挖雷成功了；*/
		for(k=0;k<25;k++){
			this.printJieMian(); 
			System.out.print("请输入：W代表挖雷，P代表插旗，例如：W34表示挖该坐标为34的位置");  
			
			Scanner string = new Scanner(System.in);  
			String line = string.nextLine();
			String instruction = line.substring(0, 1); 
			String zuobiao = line.substring(1,3);   
			if(instruction.equals("W")){
				int x = Integer.parseInt(zuobiao.substring(0,1)); 
				int y = Integer.parseInt(zuobiao.substring(1,2)); 
				boolean flag = this.walei(x,y);
				if(flag){
					break;  
				}
				
			}else if(instruction.equals("P")){
					int x = Integer.parseInt(zuobiao.substring(0,1));  
					int y = Integer.parseInt(zuobiao.substring(1,2));  
					this.chaqi(x,y); 
			}else{
				System.out.println("Error!请重新输入:");  
			}
		}
		if(k==25){
			System.out.println("恭喜闯关成功");  
		}
		this.init(); 
	public boolean walei(int x,int y){
		if(this.lei[x][y]==-1){			
			explode();    
			return true;   
		}
		else{
			this.jiemian[x][y]=(char)(this.lei[x][y]+'0');  
		}
		return false; 
	}
	
	public void explode(){    
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++){
				if(this.lei[i][j]==-1){   
					if(this.jiemian[i][j]!='P'){   
						this.jiemian[i][j]='*';   
					}
				}
			}
		this.printJieMian();   
		System.out.println("很遗憾！游戏失败！");  
	}
	
	public void chaqi(int x,int y){
		this.jiemian[x][y]='P';    
	}
}

class PlayGame{ 
	public Operate operate;
	public PlayGame(){
		this.operate = new Operate();
	}
	
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

public class SaoLei{
	public static void main(String[] args) {
		new PlayGame().start();    
	}
}