package p4_group_8_repo;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
//import javafx.animation.AnimationTimer;
//import javafx.util.Duration;
//import javafx.scene.image.Image;

public class MyStage extends World{
	MediaPlayer mediaPlayer;
	//AnimationTimer timer;
	public boolean press = false;
	public boolean changeMute = false;
	boolean start = false;
	public Image img;
	public String imageLink;
	@Override
	public void act(long now) {
		
	}
	
	
	public MyStage() {
//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				//if (!start) {
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
	/*public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	
	public void start() {
		//background.playMusic();
    	createTimer();
        timer.start();
    } */
	
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
