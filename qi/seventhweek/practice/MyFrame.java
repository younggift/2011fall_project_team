import javax.swing.*;  //JFrame�ڰ�javax.swing�У������ð��������඼����ʹ��

public class MyFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("MyFrame"); //ָ����ܵı��⣬���⽫�����ڿ�ܵı�������
		frame.setSize(400,300);   //ָ����ܿ�͸ߵ����أ����û�и��п�ܽ�ǡ����ʾ������
		frame.setVisible(true);   //Ӧ�ø÷�����ǰ��ܲ�����ʾ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //�þ��Ǹ�֪���򵱿�ܹر�ʱ�������������ʹ�ø�����䣬��ܹرճ��򲻻����

	}

}
