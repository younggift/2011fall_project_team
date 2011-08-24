import javax.swing.*;

public class MyFrameWithComponents {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Adding Components into the Frame");
		java.awt.Container container = frame.getContentPane();
                JButton jbtOK = new JButton("OK");
                container.add(jbtOK);
                frame.setSize(400,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}