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
	public char[][] mine2;
	
	public Mine()
		//���캯��
	{
		//this�ؼ��ּӹؼ������֪ͨϵͳ����mine��������е�mine����
		//������this�ؼ���,���ܻᱨ����ʾ�磺�Ҳ������ŵ�
		this.mine = new int[row][line];
		this.mine2 = new char[row][line];
	}

	//�ж��Ƿ�Խ��
	//�������������������ڴ洢ʱ�Ǵ�����һ��������ַ�У���һ�ص����ж�Խ�����
	//���淽���������ⷽ����Ƚ��迼�ǣ�ͷβ����Խ�����
	public boolean over(int i,int j)
	{
		if(i+1>9 || i-1<0 || j+1>9 || j-1<0)
			return true;
		else
			return false;
	}

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
//����
{
}

//***************************************************//
class Timer
//�����������ɨ�������ʱ��
{
}