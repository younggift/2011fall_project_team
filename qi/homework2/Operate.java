import java.util.Scanner;
public class Operate {          //�ó�����е��ǲ��ף�Ҳ���ǳ�ʼ�������������׵���صĲ�����
	public final int row = 5;   //����Ϊ�˳�ʼ������Ҫ�ȶ���һ��5*5�Ķ�ά���飻
	public final int column = 5;
	public int [][] lei;
	public char [][] jiemian;
	public Operate(){
		this.lei = new int[row][column];    //��Ϊ-1��ʾ���ף�0��ʾ��Χ���ף�����������ʾ��Χ�׵ĸ�����
		this.jiemian = new char[row][column]; //��Ϊ'O'��ʾδ�������δ���أ�'*'��ʾ���� 'P'��ʾ���죬���Ϊ��  '1'��ʾ��Χ��������
		init();
	}
	//���������һ��Ϊ���ж��Ƿ�Խ��ķ�����
	public boolean flag(int x,int y){
		if(x<0||x>=row||y<0||y>=column)  return false;
		else	
		return true;
	}
	//�����Ƕ��ڽ���ĳ�ʼ����
	public void init(){
		int sum=0;
		while(sum<5){  //����������趨����ף�
			int x;
			int y;
			x = (int)(Math.random()*5);  //��������׵ĺ������ꣻ
			y = (int)(Math.random()*5);
			if(this.lei[x][y] == -1) continue; //�����֮ǰ��������λ���ظ��˾ͼ���ѭ�����²����ף�
			this.lei[x][y] = -1; //-1����Ϊ���ף�
			sum++;		//������	
		}
		//���¿�ʼͳ��ÿ�������׵�λ�õ���Χ��������
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
		//�����ȳ�ʼ�����棬���ڶ��ǲ�ȷ���Ƿ����׵�λ�ã��ȶ���Ϊ'O';
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++){
				this.jiemian[i][j]='O';
			}
	}
	

}
