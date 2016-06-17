import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameWindow implements MouseListener, ActionListener {
	static JFrame frame;
	GamePanel panel;

	public static void main(String[] args) {
		GameWindow w = new GameWindow();
		JOptionPane.showMessageDialog(null, "Your goal:\nRepeat the pattern.\nIf you miss more than three times, you lose!");
		w.createUI();
	}

	public void createUI() {
		frame = new JFrame("Candy Clicker");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(this);
		panel = new GamePanel();
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static void lose(int score){
		frame.dispose();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
