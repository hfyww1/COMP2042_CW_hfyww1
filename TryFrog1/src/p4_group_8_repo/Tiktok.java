package p4_group_8_repo;

import javafx.scene.image.Image;	

public class Tiktok extends Actor{
	int passed = 0, check = 0;
	long temp, temp1, dur;	//temp holds beginning and end, dur is duration in rough seconds
	Image clock;
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
	
	public void tock() {
		check = 2;
		//System.out.printf("tock check %d\n", temp);
	}

	public long give() {
		return dur;
	}
}
