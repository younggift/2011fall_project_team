<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY bgcolor=pink ><Font size=1>
  <% //��ȡ�ύ��ѧ�ţ�
    String number=request.getParameter("number");
          if(number==null)
            {number="";
            }
     byte b[]=number.getBytes("ISO-8859-1");
     number=new String(b);
    //��ȡ�ύ��������
    String name=request.getParameter("name");
          if(name==null)
            {name="";
            }
     byte c[]=name.getBytes("ISO-8859-1");
     name=new String(c);
     //��ȡ�ύ���µ���ѧ�ɼ���
    String m=request.getParameter("math");
          if(m==null)
            {m="-100"; }
    //��ȡ�ύ���µ�Ӣ��ɼ���
    String e=request.getParameter("english");
          if(e==null)
            {e="-100"; }
     //��ȡ�ύ���µ������ɼ���
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
       sql.executeUpdate(condition); //ִ�����Ӳ�����
       //��ʾ�����¼�¼����еļ�¼��
     %>
     <P>�����¼�¼��ı���
     <%
       rs=sql.executeQuery("SELECT * FROM students ORDER BY ѧ�� ");
       out.print("<Table Border>");
            out.print("<TR>");
            out.print("<TH width=100>"+"ѧ��");
            out.print("<TH width=100>"+"����");
            out.print("<TH width=50>"+"��ѧ�ɼ�");
            out.print("<TH width=50>"+"Ӣ��ɼ�");
            out.print("<TH width=50>"+"�����ɼ�");
            out.print("</TR>");
       while(rs.next())
           {    out.print("<TR>");
                String n=rs.getString(1);
                 out.print("<TD >"+n+"</TD>"); 
                String xingming=rs.getString(2);
                 out.print("<TD >"+xingming+"</TD>");
                int  math=rs.getInt("��ѧ�ɼ�"); 
                 out.print("<TD >"+math+"</TD>"); 
                int english=rs.getInt("Ӣ��ɼ�"); 
                 out.print("<TD >"+english+"</TD>");
                int physics=rs.getInt("�����ɼ�"); 
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