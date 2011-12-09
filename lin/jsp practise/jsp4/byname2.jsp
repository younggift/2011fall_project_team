<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
  <% //获取提交的姓氏：
    String name=request.getParameter("name");
          if(name==null)
            {name="";
            }
     byte b[]=name.getBytes("ISO-8859-1");
     name=new String(b);
    String number,xingming;
    Connection con=null;
    Statement sql=null;
    ResultSet rs=null;
    int math,english,physics;
       try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          }
       catch(ClassNotFoundException e){}
       try{ con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
           sql=con.createStatement();
           String condition="SELECT * FROM students" ;
           rs=sql.executeQuery(condition);
       out.print("<Table Border>");
            out.print("<TR>");
            out.print("<TH width=100>"+"学号");
            out.print("<TH width=100>"+"姓名");
            out.print("<TH width=50>"+"数学成绩");
            out.print("<TH width=50>"+"英语成绩");
            out.print("<TH width=50>"+"物理成绩");
            out.print("</TR>");
       while(rs.next())
           { number=rs.getString(1);
             xingming=rs.getString(2);
             if(xingming.startsWith("王"))
               { out.print("<TR>");
                 out.print("<TD >"+number+"</TD>"); 
                 out.print("<TD >"+xingming+"</TD>");
                 math=rs.getInt("数学成绩"); 
                 out.print("<TD >"+math+"</TD>"); 
                 english=rs.getInt("英语成绩"); 
                 out.print("<TD >"+english+"</TD>");
                 physics=rs.getInt("物理成绩"); 
                 out.print("<TD >"+physics+"</TD>"); 
                 out.print("</TR>") ;  
               } 
            }
       out.print("</Table>");
      con.close();
     }
    catch(SQLException e)
     {  }
%>
</BODY>
</HTML>