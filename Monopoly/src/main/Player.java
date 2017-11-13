package main;

import java.awt.Color;
import java.util.LinkedList;

public class Player {
	public static int amountOfPlayers;
	public static int typedAmountOfPlayers = 2;
	private int playerNum, playerCash, playerValue, playerPlace;
	private String playerName;
	public LinkedList<Field> ownedFields = new LinkedList<Field>();
	private Color playerColor = Color.white;
//	private Cards[] playerCards;
	
	public Player(){
		Player.amountOfPlayers++;
		this.playerNum = Player.amountOfPlayers;
		this.playerCash = 1500;
		this.playerName = "";
		playerPlace = 0;
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
