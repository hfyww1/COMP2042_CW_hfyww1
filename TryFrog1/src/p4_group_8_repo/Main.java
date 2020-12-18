package p4_group_8_repo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;	//for key press
//import java.util.List;
import java.io.PrintWriter;

//	import com.sun.glass.events.KeyEvent;	//for key press

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.text.Text;
import javafx.stage.Stage;
//import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer, ticktock; //timer makes sure everything follows each other, ticktock is for round time
	MyStage start, background, music; //start
	Tiktok clock;
	Tiktok1 sec0, sec1, min0, colon;
	Animal animal;
	Actor fastcar, fastcar2, fastcar3, botlog, snake, snake1, botturtle;
	Level lebel;
	Mute unmute;
	boolean strt = false;
	int level, temp = -1, passed;
	long tik, tok, k;
	double compareScore;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		    start = new MyStage();
		    Scene menu  = new Scene(start,600,800);
		    Menu froggerStart = new Menu("file:src/p4_group_8_repo/StartScreen.png"); //add background
			start.add(froggerStart);
			primaryStage.setScene(menu);
			primaryStage.show();
			primaryStage.setResizable(false);	//make sure the window doesnt move
			
			start.setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if (event.getCode() == KeyCode.SPACE) {	
						System.out.println("receive space");
						background = new MyStage();
					    Scene scene  = new Scene(background,600,800);
					    
						BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/iKogsKW.png"); //add background
						background.add(froggerback);	//CAN RENAME THIS?
						
						background.add(new End(13,96));
						background.add(new End(141,96));
						background.add(new End(269,96)); //remove redundant additions
						background.add(new End(398,96));
						background.add(new End(528,96));
						
						//top logs
						background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
						background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 220, 166, 0.75));
						background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 440, 166, 0.75));

						//mid logs
						background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 0, 276, -2));
						background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 400, 276, -2));

						//bottom logs
						botlog = new Log("file:src/p4_group_8_repo/log3.png", 150, 50, 329, 0.75);
						background.add(botlog);
						background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 270, 329, 0.75));
						background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 490, 329, 0.75));
						
							
						//width and height are the same, remove one variable
						botturtle = new Turtle(500, 376, -1, 130);
						background.add(botturtle);
						background.add(new Turtle(300, 376, -1, 130));
						background.add(new WetTurtle(700, 376, -1, 130));
						background.add(new WetTurtle(600, 217, -1, 130));
						background.add(new WetTurtle(400, 217, -1, 130));
						background.add(new WetTurtle(200, 217, -1, 130));
						
						//width and height are the same, remove one variable
						background.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 0, 649, 1, 120)); //remove redundant string
						background.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 300, 649, 1, 120));
						background.add(new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 600, 649, 1, 120));
						background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 597, -1, 50));
						background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 250, 597, -1, 50));
						background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 400, 597, -1, 50));
						background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 550, 597, -1, 50));
						background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 540, 1, 200));
						background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 540, 1, 200));
						
						fastcar = new Obstacle("file:src/p4_group_8_repo/car1Left.png", 0, 490, -5, 50);
						background.add(fastcar);
						background.add(new Digit(0, 30, 550, 25)); //change third digit to move score away from title, adjusted in 139
						
						animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");	//CAN RENAME THIS?
						background.add(animal);
						
						background.start();
						
						lebel = new Level(270, 750, 100);
				    	background.add(lebel);
				    	
				    	clock = new Tiktok(40, 225, 20);
				    	background.add(clock);
				    	
				    	colon = new Tiktok1(10, 40, 315, 20);
						background.add(colon);
						sec0 = new Tiktok1(0, 40, 390, 20);
						background.add(sec0);
						sec1 = new Tiktok1(0, 40, 350, 20);
						background.add(sec1);
						min0 = new Tiktok1(0, 40, 285, 20);
						background.add(min0);
						
						createTicktock();
						ticktock.start();
						
						primaryStage.setScene(scene);
						primaryStage.show();
						
						background.playMusic();
						unmute = new Mute("file:src/p4_group_8_repo/unmute.png", 40, 450, 25, 150);
						background.add(unmute);
						
						try {
							start();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
				}
				
			});
			
			    
			
		}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if(clock.give() > 0) {
	            	setNumberClock(clock.give());
	            }
            	level = animal.upgrade();
            	if(temp!=level) {	//there so that it doesnt keep printing
            		System.out.printf("The level is %d\n" , level+1);
            		switch(level) {
            		case 1:
            			levelTwo();
            			break;
            		case 2:
            			levelThree();
            			break;
            		case 3:
            			levelFour();
            			break;
            		case 4:
            			levelFive();
            			break;
            		}
            		temp = level;
            	}
            	if(background.changePic()) {	//receive changing mute from MyStage
            		unmute.picMute();	//change mute picture accordingly
            	}
            	else {
            		unmute.picUnmute();
            	}
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getPoints() > compareScore) {
            		setNumber(animal.getPoints());
            		if (animal.getPoints() > compareScore) {
            			try {
    						writeScore(animal.getPoints());
    					} catch (IOException e) {
    						e.printStackTrace();
    					}
            		}
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }

	public void createTicktock() {	//animation timer for each round
		ticktock = new AnimationTimer() {
            @Override
            public void handle(long now) {
            }
		};
	}
	
	public void stopwatch() {	//reset round timer
		System.out.println("stopwatch()");
		clock.tock();
    	ticktock.stop();
    	background.remove(clock);
    	background.add(clock);
    	ticktock.start();
    	System.out.println("end stopwatch()");
	}
	
	public void start() throws IOException{
    	createTimer();
        timer.start();
        readScore();
    }

    public void stop() {
        timer.stop();
    }
    
    private void writeScore(int newScore) throws IOException {

 	   File output = new File("C:\\Users\\Monisha\\Desktop\\Soft Maint\\cw\\scores.txt");
 	   FileWriter writer = new FileWriter(output);
 	   PrintWriter printWriter = new PrintWriter(writer);
 	   
 	   printWriter.printf("%d", newScore);
 	   printWriter.close();
    }//END of write method
    
    //read HighScore from scores.txt file
     //make "compareScore" a global variable, compare and save "max" in WRITE
    private void readScore() throws IOException {
 	   int i, space = 0, power = 2;
 	   try (FileReader hiscore = new FileReader("C:\\Users\\Monisha\\Desktop\\Soft Maint\\cw\\scores.txt")) {
 		   while ((i = hiscore.read()) != -1) {
 			   int char2int = (char)i - '0';
 			   background.add(new Digit(char2int, 30, 30, 30));
 			   space-=20;
 			   compareScore = (Math.pow(10, power)) * char2int;
 			   power--;
 		   }
 	   }
 	   catch(IOException e) {
 		   System.out.println("no file");
 		   background.add(new Digit(0, 166, 30, 30));
 	   }
    }//END of read method
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 550 - shift, 25));
    		  shift+=30;
    		}
    }
    
    public void setNumberClock(long n) {
    	if (n > 0) {
    		  long d = n / 10;
    		  k = n - d * 10;
    		  n = d;
    		  background.remove(sec0);
    		  sec0 = new Tiktok1(k, 40, 390, 20);	//seconds in 1 unit
    		  background.add(sec0);
    		  background.remove(sec1);
    		  sec1 = new Tiktok1(n, 40, 350, 20);	//seconds in 10 unit
    		  background.add(sec1);
    	}
    }
    
    public void levelTwo() {	//new fast car, remove one bottom log
    	System.out.println("enter level 2");
    	lebel.incrA();
    	stopwatch();
    	background.remove(fastcar);
    	background.remove(botlog);
    	fastcar2 = new Obstacle("file:src/p4_group_8_repo/car2.png", 300, 490, -5, 50); //add new car
    	background.add(fastcar);
    	background.add(fastcar2);
    }
    
    public void levelThree() {	//fast cars faster, snake
    	lebel.incrA();
    	stopwatch();
    	background.remove(fastcar);
    	background.remove(fastcar2);
    	fastcar = new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 490, -6, 50);
    	fastcar2 = new Obstacle("file:src/p4_group_8_repo/car2.png", 300, 490, -6, 50);
    	background.add(fastcar);
		background.add(fastcar2);
		snake = new Snake("file:src/p4_group_8_repo/snake.png", 0, 440, -2, 50);
		background.add(snake);
    }
    
    public void levelFour() {	//1 more fast car, 1 less bottom turtle
    	lebel.incrA();
    	stopwatch();
    	background.remove(fastcar);
    	background.remove(fastcar2);
    	fastcar3 = new Obstacle("file:src/p4_group_8_repo/car2.png", 450, 490, -6, 50);
    	background.add(fastcar);
		background.add(fastcar2);
		background.add(fastcar3);
		background.remove(botturtle);
    }
    
    public void levelFive() {	//1 more snake
    	lebel.incrA();
    	stopwatch();
    	background.remove(snake);
    	snake1 = new Snake("file:src/p4_group_8_repo/snake.png", 300, 440, -2, 50);
		background.add(snake);
		background.add(snake1);
    }
    
    

}