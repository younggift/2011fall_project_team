import java.awt.BorderLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.*; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.*; 
import javax.swing.*; 

@SuppressWarnings("serial") 
public class IMServer extends JFrame implements ActionListener 
{ 
private int command0=0;//记录接收重新开机的指令数目   
private int command1=0;//记录接收是否叫地主的指令数目   
private static Vector Dizhu=new Vector();
private static final int maxThreadLimit = 10; 
private static int OnlineNumber=0;
private JPanel p = new JPanel(); 
Testing test;
    String Command;
   private Vector Users=new Vector();
   public int[] Arr=new int[21];
private JTextField jtf = new JTextField(); 
private JTextArea jta = new JTextArea();
private ArrayList<ThreadServer> threadArray = new ArrayList<ThreadServer>();        //线程数组，用于存放连接线程 
public IMServer() 
{ 
p.setLayout(new BorderLayout()); 
p.add(new JLabel("发送(回车)"),BorderLayout.WEST); 
p.add(jtf,BorderLayout.CENTER); 
jtf.setHorizontalAlignment(JTextField.RIGHT); 
getContentPane().setLayout(new BorderLayout()); 
getContentPane().add(new JScrollPane(jta),BorderLayout.CENTER); 
getContentPane().add(p,BorderLayout.SOUTH); 
jta.setEditable(false); 
jtf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
jtf.addActionListener(this); 
setTitle("IM"); 
setSize(500,300); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
setVisible(true); 
 new Thread(new Runnable() {

            @Override
            public void run() {
                while(true)
                {
                    if(command0==3)
                    {
                        CreatPai();
                        command0=0;
                    }
                   else  if(command1==3)
           {
               int chose1 = 0;
                  for(int i=0;i<10000;i++)
                  {
                      
                  }
               
                if(Dizhu.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"没人抢地主，随机发牌");
                   chose1=(int)(Math.random()*3)+1;
                }
               else
                {
                 int number=(int)(Math.random()*Dizhu.size())+1;   
                Integer chose=(Integer) Dizhu.get(number-1);
                  chose1=chose.intValue();
                }
				Dizhu.removeAllElements();
                System.out.println(chose1);
                 guangBo(" 地主是："+chose1+"系统广播者");  
                 guangBo(" 地主是正在出牌");  
                 String send=test.CreatDizhu(chose1);
                 System.out.println("地主的牌的是："+send);
                guangBo("12|"+chose1+send);
                 guangBo("13|"+chose1+test.dipai);
                 command1=0;
                
            }
              
                }
            }
        }).start();
try 
{ 
ServerSocket serverSocket = new ServerSocket(8189); 
jta.append("服务器开启时间：" + new Date() + '\n'); 
while(true) 
{  
if(threadArray.size() >= maxThreadLimit) 
{ 
try 
{ 
Thread.sleep(1000); 
} 
catch(InterruptedException ex) 
{ 
} 
} 
else 
{ 
Socket socket = serverSocket.accept(); 
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
String name=in.readLine();
OnlineNumber++;
jta.append("用户"+name+ "上线:  ("+new Date() +")" +'\n'); 
jta.append("当前在线人数："+OnlineNumber+"人\n");
ThreadServer thread = new ThreadServer(OnlineNumber,name,socket); 
threadArray.add(thread); 
       Users.add("|"+name);
thread.start(); 
 try {
       Thread.sleep(100);     
 if(OnlineNumber>2)
{
    for(int i=0;i<3;i++)
 threadArray.get(i).send("ID"+Users.get(0)+Users.get(1)+Users.get(2)); 
    CreatPai();

}

          } catch (InterruptedException ex) {
    }


} 

}
} 
catch(IOException e) 
{ 
System.err.println(e); 
} 

} 
private void CreatPai()
{
      test=new Testing();

 threadArray.get(0).send("11|"+1+test.user1); 
 threadArray.get(1).send("11|"+2+test.user2); 
 threadArray.get(2).send("11|"+3+test.user3); 

}
public static void main(String[] args) 
{ 
new IMServer(); 
} 
@Override 
public void actionPerformed(ActionEvent arg0) 
{ 
if (arg0.getSource() instanceof JTextField) 
{ 
String s = jtf.getText(); 
if(s != null) 
{ 
guangBo(" 系统消息："+s); 
s = null; 
} 
jtf.setText(""); 
} 
} 
public void guangBo(String s)            //向所有客户端监听线程发送消息 
{ 
    StringTokenizer st = new StringTokenizer(s,"|");
            st.nextToken();

jta.append(s+ '\n'); 
//if(st.hasMoreElements()){
if(threadArray.size() > 0)            //遍历这个线程数组 
{ 
for(int i = 0;i < threadArray.size();i++) 
{ 
threadArray.get(i).send(s); 
System.out.println(i+": "+s);
} 
 
} 

}
//线程内部类 
 

