package p4_group_8_repo;

import javafx.scene.image.Image;

public class Level extends Actor {
	private int a=1;
	Image l1, l2, l3, l4, l5;
	@Override
	public void act(long now) {
	}
	
	
	public Level() {
		l1 = new Image("file:src/media/level1.png", 100, 100, true, true);
		l2 = new Image("file:src/media/level2.png", 100, 100, true, true);
		l3 = new Image("file:src/media/level3.png", 100, 100, true, true);
		l4 = new Image("file:src/media/level4.png", 100, 100, true, true);
		l5 = new Image("file:src/media/level5.png", 100, 100, true, true);
		setImage(l1);
		setX(270);
		setY(750);
		
		
	}
	public void incrA() {
		a++;
		switch(a) {
		case 1:
			setImage(l1);
			break;
		case 2:
			setImage(l2);
			break;
		case 3:
			setImage(l3);
			break;
		case 4:
			setImage(l4);
			break;
		case 5:
			setImage(l5);
			break;
		}
	}
	
}
