import java.lang.*;
import java.util.*;
//************************************************************//
//����
class  Mine_Clearance

{
	public static void main(String[] args) 
	{
	}
}

//**********************************************************//
//����
class Mine
//��10*10�����ʾ����
//�׵Ĳ���������ͨ��random����
//�������ڸ����ø�ֵλ��������-1
//�Ǹ���������Χ�˸�λ���׵�����
{
	//���ݳ�Ա
	public final int row = 10,line = 10;
	public int[][] mine;
	//mine���������洢�׵ķֲ���Ϣ
	public char[][] mine2;
	//mine2���鶨��Ϊchar�����ڽ����������Ϊ��ĳһλ�ÿ��ܽ��в���Ȳ�������char��
	
	public Mine()
		//���캯��
	{
		//this�ؼ��ּӹؼ������֪ͨϵͳ����mine��������е�mine����
		//������this�ؼ���,���ܻᱨ����ʾ�磺�Ҳ������ŵ�
		this.mine = new int[row][line];
		this.mine2 = new char[row][line];
	}
	//���췽������

	//�ж��Ƿ�Խ��
	//�������������������ڴ洢ʱ�Ǵ�����һ��������ַ�У���һ�ص����ж�Խ�����
	//���淽���������ⷽ����Ƚ��迼�ǣ�ͷβ����Խ�����
	public boolean over(int i,int j)
	{
		if(i>=row || i<0 || j>=line || j<0)
			return true;
		else
			return false;
	}
	//�ж��Ƿ�Խ�緽������

	public void Initialize()
		//��ʼ����
		{
			int i = 0,j = 0;
			int sum = 0;
			while(sum < 10)
			{
				//ͨ��Random����ȷ���׵�λ��
				//��http://wenku.baidu.com/view/c8376309f78a6529647d53cb.html��˵��i = (int)Math.Random()*10;�޷�ͨ������
				//�����������
				i = (int)Math.random()*10;
				j = (int)Math.random()*10;
				//���жϸô��Ƿ��Ѿ����ף������ⲽ���������׵�������10��
				if(mine[i][j]==-1) continue;
				else mine[i][j] = -1;
				sum++;
				//����8���ж��������ͳ��ĳһλ����Χ�׵ĸ���
				//ÿ����һ���׾�����Χ�˸�λ�ü���������++����
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
		//���׷�������

//������淽��
public void Print_limsurface(){
		System.out.println("------------");  
		//Ϊÿ��������滭����
		System.out.print(" ");
		for(int j=0;j<line;j++) System.out.print(" "+j);
		//��ӡ�������꣬�����û�������
		System.out.println();
		for(int i=0;i<row;i++){
			System.out.print(i);  
			//��ӡ�������꣬�����û�������
			for(int j=0;j<line;j++)
				System.out.print(" "+this.mine2[i][j]);
			//��ӡ��ÿһ�����ײ�����Ľ��棻
			System.out.println("");
		}
		System.out.println("------------"); 
		//�߿򲿷֣�
	}
	//������淽������

	public void begin()
		//��������������ٸ�
	//�ڸ÷����н��еĲ�����Ҫ�ǽ����û����룬���Ը����������Ӧ�Ĵ���
	{
	}

	//���׷�����ʼ
	public boolean Dig(int x,int y)
	{
		if(this.mine[x][y]==-1)
		{
			explode();
			return false;
			//�ڵ�����ִ��explode����������false
			}
		else
		{
			if(this.mine[x][y]==0)
				//��mine[x][y]==0��������Χ�˸�λ�ã������ͻ��ڵ㵽0ʱ����һƬ�հ�
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
				//��mine[x][y]Ϊ�������mine2[x][y]���¸�ֵ������ture
			{
				this.mine2[x][y] = (char)(this.mine[x][y]+'0');
				
			}
			return true;
		}
	}
	//���׷�������

	//explode����
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
		System.out.println("ͬѧ��ȵ����ˣ�");
	}
	//explode��������

	//flag���� ���ڲ���
	public void flag(int x,int y)
	{
		this.mine2[x][y] = 'F';
	}
	//flag��������
}

//***************************************************************//