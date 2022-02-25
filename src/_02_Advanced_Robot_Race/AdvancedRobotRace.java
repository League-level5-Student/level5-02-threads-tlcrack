package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	static Random r = new Random();
	static int z = 0;
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

		Thread racer0 = new Thread(() -> race(0));
		Thread racer1 = new Thread(() -> race(1));
		Thread racer2 = new Thread(() -> race(2));
		Thread racer3 = new Thread(() -> race(3));
		Thread racer4 = new Thread(() -> race(4));

		racer0.start();
		racer1.start();
		racer2.start();
		racer3.start();
		racer4.start();

		try {
			racer0.join();
			racer1.join();
			racer2.join();
			racer3.join();
			racer4.join();
		} catch (Exception e) {
			System.out.println("Problem!");
		}
		System.out.println("robot#" + winner + " is the winner!");
	}

	static void race(int racerNumber) {
		while (finished == false) {
			for (z = r.nextInt(50); z > 0; z--) {
				rob[racerNumber].move(1);
				rob[racerNumber].turn(1);
				if (rob[racerNumber].getX() == racerNumber * 20 + 200 && rob[racerNumber].getY() == 250) {
					finished = true;
					winner = racerNumber + 1;
					break;
				}
			}
		}
	}
}
