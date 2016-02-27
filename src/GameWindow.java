import javax.swing.JFrame;

public class GameWindows
{
	JFrame frame;
	JPanelWindows panel;

	public static void main(String[] args)
	{
		GameWindows w = new GameWindows();
		w.createUI();

	}

	public void createUI()
	{
		frame = new JFrame();
		frame.setVisible(true);
		panel = new JPanelWindows();
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		;
	}

}
Status API Training Shop Blog About Pricing
