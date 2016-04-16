import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class Candy extends JButton {
	int id;
	int x;
	int y;
	int width;
	int height;
	BufferedImage picture;

	public Candy(int x, int y, int w, int h, BufferedImage p, int id) {
		super();
		this.x =x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.picture = p;
		this.id = id;
		setBounds(x,y,width,height);
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
		if (e.getX() > x && e.getX() < (x + width) && e.getY() > y && e.getY() < (y + height)) {
			GamePanel.latestID = id;
		}

	}
}
