<%@ page contentType="text/html; charset=gb2312" %>

<%@ page language="java" %>

<%@ page import="com.mysql.jdbc.Driver" %>

<%@ page import="java.sql.*" %>

<%

//驱动程序名

String driverName="com.mysql.jdbc.Driver";

//数据库用户名

String userName="root";

//密码

String userPasswd="goucrutaif";

//数据库名

String dbName="mysql";

//表名

String tableName="db";

//联结字符串

String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;

Class.forName("com.mysql.jdbc.Driver").newInstance();

Connection connection=DriverManager.getConnection(url);

Statement statement = connection.createStatement();

String sql="SELECT * FROM "+tableName;

ResultSet rs = statement.executeQuery(sql); 

//获得数据结果集合

ResultSetMetaData rmeta = rs.getMetaData();

//确定数据集的列数，亦字段数

int numColumns=rmeta.getColumnCount();

// 输出每一个数据值

out.print("id"); 

out.print("|");

out.print("num");

out.print("<br>");

while(rs.next()) {

out.print(rs.getString(1)+" "); 

out.print("|");

out.print(rs.getString(2));

out.print("<br>"); 

} 

out.print("<br>");

out.print("数据库操作成功，恭喜你"); 

rs.close(); 

statement.close(); 

connection.close(); 

%>