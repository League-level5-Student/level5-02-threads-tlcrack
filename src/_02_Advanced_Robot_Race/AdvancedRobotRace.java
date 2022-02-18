package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static Random r = new Random();
	static int z = 0;
	static int w = 0;
	static Robot[] rob = new Robot[5];

	static int winner = 0;
	static boolean finished = false;
	
	public static void main(String[] args) {

		for (int i = 0; i < rob.length; i++) {
			rob[i] = new Robot("mini");
			rob[i].setSpeed(10);
			rob[i].penDown();
		}
		for (int s = 0; s < 5; s++) {
			rob[s].setX(s * 20 + 200);
			rob[s].setY(250);
		}
		

		Thread racer = new Thread(()->race());
		
		while (finished == false) {
			for (w = 0; w < 5; w++) {
				racer.start();
				try {
					racer.join();
				}
				catch(Exception e) {
					
				}
				if(finished==true) {
					break;
				}
			}
		}
		System.out.println("robot#" + winner + " is the winner!");
	}
	static void race() {
		for (z = r.nextInt(50); z > 0; z--) {
			rob[w].move(1);
			rob[w].turn(1);
			if (rob[w].getX() == w * 20 + 200 && rob[w].getY() == 250) {
				finished = true;
				winner = w + 1;
				break;
			}
		}
	}
}
