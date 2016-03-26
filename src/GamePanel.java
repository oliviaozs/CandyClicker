import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.colorchooser.ColorSelectionModel;

public class GamePanel extends JPanel implements ActionListener {
	Timer t;
	Color randomColor;
	public static int latestID;
	int random;
	int highlightedCandy;
	int counter = 1;
	long startTime = -1;
	int index = 0;
	int displayPhase = 0;
	int inputPhase = 1;
	int currentPhase = displayPhase;
	boolean guess = false;

	BufferedImage blueImage;
	BufferedImage greenImage;
	BufferedImage orangeImage;
	BufferedImage redImage;

	GameObject greenCandy;
	GameObject blueCandy;
	GameObject orangeCandy;
	GameObject redCandy;

	ArrayList<GameObject> objects;
	ArrayList<Integer> randomNums;

	public GamePanel() {
		randomNums = new ArrayList<Integer>();
		random = new Random().nextInt(4);
		randomNums.add(random);
		highlightedCandy = random;
		random = new Random().nextInt(4);
		randomNums.add(random);
		random = new Random().nextInt(4);
		randomNums.add(random);

		try {
			blueImage = ImageIO.read(this.getClass().getResourceAsStream("blue.png"));
			greenImage = ImageIO.read(this.getClass().getResourceAsStream("green.png"));
			orangeImage = ImageIO.read(this.getClass().getResourceAsStream("orange.png"));
			redImage = ImageIO.read(this.getClass().getResourceAsStream("red.png"));
		} catch (Exception e) {
			System.out.println("ERROR");
		}

		greenCandy = new Candy(50, 50, 150, 150, greenImage, 0);
		blueCandy = new Candy(300, 50, 150, 150, blueImage, 1);
		orangeCandy = new Candy(50, 250, 150, 150, orangeImage, 2);
		redCandy = new Candy(300, 250, 150, 150, redImage, 3);

		objects = new ArrayList<GameObject>();
		objects.add(greenCandy);
		objects.add(blueCandy);
		objects.add(orangeCandy);
		objects.add(redCandy);

		t = new Timer(1000 / 60, this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		if (currentPhase == displayPhase) {
			g.setColor(randomColor);
			if (highlightedCandy == 0) {
				g.fillRect(0, 0, 250, 250);
			} else if (highlightedCandy == 1) {
				g.fillRect(250, 0, 250, 250);
			} else if (highlightedCandy == 2) {
				g.fillRect(0, 250, 250, 250);
			} else if (highlightedCandy == 3) {
				g.fillRect(250, 250, 250, 250);
			}

		} else if (currentPhase == inputPhase) {
			if (guess) {
				g.setColor(Color.GREEN);
				if (highlightedCandy == 0) {
					g.fillRect(0, 0, 250, 250);
				} else if (highlightedCandy == 1) {
					g.fillRect(250, 0, 250, 250);
				} else if (highlightedCandy == 2) {
					g.fillRect(0, 250, 250, 250);
				} else if (highlightedCandy == 3) {
					g.fillRect(250, 250, 250, 250);
				}
			}

		}

		for (GameObject go : objects) {
			go.paintComponent(g);
		}
	}

	public void update() {
		if (currentPhase == displayPhase) {

			if (startTime == -1) {
				startTime = System.currentTimeMillis();

			}
			if (System.currentTimeMillis() - startTime >= 1000) {
				if (counter < randomNums.size()) {

					randomColor = Utilities.getRandomColor();
					highlightedCandy = randomNums.get(counter++);
					startTime = -1;
				} else {
					currentPhase = inputPhase;
					counter = 0;

				}
			}
		} else if (currentPhase == inputPhase) {
			highlightedCandy = latestID;
		}

		for (GameObject go : objects) {
			go.update();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}

	public void mouseClicked(MouseEvent e) {

		blueCandy.mouseClicked(e);
		greenCandy.mouseClicked(e);
		orangeCandy.mouseClicked(e);
		redCandy.mouseClicked(e);
		if (index < randomNums.size()) {
			if (latestID == randomNums.get(index)) {
				guess = true;
				index++;
				System.out.println("correct candy clicked");
				if (index == randomNums.size()) {
					System.out.println("adding number");
					randomNums.add(new Random().nextInt(4));
					currentPhase = displayPhase;//switches to display phase before it makes last clicked candy green
					index = 0;
					guess = false;
				}
			} else {
				guess = false;
				System.out.println("wrong candy clicked");
			}

		}

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}