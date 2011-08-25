<%@ page contentType="text/html;charset=gb2312"%>
<HTML>
<BODY bgcolor=yellow><font size=4>
<P>WELCOME!
<BR>
<form action="" method=post>
<P> Please input the row: 
<input type="text" name="x" >
<BR>
<P> Please input the col: 
<input type="text" name="y" >
<BR>
<BR>
<input type="submit" value="dig" name="submitdig">
<input type="submit" value="mark" name="submitmark">
</form>

<%
    char face[][]=new char[10][10];
    int mines[][]=new int[10][10];
    int number=0;
%>

<%
    for(int i=0;i<10;i++)
    for(int j=0;j<10;j++)
    mines[i][j]=0;

    while(number<10){
      int i=(int)(Math.random()*10);
      int j=(int)(Math.random()*10);
      if(mines[i][j]==-1)
      continue;
      mines[i][j]=-1;
      number++;
    }

    for(int i=0;i<10;i++)
    for(int j=0;j<10;j++){
      face[i][j]='_';
    }

   for(int i=0;i<10;i++){  
   for(int j=0;j<10;j++){  
     if(mines[i][j]!=-1){  
         int mineNum=0;  
         if((i-1)>=0&&(i-1)<10&&(j-1)>=0&&(j-1)<10){
            if(mines[i-1][j-1]==-1) 
                mineNum++;   
         }
         if((i-1)>=0&&(i-1)<10&&j>=0&&j<10){
            if(mines[i-1][j]==-1)   
                mineNum++;  
         }  
         if((i-1)>=0&&(i-1)<10&&(j+1)>=0&&(j+1)<10){
            if(mines[i-1][j+1]==-1)
                mineNum++;  
         }
         if(i>=0&&i<10&&(j-1)>=0&&(j-1)<10){
            if(mines[i][j-1]==-1)   
                mineNum++;  
         }
         if(i>=0&&i<10&&(j+1)>=0&&(j+1)<10){
            if(mines[i][j+1]==-1)
                mineNum++;
         }
         if((i+1)>=0&&(i+1)<10&&(j-1)>=0&&(j-1)<10){
            if(mines[i+1][j-1]==-1)  
                mineNum++;
         }
         if((i+1)>=0&&(i+1)<10&&j>=0&&j<10){
            if(mines[i+1][j]==-1)  
                mineNum++;  
         } 
         if((i+1)>=0&&(i+1)<10&&(j+1)>=0&&(j+1)<10){
            if (mines[i+1][j+1]==-1) 
                mineNum++;  
         }  
         mines[i][j] = mineNum;  
      }  
   }  
   } 
%>

<%
    String str1=request.getParameter("submitdig");
    String str2=request.getParameter("submitmark");
    String px=request.getParameter("x");
    String py=request.getParameter("y");
    int xx=Integer.parseInt(px);
    int yy=Integer.parseInt(py);
    if(str1!=NULL){
        out.print("The Location You Want To Dig is:" + xx + yy );
        out.print("<BR>");
        if(mines[xx][yy]==-1){
           for(int i=0;i<10;i++){
              for(int j=0;j<10;j++){
                 if(mines[i][j]==-1)
                   face[i][j]='*';
              }
           }
	   out.print("**********************");  
           out.print("<BR>");  
           for(int i=0;i<10;i++){  
               out.print(" "+i);  
           }  
           out.print("<BR>");  
           for (int i=0;i<10;i++){  
               out.print(i);  
               for(int j=0;j<10;j++){
                   out.print(" "+ face[i][j]);  
               }  
               out.print("<BR>");  
           }  
           out.print("**********************");  
           out.print("<BR>");
           out.println("Game Over!"+"<BR>");
        }
        else{
           face[xx][yy]=(char)('0'+mines[xx][yy]);
           out.print ("**********************");  
           out.print("<BR>");  
           for(int i=0;i<10;i++){  
               out.print(" "+i);  
           }  
           out.print("<BR>");  
           for(int i=0;i<10;i++){  
               out.print(i);  
               for (int j=0;j<10;j++){  
                   out.print(" "+ face[i][j]);  
               }  
               out.print("<BR>");  
           }  
           out.print ("**********************");  
           out.print("<BR>");
           out.println("Congratulation!"+"<BR>");
        } 
    }

    if(str2!=null){
	face[xx][yy]='#';
        out.print ("**********************");  
        out.print("<BR>");  
        for(int i=0;i<10;i++){  
            out.print(" "+i);  
        }  
        out.print("<BR>");  
        for(int i=0;i<10;i++){  
            out.print(i);  
            for (int j=0;j<10;j++){  
                out.print(" "+ face[i][j]);  
            }  
            out.print("<BR>");  
        }  
        out.print ("**********************");  
        out.print("<BR>");
    }
%> 
</BODY>
<HTML>

