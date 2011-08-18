import java.util.Scanner;  

public class ClearMine { 
	
    private static final int ROW = 10;  //保证只在运行时赋一次值
    private static final int COLUMN = 10;  
    private int[][] mines;// -1:地雷，0:周围没有雷， 1：周围有1个地雷
    private char[][] face;//'_':未知, '*':为地雷,'1':周围有1个地雷  
                          //'#'：标记为地雷  
    private int number;   //记录用户正确标出雷的个数
    
    
    public ClearMine() {  
        this.mines = new int[ROW][COLUMN];  //记录每一个点周围雷的数量
        this.face = new char[ROW][COLUMN];  //记录输出显示
        this.number = 0;
        Init();  //初始化处理
          
    }  
    
    public void Init() {  
        /* 
         * 放地雷 
         */  
        int num = 0;  
        while (num < 10) {  
            int x = (int) (Math.random() * 10);  //随即生成地雷的坐标（强大的java提供的class）
            int y = (int) (Math.random() * 10);  
            if (this.mines[x][y] == -1) {  
                continue;  
            }  
            this.mines[x][y] = -1;  
            num++;  
        }  
        /*
         * 计算周边的地雷的数目 
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
        
        // 初始化输出数组
        for (int i = 0; i < ROW; i++) {  
            for (int j = 0; j < COLUMN; j++) {  
                this.face[i][j]='_';  
            }  
        }  
    }  
    
    //计算数组是否越界
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
            return true;//踩到地雷  
        }else  
        if(this.mines[x][y]==0){  
            OpenOut(x,y);  
        }else{  
            OpenOut(x,y); 
        }  
        PrintMines();  
        return false;//没有踩到地雷  
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
            System.out.print("请操作 D代表排雷，M代表标雷 例如D12,M34:");  
            Scanner san = new Scanner(System.in);  //接收输入
            String line = san.nextLine(); //接收"\n"  
            String command = line.substring(0, 1);  //截取字符
            String args = line.substring(1, 3);  
            if(command.equals("D")){  
                int x = Integer.valueOf(args.substring(0, 1));  
                int y = Integer.valueOf(args.substring(1, 2));  
                boolean flag = this.Dig(x, y);  
                if(flag){      //若用户挖到雷则游戏结束
                    break;  
                }  
            }else if(command.equals("M")){  
                int x = Integer.valueOf(args.substring(0, 1));  
                int y = Integer.valueOf(args.substring(1, 2));  
                this.Mark(x, y);
                if(this.number==10){   //若用户标对雷的个数则游戏结束。
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