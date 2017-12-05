package main;

import java.awt.Color;
import java.util.LinkedList;

public class Player {
	public static int amountOfPlayers;
	public static int typedAmountOfPlayers = 2;
	public static LinkedList<Color> ownedColors = new LinkedList<Color>();

	public boolean inJail = false;
	public boolean outOfJailFreeCard = false;
	
	public int laps = 0, amountOfHouses = 0;
	public LinkedList<Field> ownedFields = new LinkedList<Field>();
	
	protected int playerNum, playerCash, playerValue, playerPlace;
	protected String playerName;	
	protected Color playerColor = Color.white;
	
	protected Board board;
	
	
	public Player(Board board){
		Player.amountOfPlayers++;
		this.playerNum = Player.amountOfPlayers;
		this.playerCash = 1500;
		this.playerName = "";
		this.board = board;
		playerPlace = 0;
		ownedColors.add(this.playerColor);
	}
	
	
	public void creatingPlayersTick(){
		ownedColors.set(playerNum - 1, playerColor);
	}

	public void tick(){
		playerValue = 0;
		
		playerValue += playerCash;
		for (int i = 0; i < ownedFields.size(); i++) {
			if(!ownedFields.get(i).isMortgaged()){
				playerValue += ownedFields.get(i).getMortgagePrice();
			}
		}
	}
	
	public void goToJail(){
		if(outOfJailFreeCard){
			outOfJailFreeCard = false;
		}else{
			inJail = true;
			for (int i = 0; i < board.fields.length; i++) {
				if(board.fields[i].getPropertyName().equals("Just Visting")){
					playerPlace = i;
				}
			}
		}
	}
	
	//Getters og setters
	
	public static int getAmountOfPlayers() {
		return amountOfPlayers;
	}

	public static void setAmountOfPlayers(int amountOfPlayers) {
		Player.amountOfPlayers = amountOfPlayers;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public int getPlayerCash() {
		return playerCash;
	}

	public void setPlayerCash(int playerCash) {
		this.playerCash = playerCash;
	}

	public int getPlayerValue() {
		return playerValue;
	}

	public void setPlayerValue(int playerValue) {
		this.playerValue = playerValue;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	
	public int getPlayerPlace() {
		return playerPlace;
	}


	public void setPlayerPlace(int playerPlace) {
		this.playerPlace = playerPlace;
	}


	public Color getPlayerColor() {
		return playerColor;
	}


	public void setPlayerColor(Color playerColor) {
		this.playerColor = playerColor;
	}

}
