package p4_group_8_repo;

//highscore file
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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
		    Menu froggerStart = new Menu("file:src/media/StartScreen.png"); //add start screen background
			start.add(froggerStart);
			primaryStage.setScene(menu);
			primaryStage.show();
			primaryStage.setResizable(false);	//make sure the window doesnt move from set size
			
			start.setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if (event.getCode() == KeyCode.SPACE) {	
						System.out.println("receive space");
						background = new MyStage();
					    Scene scene  = new Scene(background,600,800);
					    
						BackgroundImage froggerback = new BackgroundImage("file:src/media/iKogsKW.png"); //add background
						background.add(froggerback);	
						
						background.add(new End(13,96));
						background.add(new End(141,96));
						background.add(new End(269,96)); //remove redundant additions
						background.add(new End(398,96));
						background.add(new End(528,96));
						
						//top logs
						background.add(new Log("file:src/media/log3.png", 150, 0, 166, 0.75));
						background.add(new Log("file:src/media/log3.png", 150, 220, 166, 0.75));
						background.add(new Log("file:src/media/log3.png", 150, 440, 166, 0.75));

						//mid logs
						background.add(new Log("file:src/media/logs.png", 300, 0, 276, -2));
						background.add(new Log("file:src/media/logs.png", 300, 400, 276, -2));

						//bottom logs
						botlog = new Log("file:src/media/log3.png", 150, 50, 329, 0.75);
						background.add(botlog);
						background.add(new Log("file:src/media/log3.png", 150, 270, 329, 0.75));
						background.add(new Log("file:src/media/log3.png", 150, 490, 329, 0.75));
						
							
						//width and height are the same, remove one variable
						botturtle = new Turtle(500, 376, -1, 130);
						background.add(botturtle);
						background.add(new Turtle(300, 376, -1, 130));
						background.add(new WetTurtle(700, 376, -1, 130));
						background.add(new WetTurtle(600, 217, -1, 130));
						background.add(new WetTurtle(400, 217, -1, 130));
						background.add(new WetTurtle(200, 217, -1, 130));
						
						//width and height are the same, remove one variable
						background.add(new Obstacle("file:src/media/truck1Right.png", 0, 649, 1, 120)); //remove redundant string
						background.add(new Obstacle("file:src/media/truck1Right.png", 300, 649, 1, 120));
						background.add(new Obstacle("file:src/media/truck1Right.png", 600, 649, 1, 120));
						background.add(new Obstacle("file:src/media/car1Left.png", 100, 597, -1, 50));
						background.add(new Obstacle("file:src/media/car1Left.png", 250, 597, -1, 50));
						background.add(new Obstacle("file:src/media/car1Left.png", 400, 597, -1, 50));
						background.add(new Obstacle("file:src/media/car1Left.png", 550, 597, -1, 50));
						background.add(new Obstacle("file:src/media/truck2Right.png", 0, 540, 1, 200));
						background.add(new Obstacle("file:src/media/truck2Right.png", 500, 540, 1, 200));
						
						fastcar = new Obstacle("file:src/media/car1Left.png", 0, 490, -5, 50);
						background.add(fastcar);
						background.add(new Digit(0, 30, 550, 45)); //change third digit to move score away from title, adjusted in 139
						
						animal = new Animal();
						background.add(animal);
						
						background.start();
						
						lebel = new Level();
				    	background.add(lebel);
				    	
				    	clock = new Tiktok(40, 175);
				    	background.add(clock);
				    	
				    	colon = new Tiktok1(10, 40, 265);
						background.add(colon);
						sec0 = new Tiktok1(0, 40, 340);
						background.add(sec0);
						sec1 = new Tiktok1(0, 40, 300);
						background.add(sec1);
						min0 = new Tiktok1(0, 40, 235);
						background.add(min0);
						
						createTicktock();
						ticktock.start();
						
						primaryStage.setScene(scene);
						primaryStage.show();
						
						background.playMusic();
						unmute = new Mute(40, 390, 25);
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
    						write(animal.getPoints());
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
		clock.tock();
    	ticktock.stop();
    	background.remove(clock);
    	background.add(clock);
    	ticktock.start();
	}
	
	public void start() throws IOException{
    	createTimer();
        timer.start();
        read();
    }

    public void stop() {
        timer.stop();
    }
    
    //write a score.txt in package
    private void write(int newScore) throws IOException {	//write score into file
 	   File output = new File("src/p4_group_8_repo/scores.txt");
 	   FileWriter filewriter = new FileWriter(output);
 	   PrintWriter printwriter = new PrintWriter(filewriter);
 	   printwriter.printf("%d", newScore);
 	   printwriter.close();
    }
    
   //read highscore from score.txt and compare to current player to save
    private void read() throws IOException {
 	   int i, g = 2, space = 30;
 	   try (FileReader hs = new FileReader("src/p4_group_8_repo/scores.txt")) {	//high score
 		   while ((i = hs.read()) != -1) {
 			   int char2int = (char)i - '0';	//change to integer
 			   System.out.println((char)i);
 			   background.add(new Digit(char2int, 30, space, 45));
 			   compareScore = (Math.pow(10, g)) * char2int;
 			   g--;	//sets single unit, tens unit, hundreds
 			   space = space+30;	//this prints in the units next to each other
 		   }
 	   }
 	   catch(IOException e) {
 		   System.out.println("Error: cannot find .txt file");
 		   background.add(new Digit(0, 30, space+20, 45));
 	   }
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 550 - shift, 45));
    		  shift+=30;
    		}
    }
    
    public void setNumberClock(long n) {	//store time of previous round
    	if (n > 0) {
    		  long d = n / 10;
    		  k = n - d * 10;
    		  n = d;
    		  background.remove(sec0);
    		  sec0 = new Tiktok1(k, 40, 340);	//seconds in 1 unit
    		  background.add(sec0);
    		  background.remove(sec1);
    		  sec1 = new Tiktok1(n, 40, 300);	//seconds in 10 unit
    		  background.add(sec1);
    	}
    }
    
    public void levelTwo() {	//new fast car, remove one bottom log
    	System.out.println("enter level 2");
    	lebel.incrA();
    	stopwatch();
    	background.remove(fastcar);
    	background.remove(botlog);
    	fastcar2 = new Obstacle("file:src/media/car2.png", 300, 490, -5, 50); //add new car
    	background.add(fastcar);
    	background.add(fastcar2);
    }
    
    public void levelThree() {	//fast cars faster, snake
    	lebel.incrA();
    	stopwatch();
    	background.remove(fastcar);
    	background.remove(fastcar2);
    	fastcar = new Obstacle("file:src/media/car1Left.png", 100, 490, -6, 50);
    	fastcar2 = new Obstacle("file:src/media/car2.png", 300, 490, -6, 50);
    	background.add(fastcar);
		background.add(fastcar2);
		snake = new Obstacle("file:src/media/snake.png", 0, 440, -2, 50);
		background.add(snake);
    }
    
    public void levelFour() {	//1 more fast car, 1 less bottom turtle
    	lebel.incrA();
    	stopwatch();
    	background.remove(fastcar);
    	background.remove(fastcar2);
    	fastcar3 = new Obstacle("file:src/media/car2.png", 450, 490, -6, 50);
    	background.add(fastcar);
		background.add(fastcar2);
		background.add(fastcar3);
		background.remove(botturtle);
    }
    
    public void levelFive() {	//1 more snake
    	lebel.incrA();
    	stopwatch();
    	background.remove(snake);
    	snake1 = new Obstacle("file:src/media/snake.png", 300, 440, -2, 50);
		background.add(snake);
		background.add(snake1);
    }
    
    

}
