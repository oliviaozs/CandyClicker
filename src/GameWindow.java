import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameWindow implements MouseListener {
	static JFrame frame;
	GamePanel panel;

	public static void main(String[] args) {
		GameWindow w = new GameWindow();
		JOptionPane.showMessageDialog(null, "your goal: repeat the pattern\nif you miss more than three times, you lose!");
		w.createUI();
	}

	public void createUI() {
		frame = new JFrame("repeat the pattern!");
		frame.addMouseListener(this);
		panel = new GamePanel();
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void lose(int score){
		frame.setVisible(false);
		JOptionPane.showMessageDialog(null, "you lose!\nyour score: "+score);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		panel.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
