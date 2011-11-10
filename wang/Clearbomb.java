import java.util.Scanner;
import java.util.Arrays;
class Input
{
	static Scanner input=new Scanner(System.in);



	public static int getInt()
	{
      return input.nextInt();
	}



	public static String getString()
	{
		return input.nextLine();
	}

}



class Game
{
	static final int size=100;
	static int line;
	static int row;
	static int bombnum;
	static int h=0;
	static int t=0;//���������Ƿ��ÿ��λ�ö�����һ��
	static int Tt=0;//���������Ƿ����ȷ����ȫ���ҵ� 
	static int Ft=0;//��������Ǵ��������


	
	static int[] a=new int[size];//�ݴ��׵���λ��
	static int[] b=new int[size];//�ݴ��׵���λ��
	static char[][] bomb=new char[size][size];
	static int show[][]=new int[size][size];
	static char[][] face=new char[size][size];//���û�չʾɨ�׽���



	
	public Game()
	{
		System.out.print("������������");
		row=Input.getInt();
		System.out.print("������������");
		line=Input.getInt();
		System.out.print("������������");
		bombnum=Input.getInt();

		for(int i=0;i<row;i++)//�����ʼ��
		{
			for(int j=0;j<line;j++)
				face[i][j]='+';
		}
	}


	public static void clear()//ʵ���ڴ�����
	{

		Ft=0;
		Tt=0;
		for(int i=0;i<size;i++)
		{
			a[i]=0;
			b[i]=0;
			for(int j=0;j<size;j++)
			{
				bomb[i][j]='+';
				show[i][j]=0;
				//face[i][j]='+';
			}
		}
	}


	
	public static void rand()//���������
	{
		while(h<bombnum)
		{
			a[h]=(int)(Math.random()*row);
			b[h]=(int)(Math.random()*line);
			for(int i=0;i<h;i++)
			{
				if(a[h]==a[i]&&b[h]==b[i])
				{
					h--;
					break;
				}
			}
			h++;
		}
		
	}



	
	public static  void setBomb()//����
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<line;j++)
			{
				bomb[i][j]='+';
			}
		}
		
		for(int i=0;i<bombnum;i++)
		{
			bomb[a[i]][b[i]]='*';
		}

	}


	
	
	public static void showBombNum()//չʾ����λ�ô�������
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<line;j++)
			{
				if(bomb[i][j]!='*')
				{
					if(i==0&&j==0)
					{
						if(bomb[i+1][j]=='*') show[i][j]++;
						if(bomb[i+1][j+1]=='*') show[i][j]++;
						if(bomb[i][j+1]=='*')   show[i][j]++;
					}
					
					if(i==row-1&&j==0)
					{
						if(bomb[i-1][j]=='*') show[i][j]++;
						if(bomb[i-1][j+1]=='*')  show[i][j]++;
						if(bomb[i][j+1]=='*')    show[i][j]++;
					}
					
					if(i==0&&j==line-1)
					{
						if(bomb[i][j-1]=='*')   show[i][j]++;
						if(bomb[i+1][j-1]=='*')  show[i][j]++;
						if(bomb[i+1][j]=='*')    show[i][j]++;
					} 
					if(i==row-1&&j==line-1)
					{
						if(bomb[i][j-1]=='*')    show[i][j]++;
						if(bomb[i-1][j]=='*')    show[i][j]++;
						if(bomb[i-1][j-1]=='*')  show[i][j]++;
						
					}
					if(i==0&&j>0&&j<line-1)
					{
						if(bomb[i][j-1]=='*')   show[i][j]++;
						if(bomb[i][j+1]=='*')   show[i][j]++;
						if(bomb[i+1][j-1]=='*') show[i][j]++;
						if(bomb[i+1][j]=='*')   show[i][j]++;
						if(bomb[i+1][j+1]=='*') show[i][j]++;
					}
					if(i==row-1&&j>0&&j<line-1)
					{
						if(bomb[i][j-1]=='*')   show[i][j]++;
						if(bomb[i][j+1]=='*')   show[i][j]++;
						if(bomb[i-1][j-1]=='*') show[i][j]++;
						if(bomb[i-1][j]=='*')   show[i][j]++;
						if(bomb[i-1][j+1]=='*') show[i][j]++;
					}
					if(i>0&&i<row-1&&j==0)
					{
						if(bomb[i-1][j]=='*')   show[i][j]++;
						if(bomb[i+1][j]=='*')   show[i][j]++;
						if(bomb[i][j+1]=='*') show[i][j]++;
						if(bomb[i-1][j+1]=='*')   show[i][j]++;
						if(bomb[i+1][j+1]=='*') show[i][j]++;
						
					}
					if(i>0&&i<row-1&&j==line-1)
					{
						if(bomb[i-1][j]=='*')   show[i][j]++;
						if(bomb[i+1][j]=='*')   show[i][j]++;
						if(bomb[i][j-1]=='*')    show[i][j]++;
						if(bomb[i-1][j-1]=='*')   show[i][j]++;
						if(bomb[i+1][j-1]=='*')   show[i][j]++;
					}
					if(i>0&&i<row-1&&j>0&&j<line-1)
					{
						if(bomb[i-1][j]=='*')    show[i][j]++;
						if(bomb[i-1][j-1]=='*')  show[i][j]++;
						if(bomb[i+1][j-1]=='*')  show[i][j]++;
						if(bomb[i][j-1]=='*')    show[i][j]++;
						if(bomb[i+1][j]=='*')    show[i][j]++;
						if(bomb[i][j+1]=='*')    show[i][j]++;
						if(bomb[i-1][j+1]=='*')  show[i][j]++;
						if(bomb[i+1][j+1]=='*')  show[i][j]++;
						
					}
					
				}
				else show[i][j]=9;//���׵�λ�ô����Ϊ1
			}
		}
	}





	public static void printMines()//����չʾ
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.print(" ");
		for (int i = 0; i < line; i++) 
		{
			System.out.print(" "+i);
		}
		System.out.println();
		for (int i = 0; i < row; i++) 
		{
			System.out.print(i);
			for (int j = 0; j < line; j++)
			{
				System.out.print(" "+face[i][j]);
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}




	public static boolean XY(int x,int y)
	{
		if(x>=0&&y>=0&&x<row&&y<line)
			return true;
		else return false;
	}
	
	


	public static synchronized boolean Dig(int x, int y)//�ڵĲ���
	{
		if(show[x][y]==9)
		{
			show();
			return true;//�ȵ�����
		}
		else if(show[x][y]==0)
		{
			show(x,y);

			if(XY(x-1,y-1)&&face[x-1][y-1]=='+')
			{
				show(x-1,y-1);
				t++;
			}
			if(XY(x-1,y)&&face[x-1][y]=='+')
			{
				show(x-1,y);
				t++;
			}
			if(XY(x-1,y+1)&&face[x-1][y+1]=='+')
			{
				show(x-1,y+1);
				t++;
			}
			if(XY(x,y-1)&&face[x][y-1]=='+')
			{
				show(x,y-1);
				t++;
			}
			if(XY(x,y+1)&&face[x][y+1]=='+')
			{
				show(x,y+1);
				t++;
			}
			if(XY(x+1,y-1)&&face[x+1][y-1]=='+')
			{
				show(x+1,y-1);
				t++;
			}
			if(XY(x+1,y)&&face[x+1][y]=='+')
			{
				show(x+1,y);
				t++;
			}
			if(XY(x+1,y+1)&&face[x+1][y+1]=='+')
			{
				show(x+1,y+1);
				t++;
			}


		}
		else
		{
			face[x][y]=(char)(show[x][y]+'0');
		}
		printMines();
		return false;//û�вȵ�����
	}






	public static  void Mark(int x, int y)//����ǵĲ���
	{
		face[x][y]='#';
	}




	public static void show()//ÿ����һ�β���(Mark||Dig)�����û�չʾ�䵱ǰ���
	{
		for(int i=0; i<row;i++)
		{
			for(int j=0;j<line; j++)
			{
				if(show[i][j]==9)
				{
					if(face[i][j]!='#')
					{
						face[i][j]='*';
					}
					else 
					{
						face[i][j]='@';
					}
				}
			}
		}
		printMines();
		System.out.println("ʤ���˱��ҳ��£��������������");
		
	}





	public static void show(int x,int y)
	{
		face[x][y]=(char)(show[x][y]+'0');
	}




	public static void BeginGame()//��Ϸ����
	{
		printMines();
		while(true)
		{
			
			Scanner scanner = new Scanner(System.in);
			String LINE = scanner.nextLine();
			String command = LINE.substring(0, 1);
			String args = LINE.substring(1, 3);
			if(command.equals("D"))
			{
				int x = Integer.valueOf(args.substring(0, 1));
				int y = Integer.valueOf(args.substring(1, 2));
				boolean flag = Dig(x, y);// ����

				if(flag) break;
	
				t++;
			}
			else if(command.equals("M"))
			{
				int x = Integer.valueOf(args.substring(0, 1));
				int y = Integer.valueOf(args.substring(1, 2));
				Mark(x, y);//���
				printMines();
				t++;
			}
			else System.out.println("error!");


		   if(t==row*line)
		   {
			   for(int i=0;i<row;i++)
			   {
				   for(int j=0;j<line;j++)
				   {
					    if(bomb[i][j]=='*')
					    {
						    if(face[i][j]!='#')
						    {
						       //System.out.println("ʤ���˱��ҳ��£��������������");
                               face[i][j]='@';//��ʾ��Ǵ���
							   Ft++;
						       //break;
						    }
						    else Tt++;
					    }
				   }
			   }
			   if(Tt==bombnum) System.out.println("��ϲ���أ�");
			   if(Ft>=1) show();

			   break;
		    }
		}

		
	}
}





class Dig_Mark     //�ṩ������Ϸ��һ�����棬������ɨ�׹���
{
	Game game;
	public Dig_Mark()
	{
		this.game=new Game();
	}

	public static void rules()
	{
		System.out.println("��ӭ����ɨ�׳��򣡣�����");
		System.out.println("begin������Ϸ��ʼ��exit�������");
		System.out.print("��ѡ��");
	}
	public void start()
	{
		System.out.println("��ѡ������D��������(Dig)��M�������(Mark) ����M12");
	}
}






public class Clearbomb {
	

	
	public static void main(String[] args) {


        Dig_Mark.rules();
		Scanner read=new Scanner(System.in);
		String order=Input.getString();


		while(order.equals("begin"))
		{
			if(order.equals("exit")) break;

		     Dig_Mark set=new Dig_Mark();
		     set.start();
		     Game.rand();
		     Game.setBomb();
		     Game.showBombNum();
		     Game.BeginGame();
		     //System.out.println(Arrays.toString(Game.a));
		     Game.clear();
		     //System.out.println(Arrays.toString(Game.a));
			 order=read.nextLine();
		}


			 

	}

}