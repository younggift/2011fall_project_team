import java.util.Scanner;  

public class ClearMine { 
	
    private static final int ROW = 10;  //��ֻ֤������ʱ��һ��ֵ
    private static final int COLUMN = 10;  
    private int[][] mines;// -1:���ף�0:��Χû���ף� 1����Χ��1������
    private char[][] face;//'_':δ֪, '*':Ϊ����,'1':��Χ��1������  
                          //'#'�����Ϊ����  
    private int number;   //��¼�û���ȷ����׵ĸ���
    
    
    public ClearMine() {  
        this.mines = new int[ROW][COLUMN];  //��¼ÿһ������Χ�׵�����
        this.face = new char[ROW][COLUMN];  //��¼�����ʾ
        this.number = 0;
        Init();  //��ʼ������
          
    }  
    
    public void Init() {  
        /* 
         * �ŵ��� 
         */  
        int num = 0;  
        while (num < 10) {  
            int x = (int) (Math.random() * 10);  //�漴���ɵ��׵����꣨ǿ���java�ṩ��class��
            int y = (int) (Math.random() * 10);  
            if (this.mines[x][y] == -1) {  
                continue;  
            }  
            this.mines[x][y] = -1;  
            num++;  
        }  
        /*
         * �����ܱߵĵ��׵���Ŀ 
         */  
        for (int i = 0; i < ROW; i++) {  
            for (int j = 0; j < COLUMN; j++) {  
                if (this.mines[i][j] != -1) {  
                    int mineNum = 0;   
                    if (Judge(i - 1, j - 1)) {  
                        if (this.mines[i - 1][j - 1] == -1) {  
                            mineNum++;  
                        }  
                    }    
                    if (Judge(i - 1, j)) {  
                        if (this.mines[i - 1][j] == -1) {  
                            mineNum++;  
                        }  
                    }   
                    if (Judge(i - 1, j + 1)) {  
                        if (this.mines[i - 1][j + 1] == -1) {  
                            mineNum++;  
                        }  
                    }   
                    if (Judge(i, j - 1)) {  
                        if (this.mines[i][j - 1] == -1) {  
                            mineNum++;  
                        }  
                    }  
                    if (Judge(i, j + 1)) {  
                        if (this.mines[i][j + 1] == -1) {  
                            mineNum++;  
                        }  
                    }  
                    if (Judge(i + 1, j - 1)) {  
                        if (this.mines[i + 1][j - 1] == -1) {  
                            mineNum++;  
                        }  
                    }  
                    if (Judge(i + 1, j)) {  
                        if (this.mines[i + 1][j] == -1) {  
                            mineNum++;  
                        }  
                    }  
                    if (Judge(i + 1, j + 1)) {  
                        if (this.mines[i + 1][j + 1] == -1) {  
                            mineNum++;  
                        }  
                    }  
                    this.mines[i][j] = mineNum;  
                }  
            }  
        } 
        
        // ��ʼ���������
        for (int i = 0; i < ROW; i++) {  
            for (int j = 0; j < COLUMN; j++) {  
                this.face[i][j]='_';  
            }  
        }  
    }  
    
    //���������Ƿ�Խ��
    private boolean Judge(int x, int y) {  
        if (x < 0 || x >= ROW || y < 0 || y >= COLUMN) {  
            return false;  
        }  
        return true;  
    }  
    

    public void PrintMines(){  
        System.out.println("**********************");  
        System.out.print(" ");  
        for (int i = 0; i < COLUMN; i++) {  
            System.out.print(" "+i);  
        }  
        System.out.println();  
        for (int i = 0; i < ROW; i++) {  
            System.out.print(i);  
            for (int j = 0; j < COLUMN; j++) {  
                System.out.print(" "+this.face[i][j]);  
            }  
            System.out.println();  
        }  
        System.out.println("**********************");  
    }  
      
      
    public boolean Dig(int x, int y){  
        if(this.mines[x][y]==-1){  
            Blust();  
            return true;//�ȵ�����  
        }else  
        if(this.mines[x][y]==0){  
            OpenOut(x,y);  
        }else{  
            OpenOut(x,y); 
        }  
        PrintMines();  
        return false;//û�вȵ�����  
    }  
    
    public void Mark(int x, int y){
        this.face[x][y]='#'; 
        if(this.mines[x][y]==-1) this.number++;
    }  
    private void Blust(){  
        for(int i=0; i<ROW;i++){  
            for(int j=0;j<COLUMN; j++){  
                if(this.mines[i][j]==-1){  
                    if(this.face[i][j]!='#'){  
                        this.face[i][j]='*';  
                    } 
                }  
            }  
        }  
        this.PrintMines();  
        System.out.println("Game Over!!");  
          
    }  
    private void OpenOut(int x,int y){  
        this.face[x][y]=(char)(this.mines[x][y]+'0');  
    }  
    
    public void BeginClearMine(){  
        while(true){  
            this.PrintMines();  
            System.out.print("����� D�������ף�M������� ����D12,M34:");  
            Scanner san = new Scanner(System.in);  //��������
            String line = san.nextLine(); //����"\n"  
            String command = line.substring(0, 1);  //��ȡ�ַ�
            String args = line.substring(1, 3);  
            if(command.equals("D")){  
                int x = Integer.valueOf(args.substring(0, 1));  
                int y = Integer.valueOf(args.substring(1, 2));  
                boolean flag = this.Dig(x, y);  
                if(flag){      //���û��ڵ�������Ϸ����
                    break;  
                }  
            }else if(command.equals("M")){  
                int x = Integer.valueOf(args.substring(0, 1));  
                int y = Integer.valueOf(args.substring(1, 2));  
                this.Mark(x, y);
                if(this.number==10){   //���û�����׵ĸ�������Ϸ������
                	System.out.println("Congratulation!");
                	break;
                }
            }else {  
            	this.PrintMines();
                System.out.println("Error!");  
            }  
        }  
        this.Init();  
    } 
    
    

}  