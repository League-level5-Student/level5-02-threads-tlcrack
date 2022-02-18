package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	static Robot ari = new Robot(400, 400);
	static Robot barry = new Robot(550, 475);
	static Robot carrie = new Robot(700, 400);
	static Robot dairy = new Robot(850, 475);
	static Robot eerie = new Robot(1000, 400);
	public static void main(String[] args) {
		ari.setSpeed(10);
		barry.setSpeed(10);
		carrie.setSpeed(10);
		dairy.setSpeed(10);
		eerie.setSpeed(10);

		ari.setPenColor(Color.blue);
		barry.setPenColor(Color.yellow);
		dairy.setPenColor(Color.green);
		eerie.setPenColor(Color.red);
		
		ari.setPenWidth(10);
		barry.setPenWidth(10);
		carrie.setPenWidth(10);
		dairy.setPenWidth(10);
		eerie.setPenWidth(10);
		
		ari.penDown();
		barry.penDown();
		carrie.penDown();
		dairy.penDown();
		eerie.penDown();

		ari.hide();
		barry.hide();
		carrie.hide();
		dairy.hide();
		eerie.hide();
		
		Thread air = new Thread(()->encircle(ari));
		Thread bear = new Thread(()->encircle(barry));
		Thread care = new Thread(()->encircle(carrie));
		Thread dare = new Thread(()->encircle(dairy));
		Thread ear = new Thread(()->encircle(eerie));
		
		air.start();
		bear.start();
		care.start();
		dare.start();
		ear.start();
		try {
			air.join();
			bear.join();
			care.join();
			dare.join();
			ear.join();
		}
		catch(Exception e) {
			
		}
	}
	
	static void encircle(Robot fairy) {
		for(int i = 0; i < 360; i++) {
			fairy.move(2);
			fairy.turn(1);
		}
		
	}
}

