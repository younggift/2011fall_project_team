<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY bgcolor=pink >
<Font size=1>
<P>ɾ����¼��
<FORM action="delete.jsp" method=post>
���뱻ɾ����¼��ѧ�ţ�
<Input type="text" name="number">
<BR>
<BR><Input type="submit" name="b" value="�ύɾ��">
</FORM>
<P>���ݿ�ɾ��ǰ�����ݼ�¼�ǣ�
 <% String name,number;
    int math,physics,english;
    Connection con;
    Statement sql; 
    ResultSet rs;
    try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
    catch(ClassNotFoundException e){}
    try { con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
         sql=con.createStatement();
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
       { out.print("<TR>");
             number=rs.getString(1); 
             out.print("<TD >"+number+"</TD>"); 
             name=rs.getString(2); 
             out.print("<TD >"+name+"</TD>");
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
   catch(SQLException e1) {}
 %>
</Font>
</BODY>
</HTML>