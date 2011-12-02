<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
  <% //获取提交的分数的最大值和最小值：
    String englishmax=request.getParameter("englishmax");
          if(englishmax==null)
            {englishmax="100";
            }
    String englishmin=request.getParameter("englishmin");
          if(englishmin==null)
            {englishmin="0";
            }
    String mathmax=request.getParameter("mathmax");
          if(mathmax==null)
            {mathmax="100";
            }
    String mathmin=request.getParameter("mathmin");
          if(mathmin==null)
            {mathmin="0";
            }
    Connection con=null;
    Statement sql=null;
    ResultSet rs=null;
       try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          }
       catch(ClassNotFoundException e){}
       try
      {    con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
           sql=con.createStatement();
           String eCondition="英语成绩 <= "+englishmax+" AND "+"英语成绩 >= "+englishmin;
           String mCondition="数学成绩 <= "+mathmax+" AND "+"数学成绩 >= "+mathmin;
           String condition="SELECT * FROM students WHERE "+mCondition+" and "+eCondition;
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
          {}
%>
</BODY>
</HTML>