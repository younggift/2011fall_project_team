<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
  <% //��ȡ�ύ������ʽ��
    String name=request.getParameter("R");
          if(name==null)
            {name="";}
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
     try { con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
         sql=con.createStatement();
         String condition="SELECT * FROM students ORDER BY "+name;
         rs=sql.executeQuery(condition);
         out.print("<Table Border>");
            out.print("<TR>");
            out.print("<TH width=100>"+"ѧ��");
            out.print("<TH width=100>"+"����");
            out.print("<TH width=50>"+"��ѧ�ɼ�");
            out.print("<TH width=50>"+"Ӣ��ɼ�");
            out.print("<TH width=50>"+"�����ɼ�");
            out.print("<TH width=50>"+"�ܳɼ�");
            out.print("</TR>");
           while(rs.next())
             { out.print("<TR>");
               number=rs.getString(1); 
               out.print("<TD >"+number+"</TD>"); 
               xingming=rs.getString(2); 
               out.print("<TD >"+xingming+"</TD>");
               math=rs.getInt("��ѧ�ɼ�"); 
               out.print("<TD >"+math+"</TD>"); 
               english=rs.getInt("Ӣ��ɼ�"); 
               out.print("<TD >"+english+"</TD>");
               physics=rs.getInt("�����ɼ�"); 
               out.print("<TD >"+physics+"</TD>"); 
               int total=math+english+physics;
               out.print("<TH >"+total+"</TH>"); 
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