 import java.awt.Font;
import java.awt.TextArea;
import javax.swing.JFrame;
public final class one_for extends JFrame {
	private static final long serialVersionUID = 1L;
	TextArea textArea = new TextArea();
	one_for() {

		super("0.0");
		this.add(textArea);
		nine();
		textArea.setEnabled(false);// 设置的是不可用
		textArea.setFont(new Font("", Font.LAYOUT_RIGHT_TO_LEFT, 15));
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(920, 210);
	}
	public void nine() {
		for (int i = 1, j = 1; i <= 9; j++) {
			textArea.append(j + "*" + i + "=" + j * i + " \t&");
			if (i == j) {
				i++;
				j = 0;
				textArea.append("\n");
			}
		}
	}
	public static void main(String[] args) {
		new one_for();
	}
}
