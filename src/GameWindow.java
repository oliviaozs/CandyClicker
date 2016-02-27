import javax.swing.JFrame;

public class GameWindow {
	JFrame frame;
	GamePanel panel;

	public static void main(String[] args) {
		GameWindow w = new GameWindow();
		w.createUI();

	}

	public void createUI() {
		frame = new JFrame();
		frame.setVisible(true);
		panel = new GamePanel();
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
