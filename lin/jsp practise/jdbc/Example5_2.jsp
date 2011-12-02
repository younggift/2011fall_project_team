<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
 <% Connection con;
    Statement sql; 
    ResultSet rs;
    try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
    catch(ClassNotFoundException e){}
    try { con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
         sql=con.createStatement();
         rs=sql.executeQuery("SELECT * FROM students WHERE ”¢”Ô≥…º® >= 80 ");
         out.print("<Table Border>");
         out.print("<TR>");
            out.print("<TH width=100>"+"–’√˚");
            out.print("<TH width=50>"+"”¢”Ô≥…º®");
         out.print("</TR>");
       while(rs.next())
       { out.print("<TR>");
             out.print("<TD >"+rs.getString(2)+"</TD>");
             out.print("<TD >"+rs.getInt("”¢”Ô≥…º®")+"</TD>");
         out.print("</TR>") ; 
        }
        out.print("</Table>");
        con.close();
     }
   catch(SQLException e1) {}
 %>
</BODY>
</HTML>