package p4_group_8_repo;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Animal class handles the players frog movement and interactions
 * @author  Wan Hanna Monisha binti Wan Nurnizam, 20052342
 * @since   2020-12-18
 */

public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	int points = 0;
	int end = 0;
	private boolean second = false; //flips between jumping and non jumping pic
	boolean noMove = false;
	double movement = 26.6666666; //13.3333333*2;
	double movementX = 21.333332; //10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean changeScore = false;
	int df = 0; //change variable name from carD to understand image flip count
	double w = 800; //score limit
	ArrayList<End> inter = new ArrayList<End>();
	public Animal() {
		setImage(new Image("file:src/media/froggerUp.png", imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/media/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/media/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/media/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/media/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/media/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/media/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/media/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/media/froggerRightJump.png", imgSize, imgSize, true, true);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				KeyCode g = event.getCode();	//pressed key
				if (!noMove){
					if (second) {
						if (g == KeyCode.W) {	  
			                move(0, -movement);
			                changeScore = false;
			                setImage(imgW1);
			            }
			            else if (g == KeyCode.A) {	            	
			            	 move(-movementX, 0);
			            	 setImage(imgA1);
			            }
			            else if (g == KeyCode.S) {	            	
			            	 move(0, movement);
			            	 setImage(imgS1);
			            }
			            else if (g == KeyCode.D) {	            	
			            	 move(movementX, 0);
			            	 setImage(imgD1);
			            }
						second = false;	//move second outside embedded if else
					}
					else {
						if (g == KeyCode.W) {	            	
			                move(0, -movement);
			                setImage(imgW2);
			            }
			            else if (g == KeyCode.A) {	            	
			            	 move(-movementX, 0);
			            	 setImage(imgA2);
			            }
			            else if (g == KeyCode.S) {	            	
			            	 move(0, movement);
			            	 setImage(imgS2);
			            }
			            else if (g == KeyCode.D) {	            	
			            	 move(movementX, 0);
			            	 setImage(imgD2);
			            }
						second = true;	//move second outside embedded if else
					}
				} //if no move end
			}
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				KeyCode g = event.getCode();	//released key
				if (!noMove) {
					if (g == KeyCode.W) {	  
						if (getY() < w) {	//w is highest score
							changeScore = true;
							w = getY();
							points+=10;
						}
		                move(0, -movement);
		                setImage(imgW1);
		            }
		            else if (g == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            }
		            else if (g == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            }
		            else if (g == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				} //if no move end curly
			}
			
		});
	}
	
	@Override
	public void act(long now) {
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 == 0) {
				df++;
			}
			switch(df){	//set switch case
				case 1:
					setImage(new Image("file:src/media/cardeath1.png", imgSize, imgSize, true, true));
					break;
				case 2:
					setImage(new Image("file:src/media/cardeath2.png", imgSize, imgSize, true, true));
					break;
				case 3:
					setImage(new Image("file:src/media/cardeath3.png", imgSize, imgSize, true, true));
					break;
				case 4:
					setX(300);
					setY(679.8+movement);
					carDeath = false;
					df = 0;
					setImage(new Image("file:src/media/froggerUp.png", imgSize, imgSize, true, true));
					noMove = false;
					if (points>50) {
						points-=50;
						changeScore = true;
					}
					break;
			}
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				df++;
			}
			switch(df) {	//set switch case
				case 1:
					setImage(new Image("file:src/media/waterdeath1.png", imgSize,imgSize , true, true));
					break;
				case 2:
					setImage(new Image("file:src/media/waterdeath2.png", imgSize,imgSize , true, true));
					break;
				case 3:
					setImage(new Image("file:src/media/waterdeath3.png", imgSize,imgSize , true, true));
					break;
				case 4:
					setImage(new Image("file:src/media/waterdeath4.png", imgSize,imgSize , true, true));
					break;
				case 5:
					setX(300);
					setY(679.8+movement);
					waterDeath = false;
					df = 0;
					setImage(new Image("file:src/media/froggerUp.png", imgSize, imgSize, true, true));
					noMove = false;
					if (points>50) {
						points-=50;
						changeScore = true;
					}
					break;
					
			}
		}
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		
		//if intersect with car, cardeath
		if (getIntersectingObjects(Obstacle.class).size() >= 1) { //touching snake gives car death
			carDeath = true;
		}
		//remove useless if
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
			//no need to set positions, already declared
		}
	}
	public boolean getStop() {	//end = how many end spots are filled
		return end==5;
	}
	
	public int upgrade() {	//called by main to know when to level up
		return end;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
	

}
