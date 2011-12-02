<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
 <% String name,number;
    int math,physics,english;
    Connection con;
    Statement sql; 
    ResultSet rs;
    try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
    catch(ClassNotFoundException e){}
    try{ con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
         sql=
con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //返回可滚动的结果集：
         rs=sql.executeQuery("SELECT * FROM students");
        //将游标移动到最后一行：
            rs.last();
        //获取最后一行的行号：
          int lownumber=rs.getRow();
         out.print("该表共有"+lownumber+"条记录");
         out.print("<BR>现在逆序输出记录：");
         out.print("<Table Border>");
         out.print("<TR>");
            out.print("<TH width=100>"+"学号");
            out.print("<TH width=100>"+"姓名");
            out.print("<TH width=50>"+"数学成绩");
            out.print("<TH width=50>"+"英语成绩");
            out.print("<TH width=50>"+"物理成绩");
       out.print("</TR>");
       //为了逆序输出记录，需将游标移动到最后一行之后：
        rs.afterLast();
        while(rs.previous())
        { out.print("<TR>");
             number=rs.getString(1); 
             out.print("<TD >"+number+"</TD>"); 
             name=rs.getString(2); 
             out.print("<TD >"+name+"</TD>");
             math=rs.getInt("数学成绩"); 
             out.print("<TD >"+math+"</TD>"); 
             english=rs.getInt("英语成绩"); 
             out.print("<TD >"+english+"</TD>");
             physics=rs.getInt("物理成绩"); 
             out.print("<TD >"+physics+"</TD>");   
         out.print("</TR>") ;          
         }
       out.print("</Table>");
       out.print("单独输出第5条记录<BR>");
        rs.absolute(5);
             number=rs.getString(1); 
             out.print(number+","); 
             name=rs.getString(2); 
             out.print(name+",");
             math=rs.getInt("数学成绩"); 
             out.print(math+","); 
             english=rs.getInt("英语成绩"); 
             out.print(english+",");
             physics=rs.getInt("物理成绩"); 
             out.print(physics+"。"); 
        con.close();
     }
   catch(SQLException e1) {}
 %>
</BODY>
</HTML>