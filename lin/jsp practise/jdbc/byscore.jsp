<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
  <% //��ȡ�ύ�ķ��������ֵ����Сֵ��
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
           String eCondition="Ӣ��ɼ� <= "+englishmax+" AND "+"Ӣ��ɼ� >= "+englishmin;
           String mCondition="��ѧ�ɼ� <= "+mathmax+" AND "+"��ѧ�ɼ� >= "+mathmin;
           String condition="SELECT * FROM students WHERE "+mCondition+" and "+eCondition;
           rs=sql.executeQuery(condition);
       out.print("<Table Border>");
            out.print("<TR>");
            out.print("<TH width=100>"+"ѧ��");
            out.print("<TH width=100>"+"����");
            out.print("<TH width=50>"+"��ѧ�ɼ�");
            out.print("<TH width=50>"+"Ӣ��ɼ�");
            out.print("<TH width=50>"+"����ɼ�");
            out.print("</TR>");
       while(rs.next())
           { out.print("<TR>");
             out.print("<TD >"+rs.getString(1)+"</TD>"); 
             out.print("<TD >"+rs.getString(2)+"</TD>");
             out.print("<TD >"+rs.getInt("��ѧ�ɼ�")+"</TD>"); 
             out.print("<TD >"+rs.getInt("Ӣ��ɼ�")+"</TD>");
             out.print("<TD >"+rs.getInt("����ɼ�")+"</TD>");   
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