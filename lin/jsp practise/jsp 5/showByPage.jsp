<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
 <%! int pageSize=3; //ÿҳ��ʾ�ļ�¼����
     int pageCount=0; //��ҳ�����ҳ����
 %> 
<%-- �ͻ�ͨ�����ύ��Ҫ��ʾ��ҳ����--%>
<FORM action="" method=get >
 ����ҳ����<Input Type=text name=showPage size=4 >
   <Input Type=submit name=g value=�ύ>
 </FORM>
<%  Connection con;
    Statement sql; 
    ResultSet rs;
    try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }
    catch(ClassNotFoundException e){}
    try { con=DriverManager.getConnection("jdbc:odbc:sun","sa","");
         sql=
con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //���ؿɹ����Ľ������
         rs=sql.executeQuery("SELECT * FROM students");
        //���α��ƶ������һ�У�
            rs.last();
        //��ȡ���һ�е��кţ�
         int lastRow=rs.getRow();
        //�����ҳ�����ҳ����
        pageCount=(lastRow%pageSize==0)?(lastRow/pageSize):(lastRow/pageSize+1);
        //��ǰ��ʾ�ĳ�ʼҳ����
        int showPage=1;
        //��֪�ͻ���ҳ����
      %>
        <P> ����<%=pageCount%>ҳ
        <BR>ÿҳ��ʾ<%=pageSize%>����¼.
      <% //��ȡ�ͻ���Ҫ��ʾ��ҳ����
          String integer=request.getParameter("showPage");
               if(integer==null)
                  { integer="1";
                  } 
           try {showPage=Integer.parseInt(integer);  
               }
           catch(NumberFormatException e)
               {showPage=1;
               }
          if(showPage<=1)
             {showPage=1;
             }
          if(showPage>=pageCount)
             {showPage=pageCount;
             }
      %>
        <BR>Ŀǰ��ʾ��<%=showPage%>ҳ  
      <% //���Ҫ��ʾ��showPageҳ����ô�α�Ӧ�Ƶ�posion��ֵ�ǣ�
         int posion=(showPage-1)*pageSize+1;
          rs.absolute(posion); // �����α��λ��
          out.print("<Table Border>");
          out.print("<TR>");
            out.print("<TH width=100>"+"ѧ��");
            out.print("<TH width=100>"+"����");
            out.print("<TH width=50>"+"��ѧ�ɼ�");
            out.print("<TH width=50>"+"Ӣ��ɼ�");
            out.print("<TH width=50>"+"����ɼ�");
          out.print("</TR>");
       for (int i=1;i<=pageSize;i++)
        { out.print("<TR>");
             out.print("<TD >"+rs.getString(1)+"</TD>"); 
             out.print("<TD >"+rs.getString(2)+"</TD>");
             out.print("<TD >"+rs.getInt("��ѧ�ɼ�")+"</TD>"); 
             out.print("<TD >"+rs.getInt("Ӣ��ɼ�")+"</TD>");
            out.print("<TD >"+rs.getInt("����ɼ�")+"</TD>");   
         out.print("</TR>") ; 
          rs.next();  
         }
       out.print("</Table>");
      con.close();
     }
   catch(SQLException e1) {}
 %>
</BODY>
</HTML>