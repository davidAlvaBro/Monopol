package main;

import java.util.Random;

public class Chance {
	private static Random r = new Random();
	private static int random;
	private static String whatHappens = "";
	
	public static String drawChance(Board board){
		random = r.nextInt(4) + 1;
//		System.out.println("We Got A Chance And The Random Thing Is: " + random);
			
		switch(random){
		case 1:
			return getMoney(board);
		case 2:
			return moveToAPlace(board);
		case 3:
			return payUp(board);
		case 4:
			return speacialStuff(board);
		}
		
		return "Lol. This Is Not Possible You Dirty Hacker!";
	}
	
	public static String getMoney(Board board){
		int value = 0; 
//		System.out.println("This Is A Get Money");
		random = r.nextInt(6) + 1;
		switch(random){
		case 1:
			value = 50 + Operations.round*Operations.round/24;
//			System.out.println("EEEYY ITS YA BOY");
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
		random = r.nextInt(40);
//		System.out.println("We Got A Move To A Place Chance");
		int placeBefore = board.players[Operations.turn].getPlayerPlace();
		board.players[Operations.turn].setPlayerPlace(random);
		whatHappens = "You Move To " + board.fields[random].getPropertyName() + " From " + placeBefore; 
		board.landedOn();
		return whatHappens;
	}
	
	public static String payUp(Board board){
		int value = 0; 
		random = r.nextInt(6) + 1;
//		System.out.println("We Got A Pay Up Chance");
		switch(random){
		case 1:
			value = 50 + Operations.round*Operations.round/24;
			whatHappens = "You Have Won The Anti Lottery. Pay Up Bitch " + value;
//			System.out.println("Did This Kill You?");
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
		// impliment mere shit here like killing stuff xD
		random = r.nextInt(2) + 1;
//		System.out.println("We Got A Special Stuff Chance");
		switch(random){
		case 1:
			whatHappens = "Go To Jail You Filthy Criminal";
			board.players[Operations.turn].goToJail();
			break;
		case 2:
			whatHappens = "Next Time You Go To Jail I Will Bail You Out";
			board.players[Operations.turn].outOfJailFreeCard = true;
			break;
		}
		
		return whatHappens;
	}

}
