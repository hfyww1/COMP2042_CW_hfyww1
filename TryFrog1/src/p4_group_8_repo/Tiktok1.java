package p4_group_8_repo;

import javafx.scene.image.Image;

public class Tiktok1 extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Tiktok1(long n, int dim, int x) {	//made because n needs to be long
		im1 = new Image("file:src/media/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(20);
	}
	
}
