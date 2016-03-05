import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
	int id;

	public Player(int x, int y, int w, int h, BufferedImage p, int id) {
		super(x, y, w, h, p);
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public void update() {

	}

	public void paintComponent(Graphics g) {
		g.drawImage(picture, x, y, width, height, null);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getX() > x && e.getX() < (x + width) && e.getY() > y && e.getY() < (y + height)) {
			GamePanel.latestID = id;
		}

	}
}
