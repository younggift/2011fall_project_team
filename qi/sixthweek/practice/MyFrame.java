import javax.swing.*;  //JFrame在包javax.swing中，导入后该包中所有类都可以使用

public class MyFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("MyFrame"); //指定框架的标题，标题将出现在框架的标题栏内
		frame.setSize(400,300);   //指定框架宽和高的像素，如果没有该行框架将恰好显示标题栏
		frame.setVisible(true);   //应用该方法以前框架不会显示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //该句是告知程序当框架关闭时结束程序，如果不使用该条语句，框架关闭程序不会结束

	}

}
