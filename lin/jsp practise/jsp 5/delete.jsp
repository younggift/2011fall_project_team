<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY bgcolor=pink ><Font size=1>
  <% //获取提交的学号：
    String number=request.getParameter("number");
          if(number==null)
            {number="";
            }
     byte b[]=number.getBytes("ISO-8859-1");
     number=new String(b);
    Connection con=null;
    Statement sql=null;
    ResultSet rs=null;
       try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          }
       catch(ClassNotFoundException event){}
       try {con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
       sql=con.createStatement();
       //删除操作：
       String deleteAll="DELETE  FROM students WHERE 学号"+" = "+"'"+number+"'";
       sql.executeUpdate(deleteAll);
      %>
     <P>删除记录后的表：
     <%
       rs=sql.executeQuery("SELECT * FROM students ORDER BY 学号 ");
       out.print("<Table Border>");
            out.print("<TR>");
            out.print("<TH width=100>"+"学号");
            out.print("<TH width=100>"+"姓名");
            out.print("<TH width=50>"+"数学成绩");
            out.print("<TH width=50>"+"英语成绩");
            out.print("<TH width=50>"+"物理成绩");
            out.print("</TR>");
       while(rs.next())
           {    out.print("<TR>");
                String n=rs.getString(1);
                 out.print("<TD >"+n+"</TD>"); 
                String xingming=rs.getString(2);
                 out.print("<TD >"+xingming+"</TD>");
                int  math=rs.getInt("数学成绩"); 
                 out.print("<TD >"+math+"</TD>"); 
                int english=rs.getInt("英语成绩"); 
                 out.print("<TD >"+english+"</TD>");
                int physics=rs.getInt("物理成绩"); 
                 out.print("<TD >"+physics+"</TD>"); 
            out.print("</TR>") ;  
         }
       out.print("</Table>");
      con.close();
     }
    catch(SQLException event)
          {out.print(""+event);
          }
 %>
</FONT>
</BODY>
</HTML>