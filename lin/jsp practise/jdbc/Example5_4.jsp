<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.sql.*" %>
<HTML>
<BODY>
 <% String xuehao,name;
    int math;
    Connection con;
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
         out.print("<Table Border>");
         out.print("<TR>");
             out.print("<TH width=100>"+"ѧ��");
             out.print("<TH width=100>"+"����");
             out.print("<TH width=50>"+"��ѧ�ɼ�");
         out.print("</TR>");
        //���α��ƶ������һ�У�
            rs.last();
        //��ȡ���һ�е��кţ�
          int lownumber=rs.getRow();
        //��ȡ��¼����
        int number=lownumber;
        double sum=0;
        int ��ȡ��Ŀ=4;
        int old_i[]={0,0,0,0}; 
        int k=��ȡ��Ŀ;
        int j=0;
           while(��ȡ��Ŀ>0)
                {int i=(int)(Math.random()*number+1);//�����ȡһ��1��number֮�������
                 boolean boo=false;
                 for(int m=0;m<old_i.length;m++)   //���Ҹ����Ƿ��ѱ�ȡ����
                      {if(i==old_i[m])
                       boo=true;
                      }
                 if(boo)  continue;   //��������ѱ�ȡ������������ѭ������������������� 
                 rs.absolute(i);                   //�α��Ƶ���һ�С�
                 out.print("<TR>");
                 xuehao=rs.getString(1);              //��ȡ����ѧ���ֶε�ֵ��
                 out.print("<TD >"+xuehao+"</TD>");
                 name=rs.getString(2);              //��ȡ���������ֶε�ֵ��
                 out.print("<TD >"+name+"</TD>");
                 math=rs.getInt("��ѧ�ɼ�");        //��ȡ������ѧ�ɼ��ֶε�ֵ��
                 out.print("<TD >"+math+"</TD>"); 
                 out.print("</TR>") ;
                 sum=sum+math; 
                 ��ȡ��Ŀ--; 
                 old_i[j]=i;        //��¼��ȡ�����кš�
                 j++;      
                }
         out.print("</Table>");
         out.print("ƽ���ɼ��ǣ�"+sum/k);
         con.close();
     }
   catch(SQLException e1) {}
 %>
</BODY>
</HTML>