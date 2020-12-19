package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * Digit class handles the score digits
 * @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
 * @since   2020-12-18
 */
public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Remove y parameter as position for all of score digits on the same y plane
	 * Remove dim parameter as the size is set constant for all digits displayed
	 * @param n
	 * @param x
	 */
	public Digit(int n, int x) {
		im1 = new Image("file:src/media/"+n+".png", 30, 30, true, true);
		setImage(im1);
		setX(x);
		setY(45);
	}
	
}
