package CardAttendant;

import java.awt.FlowLayout;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.*;

public class TimeCount extends JPanel implements  Runnable{
	
	private JButton start;
	private JTextField in;
	private JLabel ibNow, ibNowTitle, ibLeftSecTitle, ibLeftSec, ibLeftMinTitle, ibLeftMin, ibMin;
	private Thread time, clocker;
	long startTime, endTime;
	long nowTime, leftTime, leftSec, leftMin;
	boolean flag = false;
	
	public TimeCount(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		this.setSize(200, 170);
		this.setVisible(true);
		initUI();
		clocker = new Thread(this, "clock");
		clocker.start();
		time = new Thread(this, "ti");
                this.action1();
		time.start();
	}
	private void initUI(){
		ibNowTitle = new JLabel("当前时间为:");
		ibNow = new JLabel();
               
		ibLeftSecTitle = new JLabel("离结束还有:");
		ibLeftSec = new JLabel("未设置");
		ibLeftMinTitle = new JLabel("离结束还有:");
		ibLeftMin = new JLabel("未设置");
		//ibMin = new JLabel("倒计时(单位：秒)");
		//in = new JTextField(5);
		this.add(ibNowTitle);
		this.add(ibNow);
		this.add(ibLeftSecTitle);
		this.add(ibLeftSec);
		//this.add(ibLeftMinTitle);
		//this.add(ibLeftMin);
		//this.add(ibMin);
		//this.add(in);
		
	}

	
	public final void action1() {
		
			Calendar startCalendar = Calendar.getInstance();
			startTime = startCalendar.getTime().getTime();
			endTime = startTime + 30*1000;
			flag = true;
		
	}

	@Override
	public void run() {
		//SimpleDateFormat dataFormat = new SimpleDateFormat("hh:mm:ss");
                DateFormat dataFormat= DateFormat.getTimeInstance();
		Calendar now;
		while(((Thread.currentThread()).getName()).equals("clock")){
			now = Calendar.getInstance();
			nowTime = now.getTime().getTime();
			ibNow.setText(dataFormat.format(now.getTime()));
		}
		while(((Thread.currentThread()).getName()).equals("ti"))
			while(flag){
				leftTime = endTime - nowTime;
				leftSec = leftTime/1000;
				leftMin = leftTime/(60*1000);
				ibLeftSec.setText(leftSec+"秒");
				//ibLeftMin.setText(leftMin+"分");
				if(leftSec == 0){
					flag = false;
					JOptionPane.showMessageDialog(this, "超时!\n启动托管", "托管" , JOptionPane.OK_OPTION);
					//new RotateImageDemo();
                                       
                                        break;
				}
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
	}
	public static void main(String[] args){
		new TimeCount();
               
   TimeCount i=new TimeCount();;

    JFrame f=new JFrame();
    f.add(i);
     f.setSize(600, 600);
      f.setVisible(true);
    f. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	}


