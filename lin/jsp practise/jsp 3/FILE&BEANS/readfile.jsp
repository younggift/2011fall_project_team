//��ȡ�ļ�����ҳ��

<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="ReadFile" %> 
<HTML>
<BODY ><Font size=2>
<jsp:useBean id="file" class="ReadFile" scope="session" >
</jsp:useBean>
<jsp:setProperty  name= "file"  property="fileName" param="fileName" />
<P>�ļ�
<jsp:getProperty  name= "file"  property="fileName"  />
����������:<BR>
</Font>
<Font size=1>
<% StringBuffer s=file.readFile();
   out.print(s);
%>
<FORM action="filepathselect.jsp" method=post name=form>
<Input type=submit value="����ѡ��Ŀ¼">
</FORM>
<BR>
<FORM action="listfilename.jsp" method=post name=form>
<Input type=submit value="����ѡ���ļ�">
</FORM>
</Body>
</HTML>
