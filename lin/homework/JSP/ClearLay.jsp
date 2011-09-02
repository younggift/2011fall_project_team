<%@ page contentType="text/html;charset=gb2312"%>
<HTML>
<BODY bgcolor=yellow><font size=3>
<P> CLEARLAY
<br>
<form action="" method=post>
<P>Please input x£º
<input type="text" name="x" >
<br>
<P>Please input y£º
<input type="text" name="y">
<br>
<br>
<input type="submit" value="dig" name="submit1">
<input type="submit" value="mark" name="submit2">
</form>

<%
    char faces[][]=new char[5][5];
    int mines[][]=new int[5][5];
    int t=0;
%>
<%
     
    for(int i=0;i<5;i++)
    for(int j=0;j<5;j++)
    mines[i][j]=0;

    while(t<8)
   {
      int p=(int)(Math.random()*5);
      int q=(int)(Math.random()*5);
      if(mines[p][q]==-1)
      continue;

      mines[p][q]=-1;
      t++;
   }


  int a[][]=new int[7][7];
  for(int i=0;i<7;i++)
  for(int j=0;j<7;j++)
  a[i][j]=0;
  

  for(int i=1;i<6;i++)
  for(int j=1;j<6;j++)
  a[i][j]=mines[i-1][j-1];

  for(int i=1;i<6;i++)
  for(int j=1;j<6;j++)
  {
    if(a[i][j]!=-1)
    {
        if(a[i-1][j-1]==-1) mines[i-1][j-1]++;
        if(a[i-1][j]==-1)   mines[i-1][j-1]++;
        if(a[i-1][j+1]==-1) mines[i-1][j-1]++;
        if(a[i][j-1]==-1)   mines[i-1][j-1]++;
        if(a[i][j+1]==-1)   mines[i-1][j-1]++;
        if(a[i+1][j-1]==-1) mines[i-1][j-1]++;
        if(a[i+1][j]==-1)   mines[i-1][j-1]++;
        if(a[i+1][j+1]==-1) mines[i-1][j-1]++;
     }
   }

 

    for(int i=0;i<5;i++)
    for(int j=0;j<5;j++)
	{
	    faces[i][j]='_';
    }

%>

<%
    String px=request.getParameter("x");
    String py=request.getParameter("y");
    String str1=request.getParameter("submit1");
    String str2=request.getParameter("submit2");
    int x=Integer.parseInt(px);
    int y=Integer.parseInt(py);
    if(str1!=null)
    {
	    
        if(mines[x][y]==-1)
       {
	        for(int i=0;i<5;i++)
           for(int j=0;j<5;j++)
	      {
             if(mines[i][j]==-1)
             faces[i][j]='*';
		  }
		  
           for(int i=0;i<5;i++)
           {
               for(int j=0;j<5;j++)
               out.print(faces[i][j]+" ");
               out.print("<BR>");
            }
          
          out.print("GAMEOVER"+"<BR>");
          
        }
       else
       {
           faces[x][y]=(char)('0'+mines[x][y]);
           for(int i=0;i<5;i++)
           {
               for(int j=0;j<5;j++)
               out.print(faces[i][j]+" ");
               out.print("<BR>");
            }
         
           out.print("CONTINUE"+"<BR>");
        } 
    }
	
	if(str2!=null)
	{
	   faces[x][y]='!';
	   
	   for(int i=0;i<5;i++)
       {
          for(int j=0;j<5;j++)
          out.print(faces[i][j]+" ");
          out.print("<BR>");
       }
	 }
	
	
%>
           
</body>
<html>




