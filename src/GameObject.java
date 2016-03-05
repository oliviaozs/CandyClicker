import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GameObject {
	int x, y, width, height;
	BufferedImage picture;
	

	public GameObject(int x, int y, int w, int h, BufferedImage p) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.picture = p;

	}

	public void update() {

	}

	public void paintComponent(Graphics g) {
		g.drawImage(picture, x, y, width, height, null);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}