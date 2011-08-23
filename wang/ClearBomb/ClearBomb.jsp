<%@ page contentType="text/html;charset=gb2312"%>
<HTML>
<BODY bgcolor=cyan><font size=3>
<P> 扫雷界面
<br>
<form action="" method=post>
<P>请输入横坐标：
<input type="text" name="x" >
<br>
<P>请输入纵坐标：
<input type="text" name="y">
<br>
<br>
<input type="submit" value="dig" name="submit1">
<input type="submit" value="mark" name="submit2">
</form>

<%
    char Bomb_Show[][]=new char[5][5];
    int bombnum[][]=new int[5][5];
    int t=0;
%>
<%
     
    for(int i=0;i<5;i++)
    for(int j=0;j<5;j++)
    bombnum[i][j]=0;

    while(t<8)
   {
      int p=(int)(Math.random()*5);
      int q=(int)(Math.random()*5);
      if(bombnum[p][q]==-1)
      continue;

      bombnum[p][q]=-1;
      t++;
   }


  int a[][]=new int[7][7];
  for(int i=0;i<7;i++)
  for(int j=0;j<7;j++)
  a[i][j]=0;
  

  for(int i=1;i<6;i++)
  for(int j=1;j<6;j++)
  a[i][j]=bombnum[i-1][j-1];

  for(int i=1;i<6;i++)
  for(int j=1;j<6;j++)
  {
    if(a[i][j]!=-1)
    {
        if(a[i-1][j-1]==-1) bombnum[i-1][j-1]++;
        if(a[i-1][j]==-1)   bombnum[i-1][j-1]++;
        if(a[i-1][j+1]==-1) bombnum[i-1][j-1]++;
        if(a[i][j-1]==-1)   bombnum[i-1][j-1]++;
        if(a[i][j+1]==-1)   bombnum[i-1][j-1]++;
        if(a[i+1][j-1]==-1) bombnum[i-1][j-1]++;
        if(a[i+1][j]==-1)   bombnum[i-1][j-1]++;
        if(a[i+1][j+1]==-1) bombnum[i-1][j-1]++;
     }
   }

 

    for(int i=0;i<5;i++)
    for(int j=0;j<5;j++)
	{
	    Bomb_Show[i][j]='$';
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
	    
        if(bombnum[x][y]==-1)
       {
	        for(int i=0;i<5;i++)
           for(int j=0;j<5;j++)
	      {
             if(bombnum[i][j]==-1)
             Bomb_Show[i][j]='*';
		  }
		  
           for(int i=0;i<5;i++)
           {
               for(int j=0;j<5;j++)
               out.print(Bomb_Show[i][j]+" ");
               out.print("<BR>");
            }
          
          out.print("很遗憾，你闯关失败"+"<BR>");
          
        }
       else
       {
           Bomb_Show[x][y]=(char)('0'+bombnum[x][y]);
           for(int i=0;i<5;i++)
           {
               for(int j=0;j<5;j++)
               out.print(Bomb_Show[i][j]+" ");
               out.print("<BR>");
            }
         
           out.print("请继续输入数据"+"<BR>");
        } 
    }
	
	if(str2!=null)
	{
	   Bomb_Show[x][y]='!';
	   
	   for(int i=0;i<5;i++)
       {
          for(int j=0;j<5;j++)
          out.print(Bomb_Show[i][j]+" ");
          out.print("<BR>");
       }
	 }
	
	
%>
           
</body>
<html>




