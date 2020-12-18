package p4_group_8_repo;

import javafx.scene.image.Image;

public class Mute extends Actor {
	Image mute;
	Image unmute;
	//MyStage background;
	//boolean changeMute = false;
	
	public Mute(int size, int xpos, int ypos) {
		mute = new Image("file:src/media/mute.png", 40, 40, true, true);
		unmute = new Image("file:src/media/unmute.png", 40, 40, true, true);
		setImage(unmute);
		setX(xpos);
		setY(ypos);
	}
	
	public void picMute() {
		setImage(mute);
	}
	
	public void picUnmute() {
		setImage(unmute);
	}
	
	@Override
	public void act(long now) {
		
	}
}
