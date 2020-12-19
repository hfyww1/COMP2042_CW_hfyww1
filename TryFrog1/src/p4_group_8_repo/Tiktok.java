package p4_group_8_repo;

import javafx.scene.image.Image;	
/**
 * Tiktok class is the clock image that shows up, and collects the duration of the round
 * @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
 * @since   2020-12-18
 */
public class Tiktok extends Actor{
	int passed = 0, check = 0;
	long temp, temp1, dur;	//temp holds beginning and end, dur is duration in rough seconds
	Image clock;
	/**
	 *The overrided method flips at ends of rounds to calculate duration of previous round
	 *@param check is a check to collect the time count from 'now'
	 *@param now stabilizing time counter
	 */
	@Override
	public void act(long now) {
		if(check == 0) {
			temp = now;
			System.out.printf("begun at %d\n", temp);
			check++;
		}
		if(check == 2) {
			temp1 = now;
			System.out.printf("ends at %d\n", temp1);
			check++;
		}
		if(check == 3) {
			dur = temp1 - temp;
			dur = dur/900000000;
			System.out.printf("duration is %d\n", dur);
			check = 0;
		}
	}
	
	public Tiktok(int size, int xpos) {
		clock = new Image("file:src/media/clock.png", size, size, true, true);
		setImage(clock);
		setX(xpos);
		setY(20);
	}
	
	/**
	 * This method calls to collect the 'now' count
	 */
	public void tock() {
		check = 2;	//flips through what stores 'now'
	}
	
	/**
	 * Main calls this function to receive the duration of time
	 * @return dur
	 */
	public long give() {
		return dur;
	}
}
