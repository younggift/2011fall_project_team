//ѡ���ļ�ҳ��

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="ReadFile" %> 
<HTML>
<BODY ><Font size=2>
<jsp:useBean id="file" class="ReadFile" scope="session" >
</jsp:useBean>
<jsp:setProperty  name= "file"  property="filePath" param="filePath" />
<P>��Ŀ¼
<jsp:getProperty  name= "file"  property="filePath"  />
�������ļ�:<BR>
<% String name[]=file.listFile();
   for(int i=0;i<name.length;i++)
      {out.print("<BR>"+name[i]);
      }
%>
<Form action=readfile.jsp  method="post">
 <P>�����ļ�������: 
<Input type=text name="fileName" name= "f" >
<Input type=submit value="�ύ">
</Form>
<BR>
<FORM action="filepathselect.jsp" method=post name=form>
<Input type=submit value="����ѡ��Ŀ¼">
</FORM>
</Body>
</HTML>