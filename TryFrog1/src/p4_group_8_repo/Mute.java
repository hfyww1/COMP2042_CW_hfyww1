package p4_group_8_repo;

import javafx.scene.image.Image;

public class Mute extends Actor {
	Image mute;
	Image unmute;
	//MyStage background;
	//boolean changeMute = false;
	
	public Mute(String imageLink, int size, int xpos, int ypos, int s) {
		setImage(new Image(imageLink, size, size, true, true));
		setX(xpos);
		setY(ypos);
		
		mute = new Image("file:src/p4_group_8_repo/mute.png", 40, 40, true, true);
		unmute = new Image("file:src/p4_group_8_repo/unmute.png", 40, 40, true, true);
		
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
