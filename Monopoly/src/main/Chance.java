package main;

import java.util.Random;

public class Chance {
	private static TypeOfChance typeOfChance;
	private static Random r = new Random();
	private static int random;
	
	public static String drawChance(Board board){
		random = r.nextInt(4);
		
		if(random == 1){
			typeOfChance = TypeOfChance.GetMoney;
			return getMoney(board);
			
		}else if(random == 2){
			typeOfChance = TypeOfChance.MoveToAPlace;
			return moveToAPlace(board);
			
		}else if(random == 3){
			typeOfChance = TypeOfChance.PayUp;
			return payUp(board);
			
		}else if(random == 4){
			typeOfChance = TypeOfChance.SpecialStuff;
			return speacialStuff(board);
		}
		
		else return "lol. This Cant Happen"; 
	}
	
	public static String getMoney(Board board){
		int value = 0; 
		String whatHappens = "";
		random = r.nextInt();
		switch(random){
		case 1:
			value = Operations.round*Operations.round*Operations.round/2;
			whatHappens = "You Won The Great Price Of The Time Lottery and resive " + value;
			break;
		case 2:
			value = 50;
			whatHappens = "You Found a " + value + " bill on the ground";
			break;
		case 3: 
			value = 50*(board.players.length - 1);
			for (int i = 0; i < board.players.length; i++) {
				if(i != Operations.turn){
					board.players[i].setPlayerCash(board.players[i].getPlayerCash() - 50);
				}
			}
			whatHappens = "EYYY. It Is Your Birthday And You Recive " + value + " From The Other Players";
			break;
		case 4:
			value = 100; 
			whatHappens = "WOW, a " + value + " bucks! GE, Thanks Grandma!";
			break;
		case 5:
			value = 200;
			whatHappens = "Uuh, My Stocks Finally Paid Of " + value;
			break;
		case 6: 
			value = 500; 
			whatHappens = "Damn, I Won The Big Lotto!! " + value;
			break;
		}
			
		
		board.players[Operations.turn].setPlayerCash(board.players[Operations.turn].getPlayerCash() + value);
		return whatHappens;
	}
	
	public static String moveToAPlace(Board board){
		
	}
	
	public static String payUp(Board board){
		int value = 0; 
		String whatHappens = "";
		random = r.nextInt();
		switch(random){
		case 1:
			value = Operations.round*Operations.round*Operations.round/2;
			whatHappens = "You Have Won The Anti Lottery. Pay Up Bitch " + value;
			break;
		case 2:
			value = 50;
			whatHappens = "Shit, I Droped My " + value + " Bill On The Ground";
			break;
		case 3: 
			value = 50*(board.players.length - 1);
			for (int i = 0; i < board.players.length; i++) {
				if(i != Operations.turn){
					board.players[i].setPlayerCash(board.players[i].getPlayerCash() - 50);
				}
			}
			whatHappens = "Damn. You Lost The Friday Night Poker Game. Pay " + value + " To The Other Players";
			break;
		case 4:
			value = 100; 
			whatHappens = "You Have Been Speeding To Much... Again. Pay " + value;
			break;
		case 5:
			value = 200;
			whatHappens = "Uuh, My Stocks Didn't Paid Of " + value;
			break;
		case 6: 
			value = 500; 
			whatHappens = "You Where Rekt By The Mob And Wasn't Insured " + value;
			break;
		}
			
		
		board.players[Operations.turn].setPlayerCash(board.players[Operations.turn].getPlayerCash() - value);
		return whatHappens;
	}

	public static String speacialStuff(Board board){
		
	}

}
