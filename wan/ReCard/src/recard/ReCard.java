/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recard;

import function.Compare;
import function.Comparecard;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import test.VectorCard;

/**
 *
 * @author Administrator
 */
public class ReCard extends JFrame implements ActionListener,Runnable,MouseListener
{
    Socket socket;
    
   boolean  ischupai=false;//标记是否出牌
   JLabel right=new JLabel("当前牌数为"+17);//标记剩余牌数
   JLabel left=new JLabel("当前牌数为"+17);//标记剩余牌数
   JLabel current=new JLabel("当前牌数为"+17);//标记剩余牌数
   JLabel right1=new JLabel();//标记剩余牌数
   JLabel left1=new JLabel();//标记剩余牌数
   JLabel current1=new JLabel();//标记剩余牌数
    JButton start =new JButton("开始");
    JButton yes =new JButton("叫地主");
    JButton no =new JButton("不叫");
    Compare compare=new Compare();
   VectorCard music=new VectorCard();
   JLabel[] labdipai=new JLabel[3];
    private JTextArea jta = new JTextArea(); 
    private JTextArea jta1 = new JTextArea(); 
    private OutputStream toServer;
    private PrintWriter out;
    private BufferedReader in;
    private String Username;
    Thread th=new Thread(this,"listen");
    Vector PlayCard=new Vector();//记录要出的牌
    Vector PlayCard1=new Vector();//记录上个玩家出牌
    Vector PlayCard2=new Vector();//记录上一个玩家出牌
public static Vector RecordCard=new Vector();//记录玩家出牌
Vector LeftCard=new Vector();//记录剩下的牌
TestLabel[] labelPic=new TestLabel[51];
JLabel[] lab=new JLabel[20];
JLabel[] labr1=new JLabel[20];
JLabel[] labr2=new JLabel[20];
JLabel[] labl1=new JLabel[20];
JLabel[] labl2=new JLabel[20];

    String msg;
    String Command;
   private String last;
  private String dizhu;
   public int[] Arr;

