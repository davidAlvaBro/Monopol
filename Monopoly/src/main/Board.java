package main;

import java.awt.Color;

public class Board {
	private String[] fieldNames = {"Go","Old Kent Road","Community Chest", "White Chapel Road","Income Tax",
			"Merylebone Station","The Angel Islington","Chance","Euston Road","Pentonville Road","Just Visting","Pall Mall",
			"Chance","Whitehall","Northlimberland Road","Febchurch Street St.","Bow Street","Community Chest","Mlborough Street",
			"Vine Street","Free Parking","Strand","Chance","Fleet Street","Trafalgar Square","King Cross St.","Leichester Square",
			"Coventry Street","Community Chest","Piccadilly","GO TO JAIL","Regent Street","Oxford Street","Community Chest","Bond Street",
			"Liverpool St.","Chance","Park Lane","Super Tax","Mayfair"};
	public Field[] fields = new Field[fieldNames.length];
	public Player[] players;
	public boolean createdPlayers = false;
	private boolean createdAmountOfPlayers;
	
	public Board(){
		FieldProperties temp;
		for (int i = 0; i < fieldNames.length; i++) {
			if(i%10 == 0|| i == 0){
				temp = 	FieldProperties.Corners;
			}else if(i%5 == 0){
				temp = 	FieldProperties.TrainStation;
			}else if(i == 2|| i == 17 || i == 28 || i == 33){
				temp = 	FieldProperties.CommunityChest;
			}else if(i == 7 || i == 12 || i == 22 || i == 36){
				temp = FieldProperties.Chance;
			}else if(i == 4 || i == 38){
				temp = FieldProperties.Taxes;
			}else{
				temp = FieldProperties.NormalField;
			}
			fields[i] = new Field(i*10 + 50, i*2+10, fieldNames[i], temp);
		}
	}
	
	public void tick(){
		if(MainAc.title == Title.SetPlayer && !createdAmountOfPlayers){
			players = new Player[Player.typedAmountOfPlayers];
			for (int i = 0; i < Player.typedAmountOfPlayers; i++) {
				players[i] = new Player();
			}
			createdAmountOfPlayers = true;
		}
		if(MainAc.title == Title.SetPlayer && !createdPlayers){
			for (int i = 0; i < players.length; i++) {
				players[i].creatingPlayersTick();
			}
		}
		
		if(createdPlayers){
			for (int i = 0; i < players.length; i++) {
				players[i].tick();
			}	
		}
	}
}
