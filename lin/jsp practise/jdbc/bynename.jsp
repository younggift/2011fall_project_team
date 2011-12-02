<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
  <% //获取提交的姓名：
    String name=request.getParameter("name");
          if(name==null)
            {name="";
            }
     byte b[]=name.getBytes("ISO-8859-1");
     name=new String(b);
    Connection con=null;
    Statement sql=null;
    ResultSet rs=null;
       try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          }
       catch(ClassNotFoundException e){}
       try { con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
             sql=con.createStatement();
             String condition="SELECT * FROM students WHERE 姓名 = "+"'"+name+"'";
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
                   { out.print("<TR>");
                     out.print("<TD >"+rs.getString(1)+"</TD>"); 
                     out.print("<TD >"+rs.getString(2)+"</TD>");
                     out.print("<TD >"+rs.getInt("数学成绩")+"</TD>"); 
                     out.print("<TD >"+rs.getInt("英语成绩")+"</TD>");
                     out.print("<TD >"+rs.getInt("物理成绩")+"</TD>");   
                     out.print("</TR>") ;  
                    }
              out.print("</Table>");
              con.close();
           }
    catch(SQLException e)
           {  }
%>
</BODY>
</HTML>