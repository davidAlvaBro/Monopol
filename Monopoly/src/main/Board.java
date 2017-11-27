package main;

import java.awt.Color;
import java.awt.Graphics;

public class Board {
	private String[] fieldNames = {"Go","Old Kent Road","Community Chest", "White Chapel Road","Income Tax",
			"Merylebone Station","The Angel Islington","Chance","Euston Road","Pentonville Road","Just Visting","Pall Mall",
			"Chance","Whitehall","Northlimberland Road","Febchurch Street St.","Bow Street","Community Chest","Mlborough Street",
			"Vine Street","Free Parking","Strand","Chance","Fleet Street","Trafalgar Square","King Cross St.","Leichester Square",
			"Coventry Street","Community Chest","Piccadilly","GO TO JAIL","Regent Street","Oxford Street","Community Chest","Bond Street",
			"Liverpool St.","Chance","Park Lane","Super Tax","Mayfair"};
	public Field[] fields = new Field[fieldNames.length];
	public Player[] players;
	private Player[] tempPlayers;
	public boolean createdPlayers = false;
	private boolean createdAmountOfPlayers;
	public boolean[] showFields = new boolean[fieldNames.length];
	private String chance, communityChest;
	public boolean landedOnChance = false, landedOnCommunityChest = false;
	
