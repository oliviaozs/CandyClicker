import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	Timer t;
	BufferedImage image;
	BufferedImage enemyImage;
	BufferedImage playerImage;
	GameObject player;
	GameObject enemy;
	ArrayList<GameObject> objects;

	public GamePanel() {
		
		try {
			enemyImage = ImageIO.read(this.getClass().getResourceAsStream("raincloud.jpg"));
			playerImage = ImageIO.read(this.getClass().getResourceAsStream("bird.jpg"));
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		
		player = new Player(0,0,100,100, playerImage);
		enemy = new Enemy(100, 100, 100, 100, enemyImage);
		
		objects = new ArrayList<GameObject>();
		objects.add(player);
		objects.add(enemy);
		
		t = new Timer(1000 / 60, this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		for (GameObject go: objects){
			go.paintComponent(g);
		}
	}
	
	public void update(){
		for(GameObject go: objects){
			go.update();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}

}