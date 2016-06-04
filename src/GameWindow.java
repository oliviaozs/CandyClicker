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
	static JFrame gameFrame;
	JFrame startFrame;
	JPanel startPanel;
	GamePanel panel;
	JButton instructions;
	JButton startGame;

	public static void main(String[] args) {
		GameWindow w = new GameWindow();
		w.start();
	}

	public void createUI() {
		gameFrame = new JFrame("Candy Clicker");
		gameFrame.addMouseListener(this);
		panel = new GamePanel();
		gameFrame.add(panel);
		gameFrame.setSize(500, 500);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
	}
	
	public void start(){
		startFrame = new JFrame("Candy Clicker");
		startFrame.setSize(500, 500);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startPanel = new JPanel();
		instructions = new JButton("Instructions");
		instructions.addActionListener(this);
		startGame = new JButton("Start Game");
		startGame.addActionListener(this);
		startPanel.add(startGame);
		startPanel.add(instructions);
		startFrame.add(startPanel);
		startPanel.setBackground(Color.ORANGE);
		startFrame.setVisible(true);
	}
	
	public static void lose(int score){
		gameFrame.dispose();
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
		if ((JButton) e.getSource() == instructions){
			JOptionPane.showMessageDialog(null, "Your goal:\nRepeat the pattern.\nIf you miss more than three times, you lose!");
		} else if ((JButton) e.getSource() == startGame){
			startFrame.dispose();
			createUI();
		}
		
	}

}
