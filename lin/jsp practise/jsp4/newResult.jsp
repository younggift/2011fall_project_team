<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY bgcolor=pink ><Font size=1>
  <% //��ȡ�ύ��������
    String name=request.getParameter("name");
          if(name==null)
            {name="";
            }
     byte b[]=name.getBytes("ISO-8859-1");
     name=new String(b);
     //��ȡ�ύ���µ���ѧ�ɼ���
    String newMath=request.getParameter("math");
          if(newMath==null)
            {newMath="-100";
            }
    //��ȡ�ύ���µ�Ӣ��ɼ���
    String newEnglish=request.getParameter("english");
          if(newEnglish==null)
            {newEnglish="-100";
            }
     //��ȡ�ύ���µ�����ɼ���
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
              "UPDATE students SET ��ѧ�ɼ� = "+newMath+" WHERE ����="+"'"+name+"'" ,
              condition2=
              "UPDATE students SET Ӣ��ɼ� = "+newEnglish+" WHERE ����="+"'"+name+"'" ,
              condition3=
              "UPDATE students SET ����ɼ� = "+newPhysics+" WHERE ����="+"'"+name+"'" ;
       //ִ�и��²�����
       sql.executeUpdate(condition1);
       sql.executeUpdate(condition2);
       sql.executeUpdate(condition3);
       //��ʾ���º�ı��еļ�¼��
     %>
     <P>���º�ı�ļ�¼��
     <%
       rs=sql.executeQuery("SELECT * FROM students");
       out.print("<Table Border>");
            out.print("<TR>");
            out.print("<TH width=100>"+"ѧ��");
            out.print("<TH width=100>"+"����");
            out.print("<TH width=50>"+"��ѧ�ɼ�");
            out.print("<TH width=50>"+"Ӣ��ɼ�");
            out.print("<TH width=50>"+"����ɼ�");
            out.print("</TR>");
       while(rs.next())
           {
             out.print("<TR>");
                 number=rs.getString(1);
                 out.print("<TD >"+number+"</TD>"); 
                 xingming=rs.getString(2);
                 out.print("<TD >"+xingming+"</TD>");
                 math=rs.getInt("��ѧ�ɼ�"); 
                 out.print("<TD >"+math+"</TD>"); 
                 english=rs.getInt("Ӣ��ɼ�"); 
                 out.print("<TD >"+english+"</TD>");
                 physics=rs.getInt("����ɼ�"); 
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