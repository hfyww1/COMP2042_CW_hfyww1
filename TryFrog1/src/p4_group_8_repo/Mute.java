package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * Mute class extends actor and changes images according to muted or unmuted
 * @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
 * @since   2020-12-18
 */
public class Mute extends Actor {
	Image mute;
	Image unmute;
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
