package p4_group_8_repo;

import javafx.scene.image.Image;

public class Level extends Actor {
	private int speed;
	private int a=1;
	Image l1, l2, l3, l4, l5;
	@Override
	public void act(long now) {
		/*move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);*/
	}
	
	
	public Level(int xpos, int ypos, int w) {
		l1 = new Image("file:src/media/level1.png", w, w, true, true);
		l2 = new Image("file:src/media/level2.png", w, w, true, true);
		l3 = new Image("file:src/media/level3.png", w, w, true, true);
		l4 = new Image("file:src/media/level4.png", w, w, true, true);
		l5 = new Image("file:src/media/level5.png", w, w, true, true);
		setImage(l1);
		setX(xpos);
		setY(ypos);
		//speed = s;
		
		
	}
	public void incrA() {
		a++;
		switch(a) {
		case 1:
			//System.out.printf("level 1 image set");
			setImage(l1);
			break;
		case 2:
			//System.out.printf("level 2 image set");
			setImage(l2);
			break;
		case 3:
			//System.out.printf("level 3 image set");
			setImage(l3);
			break;
		case 4:
			//System.out.printf("level 3 image set");
			setImage(l4);
			break;
		case 5:
			//System.out.printf("level 3 image set");
			setImage(l5);
			break;
		}
	}
	
}
