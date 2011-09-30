class Coop1 extends Thread {
  public Coop1() {
    System.out.println("Constructed Coop1");
    start();
  }
  public void run() {
    System.out.println("Coop1 going into wait");
    synchronized(this) {
      try {
        wait();
      } catch(InterruptedException e) {
        System.out.println(
          "InterruptedException = " + e);
      }
    }
    System.out.println("Coop1 exited wait");
  }
}

class Coop2 extends Thread {
  Coop1 otherThread;
  public Coop2(Coop1 otherThread) {
    this.otherThread = otherThread;
    System.out.println("Constructed Coop2");
    start();
  }
  public void run() {
    System.out.println("Coop2 pausing 5 secs");
    try {
      sleep(5000);
    } catch(InterruptedException e) {
      System.out.println(
        "InterruptedException = " + e);
    }
    System.out.println("Coop2 calling notifyAll");
    synchronized(otherThread) {
      otherThread.notifyAll();
    }
  }
}

public class ThreadCooperation {
  public static void main(String args[]) {
    new Coop2(new Coop1());
  }
}