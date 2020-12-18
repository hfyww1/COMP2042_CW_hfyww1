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
			System.out.printf("temp %d\n", temp);
			check++;
		}
		if(check == 2) {
			temp1 = now;
			System.out.printf("temp1 %d\n", temp1);
			check++;
		}
		if(check == 3) {
			dur = temp1 - temp;
			dur = dur/900000000;
			System.out.printf("duration is %d\n", dur);
			check = 0;
		}
	}
	
	public Tiktok(int size, int xpos, int ypos) {
		clock = new Image("file:src/p4_group_8_repo/clock.png", size, size, true, true);
		setImage(clock);
		setX(xpos);
		setY(ypos);
	}
	
	public void tock() {
		check = 2;
		System.out.printf("tock check %d\n", temp);
	}

	public long give() {
		return dur;
	}
}