	public static int fieldSettingForSale;
	// Things for tradeing 
	public static int personToTradeWith;
	public static int propertyTrade;
	public static int moneyYouWantToGive;
	public static int amountOfPropertiesInTheTrade;
	
	
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
		
		
		for (int i = 0; i < showFields.length; i++) {
			showFields[i] = false;
		}
	}
	
	public void tick(){
		if(Player.amountOfPlayers == 1){
			MainAc.title = Title.WinnerScreen;
		}
		
		if(MainAc.title == Title.SetPlayer && !createdAmountOfPlayers){ 
			players = new Player[Player.typedAmountOfPlayers];
			for (int i = 0; i < Player.typedAmountOfPlayers; i++) {
				players[i] = new Player(this);
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
				
				if(players[i].getPlayerValue() <= 0){
					System.out.println("SHIIIIIT YOU DIDEDEDDED");
					for (int j = 0; j < players[i].ownedFields.size(); j++) {
						players[i].ownedFields.get(j).setHouseAmounts(0);
						players[i].ownedFields.get(j).setPriceLandedOn(players[i].ownedFields.get(j).getStanPrice());
						players[i].ownedFields.get(j).setMortgaged(false);
						players[i].ownedFields.get(j).setOwnedBy("No one");
						players[i].ownedFields.get(j).setOwned(false);
						
					}
					
					for (int j = 0; j < players.length; j++) {
						System.out.println(j + " The player number " + players[j].getPlayerName());
					}
					
					for (int j = 0; j < players.length; j++) {
						if(j > i){
							players[j].setPlayerNum(players[j].getPlayerNum() - 1);
						}
					}
					
					tempPlayers = new Player[players.length - 1];
					for (int j = 0; j < tempPlayers.length; j++) {
						tempPlayers[j] = players[j];
					}
					
					for (int j = i; j < players.length - 1; j++) {
						tempPlayers[j] = players[j + 1];
					}
					
					players = tempPlayers;
					System.out.println("");
					for (int j = 0; j < players.length; j++) {
						System.out.println(j + " The player number " + players[j].getPlayerName());
					}

					Player.amountOfPlayers--;
					
					if(Operations.turn == 0){
						Operations.turn = Player.amountOfPlayers;
						Operations.tempTurn = Player.amountOfPlayers;
					}
					Operations.turn--;
					Operations.tempTurn--;
					
					
				}
			}	
		}
	}
	
	public void render(Graphics g){
		
		if(landedOnChance){
			g.setColor(Color.black);
			g.fillRect(MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2, MainAc.width - (3*MainAc.width/4)/13*4 - MainAc.width/4 - 11, MainAc.height - (3*MainAc.width/4)/13*4 - 11);
			g.setColor(Color.white);
			g.drawRect(MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2, MainAc.width - (3*MainAc.width/4)/13*4 - MainAc.width/4 - 11, MainAc.height - (3*MainAc.width/4)/13*4 - 11);
			
			g.drawString("You Landed On Chance! ", MainAc.width/4 + (3*MainAc.width/4)/13*2 + 10, (3*MainAc.width/4)/13*2 + 40);
			g.drawString(chance, MainAc.width/4 + (3*MainAc.width/4)/13*2 + 10, (3*MainAc.width/4)/13*2 + 100);
		}else if(landedOnCommunityChest){
			g.setColor(Color.black);
			g.fillRect(MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2, MainAc.width - (3*MainAc.width/4)/13*4 - MainAc.width/4 - 11, MainAc.height - (3*MainAc.width/4)/13*4 - 11);
			g.setColor(Color.white);
			g.drawRect(MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2, MainAc.width - (3*MainAc.width/4)/13*4 - MainAc.width/4 - 11, MainAc.height - (3*MainAc.width/4)/13*4 - 11);
			
			g.drawString("You Landed On A Community Chest! ", MainAc.width/4 + (3*MainAc.width/4)/13*2 + 10, (3*MainAc.width/4)/13*2 + 40);
			g.drawString(communityChest, MainAc.width/4 + (3*MainAc.width/4)/13*2 + 10, (3*MainAc.width/4)/13*2 + 100);
		}
	}
	
	public boolean shouldShowField(){
		for (int i = 0; i <showFields.length; i++) {
			if(showFields[i]){
				return true;
			}
		}
		return false;
	}
	
	public void landedOn(){
		if(this.fields[this.players[Operations.turn].getPlayerPlace()].isOwned()){
			for (int i = 0; i < this.players.length; i++) {
				if(this.fields[this.players[Operations.turn].getPlayerPlace()].getOwnedBy().equals(this.players[i].getPlayerName())){
					this.players[i].setPlayerCash(this.players[i].getPlayerCash() + this.fields[this.players[Operations.turn].getPlayerPlace()].getPriceLandedOn());
					this.players[Operations.turn].setPlayerCash(this.players[Operations.turn].getPlayerCash() - this.fields[this.players[Operations.turn].getPlayerPlace()].getPriceLandedOn());
				}
			}
		}else if(this.fields[this.players[Operations.turn].getPlayerPlace()].typeOfField == FieldProperties.Chance){
			//FYR OP FOR EN CHANCEN
			chance = Chance.drawChance(this);
			landedOnChance = true;
			
			
		}else if(this.fields[this.players[Operations.turn].getPlayerPlace()].typeOfField == FieldProperties.CommunityChest){
			//FYR OP FOR EN COMMUNITYCHEST
			communityChest = CommunityChest.drawCommunityChest(this);
			landedOnCommunityChest = true;
					
		}else if(this.fields[this.players[Operations.turn].getPlayerPlace()].typeOfField == FieldProperties.Taxes){
			
			if(this.players[Operations.turn].getPlayerPlace() == 4){
				this.players[Operations.turn].setPlayerCash(this.players[Operations.turn].getPlayerCash() - this.players[Operations.turn].getPlayerValue()*1/10);
			}else if(this.players[Operations.turn].getPlayerPlace() == 38){
				this.players[Operations.turn].setPlayerCash(this.players[Operations.turn].getPlayerCash() - this.players[Operations.turn].getPlayerValue()*2/10);
			}
		}else if(this.fields[this.players[Operations.turn].getPlayerPlace()].typeOfField == FieldProperties.Corners){
			//FYR OP FOR EN FUUUUUUCK DER SKAL SKE MEGET HER.......
			if(this.players[Operations.turn].getPlayerPlace() == 30){
				this.players[Operations.turn].goToJail();
			}
		}
	}
	
	
}
