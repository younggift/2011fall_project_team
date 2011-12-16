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
    try { con=DriverManager.getConnection("jdbc:odbc:star","","");
         sql=con.createStatement();
         rs=sql.executeQuery("SELECT * FROM 品名 ");
         out.print("<Table Border>");
         out.print("<TR>");
            out.print("<TH width=100>"+"品名");
            out.print("<TH width=50>"+"单位");
            out.print("<TH width=50>"+"单价");
         out.print("</TR>");
       while(rs.next())
       { out.print("<TR>");
            String name=rs.getString(1); 
             out.print("<TD >"+name+"</TD>");
            String  unit=rs.getString(2); 
             out.print("<TD >"+unit+"</TD>");
            String  unitprice=rs.getString(3); 
            out.print("<TD >"+unitprice+"</TD>");
         out.print("</TR>") ;          
        }
        out.print("</Table>");
        con.close();
     }
   catch(SQLException e1) {}
 %>
</BODY>
</HTML>