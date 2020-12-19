package p4_group_8_repo;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * MyStage handles the music
 * @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
 * @since   2020-12-18
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	public boolean press = false;
	public boolean changeMute = false;
	boolean start = false;
	public Image img;
	public String imageLink;
	@Override
	public void act(long now) {
		
	}
	
	
	public MyStage() {	//remove unused media parts
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.M) {	
					if(!changeMute) {
						System.out.println("receive m");
						changeMute = true; //mute
						stopMusic();
					}
					else {
						changeMute = false; //unmute
						playMusic();
					}
	            }
			}
			
		});
	}
	
	public boolean changePic() {
		return changeMute;
	}
	
	public boolean changeToUnmute() {
		return true;
	}
	
	public void playMusic() {
		String musicFile = "src/media/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
