import java.awt.Color;
import java.util.Random;

public class Utilities {
	
	 public static Color getRandomColor()
	  {
		 Random RANDOM = new Random();
	    return new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));
	  }
}
