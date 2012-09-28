/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recard;

import org.omg.CORBA.Current;

/**
 *
 * @author Administrator
 */
public class Main implements Runnable{
    private final Thread server;
    private final Thread thread1;
    private final Thread thread2;
    private final Thread thread3;
  ThreadGroup group=new ThreadGroup("thread");
 
    public Main() {
        server=new Thread(this);
        thread1=new Thread(this);
        thread2=new Thread(this);
        thread3=new Thread(this);
        server.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
    public static void main(String[] args)
    {
        new Main();
    }

    @Override
    public void run() {
        {
            
         if(Thread.currentThread()==server)
         {
             new IMServer();
         }
        if(Thread.currentThread()==thread1)
        {
                 ReCard p1=new ReCard("1");
        }
           else     if(Thread.currentThread()==thread2)
           {      
                  ReCard p2=new ReCard("2");
           }
           
            else  if(Thread.currentThread()==thread3)
            {
                    ReCard p3=new ReCard("3"); 
        
            }
       }
    }
}
