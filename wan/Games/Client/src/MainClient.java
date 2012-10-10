import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import javax.swing.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Administrator
 */
public class MainClient extends JFrame implements ActionListener,Runnable,MouseListener
{
    Socket socket; 
    JTextField textTalk;
    JComboBox listOnline; //�����û��б�
    boolean  ischupai=false;//����Ƿ����
    JLabel right=new JLabel("��ǰ����Ϊ"+17);//���ʣ������
    JLabel left=new JLabel("��ǰ����Ϊ"+17);//���ʣ������
    JLabel current=new JLabel("��ǰ����Ϊ"+17);//���ʣ������
    JLabel right1=new JLabel();//���ʣ������
    JLabel left1=new JLabel();//���ʣ������
    JLabel current1=new JLabel();//���ʣ������
    JLabel[] labplayer={new JLabel(""),new JLabel(""),new JLabel("")};
    JButton start =new JButton("��ʼ");
    JButton yes =new JButton("�е���");
    JButton no =new JButton("����");
    Compare compare=new Compare();
    VectorCard music=new VectorCard();
    JLabel[] labdipai=new JLabel[3];
    private JTextArea jta = new JTextArea(); 
    private JTextArea jta1 = new JTextArea(); 
    private OutputStream toServer;
    private PrintWriter out;
    private BufferedReader in;
    private String Id;
    private String Username;
    private String[] Users=new String[3];
    
    Thread th=new Thread(this,"listen");
 
    Vector PlayCard=new Vector();//��¼Ҫ������
    Vector PlayCard1=new Vector();//��¼�ϸ���ҳ���
    Vector PlayCard2=new Vector();//��¼��һ����ҳ���
    public static Vector RecordCard=new Vector();//��¼��ҳ���
    Vector LeftCard=new Vector();//��¼ʣ�µ���
    TestLabel[] labelPic=new TestLabel[20];
    JLabel[] lab=new JLabel[20];
    JLabel[] labr1=new JLabel[20];
    JLabel[] labr2=new JLabel[20];
    JLabel[] labl1=new JLabel[20];
    JLabel[] labl2=new JLabel[20];

	private JButton   ibLeftSec;
	private JButton   isbuchuR;
	private JButton   isbuchuL;
	private Thread time, clocker;
	public static long startTime, endTime;
	long nowTime, leftTime, leftSec, leftMin;
	boolean flag = false;
	public static boolean isTimeout=false;
    String msg;
    String Command;
    private String last;
    private String dizhu;
    public int[] Arr;

    public int loc=760; //��ǰ��ҳ��Ƶ����λ��
    public int locr=580; //��ǰ��ҳ��Ƶ����λ��
    public int locl1=580; //��ǰ��ҳ��Ƶ����λ��
    public int locl2=500; //��ǰ��ҳ��Ƶ����λ��
    private JButton buttonTalk;
   
