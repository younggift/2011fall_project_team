/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import CardAttendant.OnePerson;
import CardAttendant.ThreePerson;
import CardAttendant.TwoPerson;
import Music.Music;
import function.CreateCard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author wanjiang
 */
public class Main extends JFrame implements ActionListener,Runnable,MouseListener{
   public Vector frontcard=new Vector();
   public static int[] card;
   JLabel[] lab=new JLabel[3];
   JButton  qiangdizhu=new JButton("抢地主");
   JButton  buqiang=new JButton("不抢");
   Boolean  qdizhu;
   int dizhu;  //最先出牌的是地主，牌轮转
   Music music=new Music();
   Thread th=new Thread(this);
   public static Vector Recodcard=new Vector();
    CreateCard   creat=new CreateCard();
    OnePerson one;
    TwoPerson two;
    int [] onecard=new int[20];
    int [] twocard=new int[20];
    int [] threecard=new int[20];
    int [] dipai=new int[3];
    ThreePerson three;
     TimeCount pa;
    JButton first =new JButton("玩家1出牌");
    JButton second =new JButton("玩家2出牌");
    JButton third =new JButton("玩家3出牌");
    
    JButton buchu =new JButton("不出");
    JButton tuoguan =new JButton("托管");
    public Main() {
    this.setLayout(null);
//    one.addMouseListener(this);
//    two.addMouseListener(this);
//    three.addMouseListener(this);
   
       card=creat.imgPath;
    for(int i=1;i<=54;i++)
    {
       if(i<=17) onecard[i-1]=card[i];
       else if(i>17&&i<=34) twocard[i-18]=card[i];
       else if(i>34&&i<=51) threecard[i-35]=card[i];
       else  dipai[i-52]=card[i];
    } 
            pa=new TimeCount();
            pa.setLocation(0,50);
            pa.setVisible(true);
            this.add(pa);
     one=new OnePerson(onecard); 
     one.setVisible(false);

    two=new TwoPerson(twocard);
    two.setVisible(false);
    
    three =new ThreePerson(threecard);
    three.setVisible(false);
    first.setActionCommand("display1");
    second.setActionCommand("display2");
    third.setActionCommand("display3");
    first.addActionListener(this);
    second.addActionListener(this);
    third.addActionListener(this);
    qiangdizhu.setBounds(200,100,120, 40);
    qiangdizhu.setActionCommand("qiang");
    qiangdizhu.addActionListener(this);
    buqiang.setActionCommand("buqiang");
    buqiang.addActionListener(this);
    buqiang.setBounds(400,100,120, 40);
    this.add(qiangdizhu);
    this.add(buqiang);
    this.add(first);
    this.add(second);
    this.add(third);
    one.pa2.addMouseListener(this);
    two.pa2.addMouseListener(this);
    three.pa2.addMouseListener(this);
    this.addMouseListener(this);
    first.setBounds(180,0,120, 40);
    second.setBounds(300,0,120, 40);
    third.setBounds(420,0,120, 40);
          setLocation(400,0);
          setSize(700, 700);
          setVisible(true);
          one.setLocation(10, 250);
          two.setLocation(10, 250);
          three.setLocation(10,250);
          this.add(one);
          this.add(two);
          this.add(three);
          th.start();
          this.Dizi();
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setVisible(true);
        dizhu=(int)(Math.random()*3)+1;
          CreatDizhu();
        
    }
       public void Dizi()  //加载底牌
       {
                for(int i=0;i<3;i++)
      {
        lab[i]=new JLabel();
         lab[i].setText("lab "+i);
         lab[i].setIcon(new ImageIcon(getClass().getResource("/Panel/tupian/"+0+".jpg")));
         lab[i].setBounds(600-i*30, 50, 80, 100);
         this.add(lab[i]);
      }  
       } 
   public static void main(String[] args) {
      try
      {
          new Main();
      }
       catch(Exception e){}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     String cmd=e.getActionCommand();
      if(cmd.equals("display1")&&dizhu==1) 
     {
     one.setVisible(true); 
     Loadtime();
    first.setText("玩家1正在出牌");
    first.setActionCommand("hide1");
             qiangdizhu.setVisible(true);
         buqiang.setVisible(true);
     }
      else if(cmd.equals("hide1"))
      {
      one.setVisible(false);    
    first.setText("玩家1出牌");
    first.setActionCommand("display1");
             qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
    dizhu=2;
    }
      if(cmd.equals("display2")&&dizhu==2) 
     {
     two.setVisible(true);
     Loadtime();
    second.setText("玩家2正在出牌");
    second.setActionCommand("hide2");
         qiangdizhu.setVisible(true);
         buqiang.setVisible(true);
     }
      else if(cmd.equals("hide2"))
      {
      two.setVisible(false);    
    second.setText("玩家2出牌");
    second.setActionCommand("display2");
         qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
      dizhu=3;
    }
        if(cmd.equals("display3")&&dizhu==3) 
     {
     three.setVisible(true);
     Loadtime();
    third.setText("玩家3正在出牌");
    third.setActionCommand("hide3");
           qiangdizhu.setVisible(true);
         buqiang.setVisible(true);
     }
      else if(cmd.equals("hide3"))
     {
     three.setVisible(false);
    third.setText("玩家3出牌");
    third.setActionCommand("display3");
          qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
    dizhu=1;
    }
      else if(cmd.equals("qiang"))
      {
         
          Qiangdizhu();
           music.play("qiang"+((int)(Math.random()*3)+1));
      }
      else if(cmd.equals("buqiang"))
      {
         music.play("buqiang");
          new Thread(new Runnable() {

                @Override
                public void run() {
                   
                        buqiangDizhu();
                    try {
                        Thread.sleep(100); //避免切换的时候看到下家的牌
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        dizhu++;
                        if(dizhu>3) dizhu=1;
                        CreatDizhu();
                   
                }
            }).start();
      }
        if(cmd.equals("buchu"))
        {
            buchu();
             music.play("buyao"+((int)(Math.random()*3)+1));
        }
        if(cmd.equals("tuoguan"))
        {
            tuoguan();
        }
    }
    void CreatDizhu()
    {

    
   switch(dizhu)
   {
       case 1:
            one.setVisible(true);
            Loadtime();
            break;
       case 2:
            two.setVisible(true);
            Loadtime();
            break;
       case 3:
            three.setVisible(true);
            Loadtime();
            break;
   }
    }
        void buqiangDizhu()
    {
   switch(dizhu)
   {
       case 1:
            one.setVisible(false);
            break;
       case 2:
            two.setVisible(false);
            break;
       case 3:
            three.setVisible(false);
            break;
   }
    }
    void Qiangdizhu()
    {
        //显示底牌
            for(int i=0;i<3;i++)
       lab[i].setIcon(new ImageIcon(getClass().getResource("/Panel/tupian/"+dipai[i]+".jpg")));
        //去除抢地主按钮
         qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
         qiangdizhu.setText("不出");
         buqiang.setText("托管");
         qiangdizhu.disable();
         qiangdizhu.setActionCommand("buchu");
         buqiang.setActionCommand("tuoguan");
         Loadtime();
   switch(dizhu)
   {
       case 1:
           one.setVisible(false);
           this.remove(one);
           one.dispose();
          int[] newonecard=contact(onecard);        
          one=new OnePerson(newonecard);
          
         one.setLocation(10, 250);
         one.setVisible(true);
        
          this.add(one);
          
         first.setText("玩家1正在出牌");
         first.setActionCommand("hide1");
            break;
       case 2:
              this.remove(two);
          int[] newtwocard=contact(twocard);
          two=new TwoPerson(newtwocard);
          two.setLocation(10, 250);
          two.setVisible(true);
          this.add(two);
          second.setText("玩家2正在出牌");
          second.setActionCommand("hide2");
            break;
       case 3:
              this.remove(three);
          int[] newthreecard=contact(threecard);
          three=new ThreePerson(newthreecard);
          three.setLocation(10, 250);
          three.setVisible(true);
          this.add(three);
          third.setText("玩家3正在出牌");
          third.setActionCommand("hide3");
            break;
        
   }
    }
     private  int[] contact(int a[])  //合并两个数组
     {
         int j=0;
  for(int i = a.length-1; i >a.length-4; i--)
  {
                 a[i]=dipai[j];
                 j++;
  }
  CreateCard.maoPao(a, 0, 19);
     return a;
   }
   void currentplayer()
   {
switch(dizhu)
        {
            case 1:
      one.setVisible(false);    
      first.setText("玩家1出牌");
    first.setActionCommand("display1");
             qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
             dizhu=2; 
                break;
            case 2:
                    two.setVisible(false);    
    second.setText("玩家2出牌");
    second.setActionCommand("display2");
         qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
              dizhu=3;
                break;
            case 3:
                   three.setVisible(false);
    third.setText("玩家3出牌");
    third.setActionCommand("display3");
          qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
               dizhu=1;
                break;
        }
         TimeCount.isTimeout=false;
   }
   void Loadtime()
   {
//            if(pa!=null)  this.remove(pa);
//         
//           pa=new TimeCount();
//            pa.setLocation(0,50);
//            pa.setVisible(true);
//            this.add(pa);
       Calendar startCalendar = Calendar.getInstance();
      			TimeCount.startTime = startCalendar.getTime().getTime();
			TimeCount.endTime = TimeCount.startTime + 31*1000;   //多次测试31时才能显示为30 
   }

    @Override
    public void run() {
      if(Thread.currentThread()==th)  
        while(true){
            if(TimeCount.isTimeout)  currentplayer();
            
            if(OnePerson.pa2.getLeftCard().isEmpty()){ 
          
              JOptionPane.showMessageDialog(null,"玩家1获得胜利","胜利", JOptionPane.PLAIN_MESSAGE);
               break;
            }
            if(TwoPerson.pa2.getLeftCard().isEmpty()){ 
          
              JOptionPane.showMessageDialog(null,"玩家2获得胜利","胜利", JOptionPane.PLAIN_MESSAGE);
               break;
            }
           if(ThreePerson.pa2.getLeftCard().isEmpty()){ 
          
              JOptionPane.showMessageDialog(null,"玩家3获得胜利","胜利", JOptionPane.PLAIN_MESSAGE);
               break;
            }
        }
    }

    public void buchu()
    {
switch(dizhu)
        {
            case 1:
 
      one.setVisible(false);    
      first.setText("玩家1出牌");
    first.setActionCommand("display1");
             qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
         one.istuoguan=true;
               dizhu=2; 
                break;
            case 2:
            
                    two.setVisible(false);    
    second.setText("玩家2出牌");
    second.setActionCommand("display2");
         qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
         two.istuoguan=true;
      dizhu=3;
                break;
            case 3:
             
                   three.setVisible(false);
    third.setText("玩家3出牌");
    third.setActionCommand("display3");
          qiangdizhu.setVisible(false);
         buqiang.setVisible(false);
         three.istuoguan=true;
               dizhu=1;
                break;
        }
    }
    public void tuoguan()
    {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
           
             
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
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
}
