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
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public void setWidth(int w){
		this.width = w;
	}
	
	public void setHeight(int h){
		this.height = h;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(picture, x, y, width, height, null);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getX() > (x-50) && e.getX() < (x + width+50) && e.getY() > (y-50) && e.getY() < (y + height+50)) {
			GamePanel.latestID = id;
		}

	}
}