    String IP;//������IP��ַ
    public MainClient(String name,String IP) {
      //super(name);
      this.setTitle("���"+name);
      this.Username=name;
      this.IP=IP;
      this.setLayout(null);
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setResizable(false);
      Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
      int width = (int)screensize.getWidth()-80;
      int height = (int)screensize.getHeight()-50;
      this.setLocation(50, 0);
      init();
      getContentPane().setBackground(Color.GREEN);
      this.Bupai();
      this.setSize(width,height);
      int width1 = this.getWidth();
      int height1 = this.getHeight();
      clocker = new Thread(this, "clock");
	  clocker.start();
	time = new Thread(this, "ti");
	time.start();  
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void init()
    {
     
        
     for(int i=0;i<3;i++)
     {
         labplayer[i].setSize(80, 40);
            
         this.add(labplayer[i]);
     }
        
        
        
     buttonTalk = new JButton("����");
     buttonTalk.setSize(60, 30);
     buttonTalk.setLocation(1080, 570);
     buttonTalk.setFocusable(false);
     buttonTalk.addActionListener(this);
     this.add(buttonTalk);
     
     isbuchuR= new JButton("����") ;
     isbuchuR.setFocusable(false);
     isbuchuR.setEnabled(false);
     isbuchuR.setBackground(Color.red);
     isbuchuR.setBounds(120,300, 62, 40);
     isbuchuL= new JButton("����") ;
     isbuchuL.setFocusable(false);
     isbuchuL.setEnabled(false);
     isbuchuL.setBackground(Color.red);
     ibLeftSec = new JButton("");
     isbuchuL.setBounds(900,300, 62, 40);    
     ibLeftSec.setFocusable(false);
     ibLeftSec.setEnabled(false);
     ibLeftSec.setBackground(Color.red);
     this.add(ibLeftSec);
     isbuchuR.setVisible(false);       
     isbuchuL.setVisible(false);       
       this.add(isbuchuR);
       this.add(isbuchuL);
     
     
     listOnline=new JComboBox();
     listOnline.addItem("All");
     listOnline.setLocation(1160, 600);
     listOnline.setSize(58, 30);
     this.add(listOnline);
     
     JLabel labtalk=new JLabel("��������¼");
     labtalk.setBounds(1150, 540,80, 40);
     this.add(labtalk);
     JLabel labre=new JLabel("��Ϣ������");
     labre.setBounds(1080, 600,80, 40);
     this.add(labre);
     textTalk = new JTextField(20);
     textTalk.setSize(120, 30);
     textTalk.setLocation(1150,570);
     textTalk.addActionListener(this);
     this.add(textTalk);
     this.add(listOnline);
      JLabel lab1=new JLabel("��ҷ�����Ϣ");
      JLabel lab2=new JLabel("<html>ϵ<br>ͳ<br>��<br>Ϣ<br>��<br>");
      lab1.setBounds(1150, 20,80, 40);
      lab2.setBounds(5, 0,40,100);
      right.setBounds(890, 270, 120, 40);
      left.setBounds(130, 270, 120, 40);
      current.setBounds(560, 500, 120, 40);
       right1.setBounds(860, 270, 120, 40);
      left1.setBounds(100, 270, 120, 40);
      current1.setBounds(530, 500, 120, 40);
      this.add(lab1);
      this.add(lab2);
      this.add(right);
      this.add(left);
      this.add(current);
      this.add(right1);
      this.add(left1);
      this.add(current1);
       jta.setLocation(25, 5);
       jta.setSize(240, 100);
       jta.setVisible(true);
       jta1.setLocation(900, 5);
       jta1.setSize(140, 600);
       jta1.setVisible(true);
        start.setSize(60, 40);
      start.setLocation(540, 470);
      start.setFocusable(false);
      start.setVisible(true); 
      start.setActionCommand("start");
      start.addActionListener(this);
      yes.setSize(73, 40);
      yes.setLocation(450, 470);
      yes.setFocusable(false);
      yes.setVisible(false); 
      yes.setActionCommand("yes");
      yes.addActionListener(this);
     no.setSize(73, 40);
     no.setLocation(650, 470);
     no.setFocusable(false);
     no.setVisible(false); 
     no.setActionCommand("no");
     no.addActionListener(this);
    //jta.setLineWrap(true);    //�����Զ�����,�Զ������򲻻���ֺ���Ĺ�����
    jta.setEditable(true);    //���ÿɱ༭
    JScrollPane jsp = new JScrollPane(jta);    //��ӹ�����
    jsp.setBounds(25,0,240,100);    //���� JScrollPane ��100,��200
    jta1.setEditable(true);    //���ÿɱ༭
    JScrollPane jsp1 = new JScrollPane(jta1);    //��ӹ�����
    jsp1.setBounds(1110,50,150,500);    //���� JScrollPane ��100,��200
     this.add(jsp);    //�������������
     this.add(jsp1);    //�������������
     this.add(start);
     this.add(yes);
     this.add(no);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String cmd=e.getActionCommand();
            if (e.getSource() instanceof JTextField) 
            { 
                String s =textTalk.getText(); 
              if(s.length()>0) 
                {
                     java.text.DateFormat format1 = new java.text.SimpleDateFormat("HH:mm:ss");
                      String strTime = format1.format(new Date());
                      strTime="("+strTime+")";  
                       jta1.append("���"+Id+": "+s+strTime);   
                        out.println("talk|"+s+"|"+Id+"|"+listOnline.getSelectedItem().toString());
                        s = ""; 
                } 
                textTalk.setText(""); 
            } 

            if(e.getSource()==buttonTalk) 
            {
                  String s =textTalk.getText(); 
              if(s.length()>0) 
                { 
                    java.text.DateFormat format1 = new java.text.SimpleDateFormat("HH:mm:ss");
                     String strTime = format1.format(new Date());
                     strTime="("+strTime+")";  
                        jta1.append("���"+Id+": "+s+strTime+"\n");   
                        out.println("talk|"+s+"|"+Id+"|"+listOnline.getSelectedItem().toString());
                         s=""; 
                } 
             textTalk.setText(""); 
             }
            
            if(cmd.equals("start")) 
            {
              th.start();
              start.setVisible(false);
              start.setText("���¿���");
              start.setSize(100, 40);
              start.setActionCommand("restart");
            }
          else if(cmd.equals("yes"))
          {
            
              
            out.println("21|"+Id+"|yes");
            yes.setText("����");
            no.setText("����");
            no.setActionCommand("buchu");
            yes.setActionCommand("chu");
            yes.setVisible(false);
            no.setVisible(false);
     
           }
          else if(cmd.equals("no"))
         {
            out.println("21|"+Id+"|no");
            yes.setText("����");
            no.setText("����");
            no.setActionCommand("buchu");
            yes.setActionCommand("chu");
            yes.setVisible(false);
            no.setVisible(false);
         }
          else if(cmd.equals("chu"))  //��������
         {
                this.Chupai();
         }
         else if(cmd.equals("buchu"))
         {
         if(PlayCard2.isEmpty()&&PlayCard1.isEmpty())
         { 
         JOptionPane.showMessageDialog(null,"�������","����",JOptionPane.WARNING_MESSAGE);
         }
         
        else 
         {
            PlayCard.removeAllElements();
            for(int i=0;i<LeftCard.size();i++) {
                 Integer p=(Integer)(LeftCard.get(i));
                 int k2=p.intValue();
              labelPic[k2].setBounds(loc-(i+1)*25, 540, 80, 100);
              labelPic[k2].sign=false;
        }
          String send="22|"+Id+"|"+LeftCard.size();
          out.println(send);  
          yes.setVisible(false);
          no.setVisible(false); 
          isbuchuL.setVisible(false);
          isbuchuL.setVisible(false);
          ischupai=false;
          new Music().play("buyao"+(int)(Math.random()*4+1));
       }
         }
         else if(cmd.equals("restart"))
         {
             out.println("20|"+Id+"|start");
             start.setVisible(false);
              for(int i=0;i<20;i++) 
           {
              lab[i].setIcon(null);
         if(i<3) labdipai[i].setIcon(null);
              labl1[i].setIcon(null);
              labl2[i].setIcon(null);
              labr1[i].setIcon(null);
              labr2[i].setIcon(null);
              labelPic[i].setIcon(null);        
       labr1[i].setBounds(1000,locr-i*25, 80, 100);
       labl1[i].setBounds(20,locl1-i*25, 80, 100);
       labelPic[i].setBounds(loc-(i+1)*25, 540, 80, 100);
       if(i<17)     
       {
         labr1[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));

         labl1[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
       }
           }
            LeftCard.removeAllElements();
            PlayCard.removeAllElements();
            PlayCard1.removeAllElements();
             yes.setActionCommand("yes");
            yes.setText("�е���");
            no.setActionCommand("no");
            no.setText("����");
            current.setText("��ǰ����Ϊ17");
            left.setText("��ǰ����Ϊ17");
            right.setText("��ǰ����Ϊ17");
            isbuchuL.setVisible(false);
            isbuchuR.setVisible(false);
            current1.setText("");
            left1.setText("");
            right1.setText("");
            ischupai=false;
         }
    }
        public void connection(String name)
                    {
                            try 
            { 
               // socket = new Socket("222.27.243.169",8189); 
                socket = new Socket(IP,8189); 
                toServer = socket.getOutputStream(); 
                 in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
                out = new PrintWriter(toServer, true); 
                out.println(name);
                while(true) 
            { 
            String s = in.readLine();
            //StringTokenizer st = new StringTokenizer(s,"|");
            int i=0;
            if(s!=null) 
            { 
            if(s.substring(0,1).endsWith(" "))
                jta.append(s+"\n");
            else DealMsg(s);
            } 
            s = null; 
            } 
            } 
            catch(IOException e) 
            { 
                jta.append("Server doesn't start"+"\n");      
            } 
            } 


    @Override
    public void run() {
    if(Thread.currentThread()==th)
    {
        this.connection(Username);
    }
   		Calendar now;
		while(((Thread.currentThread()).getName()).equals("clock")){
			now = Calendar.getInstance();
			nowTime = now.getTime().getTime();
			//ibNow.setText(dataFormat.format(now.getTime()));
		}
		while(((Thread.currentThread()).getName()).equals("ti"))
			while(flag){
				leftTime = endTime - nowTime;
				leftSec = leftTime/1000;
				leftMin = leftTime/(60*1000);
				ibLeftSec.setText(leftSec+"��");
				//ibLeftMin.setText(leftMin+"��");
				if(leftSec == 0){
					flag = false;
					JOptionPane.showMessageDialog(this, "��ʱ!\nʱ�䵽", "��ʱ" , JOptionPane.OK_OPTION);
					//new RotateImageDemo();
                                       isTimeout=true;
                                        break;
				}
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			} 
    }
    public void Bupai()
    {
 for(int i=0;i<20;i++) 
  {
      labelPic[i]=new TestLabel();
      lab[i]=new JLabel();
      labl1[i]=new JLabel();
      labl2[i]=new JLabel();
      labr1[i]=new JLabel();
      labr2[i]=new JLabel();
     labelPic[i].setBounds(loc-(i+1)*25, 540, 80, 100);
       lab[i].setBounds(loc-i*25,420, 80, 100);
       labr1[i].setBounds(1000,locr-i*25, 80, 100);
       labr2[i].setBounds(930-i*25,300, 80, 100);//�������
       labl1[i].setBounds(20,locl1-i*25, 80, 100);
       labl2[i].setBounds(locl2-i*25,300, 80, 100);//�ұ�����
 
 if(i<17){
    labr1[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));  
   labl1[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
 }
   labelPic[i].setFocusable(false);
     labelPic[i].sign=false;
     labelPic[i].addMouseListener(this);
      this.add(lab[i]);
      this.add(labr1[i]);
      this.add(labr2[i]);
      this.add(labl1[i]);
      this.add(labl2[i]);
      this.add(labelPic[i]);
    } 
  for(int i=0;i<3;i++)
      {
        labdipai[i]=new JLabel();
         labdipai[i].setBounds(600-i*40, 5, 80, 100);
         this.add(labdipai[i]);
      }  
 }

    @Override
    public void mouseClicked(MouseEvent e) {
     if(!e.isMetaDown()) 
     {//���û���һ�,�Ѿ����
       if(!PlayCard.isEmpty())  PlayCard.removeAllElements();
        for(int i=0;i<LeftCard.size();i++) {
                 Integer p=(Integer)(LeftCard.get(i));
                 int k=p.intValue();
          if(e.getSource()==labelPic[k]) {
           if(!labelPic[k].sign) {
              labelPic[k].setBounds(loc-(i+1)*25, 520, 80, 100);
              labelPic[k].sign=true;
             }
           else if(labelPic[k].sign) {
              labelPic[k].setBounds(loc-(i+1)*25, 540, 80, 100);
              labelPic[k].sign=false;
             }
          }
      }
     }
     if(e.isMetaDown()){    //�Ҽ�����
              this.Chupai();
        
     } 
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
  ;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }
        public void  AnMsg(String msg)  //������Ϣ
    {
     StringTokenizer st = new StringTokenizer(msg,"|");
     int i=0;
     Arr=new int[20];
       while (st.hasMoreTokens())
       {
           if(i==0) Command=st.nextToken();
           else if(i==1) last=st.nextToken();
       else   
               {
                   Arr[i-2]=Integer.parseInt(st.nextToken());
               }
           i++;
       }

    }
   public String ChangeVector(Vector v) {  //��������װ���ַ���
          String RealMsg="";
            for(int i=0;i<v.size();i++)
            {
                RealMsg+="|"+v.get(i);
            }
            return RealMsg;
        } 

        public void loadImg()
        {
             LeftCard.removeAllElements();
			System.out.println("���յ����ƣ�");
            for(int i=0;i<20;i++)
             {
           labelPic[i].setIcon(null);
           labelPic[i].sign=false;
                 if(Arr[i]!=0) 
           {
               
               labelPic[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+Arr[i]+".jpg")));
               System.out.print("  "+Arr[i]);
               labelPic[i].setVisible(true);       
               labelPic[i].number=Arr[i];   
               LeftCard.add(i);
           }
       else
          {
             labelPic[i].setIcon(null);
          }
            labelPic[i].setBounds(loc-(i+1)*25, 540, 80, 100);
             }
           System.out.println();
          System.out.println();
          System.out.println();
          System.out.println("����Leftcard"+LeftCard);
          System.out.println();
          System.out.println();  
          if(LeftCard.size()!=17&&LeftCard.size()!=20)
          {
              JOptionPane.showMessageDialog(null, "��������");
          }
        }
        public void DealMsg(String s)
        {
             StringTokenizer st = new StringTokenizer(s,"|");
           //  if(st.hasMoreElements())
             {
                 String command=st.nextToken();
                 if(command.equals("ID"))
                 {
                     Users[0]=st.nextToken();
                     Users[1]=st.nextToken();
                     Users[2]=st.nextToken();
                 for(int i=0;i<3;i++)
                 {
                     if(this.Username.equals(Users[i]))
                     {   
                         this.Id=i+1+"";
                         labplayer[0].setText(this.Username);
                         labplayer[0].setLocation(560, 470);
                     }

                   listOnline.addItem(Users[i]);  
                 }
                       int Idnum=Integer.parseInt(Id);
                         labplayer[1].setText(Users[Idnum%3]);
                         labplayer[1].setLocation(890, 250);  
                         labplayer[2].setText(Users[((Idnum%3)+1)%3]);
                         labplayer[2].setLocation(130, 250);                      
                 }
                 if(command.equals("11"))
                 {

                 this.AnMsg(s);
                this.loadImg();
                  yes.setVisible(true);
                   no.setVisible(true);

                 }
                 else if(command.equals("12"))
                 {
                      
                     last=st.nextToken();
                      int next=Integer.parseInt(last)%3+1;
                      dizhu=last;
                      if(last.equals(Id))
                      {
                        this.AnMsg(s);
                        this.loadImg();
                        yes.setVisible(true);
                        no.setVisible(true);
                          jta.append("���� "+Users[Integer.parseInt(Id)-1]+"�ǵ���\n");
                          jta.append("������ "+Users[Integer.parseInt(Id)-1]+"���ڳ���\n");
                          this.addtime(540, 430);
                          ischupai=true;
                           PlayCard1.removeAllElements();
                           PlayCard2.removeAllElements();
                           current1.setText("����");
                           current.setText("��ǰ����Ϊ"+LeftCard.size());
                      }
                      else if(next==Integer.parseInt(Id))
                      {
                         jta.append(last+"�ǵ���\n");
                            left1.setText("����");
                           left.setText("��ǰ����Ϊ"+20); 
                           this.addtime(200, 200);
                          for(int j=17;j<20;j++)
                      {
                            //   labl1[j].setIcon(null);
                          labl1[j].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));

                      }
                          if(LeftCard.size()<17) 
                          {
                              LeftCard.removeAllElements();
                              for(int i=0;i<17;i++)
                              {
                                  LeftCard.add(i);
                              }
                          }
                      }
                       else 
                      {
                          jta.append(Users[Integer.parseInt(last)-1]+"�ǵ���\n");
                           right1.setText("����");
                          right.setText("��ǰ����Ϊ"+20);
                          this.addtime(800, 200);
                          for(int j=17;j<20;j++)
                      {

                          labr1[j].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
                         // labr1[j].setIcon(null);
                      }
                          if(LeftCard.size()<17) 
                          {
                              LeftCard.removeAllElements();
                              for(int i=0;i<17;i++)
                              {
                                  LeftCard.add(i);
                              }
                          }
                      }
                 }
                 else if(command.equals("13"))
                 {
                     
                      int i=0;
                    String name=st.nextToken();
                        
                      while (st.hasMoreTokens())
                      {
                          
                          labdipai[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+Integer.parseInt(st.nextToken())+".jpg")));
                          i++;
                      }
                 }
                   else if(command.equals("14"))
                 {
                    {
                     last=st.nextToken();//�������
                     int leftcard=Integer.parseInt(st.nextToken());
                       int i=0;
                       int next=Integer.parseInt(last)%3+1;
                       if(next==Integer.parseInt(Id))
                       { 
                         i=0;
                          ischupai=true;
                         yes.setVisible(true);
                        no.setVisible(true);
                        this.addtime(540,430);
                      isbuchuR.setVisible(false);  
                          for(int j=0;j<20;j++)
                      {
                          labl2[j].setIcon(null);  
                          lab[j].setIcon(null);
                          
                      if(j<leftcard) 
                      {
                          labl1[j].setBounds(20,330+(int)(leftcard*25*0.5)-25*j, 80, 100);//�ұ�����  
                      }
                      
                     if(j>=leftcard)     labl1[j].setIcon(null);
                      }
                           left.setText("��ǰ����Ϊ"+leftcard);
                          PlayCard1.removeAllElements();
                          while (st.hasMoreTokens())
                      {
                          int num=Integer.parseInt(st.nextToken());;
                          if(num==-1)
                          {
                              PlayCard1.removeAllElements();  
                              break; 
                          }
                          PlayCard1.add(num);;
                        //�ұ�����  
                        labl2[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+num+".jpg")));
                          
                          i++;
                      }  
                      for(int j=0;j<i;j++)
                      {
                          labl2[j].setBounds(80+25*i-j*25,300, 80, 100);//�ұ�����   
                          
                      }
                      if(i!=0) 
                      {
                          jta.append(Users[Integer.parseInt(last)-1]+"��������\n");
                          music.run(PlayCard1);
                      }
                      else  
                      {
                          isbuchuR.setVisible(true);
                          new Music().play("buyao"+(int)(Math.random()*4+1));
                      }
                       }
                    
                else  if(last.equals(Id))
                   {
                       i=0;
                       for(int j=0;j<20;j++)
                      {
                          lab[j].setIcon(null); 
                      }
                      this.addtime(800, 200);
                      while (st.hasMoreTokens())
                      {
                          int num=Integer.parseInt(st.nextToken());
                          if(num==-1)
                          {
                             break; 
                          }
                          lab[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+num+".jpg")));
                          i++;
                      }
                      for(int j=0;j<i;j++)
                          lab[j].setBounds(400+25*i-j*25,420, 80, 100);//�ұ�����  
                      if(i!=0) jta.append("���"+Users[Integer.parseInt(last)-1]+"��������\n");
                      
                 }
                else
                {
                isbuchuL.setVisible(false);    
                 for(int j=0;j<20;j++)
                      {
                          labr2[j].setIcon(null); 
                          if(j<leftcard) 
                      {
                          labr1[j].setBounds(1000,330+(int)(leftcard*25*0.5)-25*j, 80, 100);//�ұ�����  
                      }     
                        if(j>=leftcard) 
                            labr1[j].setIcon(null);
                      }
                 this.addtime(200, 200);
                  right.setText("��ǰ����"+leftcard);
                  PlayCard2.removeAllElements();
                          while (st.hasMoreTokens())
                      {
                          int num=Integer.parseInt(st.nextToken());
                          if(num==-1)
                          {
                              PlayCard2.removeAllElements(); 
                              break; 
                          }
                          PlayCard2.add(num);
                        labr2[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+num+".jpg")));

                          i++;
                      }   
                       if(i!=0) 
                       {
                           jta.append("���"+Users[Integer.parseInt(last)-1]+"��������\n");
                           music.run(PlayCard2);
                       }   
                       else 
                       { 
                           isbuchuL.setVisible(true);
                           new Music().play("buyao"+(int)(Math.random()*4+1));
                       }
                       
                }
                 }
                 }
                  else if(command.equals("talk"))
                  {
                      String msg=st.nextToken();
                      String sender=st.nextToken();
                      String receiver=st.nextToken();
         java.text.DateFormat format1 = new java.text.SimpleDateFormat("HH:mm:ss");
        String strTime = format1.format(new Date());
          strTime="("+strTime+")";                      
                  if(receiver.equals(this.Username))
                  { 
          jta1.append("���"+sender+": "+msg+strTime+"\n");
                  }
                if(receiver.equals("All"))
      if(!sender.equals(Id))     jta1.append("���"+sender+": "+msg+strTime+"\n");
                  }
                 else if(command.equals("15"))
                 {
                     String success=st.nextToken();
                JOptionPane.showMessageDialog(null,"���"+success+"���ʤ��","ʤ��", JOptionPane.INFORMATION_MESSAGE);
                  start.setVisible(true);
                yes.setVisible(false);
                no.setVisible(false);
                 }
             }
        }
       public  boolean isHefa() //�ж��Ƿ�Ϸ�����
       {
       if(!PlayCard1.isEmpty())
       {
           boolean panduan=Comparecard.run(PlayCard1,PlayCard);
           return panduan; 
       }
       else if(!PlayCard2.isEmpty())
       {
          boolean panduan=Comparecard.run(PlayCard2,PlayCard);
           return panduan; 
       }
       else if(PlayCard2.isEmpty()&&PlayCard1.isEmpty())
       {
        if(PlayCard.isEmpty())
            return false;
          return true;
       }
       else return false;

       }
       public void Chupai()
       {
           
         for(int i=0;i<LeftCard.size();i++){
            Integer p1=(Integer)(LeftCard.get(i));
//            Integer p2=(Integer)(LeftCard.get(i+1));
                 int k1=p1.intValue();
//                 int k2=p2.intValue();
         if(labelPic[k1].sign)   {
           //  labelPic[k1].setVisible(false);
             PlayCard.add(labelPic[k1].number);
//              LeftCard.removeElementAt(i);
//                 i--;
                  
         }
             
         }
        boolean hefa=isHefa(); 
      //  hefa=true;
        if(!ischupai)
        {
            JOptionPane.showMessageDialog(null,"û���ֵ������\n��ǰ���Ƶ������"+(Integer.parseInt(last)%3+1),"����", JOptionPane.WARNING_MESSAGE);
           PlayCard.removeAllElements();
        }
    else  if(compare.run(PlayCard)[0]==0||!hefa) {
            PlayCard.removeAllElements();
            for(int i=0;i<LeftCard.size();i++) {
                 Integer p=(Integer)(LeftCard.get(i));
                 int k2=p.intValue();
              labelPic[k2].setBounds(loc-(i+1)*25, 540, 80, 100);
              labelPic[k2].sign=false;
      }
               JOptionPane.showMessageDialog(null,"������Ʋ��Ϸ�","����", JOptionPane.WARNING_MESSAGE);

      }
   else
      {

          music.run(PlayCard);
        for(int i=0;i<LeftCard.size();i++){
            
          Integer p=(Integer)(LeftCard.get(i));
                 int k=p.intValue();
                          if(labelPic[k].sign)   {
             labelPic[k].setVisible(false);

              LeftCard.removeElementAt(i);
                 i--;
                  
         }
              
           labelPic[k].setBounds(loc-(i+1)*25, 540, 80, 100);
        }
                 RecordCard=PlayCard;
               String send="22|"+Id+"|"+LeftCard.size()+this.ChangeVector(RecordCard);
                  out.println(send);
                  current.setText("��ǰ����Ϊ"+LeftCard.size());
                  ischupai=false;
             yes.setVisible(false);
              no.setVisible(false);
              if(LeftCard.isEmpty())
              {
                String send1="23|"+Username+"|";
                out.println(send1); 
         }
                    
     }
       }

    private void addtime(int x,int y) {
        		Calendar startCalendar = Calendar.getInstance();
			startTime = startCalendar.getTime().getTime();
			endTime = startTime + 30*1000;
			flag = true;
                  ibLeftSec.setBounds(x,y, 62, 40);
    }
      public static void main(String[] args)
      {
       
          String input=JOptionPane.showInputDialog("������ҵ����ֺͷ�����������IP\n   �м���||����");
          StringTokenizer st = new StringTokenizer(input,"|");
          String User=st.nextToken();
          System.out.println("�û���"+User);
          String IP=st.nextToken();
        System.out.println("�û���"+IP);
          new MainClient(User,IP);
      }
}
