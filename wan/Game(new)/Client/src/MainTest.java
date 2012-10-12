
public class MainTest implements Runnable{
    private final Thread thread1;
    private final Thread thread2;
    private final Thread thread3;

 
    public MainTest() {

        thread1=new Thread(this);
        thread2=new Thread(this);
        thread3=new Thread(this);

        thread1.start();
        thread2.start();
        thread3.start();
    }
    public static void main(String[] args)
    {
        new MainTest();
    }

    @Override
    public void run() {
        {

         {
        if(Thread.currentThread()==thread1)
        {
                 MainClient p1=new MainClient("Íæ¼Ò1","127.1.1.1");
                for(int i=0;i<10000;i++)
             {
                 
             }
        }
      else     if(Thread.currentThread()==thread2)
           {      
                  MainClient p2=new MainClient("Íæ¼Ò2","127.1.1.1");
                 for(int i=0;i<10000;i++)
             {
                 
             }
           }
           
            else  if(Thread.currentThread()==thread3)
            {
                    MainClient p3=new MainClient("Íæ¼Ò3","127.1.1.1"); 
                  for(int i=0;i<10000;i++)
             {
                 
             }
        
            }
       }
        }
    }
}
