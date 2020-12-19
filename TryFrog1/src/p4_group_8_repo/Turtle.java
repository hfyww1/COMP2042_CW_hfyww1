package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * Turtle class shows the floating turtles
 * @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
 * @since   2020-12-18
 */
public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private int speed;
	boolean bool = true;
	@Override
	public void act(long now) {
		if (now/900000000  % 3 == 0) {
			setImage(turtle2);
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtle1);
		}
		else if (now/900000000 %3 == 2) {
			setImage(turtle3);
		}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public Turtle(int xpos, int ypos, int s, int w) {
		turtle1 = new Image("file:src/media/TurtleAnimation1.png", w, w, true, true);
		turtle2 = new Image("file:src/media/TurtleAnimation2.png", w, w, true, true);
		turtle3 = new Image("file:src/media/TurtleAnimation3.png", w, w, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
