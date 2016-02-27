import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.teachingextensions.logo.Colors;

public class GamePanel extends JPanel implements ActionListener
{
	Timer t;
	BufferedImage image;
	GameObject object;
	
	public GamePanel()
	{
		t = new Timer(1000/60, this);
		t.start();
		try
		{
			image = ImageIO.read(this.getClass().getResourceAsStream("t.png"));
		}
		catch(Exception e)
		{
			System.out.println("IT DIDNT WORK");
		}
		object = new GameObject(100,100,275, 285,image);
	}
	
	public void paint(Graphics g)
	{
		object.paint(g);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}

}