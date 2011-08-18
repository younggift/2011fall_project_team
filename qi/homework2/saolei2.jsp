<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
 <head>
    <title>My JSP 'practice2.jsp' starting page</title>


  </head>
  
  <body BGCOLOR=pink>
    <% 
      int [][]lei=new int [5][5];
      char [][]jiemian=new char[5][5];
      for(int i=0;i<5;i++)
      for(int j=0;j<5;j++)
      {
          lei[i][j]=0;
      }
      int sum=0;
      while(sum<5){
          int x;
          int y;
          x=(int)(Math.random()*5);
          y=(int)(Math.random()*5);
          if(lei[x][y]==-1)
          continue;
          lei[x][y]=-1;
          sum++;
      }
   /*
      for(int i=0;i<5;i++){
      
      for(int j=0;j<5;j++)
      {
         out.print("&nbsp"+lei[i][j]);
     }
     out.print("<br>");
     }*/
for(int i=0;i<5;i++)
for(int j=0;j<5;j++){
  jiemian[i][j]='+';
}
      String s1 = request.getParameter("x");
      String s2 = request.getParameter("y");
      int xx=Integer.parseInt(s1);
      int yy=Integer.parseInt(s2);   
     out.print("您要挖的雷的位置横坐标为 :" + xx +"<br>");		
     out.print("您要挖的雷的位置纵坐标为: "+ yy +"<br>");	
    if(lei[xx][yy]==-1){
           for(int i=0;i<5;i++)
           for(int j=0;j<5;j++)
           {
           if(lei[i][j]==-1)
               jiemian[i][j]='*';
          }
          for(int i=0;i<5;i++){         
          for(int j=0;j<5;j++)        
          {
                out.print(" "+jiemian[i][j]);
          }
          out.print("<br>");
          }
          out.print("很遗憾，游戏失败了");
       }
       else{
          for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
          if(lei[i][j]!=-1){
                   int number=0;
                   if((i-1)>=0&&(i-1)<5&&(j-1)>=0&&(j-1)<5){
                         if(lei[i-1][j-1]==-1) number++;
                   }
                   if((i-1)>=0&&(i-1)<5&&j>=0&&j<5){
                         if(lei[i-1][j]==-1) number++;
                   } 
                   if((i-1)>=0&&(i-1)<5&&(j+1)>=0&&(j+1)<5){
                         if(lei[i-1][j+1]==-1) number++;
                   }      
                   if(i>=0&&i<5&&(j-1)>=0&&(j-1)<5){
                         if(lei[i][j-1]==-1) number++;
                   }     
                   if(i>=0&&i<5&&(j+1)>=0&&(j+1)<5){
                         if(lei[i][j+1]==-1) number++;
                   }   
                   if((i+1)>=0&&(i+1)<5&&(j-1)>=0&&(j-1)<5){
                         if(lei[i+1][j-1]==-1) number++;
                   } 
                   if((i+1)>=0&&(i+1)<5&&j>=0&&j<5){
                         if(lei[i+1][j]==-1) number++;
                   } 
                   if((i+1)>=0&&(i+1)<5&&(j+1)>=0&&(j+1)<5){
                         if(lei[i+1][j+1]==-1) number++;
                   }  
                   lei[i][j]=number;             
          }
      }
      }
    
              jiemian[xx][yy]=(char)(lei[xx][yy]+'0');
  
           for(int i=0;i<5;i++){         
          for(int j=0;j<5;j++)        
          {
                out.print(" "+jiemian[i][j]);
          }
          out.print("<br>");
          }
} 
%>
  </body>
</html>
