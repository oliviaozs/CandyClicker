import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer implements Runnable{
	String file;
	
	public SoundPlayer(String f){
		this.file = f;
	}
	
	@Override
	public void run() {
		try {
			File sound = new File(file);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength()/1000);
		} catch (Exception e) {
			System.err.println("couldn't find the sound");
		}
		
		
	}

}
