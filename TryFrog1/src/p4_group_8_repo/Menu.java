package p4_group_8_repo;

import javafx.scene.image.Image;

public class Menu extends Actor {
	Image menu;
	@Override
	public void act(long now) {
		
	}
	
	public Menu(String imageLink) {
		setImage(new Image(imageLink, 600, 900, true, true));
		//menu = new Image("file:src/p4_group_8_repo/StartScreen.png");
		//setImage(menu);
	}
}
