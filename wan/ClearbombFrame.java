 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ClearbombFrame extends JFrame
{
	
 
  JButton start = new JButton(" ��ʼ ");
  JPanel MenuPanel = new JPanel();
  JPanel bombPanel = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();
   Bomb[][] bombButton;
  public ClearbombFrame()
	{
    	 super("ɨ��"); 
  JPanel MainPanel=(JPanel) getContentPane();
    MainPanel.add(MenuPanel, java.awt.BorderLayout.SOUTH);
	 bombButton=new Bomb [100][100];
      for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        bombButton[i][j] = new Bomb();
        bombPanel.add(bombButton[i][j]);
      }
    }
    MainPanel.add(bombPanel, java.awt.BorderLayout.CENTER);

      
	}
	public static void main(String[] args) 
	{
		ClearbombFrame app =new ClearbombFrame();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
	}
}
class Bomb extends JButton
{
int x,y;  //��¼�����λ��
boolean  Clic;//�Ƿ���
int BomNumber;  //��ʾ�ܱߵ�����
} 