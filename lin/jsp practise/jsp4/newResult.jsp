<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY bgcolor=pink ><Font size=1>
  <% //获取提交的姓名：
    String name=request.getParameter("name");
          if(name==null)
            {name="";
            }
     byte b[]=name.getBytes("ISO-8859-1");
     name=new String(b);
     //获取提交的新的数学成绩：
    String newMath=request.getParameter("math");
          if(newMath==null)
            {newMath="-100";
            }
    //获取提交的新的英语成绩：
    String newEnglish=request.getParameter("english");
          if(newEnglish==null)
            {newEnglish="-100";
            }
     //获取提交的新的物理成绩：
     String newPhysics=request.getParameter("physics");
          if(newPhysics==null)
            {newPhysics="-100";
            } 
    Connection con=null;
    Statement sql=null;
    ResultSet rs=null;
    String number,xingming;
    int math,english,physics;
       try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          }
       catch(ClassNotFoundException e){}
       try {con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
       sql=con.createStatement();
       String condition1=
              "UPDATE students SET 数学成绩 = "+newMath+" WHERE 姓名="+"'"+name+"'" ,
              condition2=
              "UPDATE students SET 英语成绩 = "+newEnglish+" WHERE 姓名="+"'"+name+"'" ,
              condition3=
              "UPDATE students SET 物理成绩 = "+newPhysics+" WHERE 姓名="+"'"+name+"'" ;
       //执行更新操作：
       sql.executeUpdate(condition1);
       sql.executeUpdate(condition2);
       sql.executeUpdate(condition3);
       //显示更新后的表中的记录：
     %>
     <P>更新后的表的记录：
     <%
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
           {
             out.print("<TR>");
                 number=rs.getString(1);
                 out.print("<TD >"+number+"</TD>"); 
                 xingming=rs.getString(2);
                 out.print("<TD >"+xingming+"</TD>");
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
    catch(SQLException e)
     { }
 %>
</FONT>
</BODY>
</HTML>