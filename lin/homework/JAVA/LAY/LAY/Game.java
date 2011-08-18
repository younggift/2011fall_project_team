public class Game {  
    private ClearMine clearMine;  
    
    public Game(){  
        this.clearMine = new ClearMine();  
    }  
    public void start() {  
          
        int choice = 0;  
        while (true) {  
            Instructions();  
            System.out.print("Please Choice£º");  
            choice = InputUtil.getInt();  
            if (choice == 0) {  
                System.out.println("Quit!");  
                System.exit(0);  
            } else if (choice == 1) { 
                this.clearMine.BeginClearMine();  
            } else if (choice == 2) {  
                Help();  
            } else {  
                System.out.println("Error!");
            }  
        }  
    }  
    public void Instructions() {  
        System.out.println("Welcome :0 - Quit , 1 - Start , 2 - Help");  
    }  
    public void Help() {  
        System.out.println("Help Information!");  
    }  
}  