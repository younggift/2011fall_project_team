<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
 <head>
    <title>My JSP 'frame2.jsp' starting page</title>
  </head>
    <body BGCOLOR=yellow>
<% 
      int [][]lei=new int [5][5];
      char [][]jiemian=new char[5][5];
      for(int i=0;i<5;i++){
      for(int j=0;j<5;j++)
      {
          lei[i][j]=0;
      }
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
for(int i=0;i<5;i++){
for(int j=0;j<5;j++){
  jiemian[i][j]='+';
}
}
      String s1 = request.getParameter("x");
      String s2 = request.getParameter("y");
      String str1 = request.getParameter("sub1");
      String str2 = request.getParameter("sub2");
      int xx=Integer.parseInt(s1);
      int yy=Integer.parseInt(s2);   
      if(str1!=null)
      {
           out.print("雷的横坐标为 :" + xx +"<br>");		
           out.print("雷的纵坐标为: "+ yy +"<br>");	
           if(lei[xx][yy]==-1){
                for(int i=0;i<5;i++){
                for(int j=0;j<5;j++)
                {
                   if(lei[i][j]==-1)
                   jiemian[i][j]='*';
                }
                }
                for(int i=0;i<5;i++){         
                for(int j=0;j<5;j++)        
                {
                     out.print(" "+jiemian[i][j]);
                }
                out.print("<br>");
                }
                out.print("游戏失败");
            }
            else{
              for(int i=0;i<5;i++){
                  for(int j=0;j<5;j++){
                                      if(lei[i][j]!=-1)
                                                      {
                                                     int number=0;
                                      if((i-1)>=0&&(i-1)<5&&(j-1)>=0&&(j-1)<5)
                                                       {
                                      if(lei[i-1][j-1]==-1) 
                                                  number++;
                                                       }
                                      if((i-1)>=0&&(i-1)<5&&j>=0&&j<5){
                                      if(lei[i-1][j]==-1) number++; } 
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
    }
          if(str2!=null)
          {
            jiemian[xx][yy]='P';
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
