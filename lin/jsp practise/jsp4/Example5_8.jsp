<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY bgcolor=pink >
<Font size=1>
<FORM action="newResult.jsp" method=post>
输入要修改成绩的同学的姓名：<BR>
<Input type="text" name="name">
<BR>输入新的数学成绩：
<Input type="text" name="math">
<BR>输入新的英语成绩：
<Input type="text" name="english">
<BR>输入新的物理成绩：
<Input type="text" name="physics">
<BR><Input type="submit" name="b" value="提交更新">
<P>数据库更新前的数据记录是：
 <% String name,number;
    int math,physics,english;
    Connection con;
    Statement sql; 
    ResultSet rs;
    try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
    catch(ClassNotFoundException e){}
    try{ con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
         sql=con.createStatement();
         rs=sql.executeQuery("SELECT * FROM students");
         out.print("<Table Border>");
         out.print("<TR>");
            out.print("<TH width=100>"+"学号");
            out.print("<TH width=100>"+"姓名");
            out.print("<TH width=50>"+"数学成绩");
            out.print("<TH width=50>"+"英语成绩");
            out.print("<TH width=50>"+"物理成绩");
         out.print("</TR>");
       while(rs.next())
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
        con.close();
     }
   catch(SQLException e1) {}
 %>
</Font>
</BODY>
</HTML>