class ThreadServer extends Thread 
{ 
private Socket incoming;
private String name;
private int num;
private PrintWriter out; 
public ThreadServer(int num,String name,Socket i) 
{ 
   this.num=num;
    this.name=name;
    incoming = i; 
}
  public int getnum() {
            return num;
        }


public String getname()
{
    return name;
}
@Override 
public void run() 
{ 
// TODO Auto-generated method stub 
    synchronized(this)
    {
try 
{ 
try 
{ 
BufferedReader inStream = new BufferedReader(new InputStreamReader(incoming.getInputStream())); 
OutputStream outStream = incoming.getOutputStream(); 
out = new PrintWriter(outStream, true); 

while(true) 
{ 
String s = inStream.readLine(); 
System.out.println(s);
    StringTokenizer st = new StringTokenizer(s,"|");
  String  command=st.nextToken();
  if(st.hasMoreElements())
  {
     if(command.equals("error"))
	  {
         String name=st.nextToken();
         int num=Integer.parseInt(name);
		 switch(num)
			 {
			   case 1:
				   this.send("11|"+1+test.user1);
			       break;
			   case 2:
				   this.send("11|"+2+test.user2);
			       break;
			   case 3:
 				   this.send("11|"+2+test.user2);
			       break;
               default:
				   System.exit(-1);
			 }
	  }
	 if(command.equals("20"))
      {
         command0++;
      }
     else if(command.equals("21"))
      {
            
            String name1=st.nextToken();
            String dizhu=st.nextToken();
            if(dizhu.equals("yes"))
            {
                Dizhu.add(Integer.parseInt(name1));
            }
           command1++;
      }
      else if(command.equals("22"))
      {
         String name1=st.nextToken();
          if(s.endsWith("|"))
         {
           String realmsg=s.substring(3);
           guangBo(" 玩家"+name1+"不出牌"); 
          guangBo("14|"+realmsg+"|-1");
         }
         else 
         {
          String realmsg=s.substring(3);
          System.out.println(realmsg);
          guangBo(" 玩家"+name1+"正在出牌"); 
          guangBo("14|"+realmsg);
         }
          
      }
      else if(command.equals("23"))
      {
          String name1=st.nextToken();
          guangBo("15|"+name1);
      }
      else if(command.equals("talk"))
      {
         String msg=st.nextToken();
       if(msg.length()>0)
           guangBo(s);
      }
  }
  else if(s.length()>0 && !s.equalsIgnoreCase("EXIT")) 
{ 
guangBo(s); 
s = null; 
} 
else if(s.equalsIgnoreCase("EXIT")) 
{

break; 
}
} 
} 
catch(java.net.SocketException e)
{
    System.out.println("有用户退出");
    threadArray.remove(this); 
}
finally 
{ 

incoming.close(); 
} 
} 
catch(IOException e) 
{ 
e.printStackTrace(); 
} 
} 
}
public void send(String s) 
{ 
if(s != null) 
{ 
out.println(s); 
} 
} 
    } 

public String analysisMsg(String msg)
{
    StringTokenizer st = new StringTokenizer(msg,"|");
      String realMsg=st.nextToken();
     if(st.hasMoreElements())
     {
      String strre = st.nextToken();//读取用户名     
     }
     //获取信息时间
      java.text.DateFormat format1 = new java.text.SimpleDateFormat("HH:mm:ss");
        String strTime = format1.format(new Date());
          strTime="("+strTime+")";
   return    msg+strTime; 
}

        public String ChangeVector(Vector v) {  //将向量封装成字符串
          String RealMsg="";
            for(int i=0;i<v.size();i++)
            {
                RealMsg+="|"+v.get(i);
            }
            return RealMsg;
        } 
        public String PackMsg(int command,String realMsg)
        {
            return command+"|Server"+realMsg;
        }
}
