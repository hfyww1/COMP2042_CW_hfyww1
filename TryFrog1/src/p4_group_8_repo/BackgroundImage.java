package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * Background image sets the background
 * @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
 * @since   2020-12-18
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
	}
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 900, true, true)); //change width to fit window
	}

}
