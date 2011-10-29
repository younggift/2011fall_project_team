import java.util.Scanner;
class Operate{          //�ó�����е��ǲ��ף�Ҳ���ǳ�ʼ�������������׵���صĲ�����
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
		for(int i=0;i<row;i++)
            for(int j=0;j<column;j++){
                    this.lei[i][j]=0;                 
            }
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
	// ������δ�����ÿһ�β���֮��Ҫ��ӡһ�²�������½��棻
	public void printJieMian(){
		System.out.println("------------");   //���ۿ��ǣ�����һ�����
		System.out.print(" ");
		for(int j=0;j<column;j++) System.out.print(" "+j); //��ӡ�������꣬�����û�������
		System.out.println();
		for(int i=0;i<row;i++){
			System.out.print(i);  //��ӡ�������꣬�����û�������
			for(int j=0;j<column;j++)
				System.out.print(" "+this.jiemian[i][j]);  //��ӡ��ÿһ�����ײ�����Ľ��棻
			System.out.print("\n");
		}
		System.out.println("------------");  //�߿򲿷֣�
	}
	//���´��벿�������ײ�����ʼ����ĳ���
	public void beginOperate(){
		int k;
		/*��һ��forѭ����Ϊ��ͳ�Ƹ���Ϸ���ʳɹ���©�����û���Ҫ��ɨ�׹��������Ϊÿһ�����׵�λ�ò���С�죬Ҳ����˵
		ֻ���û��ܹ��ɹ�������25���Ժ�������׳ɹ��ˣ�*/
		for(k=0;k<25;k++){
			this.printJieMian(); //ÿ�δ����ײ���֮ǰ�Ƚ��д�ӡ����Ĺ�������ӡ����һ�β�����Ľ��棻
			System.out.print("�����룺W�������ף�P������죬���磺W34��ʾ�ڸ�����Ϊ34��λ��");  //���û���ʾ��Ϣ��
			//���´�����Ϊ�˶�ȡ���û�����Ĺ��������������ַ�����
			Scanner string = new Scanner(System.in);  
			String line = string.nextLine();
			String instruction = line.substring(0, 1); //����һ������Ϊ�˶�ȡ�û�������ַ��������ַ�����Ҳ����W������P��
			String zuobiao = line.substring(1,3);   //����һ������Ϊ�˶�ȡ�û�������ַ��������ַ�����Ҳ����x��y�����ꣻ ����substring���÷��Ͳ���ϸ��˵�ˣ�һ��Ҫע�������е�����������
			//������һ���жϣ��������׻��ǲ��죬����ע��
			if(instruction.equals("W")){
				int x = Integer.parseInt(zuobiao.substring(0,1));  //��������ף���ȡ���괮�е�x���ꣻ
				int y = Integer.parseInt(zuobiao.substring(1,2));  //��ȡ���괮�е�y���ꣻ
				//������Ҫ��һ���жϣ����Ƿ�ȵ����ˣ�
				boolean flag = this.walei(x,y);
				if(flag){
					break;  //����ȵ����ף�ѭ��������
				}
				//����ǲ��죬�����������
			}else if(instruction.equals("P")){
					int x = Integer.parseInt(zuobiao.substring(0,1));  //ͬ����ȡx���ꣻ
					int y = Integer.parseInt(zuobiao.substring(1,2));  //��ȡy���ꣻ
					this.chaqi(x,y);  //x��y��Ϊ�����������ķ����У�
			}else{
				System.out.println("Error!����������:");  //���������Ҫ�����룬��ʾ��������
			}
		}
		if(k==25){
			System.out.println("��ϲ���سɹ�");  //���ѭ����25�Σ�˵�����׳ɹ���
		}
		this.init();  //����ÿһ����Ϸ������ʱ�򣬲����ǳɹ��˻���ʧ���ˣ���Ҫ������һ����Ϸ֮ǰ�Ĳ����Լ�ͳ�ƹ�����
	}
	//���³��������׳����ж��Ƿ�ȵ����ף�����ȵ����׸���ô�죻
	public boolean walei(int x,int y){
		if(this.lei[x][y]==-1){			
			explode();    //����ȵ����ף�ִ�б�ը������
			return true;   //ͬʱ����ֵΪ�棻
		}
		else{
			this.jiemian[x][y]=(char)(this.lei[x][y]+'0');  //��������ף�����λ�õ�����ͨ���ַ�����ʽ���������е���Ӧλ�ã�
		}
		return false; //ͬʱ����ֵΪ�٣�
	}
	//�����Ǳ�ը�����ĳ���
	public void explode(){    //����ȵ����ף���ʼ��ͷ������
		for(int i=0;i<row;i++)
			for(int j=0;j<column;j++){
				if(this.lei[i][j]==-1){   //������ף�
					if(this.jiemian[i][j]!='P'){   //��û�б����죻
						this.jiemian[i][j]='*';    //  �򽫴����׵��ַ��������λ�ã�
					}
				}
			}
		this.printJieMian();   //ͬʱ��ӡ��������棻
		System.out.println("���ź�����Ϸʧ�ܣ�");   //������ظ����û���Ϸʧ���ˣ�
	}
	//�����ǲ��췽���ĳ���
	public void chaqi(int x,int y){
		this.jiemian[x][y]='P';     //ͨ����������x��y�������Ӧ��λ�ø�Ϊ����P��
	}
}
//���¶���һ��PlayGame�ࣻ
class PlayGame{ 
	public Operate operate;
	public PlayGame(){
		this.operate = new Operate();
	}
	//�����ǽ���������Ϸʱ��һ����ʼ���Ľ��棻
	public void begin(){
		System.out.println("��ӭ��������ɨ����Ϸ������0�˳�������1��ʼ��Ϸ������2Ѱ�����");
	}
	public void help(){
		System.out.println("�ܸ��˸����ṩ����");
	}
	public void start(){
		int option=0;
		while(true){   //һֱѭ����ֱ���û�����0��ʾ�˳�ʱ���������
			begin();
			System.out.print("������0��1��2��");
			Scanner input = new Scanner(System.in);
			option = input.nextInt();
			if(option==0){
				System.out.println("���Ѿ��˳���Ϸ");
				System.exit(0);
			}else if(option==1){
				this.operate.beginOperate();
			}else if(option==2){
				help();
			}else{
				System.out.println("Error!����������");
			}
		}
	}
}
//��������ࣻ
public class SaoLei{
	public static void main(String[] args) {
		new PlayGame().start();    //��ʼ������Ϸ��
	}
}