//MineSweeper.java
import java.util.*;
public class MineSweeper{
  public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.println("����������ı߳���");
	int side_length=input.nextInt();
	System.out.println("�������׵���Ŀ��");
	int mine_num=input.nextInt();
    int[][] mine_ground;
    mine_ground=new int[side_length+2][side_length+2];
	for(int i=0;i<side_length+2;i++){
	  for(int j=0;j<side_length+2;j++){
	    mine_ground[i][j]=0;
	  }
	}
	for(int i=0;i<mine_num;i++){
	  int mine=(int)(Math.random()*(side_length*side_length));
	  if(mine_ground[mine/side_length+1][mine%side_length+1]==0){
	    mine_ground[mine/side_length+1][mine%side_length+1]=10;
	  }
	  else{
	    i--;
	  }
	}
	for(int i=1;i<side_length+1;i++){
	  for(int j=1;j<side_length+1;j++){
	    if(mine_ground[i][j]==10) continue;
		else{
		  if(mine_ground[i-1][j-1]==10) mine_ground[i][j]++;
		  if(mine_ground[i][j-1]==10)   mine_ground[i][j]++;
		  if(mine_ground[i+1][j-1]==10) mine_ground[i][j]++;
		  if(mine_ground[i+1][j]==10)   mine_ground[i][j]++;
		  if(mine_ground[i+1][j+1]==10) mine_ground[i][j]++;
		  if(mine_ground[i][j+1]==10)   mine_ground[i][j]++;
		  if(mine_ground[i-1][j+1]==10) mine_ground[i][j]++;
		  if(mine_ground[i-1][j]==10)   mine_ground[i][j]++;
		}
	  }
	}
	int sweep_now=0;
	System.out.println("��Ϸ��ʼ��");
    while(sweep_now<side_length*side_length){
	  System.out.println("������Ҫ�ڵ��к����к�(��1���߳�)��");
	  int row=input.nextInt();
	  int column=input.nextInt();
	  if(row>side_length||column>side_length){
		System.out.println("�кŻ��кų�����Χ���˴�������Ч��");
		continue;
	  }
	  if(mine_ground[row][column]==10){
	    System.out.println("�䣡It's a pity!���ڵ����ˣ���Ϸ����������");
		break;
	  }
	  else{
	    System.out.println(mine_ground[row][column]);
		sweep_now++;
	  }
	  
	}
	if(sweep_now==side_length*side_length){
	  System.out.println("Congratulations��ɨ�׳ɹ���");
	}
  }
}