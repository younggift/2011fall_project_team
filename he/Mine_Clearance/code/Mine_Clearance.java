import java.lang.*;
import java.util.*;
//************************************************************//
//����
class  Mine_Clearance

{
	public static void main(String[] args) 
	{
		//new PlayGame().Play();
		PlayGame playgame = new PlayGame();
		playgame.Play();
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
		Initialize();
	}
	//���췽������

	//�ж��Ƿ�Խ��
	//�������������������ڴ洢ʱ�Ǵ�����һ��������ַ�У���һ�ص����ж�Խ�����
	//���淽���������ⷽ����Ƚ��迼�ǣ�ͷβ����Խ�����
	public boolean Over(int i,int j)
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
			for (i = 0;i < row;i++)
			{
				for(j = 0;j<line;j++)
				{this.mine[i][j] = 0;}
			}
			int sum = 0;
			while(sum < 10)
			{
				//ͨ��Random����ȷ���׵�λ��
				//�����������
				i = (int)(Math.random()*10);
				j = (int)(Math.random()*10);
				//���жϸô��Ƿ��Ѿ����ף������ⲽ���������׵�������10��
				if(this.mine[i][j]==-1) continue;
				//else
					this.mine[i][j] = -1;
					sum++;
				//����8���ж��������ͳ��ĳһλ����Χ�׵ĸ���
				//ÿ����һ���׾�����Χ�˸�λ�ü���������++����
				if(!(this.Over(i-1,j))&&(this.mine[i-1][j]!=-1))
				{
					this.mine[i-1][j]++;
				}
				if(!(this.Over(i+1,j))&&(this.mine[i+1][j]!=-1))
				{
					this.mine[i+1][j]++;
				}
				if(!(this.Over(i,j+1))&&(this.mine[i][j+1]!=-1))
				{
					this.mine[i][j+1]++;
				}
				if((!this.Over(i,j-1))&&(this.mine[i][j-1]!=-1))
				{
					this.mine[i][j-1]++;
				}
				if((!this.Over(i-1,j-1))&&(this.mine[i-1][j-1]!=-1))
				{
					this.mine[i-1][j-1]++;
				}
				if((!this.Over(i+1,j-1))&&(this.mine[i+1][j-1]!=-1))
				{
					this.mine[i+1][j-1]++;
				}
				if((!this.Over(i-1,j+1))&&(this.mine[i-1][j+1]!=-1))
				{
					this.mine[i-1][j+1]++;
				}
				if((!this.Over(i+1,j+1))&&(this.mine[i+1][j+1]!=-1))
				{
					this.mine[i+1][j+1]++;
				}				
			}
			for(i = 0;i<row;i++)
			{
				for(j = 0;j<line;j++)
				{this.mine2[i][j] = '#';}

			}
		}
		//���׷�������

//������淽��
public void Print_limsurface(){
		System.out.println("------------------------");  
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
		System.out.println("------------------------"); 
		//�߿򲿷֣�
	}
	//������淽������

	public void Begin()
		//��������������ٸ�
	//�ڸ÷����н��еĲ�����Ҫ�ǽ����û����룬���Ը����������Ӧ�Ĵ���
	{
		//��Ϸ�˳������� �ȵ��׻�ɹ�����90���˳�
		int Dignum = 0;
		//ÿ����һ��Dig����++
		//Item:
		for(Dignum = 0;Dignum < 90;Dignum++)
		{
		this.Print_limsurface();
		System.out.println("������Ҫִ�еĲ����������ʽ��Ҫִ�еĲ���+���꣬��Ҫ�ڣ�3��4��λ�õ�������D34��");
		Scanner sc = new Scanner(System.in);
		//��ȡ�û�������Ϣ
		String input = sc.nextLine();
		//������ı��ת��ΪString��
		String operate = input.substring(0,1);
		//��ȡҪִ�еĲ���
		String coordinate = input.substring(1);
		//��ȡ��������
		int x = Integer.parseInt(coordinate.substring(0,1));
		int y = Integer.parseInt(coordinate.substring(1,2));
		//��ȡ x y
		if(operate.equals("D"))
		{
			Print_limsurface();
			boolean status = this.Dig(x,y);
			//�ñ���status����¼�Ƿ��ڵ���
			if(!status)
			{break;}
			else
			{
				if(operate.equals("F"))
				{
					this.Flag(x,y);
				}
				else
				{System.out.println("INPUT ERROR!");}
			}
		}
		}
		System.out.println("ͬѧ ������ˣ�");
		this. Initialize();
		}

	//���׷�����ʼ
	public boolean Dig(int x,int y)
	{
		if(this.mine[x][y]==-1)
		{
			Explode();
			return false;
			//�ڵ�����ִ��explode����������false
			}
		else
		{
				this.mine2[x][y] = (char)(this.mine[x][y]+'0');
			return true;
		}
	}
	//���׷�������

	//explode����
	public void Explode()
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
		this.Initialize();
	}
	//explode��������

	//flag���� ���ڲ���
	public void Flag(int x,int y)
	{
		this.mine2[x][y] = 'F';
	}
	//flag��������
}

//***************************************************************//
class PlayGame
{
	public Mine mine;

//���캯��
	public PlayGame()
	{
		this.mine = new Mine();
	}

	public void Help()
	{
		System.out.println("ͬѧ�������ڰ���ҳ��");
		//System.out.println("��Ϸ�й���10���ף�����Խ��еĲ����� ���� ���졣");
		//System.out.println("����������Ϊ��3,4��λ�ã�������W34.");
		//System.out.println("����������Ϊ��3,4��λ�ò��죬������F34");

	}


	public void Play()
	{
		int option = 0;

		while(true)
		{
			System.out.println("������Ҫ���еĲ�����0=���� 1=��ʼ��Ϸ 2=�˳���Ϸ");
		    Scanner sc = new Scanner(System.in);
		    option = sc.nextInt();
			if(option == 0)
			{this.Help();}
			else if(option == 1)
			{this.mine.Begin();}
			else if(option == 2)
			{
				System.out.println("�����˳���Ϸ��");
				System.exit(0);
			}
			else{System.out.println("Input Error!");}
		}
	}
}