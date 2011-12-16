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
    //获取提交的姓名：
    String name=request.getParameter("name");
          if(name==null)
            {name="";
            }
     byte c[]=name.getBytes("ISO-8859-1");
     name=new String(c);
     //获取提交的新的数学成绩：
    String m=request.getParameter("math");
          if(m==null)
            {m="-100"; }
    //获取提交的新的英语成绩：
    String e=request.getParameter("english");
          if(e==null)
            {e="-100"; }
     //获取提交的新的物理成绩：
     String p=request.getParameter("physics");
          if(p==null)
            {p="-100"; } 
    Connection con=null;
    Statement sql=null;
    ResultSet rs=null;
       try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); }
       catch(ClassNotFoundException event){}
   try {con=DriverManager.getConnection("jdbc:odbc:moon","sa","");
       sql=con.createStatement();
       String condition=
       "INSERT INTO students VALUES"+"("+"'"+number+"','"+name+"',"+m+","+e+","+p+")";
       sql.executeUpdate(condition); //执行添加操作：
       //显示添加新记录后表中的记录：
     %>
     <P>添加新记录后的表：
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
     { }
 %>
</FONT>
</BODY>
</HTML>