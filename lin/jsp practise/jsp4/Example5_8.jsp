<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY bgcolor=pink >
<Font size=1>
<FORM action="newResult.jsp" method=post>
����Ҫ�޸ĳɼ���ͬѧ��������<BR>
<Input type="text" name="name">
<BR>�����µ���ѧ�ɼ���
<Input type="text" name="math">
<BR>�����µ�Ӣ��ɼ���
<Input type="text" name="english">
<BR>�����µ������ɼ���
<Input type="text" name="physics">
<BR><Input type="submit" name="b" value="�ύ����">
<P>���ݿ����ǰ�����ݼ�¼�ǣ�
 <% String name,number;
    int math,physics,english;
    Connection con;
    Statement sql; 
    ResultSet rs;
    try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
    catch(ClassNotFoundException e){}
    try{ con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
         sql=con.createStatement();
         rs=sql.executeQuery("SELECT * FROM students");
         out.print("<Table Border>");
         out.print("<TR>");
            out.print("<TH width=100>"+"ѧ��");
            out.print("<TH width=100>"+"����");
            out.print("<TH width=50>"+"��ѧ�ɼ�");
            out.print("<TH width=50>"+"Ӣ��ɼ�");
            out.print("<TH width=50>"+"�����ɼ�");
         out.print("</TR>");
       while(rs.next())
       { out.print("<TR>");
             number=rs.getString(1); 
             out.print("<TD >"+number+"</TD>"); 
             name=rs.getString(2); 
             out.print("<TD >"+name+"</TD>");
             math=rs.getInt("��ѧ�ɼ�"); 
             out.print("<TD >"+math+"</TD>"); 
             english=rs.getInt("Ӣ��ɼ�"); 
             out.print("<TD >"+english+"</TD>");
             physics=rs.getInt("�����ɼ�"); 
             out.print("<TD >"+physics+"</TD>");   
        out.print("</TR>") ; 
        }
        out.print("</Table>");
        con.close();
     }
   catch(SQLException e1) {}
 %>
</Font>
</BODY>
</HTML>