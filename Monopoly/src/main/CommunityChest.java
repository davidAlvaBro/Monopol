package main;

import java.util.Random;

public class CommunityChest {
	private static Random r = new Random();
	private static int random;
	private static String whatHappens = "";
	
	public static String drawCommunityChest(Board board){
		//Lav en Special Things der får alle til at give til de fattige og tage fra de rige
		random = r.nextInt(2) + 1;
		System.out.println("We Got A CommunityChest And The Random Thing Is: " + random);
			
		switch(random){
		case 1:
			return getMoney(board);
		case 2:
			return payUp(board);
		}
		
		return "Lol. This Is Not Possible You Dirty Hacker!";
	}
	
	public static String getMoney(Board board){
		int value = 0; 
		random = r.nextInt(5) + 1;
		System.out.println("ITS A BOY, wait... its just a get money ");
		switch(random){
		case 1:
			if(board.players[Operations.tempTurn].getPlayerValue() < 500){
				value = 0;
				for (int i = 0; i < board.players.length; i++) {
					value += board.players[i].getPlayerValue();
				}
				value = (value - board.players[Operations.turn].getPlayerValue())/(board.players.length - 1);
				
				whatHappens = "You Are Very Poor Here Take This: " + value;
			}else{
				whatHappens = "You Aren't Poor. Get Outta Here! ";
			}
			
			break;
		case 2:
			value = 0;
			for (int i = 0; i < board.players.length; i++) {
				value += board.players[i].getPlayerValue();
			}
			
			value = value/board.players.length - board.players[Operations.turn].getPlayerValue();
			
			if(value < 0){
				value = 0;
			}
			
			whatHappens = "Unemployment Benefits: " + value;;
			break;
		case 3: 
			value = board.players[Operations.turn].ownedFields.size()*20;
			whatHappens = "Property Raising In Value: " + value;;
			break;
		case 4:
			value = board.players[Operations.turn].amountOfHouses * 20; 
			whatHappens = "Houses Raising In Value: " + value;;
			break;
		case 5:
			value = 0;
			for (int i = 0; i < board.players.length; i++) {
				value += board.players[i].getPlayerCash();
			}
			
			value = value/board.players.length - board.players[Operations.turn].getPlayerCash();
			
			if(value < 0){
				value = 0;
			}
			
			whatHappens = "Unemployment Benefits: " + value;;
			break;
		
		}
			
		
		board.players[Operations.turn].setPlayerCash(board.players[Operations.turn].getPlayerCash() + value);
		return whatHappens;
	}
		
	public static String payUp(Board board){
		int value = 0; 
		random = r.nextInt(5) + 1;
		System.out.println("We Got A Pay Up Tax Thing");
		switch(random){
		case 1:
			value = board.players[Operations.tempTurn].laps*50;
			whatHappens = "Gass Tax: " + value;
			break;
		case 2:
			value = board.players[Operations.tempTurn].amountOfHouses*50;
			whatHappens = "House Tax: " + value;
			break;
		case 3: 
			value = board.players[Operations.turn].ownedFields.size()*50;
			whatHappens = "Property Tax: " + value;;
			break;
		case 4:
			value = board.players[Operations.turn].getPlayerCash()*2/10; 
			whatHappens = "Income Tax: " + value;;
			break;
		case 5:
			value = board.players[Operations.turn].getPlayerValue()*1/10;
			whatHappens = "Genaral Tax: " + value;;
			break;
		
		}
			
		board.players[Operations.turn].setPlayerCash(board.players[Operations.turn].getPlayerCash() - value);
		return whatHappens;
	}
}
