
import java.util.Scanner;
public class Clear_Bomb {

	public static void main(String[] args) {
		final int SIZE = 5;
		//�����׵���Ŀ
		
		char pbomb[][]=new char[SIZE+2][SIZE+2];
		//��չɨ�������Ա��ڼ�¼ÿ��λ����Χ���׵���Ŀ
		
		char bomb[][]=new char[SIZE+1][SIZE+1];
		//����
		
		char BombShow[][]=new char[SIZE+1][SIZE+1];
		//������ͻ�չ�ֵ�ǰɨ��״��
		
		int a[]=new int[SIZE];
		int b[]=new int[SIZE];
		//����������������ֵ�����Բ���
		
		Scanner s=new Scanner(System.in);
		print str=new print();
		
		int i;
		int h=0;
		int p,q;
		int m,n;//ɨ�׹�������ȷ�������λ��
		
		int bombnum[][]=new int[SIZE+1][SIZE+1];
		//���Դ��ÿ��λ����Χ���׵���Ŀ
		
		char tmp='0';
		
		while(h<SIZE)
		{
			a[h]=(int)(Math.random()*SIZE)+1;
			b[h]=(int)(Math.random()*SIZE)+1;
			for(i=0;i<h;i++)
			{
				if(a[h]==a[i]&&b[h]==b[i])
				{
					h--;
					break;
				}
			}
			h++;
			
		}
		//�������ظ�����������
			
		for(p=0;p<SIZE+2;p++)
			for(q=0;q<SIZE+2;q++)
			{
				pbomb[p][q]='#';
			}
		for(i=0;i<SIZE;i++)
		{
			pbomb[a[i]][b[i]]='*';
		}
		//��չ�µ���������
		
		
		
		bomb[0][0]=' ';
		BombShow[0][0]=' ';
		for(p=1;p<=SIZE;p++)
		{
			tmp+=p-1;
			bomb[0][p]=tmp;
			bomb[p][0]=tmp;
			
			BombShow[0][p]=tmp;
			BombShow[p][0]=tmp;
			
			tmp='0';
		}
		
		
		for(p=1;p<=SIZE;p++)
			for(q=1;q<=SIZE;q++)
			{
				bomb[p][q]=pbomb[p][q];
				BombShow[p][q]='#';
			}
		//����SIZE*SIZE������
		
		
		for(p=0;p<=SIZE;p++)
			for(q=0;q<=SIZE;q++)
				bombnum[p][q]=0;
		//����ÿ��λ����Χ���׵�������ʼ��
		
		
		for(p=0;p<=SIZE;p++)
		{
			for(q=0;q<=SIZE;q++)
			{
				System.out.print(BombShow[p][q]);
			}
			System.out.println();
		}
		//չ��ɨ�׽���
		
		
		for(p=1;p<=SIZE;p++)
		{
			for(q=1;q<=SIZE;q++)
			{
				if(pbomb[p][q]=='#')
				{
					if(pbomb[p-1][q]=='*')    bombnum[p][q]++;
				    if(pbomb[p+1][q]=='*')    bombnum[p][q]++;
				    if(pbomb[p][q-1]=='*')    bombnum[p][q]++;
				    if(pbomb[p][q+1]=='*')    bombnum[p][q]++;
				    if(pbomb[p-1][q-1]=='*')  bombnum[p][q]++;
				    if(pbomb[p-1][q+1]=='*')  bombnum[p][q]++;
				    if(pbomb[p+1][q-1]=='*')  bombnum[p][q]++;
				    if(pbomb[p+1][q+1]=='*')  bombnum[p][q]++;
				}
			}
		}
		
		//�õ�ÿ��λ���ϵľ�������
		
		
		for(i=0;i<SIZE*SIZE-SIZE;i++)
		{
			  tmp='0';
		      System.out.print("����������Ҫ���׵�λ�ã�\n");
		      System.out.println("(m�����m�У�n�����n��,�磴����)");
		      m=s.nextInt();
		      n=s.nextInt();
		      if(bomb[m+1][n+1]=='*')
		      {
		    	  str.printtest(bomb);
		    	  //��ӡ����������
		    	  break;
		      }
		      //���ɨ���ף�ֱ������
		      
		      
		      else 
		      {
		    	  tmp+=bombnum[m+1][n+1];
		    	  BombShow[m+1][n+1]=tmp;
		    	  str.printtest(BombShow);
		    	  //��ӡ��ǰɨ�����
		      }
		}
		
		if(i==SIZE*SIZE-SIZE) 
			System.out.println("��ϲ��ͨ��");
		else 
			System.out.println("���ź�����ʧ����");
		
		
	
	}
}
