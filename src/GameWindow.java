import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameWindow implements MouseListener {
	static JFrame frame;
	GamePanel panel;
	JButton repeatPattern;

	public static void main(String[] args) {
		GameWindow w = new GameWindow();
		JOptionPane.showMessageDialog(null, "Your goal:\nRepeat the pattern.\nIf you miss more than three times, you lose!");
		w.createUI();
	}

	public void createUI() {
		frame = new JFrame("Repeat the pattern!");
		frame.addMouseListener(this);
		panel = new GamePanel();
		//finish this and add restart button
		repeatPattern = new JButton("Repeat the pattern");
		panel.add(repeatPattern);
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void lose(int score){
		frame.setVisible(false);
		JOptionPane.showMessageDialog(null, "You lose!\nYour score: "+score);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
