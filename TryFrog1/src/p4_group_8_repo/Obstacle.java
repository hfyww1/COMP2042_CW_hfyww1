package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * Obstacle class shows the vehicles and snake
 * @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
 * @since   2020-12-18
 */
public class Obstacle extends Actor {	//these are vehicles
	private int speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w) {
		setImage(new Image(imageLink, w, w, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