   public int loc=760; //当前玩家出牌的相对位置
   public int locr=580; //当前玩家出牌的相对位置
   public int locl1=580; //当前玩家出牌的相对位置
   public int locl2=500; //当前玩家出牌的相对位置
   
   
    public ReCard(String name) {
      //super(name);
      this.setTitle("玩家"+name);
      this.Username=name;
      this.setLayout(null);
     // setExtendedState(JFrame.MAXIMIZED_BOTH);
      
      //setResizable(false);
Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
int width = (int)screensize.getWidth()-80;
int height = (int)screensize.getHeight()-50;
this.setLocation(50, 0);
       init();
       this.Bupai();
       this.setSize(width,height);
       System.out.println("宽幅： "+width+"； 高度: "+height);
        int width1 = this.getWidth();
        int height1 = this.getHeight();

       System.out.println("宽幅： "+width1+"； 高度: "+height1);
       this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void init()
    {
      JLabel lab1=new JLabel("玩家聊天区");
      JLabel lab2=new JLabel("<html>系<br>统<br>消<br>息<br>区<br>");
      lab1.setBounds(1150, 20,80, 40);
      lab2.setBounds(5, 0,40,100);
      right.setBounds(890, 270, 120, 40);
      left.setBounds(130, 270, 120, 40);
      current.setBounds(560, 500, 120, 40);
       right1.setBounds(860, 270, 120, 40);
      left1.setBounds(100, 270, 120, 40);
      current1.setBounds(530, 500, 120, 40);
      this.add(lab1);
     // this.add(lab2);
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
//jta.setLineWrap(true);    //设置自动换行,自动换行则不会出现横向的滚动条
jta.setEditable(true);    //设置可编辑
JScrollPane jsp = new JScrollPane(jta);    //添加滚动条
jsp.setBounds(25,0,240,100);    //设置 JScrollPane 宽100,高200
jta1.setEditable(true);    //设置可编辑
JScrollPane jsp1 = new JScrollPane(jta1);    //添加滚动条
jsp1.setBounds(1110,50,150,500);    //设置 JScrollPane 宽100,高200
     this.add(jsp);    //将组件加入容器
     this.add(jsp1);    //将组件加入容器
     this.add(start);
     this.add(yes);
     this.add(no);
    }
    void reInit()
    {
        for(int i=0;i<20;i++)
        {
             if(i<17)   LeftCard.add(i);//向量从0个位置开始记录
              if(i<17){
    labr1[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
      
  //labr2[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
   labl1[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
 
 //labl2[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
 
        }
    }
        System.out.println();
        System.out.println();
        System.out.println("reinit后"+LeftCard);
        System.out.println();
        System.out.println();
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        new  ReCard("3");
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();
        if(cmd.equals("start")) {
            th.start();
           start.setVisible(false);
            start.setText("重新开局");
             start.setSize(100, 40);
             start.setActionCommand("restart");
        }
        else if(cmd.equals("yes"))
        {
            out.println("21|"+Username+"|yes");
            yes.setText("出牌");
            no.setText("不出");
            no.setActionCommand("buchu");
            yes.setActionCommand("chu");
            yes.setVisible(false);
            no.setVisible(false);
     
        }
        else if(cmd.equals("no"))
        {
            out.println("21|"+Username+"|no");
            yes.setText("出牌");
            no.setText("不出");
            no.setActionCommand("buchu");
            yes.setActionCommand("chu");
            yes.setVisible(false);
            no.setVisible(false);
        }
        else if(cmd.equals("chu"))  //按键出牌
        {
                this.Chupai();
        }
        else if(cmd.equals("buchu"))
        {
          PlayCard.removeAllElements();
            for(int i=0;i<LeftCard.size();i++) {
                 Integer p=(Integer)(LeftCard.get(i));
                 int k2=p.intValue();
              labelPic[k2].setBounds(loc-(i+1)*25, 540, 80, 100);
              labelPic[k2].sign=false;
        }
           String send="22|"+Username+"|"+LeftCard.size()+"|";
          out.println(send);  
          yes.setVisible(false);
          no.setVisible(false); 
           ischupai=false;
    }
         else if(cmd.equals("restart"))
         {
             out.println("20|"+Username+"|start");
             start.setVisible(false);
              for(int i=0;i<20;i++) 
           {
              lab[i].setIcon(null);
         if(i<3)     labdipai[i].setIcon(null);
              labl1[i].setIcon(null);
              labl2[i].setIcon(null);
              labr1[i].setIcon(null);
              labr2[i].setIcon(null);
              labelPic[i].setIcon(null);
           }
            LeftCard.removeAllElements();
            PlayCard.removeAllElements();
            PlayCard1.removeAllElements();
             yes.setActionCommand("yes");
            yes.setText("叫地主");
            no.setActionCommand("no");
            no.setText("不叫");
         }
    }
public void connection(String name)
	{
		try 
{ 
socket = new Socket("127.1.1.1",8189); 
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
System.out.println("时间:"+s); 
//if(s.substring(0,1).endsWith(" ")||s.endsWith("牌"))
//{
//    jta.append(s+"\n");
//}
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
public String analysisMsg(String msg)
{
    StringTokenizer st = new StringTokenizer(msg,"|");
      String realMsg=st.nextToken();
     if(st.hasMoreElements())
     {
      String strre = st.nextToken();//读取用户名 
       int name=Integer.parseInt(strre);    
     }
     //获取信息时间
      java.text.DateFormat format1 = new java.text.SimpleDateFormat("HH:mm:ss");
        String strTime = format1.format(new Date());
          strTime="("+strTime+")";
   return    realMsg+strTime; 
}

    @Override
    public void run() {
    if(Thread.currentThread()==th)
    {
        this.connection(Username);
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
       labr2[i].setBounds(930-i*25,300, 80, 100);//左边外面
       labl1[i].setBounds(20,locl1-i*25, 80, 100);
       labl2[i].setBounds(locl2-i*25,300, 80, 100);//右边外面
 
 if(i<17){
    labr1[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
      
 // labr2[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
   labl1[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
 
 //labl2[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
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
     {//鼠标没有右击,已经左击
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
     if(e.isMetaDown()){    //右键出牌
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
        public void  AnMsg(String msg)  //解析消息
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
                   System.out.print("   "+Arr[i-2]);
               }
           i++;
       }
       System.out.println();
       System.out.println("数组Arr"+i);
    }
        public String ChangeVector(Vector v) {  //将向量封装成字符串
          String RealMsg="";
            for(int i=0;i<v.size();i++)
            {
                RealMsg+="|"+v.get(i);
            }
            return RealMsg;
        } 

        public void loadImg()
        {
             for(int i=0;i<20;i++)
             {
          if(Arr[i]!=0) 
           {
               labelPic[i].setIcon(null);
               labelPic[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+Arr[i]+".jpg")));
               labelPic[i].setVisible(true);
               labelPic[i].sign=false;
              labelPic[i].number=Arr[i];  
              System.out.print(" "+"执行"+i);
           }
         else 
             labelPic[i].setIcon(null);
             }
        }
        public void DealMsg(String s)
        {
             StringTokenizer st = new StringTokenizer(s,"|");
           //  if(st.hasMoreElements())
             {
                 String command=st.nextToken();
                 if(command.equals("11"))
                 {
                  String name=st.nextToken();
                  String msg=st.nextToken();
                  reInit();
                  this.AnMsg(s);
                  System.out.println();
                  System.out.println("当前生成的数组：");
                  for(int i=0;i<Arr[i];i++)
                  {
                   System.out.print("  "+Arr[i]);   
                  }
                  System.out.println();
                  System.out.println();
                this.loadImg(); 
                 System.out.println("A"+Username);
                       yes.setVisible(true);
                      no.setVisible(true);
                   System.out.println();
                   System.out.println();
                   System.out.println("发牌为"+s);
                   System.out.println();
                   System.out.println();
                   System.out.println("LeftCardsize"+LeftCard);
                 }
                 else if(command.equals("12"))
                 {
                      
                     last=st.nextToken();
                      int next=Integer.parseInt(last)%3+1;
                      dizhu=last;
                      if(last.equals(Username))
                      {
                        this.AnMsg(s);
                        this.loadImg();
                        yes.setVisible(true);
                        no.setVisible(true);
                          System.out.println("地主："+Username);
                          jta.append("您，玩家 "+Username+"是地主\n");
                          jta.append("地主： "+Username+"正在出牌\n");
                          ischupai=true;
                           for(int j=17;j<20;j++)
                          LeftCard.add(j);
                           current1.setText("地主");
                           current.setText("当前牌数为"+LeftCard.size());
//                          for(int j=17;j<20;j++)
//                      {
//                          labl1[j].setIcon(null);
//                          labr1[j].setIcon(null);
//                          
//                      }
                      }
                      else if(next==Integer.parseInt(Username))
                      {
                         jta.append("玩家 "+last+"是地主\n");
                         jta.append("地主下家"+Username+"正在准备\n");
                            left1.setText("地主");
                           left.setText("当前牌数为"+20); 
                          for(int j=17;j<20;j++)
                      {
                            //   labl1[j].setIcon(null);
 
                          labl1[j].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));

                      }
                      }
                       else 
                      {
                          jta.append("玩家 "+last+"是地主\n");
                         jta.append("地主上家家"+Username+"正在等待\n");
                           right1.setText("地主");
                          right.setText("当前牌数为"+20);
                          for(int j=17;j<20;j++)
                      {

                          labr1[j].setIcon(new ImageIcon(getClass().getResource("./tupian/"+0+".jpg")));
                         // labr1[j].setIcon(null);
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
                     last=st.nextToken();//出牌玩家
                     int leftcard=Integer.parseInt(st.nextToken());
                       System.out.println(last);
                       int i=0;
                       int next=Integer.parseInt(last)%3+1;
                       if(next==Integer.parseInt(Username))
                       { 
                         i=0;
                          ischupai=true;
                         yes.setVisible(true);
                        no.setVisible(true);
                          for(int j=0;j<20;j++)
                      {
                          labl2[j].setIcon(null);  
                          lab[j].setIcon(null);
                      }
                           left.setText("当前牌数为"+leftcard);
                          PlayCard1.removeAllElements();
                          while (st.hasMoreTokens())
                      {
                          int num=Integer.parseInt(st.nextToken());
                          System.out.print("  "+num);
                          if(num==-1)
                          {
                              PlayCard1.removeAllElements();  
                              break; 
                          }
                          PlayCard1.add(num);
                        //右边外面  
                        labl2[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+num+".jpg")));
                          
                          i++;
                      }  
                      for(int j=0;j<i;j++)
                          labl2[j].setBounds(80+25*i-j*25,300, 80, 100);//右边外面      
                      if(i!=0) jta.append("玩家"+last+"出完了牌\n");    
                       System.out.println();
                       System.out.println("PlayCard1："+PlayCard1);
                          System.out.println("PlayCard2:"+PlayCard2);  
                       }
                     //  System.out.println("上家的出牌：");
                    
                else  if(last.equals(Username))
                   {
                       i=0;
                       for(int j=0;j<20;j++)
                      {
                          lab[j].setIcon(null); 
                          
                      }
                      
                      while (st.hasMoreTokens())
                      {
                          int num=Integer.parseInt(st.nextToken());
                          System.out.print("  "+num);
                          if(num==-1)
                          {
                             break; 
                          }
                          lab[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+num+".jpg")));
                          i++;
                      }

                      if(i!=0) jta.append("玩家"+last+"出完了牌\n");
                      
                 }
                else
                {
                 for(int j=0;j<20;j++)
                      {
                          labr2[j].setIcon(null);        
                      }
                  right.setText("当前牌数"+leftcard);
                  PlayCard2.removeAllElements();
                          while (st.hasMoreTokens())
                      {
                          int num=Integer.parseInt(st.nextToken());
                          System.out.print("  "+num);
                          if(num==-1)
                          {
                              PlayCard2.removeAllElements(); 
                              break; 
                          }
                          PlayCard2.add(num);
                        labr2[i].setIcon(new ImageIcon(getClass().getResource("./tupian/"+num+".jpg")));

                          i++;
                      }   
                       if(i!=0) jta.append("玩家"+last+"出完了牌\n");   
                          System.out.println();
                          System.out.println("PlayCard1："+PlayCard1);
                          System.out.println("PlayCard2:"+PlayCard2);
                       
                }
                 }
                 }
                 else if(command.equals("15"))
                 {
                     String success=st.nextToken();
                JOptionPane.showMessageDialog(null,"玩家"+success+"获得胜利","胜利", JOptionPane.INFORMATION_MESSAGE);
                  start.setVisible(true);
    
                 }
             }
        }
       public  boolean isHefa() //判断是否合法出牌
       {
       if(!PlayCard1.isEmpty())
       {
           boolean panduan=Comparecard.run(PlayCard1,PlayCard);
           if(panduan)
           {
           System.out.println();
           System.out.println("上家PlayCard1:"+PlayCard1+"与本家"+PlayCard+"比较");
           System.out.println();
           }
           return panduan; 
       }
       else if(!PlayCard2.isEmpty())
       {
          boolean panduan=Comparecard.run(PlayCard2,PlayCard);
         if(panduan)
          {
           System.out.println();
           System.out.println("上家PlayCard2:"+PlayCard2+"与本家"+PlayCard+"比较");
           System.out.println();
          }
           return panduan; 
       }
       else if(PlayCard2.isEmpty()&&PlayCard1.isEmpty())
              return true;
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
            JOptionPane.showMessageDialog(null,"没有轮到你出牌\n当前出牌的是玩家"+(Integer.parseInt(last)%3+1),"警告", JOptionPane.WARNING_MESSAGE);
    else  if(compare.run(PlayCard)[0]==0||!hefa) {
            PlayCard.removeAllElements();
            for(int i=0;i<LeftCard.size();i++) {
                 Integer p=(Integer)(LeftCard.get(i));
                 int k2=p.intValue();
              labelPic[k2].setBounds(loc-(i+1)*25, 540, 80, 100);
              labelPic[k2].sign=false;
      }
               JOptionPane.showMessageDialog(null,"你出的牌不合法","警告", JOptionPane.WARNING_MESSAGE);

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
//         for(int i=0;i<PlayCard.size();i++){
//          
//            Integer p=(Integer)(PlayCard.get(i));
//                 int k=p.intValue();        
                  // t.dispose();  
                 RecordCard=PlayCard;
                 System.out.println(RecordCard);
                // String send="22|"+Username+this.ChangeVector(RecordCard);
               String send="22|"+Username+"|"+LeftCard.size()+this.ChangeVector(RecordCard);
                  out.println(send);
                  System.out.println(send);
                  current.setText("当前牌数为"+LeftCard.size());
                  ischupai=false;
             yes.setVisible(false);
              no.setVisible(false);
              if(LeftCard.isEmpty())
              {
                String send1="23|"+Username+"|";
                out.println(send1);
       //   JOptionPane.showMessageDialog(null,"恭喜你获得胜利","胜利", JOptionPane.INFORMATION_MESSAGE);
                
         }
                    
     }
       }
}
