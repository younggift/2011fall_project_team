<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
  <% //��ȡ�ύ��������
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
             String condition="SELECT * FROM students WHERE ���� = "+"'"+name+"'";
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
           {  }
%>
</BODY>
</HTML>