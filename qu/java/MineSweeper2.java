//MineSweeper2.java
import java.util.*;
import java.io.*;
public class MineSweeper2{
  static int length,width,sweep_now;       //sweep_now为已点开的点的数目
  static char mine_map[][] = new char[100][100];  //定义要显示的数组
  static int mine_ground[][] = new int[100][100];  //定义表示雷阵的数组
  static boolean already[][] = new boolean[100][100]; //标记已经被打开的点
  static boolean[][] check = new boolean[100][100];  //标记点之前是否被插旗
  public MineSweeper2(int length,int width)
  {
	  this.length=length;
	  this.width=width;
  }


  public static void intiMineMap(){                      //将要显示的数组初始化成全是“#”
    for(int i=1;i<=width;i++){          
	  for(int j=1;j<=length;j++){
	    mine_map[i][j]='#';                       //“#”代表为被挖开的点
	  }
	}
  }

   public static void printMineMap(){                     //打印要显示的数组
    for(int i=1;i<=width;i++){          
	  for(int j=1;j<=length;j++){
        System.out.print(mine_map[i][j]);
	  }
	  System.out.println();
	}
  }
  
  static void dfs(int x,int y){                     //利用深度优先搜索来打开周围没有雷的点
    if(x<1||x>width||y<1||y>length) return;
	if(already[x][y]) return;
	sweep_now++;
	if(mine_ground[x][y]!=0){
	  mine_map[x][y]=(char)(mine_ground[x][y]+48);
	  already[x][y]=true;
	  return;
	}
	if(mine_ground[x][y]==0){
	  mine_map[x][y]='`';
	  already[x][y]=true;
	}
	dfs(x+1,y);
	dfs(x+1,y+1);
	dfs(x,y+1);
	dfs(x-1,y+1);
	dfs(x-1,y);
	dfs(x-1,y-1);
	dfs(x,y-1);
	dfs(x+1,y-1);
  }

  private static int dig(int a,int b){            //挖雷操作：a和b分别为挖的点的行标和列标，从1开始
	//System.out.println("dig!");
	if(a>width||b>length) return 0;                   //若要被打开的点不在雷阵内，就不进行下面的操作
    if(mine_ground[a][b]==10){                       //1.挖到雷的情况
	  mine_map[a][b] = '*';                              //“*”表示雷
	  for(int i=1;i<=width;i++){
	    for(int j=1;j<=length;j++){
		  if(mine_ground[i][j]==10)
		    mine_map[i][j]='*';
		}
	  }
	  return 1;
	}
	else{ 
	  if(mine_ground[a][b]==0){                      //2.挖到四周的都没雷的点的情况
		mine_map[a][b]='`';                             //将四周无雷的点赋成‘`’，表示被点开
		dfs(a,b);
		return 0;
	  }
	  else{
	    mine_map[a][b]=(char)(mine_ground[a][b]+48);         //挖到四周有雷的点
		sweep_now++;
        return 0;
	  }
	}
  }

  private static int sign(int a,int b){                   //插旗操作：a和b分别为挖的点的行标和列标，从1开始
    //System.out.println("sign!");
	if(!check[a][b]){                                 //未插旗则在此点插旗
	  //System.out.println("sign~");
	  System.out.println(a+" "+b);
	  check[a][b]=true;
	  mine_map[a][b]='^';                              //“^”表示已插上旗
	  //System.out.println(mine_map[1][1]);
	  sweep_now++;
	  return 0;
	}                                        
	else{                                              //若此点已插过旗，则是取消插旗          
	  check[a][b]=false;
	  mine_map[a][b]='#';
	  sweep_now--;
	  return 0;
	}
  }

  public static void main(String[] args) throws IOException{
	  //new MineSweeper2();
	  //new MineSweeper2(length,width);
    Scanner input = new Scanner(System.in);          //用户对设置雷阵的长、宽及雷的数目     
	System.out.println("请输入雷阵的长：");
	int length = input.nextInt();
	System.out.println("请输入雷阵的宽：");
	int width = input.nextInt();
	System.out.println("请输入雷的数目：");
	int mine_num = input.nextInt();

	new MineSweeper2(length,width);
	for(int i=0;i<width+2;i++){                      //雷阵的初始化
	  for(int j=0;j<length+2;j++){
	    mine_ground[i][j] = 0;
	  }
	}
	
	for(int i=0;i<mine_num;i++){
	  int mine = (int)(Math.random()*(length*width));      //产生随机数布雷
	  if(mine_ground[mine/length+1][mine%length+1]==0){    
	    mine_ground[mine/length+1][mine%length+1] = 10;
	  }
	  else{                                                //若一个点之前已经有了雷就再多循环一次
	    i--;
	  }
	}
    
	for(int i=1;i<=width;i++){                        //为非雷区域填数字
	  for(int j=1;j<=length;j++){
	    if(mine_ground[i][j]==10) continue;
		if(mine_ground[i][j+1]==10) mine_ground[i][j]++;
		if(mine_ground[i+1][j+1]==10) mine_ground[i][j]++;
		if(mine_ground[i+1][j]==10) mine_ground[i][j]++;
		if(mine_ground[i+1][j-1]==10) mine_ground[i][j]++;
		if(mine_ground[i-1][j]==10) mine_ground[i][j]++;
		if(mine_ground[i-1][j-1]==10) mine_ground[i][j]++;
		if(mine_ground[i][j-1]==10) mine_ground[i][j]++;
		if(mine_ground[i-1][j+1]==10) mine_ground[i][j]++;
	  }
	}

    intiMineMap();
	//printMineMap();
	//System.out.println("helllllllll");
	while(sweep_now<length*width){
	  System.out.println("请输入您要执行的操作种类及坐标（挖雷用“d”表示，插旗用“s”表示，后面接行标及列标，从1开始）：");
	  System.out.println("（在已插过旗的地方插旗为拿掉已插上的旗）");
	  if(sweep_now==0) printMineMap();
	  //System.out.println(sweep_now);
      byte cmd[]=new byte[10];
	  System.in.read(cmd);
	  //System.out.println(cmd[1]+" "+cmd[2]);
	  if((char)cmd[0]=='d'){
		//System.out.println("dig");
	    if(dig((int)cmd[1]-48,(int)cmd[2]-48)==1){
		  printMineMap();
		  System.out.println("您挖到了雷，游戏结束!");
		  break;
		}
		else
		  printMineMap();
	  }
	  if((char)cmd[0]=='s'){
		//System.out.println("sign");
	    sign((int)cmd[1]-48,(int)cmd[2]-48);
		printMineMap();
	  }
	}
	if(sweep_now==length*width)
	  System.out.println("Yeah!");
  }
}