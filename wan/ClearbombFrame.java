 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ClearbombFrame extends JFrame
{
	
 
  JButton start = new JButton(" 开始 ");
  JPanel MenuPanel = new JPanel();
  JPanel bombPanel = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();
   Bomb[][] bombButton;
  public ClearbombFrame()
	{
    	 super("扫雷"); 
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
int x,y;  //记录点击的位置
boolean  Clic;//是否点击
int BomNumber;  //显示周边的雷数
} 