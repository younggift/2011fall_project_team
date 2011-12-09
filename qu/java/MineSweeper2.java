//MineSweeper2.java
import java.util.*;
import java.io.*;
public class MineSweeper2{
  static int length,width,sweep_now;       //sweep_nowΪ�ѵ㿪�ĵ����Ŀ
  static char mine_map[][] = new char[100][100];  //����Ҫ��ʾ������
  static int mine_ground[][] = new int[100][100];  //�����ʾ���������
  static boolean already[][] = new boolean[100][100]; //����Ѿ����򿪵ĵ�
  static boolean[][] check = new boolean[100][100];  //��ǵ�֮ǰ�Ƿ񱻲���
  public MineSweeper2(int length,int width)
  {
	  this.length=length;
	  this.width=width;
  }


  public static void intiMineMap(){                      //��Ҫ��ʾ�������ʼ����ȫ�ǡ�#��
    for(int i=1;i<=width;i++){          
	  for(int j=1;j<=length;j++){
	    mine_map[i][j]='#';                       //��#������Ϊ���ڿ��ĵ�
	  }
	}
  }

   public static void printMineMap(){                     //��ӡҪ��ʾ������
    for(int i=1;i<=width;i++){          
	  for(int j=1;j<=length;j++){
        System.out.print(mine_map[i][j]);
	  }
	  System.out.println();
	}
  }
  
  static void dfs(int x,int y){                     //���������������������Χû���׵ĵ�
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

  private static int dig(int a,int b){            //���ײ�����a��b�ֱ�Ϊ�ڵĵ���б���б꣬��1��ʼ
	//System.out.println("dig!");
	if(a>width||b>length) return 0;                   //��Ҫ���򿪵ĵ㲻�������ڣ��Ͳ���������Ĳ���
    if(mine_ground[a][b]==10){                       //1.�ڵ��׵����
	  mine_map[a][b] = '*';                              //��*����ʾ��
	  for(int i=1;i<=width;i++){
	    for(int j=1;j<=length;j++){
		  if(mine_ground[i][j]==10)
		    mine_map[i][j]='*';
		}
	  }
	  return 1;
	}
	else{ 
	  if(mine_ground[a][b]==0){                      //2.�ڵ����ܵĶ�û�׵ĵ�����
		mine_map[a][b]='`';                             //���������׵ĵ㸳�ɡ�`������ʾ���㿪
		dfs(a,b);
		return 0;
	  }
	  else{
	    mine_map[a][b]=(char)(mine_ground[a][b]+48);         //�ڵ��������׵ĵ�
		sweep_now++;
        return 0;
	  }
	}
  }

  private static int sign(int a,int b){                   //���������a��b�ֱ�Ϊ�ڵĵ���б���б꣬��1��ʼ
    //System.out.println("sign!");
	if(!check[a][b]){                                 //δ�������ڴ˵����
	  //System.out.println("sign~");
	  System.out.println(a+" "+b);
	  check[a][b]=true;
	  mine_map[a][b]='^';                              //��^����ʾ�Ѳ�����
	  //System.out.println(mine_map[1][1]);
	  sweep_now++;
	  return 0;
	}                                        
	else{                                              //���˵��Ѳ���죬����ȡ������          
	  check[a][b]=false;
	  mine_map[a][b]='#';
	  sweep_now--;
	  return 0;
	}
  }

  public static void main(String[] args) throws IOException{
	  //new MineSweeper2();
	  //new MineSweeper2(length,width);
    Scanner input = new Scanner(System.in);          //�û�����������ĳ������׵���Ŀ     
	System.out.println("����������ĳ���");
	int length = input.nextInt();
	System.out.println("����������Ŀ�");
	int width = input.nextInt();
	System.out.println("�������׵���Ŀ��");
	int mine_num = input.nextInt();

	new MineSweeper2(length,width);
	for(int i=0;i<width+2;i++){                      //����ĳ�ʼ��
	  for(int j=0;j<length+2;j++){
	    mine_ground[i][j] = 0;
	  }
	}
	
	for(int i=0;i<mine_num;i++){
	  int mine = (int)(Math.random()*(length*width));      //�������������
	  if(mine_ground[mine/length+1][mine%length+1]==0){    
	    mine_ground[mine/length+1][mine%length+1] = 10;
	  }
	  else{                                                //��һ����֮ǰ�Ѿ������׾��ٶ�ѭ��һ��
	    i--;
	  }
	}
    
	for(int i=1;i<=width;i++){                        //Ϊ��������������
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
	  System.out.println("��������Ҫִ�еĲ������༰���꣨�����á�d����ʾ�������á�s����ʾ��������б꼰�б꣬��1��ʼ����");
	  System.out.println("�����Ѳ����ĵط�����Ϊ�õ��Ѳ��ϵ��죩");
	  if(sweep_now==0) printMineMap();
	  //System.out.println(sweep_now);
      byte cmd[]=new byte[10];
	  System.in.read(cmd);
	  //System.out.println(cmd[1]+" "+cmd[2]);
	  if((char)cmd[0]=='d'){
		//System.out.println("dig");
	    if(dig((int)cmd[1]-48,(int)cmd[2]-48)==1){
		  printMineMap();
		  System.out.println("���ڵ����ף���Ϸ����!");
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