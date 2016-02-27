import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

	public Player(int x, int y, int w, int h, BufferedImage p) {
		super(x, y, w, h, p);
	}

	public void update() {

	}

	public void paintComponent(Graphics g) {
		g.drawImage(picture, x++, y, width, height, null);
	}
}
