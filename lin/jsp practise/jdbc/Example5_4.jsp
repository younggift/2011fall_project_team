<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
 <% String xuehao,name;
    int math;
    Connection con;
    Statement sql; 
    ResultSet rs;
    try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
    catch(ClassNotFoundException e){}
    try { con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
         sql=
con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //返回可滚动的结果集：
         rs=sql.executeQuery("SELECT * FROM students");
         out.print("<Table Border>");
         out.print("<TR>");
             out.print("<TH width=100>"+"学号");
             out.print("<TH width=100>"+"姓名");
             out.print("<TH width=50>"+"数学成绩");
         out.print("</TR>");
        //将游标移动到最后一行：
            rs.last();
        //获取最后一行的行号：
          int lownumber=rs.getRow();
        //获取记录数：
        int number=lownumber;
        double sum=0;
        int 抽取数目=4;
        int old_i[]={0,0,0,0}; 
        int k=抽取数目;
        int j=0;
           while(抽取数目>0)
                {int i=(int)(Math.random()*number+1);//随机获取一个1到number之间的数。
                 boolean boo=false;
                 for(int m=0;m<old_i.length;m++)   //查找该行是否已被取出。
                      {if(i==old_i[m])
                       boo=true;
                      }
                 if(boo)  continue;   //假如该行已被取出，结束本次循环，继续产生随机数。 
                 rs.absolute(i);                   //游标移到这一行。
                 out.print("<TR>");
                 xuehao=rs.getString(1);              //获取该行学号字段的值。
                 out.print("<TD >"+xuehao+"</TD>");
                 name=rs.getString(2);              //获取该行姓名字段的值。
                 out.print("<TD >"+name+"</TD>");
                 math=rs.getInt("数学成绩");        //获取改行数学成绩字段的值。
                 out.print("<TD >"+math+"</TD>"); 
                 out.print("</TR>") ;
                 sum=sum+math; 
                 抽取数目--; 
                 old_i[j]=i;        //记录已取出的行号。
                 j++;      
                }
         out.print("</Table>");
         out.print("平均成绩是："+sum/k);
         con.close();
     }
   catch(SQLException e1) {}
 %>
</BODY>
</HTML>