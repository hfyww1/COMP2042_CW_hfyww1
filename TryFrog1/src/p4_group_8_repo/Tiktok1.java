package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * Tiktok1 class is the digital clock's numbers
 * @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
 * @since   2020-12-18
 */
public class Tiktok1 extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Similar to Digit class, this takes a long parameter instead of int
	 * The same yposition for all digits, so it is set inside this class
	 * @param n	long int for 'now' variable
	 * @param dim	size
	 * @param x	x position
	 */
	public Tiktok1(long n, int dim, int x) {	//made because n needs to be long
		im1 = new Image("file:src/media/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(20);
	}
	
}
