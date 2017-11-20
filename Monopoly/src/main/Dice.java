package main;

import java.util.Random;

public class Dice {
	
	public static int diceLeft, diceRight;
	public static boolean rollDice = false;
	private static Random r = new Random();
	
	public static void rollTheDice(){
		diceLeft = r.nextInt(6) + 1;
		diceRight = r.nextInt(6) + 1;
		
//		diceLeft = 2;
//		diceRight = 2;
		
		
	}
}
