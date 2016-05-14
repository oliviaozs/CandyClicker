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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.colorchooser.ColorSelectionModel;

public class GamePanel extends JPanel implements ActionListener {
	Timer t;
	Color highlightColor;
	Color randomColor;
	public static int latestID;
	int random;
	int highlightedCandy;
	int candyClicked;
	int counter = 1;
	long startTime = -1;
	int index = 0;
	int displayPhase = 0;
	int inputPhase = 1;
	int currentPhase = displayPhase;
	int waitTime = 800;
	int lastSelected = -1;
	int numWrong = 0;
	boolean register = true;

	SoundPlayer correctSound;
	SoundPlayer wrongSound;
	SoundPlayer levelUp;

	BufferedImage blueImage;
	BufferedImage greenImage;
	BufferedImage orangeImage;
	BufferedImage redImage;

	Candy greenCandy;
	Candy blueCandy;
	Candy orangeCandy;
	Candy redCandy;

	ArrayList<Candy> candies;
	ArrayList<Integer> randomNums;

	public GamePanel() {
		randomNums = new ArrayList<Integer>();
		random = new Random().nextInt(4);
		randomNums.add(random);
		highlightedCandy = random;
		randomColor = Utilities.getRandomColor();

		try {
			blueImage = ImageIO.read(this.getClass().getResourceAsStream("blue.png"));
			greenImage = ImageIO.read(this.getClass().getResourceAsStream("green.png"));
			orangeImage = ImageIO.read(this.getClass().getResourceAsStream("orange.png"));
			redImage = ImageIO.read(this.getClass().getResourceAsStream("red.png"));

			correctSound = new SoundPlayer("correct.wav");
			wrongSound = new SoundPlayer("wrong.wav");
			levelUp = new SoundPlayer("levelup.wav");
		} catch (Exception e) {
			System.out.println("ERROR");
		}

		greenCandy = new Candy(50, 50, 150, 150, greenImage, 0);
		blueCandy = new Candy(300, 50, 150, 150, blueImage, 1);
		orangeCandy = new Candy(50, 300, 150, 150, orangeImage, 2);
		redCandy = new Candy(300, 300, 150, 150, redImage, 3);

		candies = new ArrayList<Candy>();
		candies.add(greenCandy);
		candies.add(blueCandy);
		candies.add(orangeCandy);
		candies.add(redCandy);

		t = new Timer(1000 / 60, this);
		t.start();
	}

	public void paintComponent(Graphics g) {
		if (currentPhase == displayPhase) {
			g.setColor(randomColor);
		} else if (currentPhase == inputPhase){
			g.setColor(highlightColor);
		}
			if (highlightedCandy == 0) {
				greenCandy.setWidth(200);
				greenCandy.setHeight(200);
				greenCandy.setX(25);
				greenCandy.setY(25);
				g.fillRect(0, 0, 250, 250);
			} else if (highlightedCandy == 1) {
				blueCandy.setWidth(200);
				blueCandy.setHeight(200);
				blueCandy.setX(275);
				blueCandy.setY(25);
				g.fillRect(250, 0, 250, 250);
			} else if (highlightedCandy == 2) {
				orangeCandy.setWidth(200);
				orangeCandy.setHeight(200);
				orangeCandy.setX(25);
				orangeCandy.setY(275);
				g.fillRect(0, 250, 250, 250);
			} else if (highlightedCandy == 3) {
				redCandy.setWidth(200);
				redCandy.setHeight(200);
				redCandy.setX(275);
				redCandy.setY(275);
				g.fillRect(250, 250, 250, 250);
			}

		for (Candy go : candies) {
			go.paintComponent(g);
		}
	}

	public void update() {
		if (currentPhase == displayPhase) {

			if (startTime == -1) {
				startTime = System.currentTimeMillis();

			}
			if (System.currentTimeMillis() - startTime >= waitTime) {
				for (Candy go: candies) {
					go.setWidth(150);
					go.setHeight(150);
					if (go.getID() == 0){
						go.setX(50);
						go.setY(50);
					} else if (go.getID() == 1){
						go.setX(300);
						go.setY(50);
					} else if (go.getID()==2){
						go.setX(50);
						go.setY(300);
					} else if (go.getID() == 3){
						go.setX(300);
						go.setY(300);
					}
				}
				startTime = -1;
				if (counter < randomNums.size()) {
					randomColor = Utilities.getRandomColor();
					highlightedCandy = randomNums.get(counter++);
				} else {
					currentPhase = inputPhase;
					counter = 0;
					highlightedCandy = -1;
					latestID = -1;
				}
			}
		} else if (currentPhase == inputPhase) {
			if (startTime == -1 && latestID !=-1) {
				startTime = System.currentTimeMillis();
				highlightedCandy = latestID;
				register = false;
			} 
			if (System.currentTimeMillis() - startTime >= 700) {
					register = true;
					latestID = -1;
					startTime = -1;
					highlightedCandy = latestID;
					for (Candy go: candies) {
						go.setWidth(150);
						go.setHeight(150);
						if (go.getID() == 0){
							go.setX(50);
							go.setY(50);
						} else if (go.getID() == 1){
							go.setX(300);
							go.setY(50);
						} else if (go.getID()==2){
							go.setX(50);
							go.setY(300);
						} else if (go.getID() == 3){
							go.setX(300);
							go.setY(300);
						}
					}
					if (index == randomNums.size()) {
						if (randomNums.size() % 5 == 0) {
							waitTime -= 75;
						}
						new Thread(new SoundPlayer("levelup.wav")).start();
						System.out.println("adding number");
						randomNums.add(new Random().nextInt(4));
						currentPhase = displayPhase;
						index = 0;
					}
			}
		}

		for (Candy go : candies) {
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

		if (index < randomNums.size() && register) {
			if (latestID == randomNums.get(index)) {
				new Thread(new SoundPlayer("correct.wav")).start();
				highlightColor = Color.GREEN;
				index++;
				System.out.println("correct candy clicked");
				/*if (index == randomNums.size()) {
					if (randomNums.size() % 5 == 0) {
						waitTime -= 75;
					}
					levelUp.run();
					System.out.println("adding number");
					randomNums.add(new Random().nextInt(4));
					currentPhase = displayPhase;
					index = 0;
				}*/
			} else {
				numWrong++;
				if (numWrong == 3) {
					GameWindow.lose(randomNums.size()-1);
				} else {
					new Thread(new SoundPlayer("wrong.wav")).start();
					System.out.println("wrong candy clicked");
					currentPhase = displayPhase;
					index = 0;
				}
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