<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
 <% String name,number;
    int math,physics,english;
    Connection con;
    Statement sql; 
    ResultSet rs;
    try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
    catch(ClassNotFoundException e){}
    try{ con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
         sql=
con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //���ؿɹ����Ľ������
         rs=sql.executeQuery("SELECT * FROM students");
        //���α��ƶ������һ�У�
            rs.last();
        //��ȡ���һ�е��кţ�
          int lownumber=rs.getRow();
         out.print("�ñ���"+lownumber+"����¼");
         out.print("<BR>�������������¼��");
         out.print("<Table Border>");
         out.print("<TR>");
            out.print("<TH width=100>"+"ѧ��");
            out.print("<TH width=100>"+"����");
            out.print("<TH width=50>"+"��ѧ�ɼ�");
            out.print("<TH width=50>"+"Ӣ��ɼ�");
            out.print("<TH width=50>"+"����ɼ�");
       out.print("</TR>");
       //Ϊ�����������¼���轫�α��ƶ������һ��֮��
        rs.afterLast();
        while(rs.previous())
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
       out.print("���������5����¼<BR>");
        rs.absolute(5);
             number=rs.getString(1); 
             out.print(number+","); 
             name=rs.getString(2); 
             out.print(name+",");
             math=rs.getInt("��ѧ�ɼ�"); 
             out.print(math+","); 
             english=rs.getInt("Ӣ��ɼ�"); 
             out.print(english+",");
             physics=rs.getInt("����ɼ�"); 
             out.print(physics+"��"); 
        con.close();
     }
   catch(SQLException e1) {}
 %>
</BODY>
</HTML>