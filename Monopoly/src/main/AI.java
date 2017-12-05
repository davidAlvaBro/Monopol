package main;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AI extends Player{
	public static int amountOfAIs;
	public static boolean isAITurn = false;
	private int stuffCount = 0, inJailTriesCount, dangerousValue, iWannaBuy;
	public static int AISpeed = 500;
	private int wannaBuyTrainStation;
	private int averageAmountOfProperties;
	private int propertyIWannaBuyHouseOn;
	
	private Random r;
	
	public AI(Board board) {
		super(board);
		r = new Random();
		
	}
	
	
	public void runAI(){
		
		stuffCount++;
		
		if(stuffCount == 1){
			rollTheDiceAI();
		}else if(stuffCount == 2){
			waitAI();
		}else if(stuffCount == 3){
			shouldAIBuyProperty();
		}else if(stuffCount == 4){
			endTurn();
		}
	}
	
	
	public void tick(){
		super.tick();
		
		if(50 + Operations.round*Operations.round/24 >= laps*50){
			if(50 + Operations.round*Operations.round/24 >= 500){
				dangerousValue = 50 + Operations.round*Operations.round/24;
			}else{
				dangerousValue = 500;
			}
		}else if(laps*50 >= 500){
			dangerousValue = laps*50;
		}else{
			dangerousValue = 500;
		}
		
		
	}
	
	
	public void rollTheDiceAI(){
		Dice.rollTheDice();
		if(inJail){
			if(Dice.diceLeft == Dice.diceRight){
				inJail = false;
				if(Operations.move > Player.amountOfPlayers - 2){
					Operations.move -= Player.amountOfPlayers;
					Operations.round++;
				}
				Operations.move++;
			}else if(inJailTriesCount < 3){
				stuffCount--;
				inJailTriesCount++;
			}else{
				inJailTriesCount = 0;
			}
			functionAsAnAI();
			
		}else{
			Dice.rollTheDice();
			if(Operations.move > Player.amountOfPlayers - 2){
				Operations.move -= Player.amountOfPlayers;
				Operations.round++;
			}
			Operations.move++;
		}
	}
	
	
	public void waitAI(){
		functionAsAnAI();
	}
	
	
	public void shouldAIBuyProperty(){
		//HER SKAL DER MATEMATIKKEN IND
		
		if(iWannaBuyValue()){
			stuffCount--;
		}
		
		
		functionAsAnAI();
	}
	
	
	public void endTurn(){
		
		if(Dice.diceLeft == Dice.diceRight){
			
		}else{
			if(Operations.turn > Player.amountOfPlayers - 2){
				Operations.turn -= Player.amountOfPlayers;
			}
			Operations.turn++;
			MainAc.title = Title.Game;
		}
		
		
		isAITurn = false;
		stuffCount = 0;
	}
	
	
	private void functionAsAnAI(){
		try {
			TimeUnit.MILLISECONDS.sleep(AISpeed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int j = 0; j < board.showFields.length; j++) {
			board.showFields[j] = false;
		}
		
		board.landedOnChance = false;
		board.landedOnCommunityChest = false;
		
		while(Keys.isPaused){
			try {
				TimeUnit.MILLISECONDS.sleep(AISpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private boolean iWannaBuyValue(){
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// Lav en variabel der er divideret der er ledige fælder divideret med en konstant for at få dem til at tænke at fælder er mere værd tidligt i spillet (måske gange købe husene med omvendte variable for at stoppe med at købe huse når de har mange penge) 
		// Eller lav en variable der er baserede runder og får huse til at være mindre værd i starten og grunde til at være mere værd
		int thisPropertyIWannaBuy = 0;
		int propertiesIWannaBuy = 0;
		
		int amountOfFreeProperties = 0;
		
		for (int i = 0; i < board.fields.length; i++) {
			if(board.fields[i].typeOfField == FieldProperties.NormalField && !board.fields[i].isOwned()){
				amountOfFreeProperties++;
			}
		}
		
		int averagePriceForProperty = checkWhatTheAveragePrisForHousesIs();
		
		if(board.fields[playerPlace].isBuyable() && !board.fields[playerPlace].isOwned()){
			thisPropertyIWannaBuy = (int) Math.sqrt((playerCash - board.fields[playerPlace].getPrice())*playerCash/(board.fields[playerPlace].getPrice()+dangerousValue))*playerCash/(board.fields[playerPlace].getPrice()+dangerousValue);
			
//			System.out.println("Her er start værdien for ThisPropertyIWannaBuy " + thisPropertyIWannaBuy);
			
			thisPropertyIWannaBuy = thisPropertyIWannaBuy*amountOfFreeProperties*amountOfFreeProperties/Field.numberNormalField/4;
			
			if(board.fields[playerPlace].typeOfField == FieldProperties.NormalField){
				thisPropertyIWannaBuy = (int) (thisPropertyIWannaBuy * board.fields[playerPlace].getNumberNormalField()/(2*Math.sqrt(board.fields[playerPlace].getNumberNormalField())));
				
//				System.out.println("Her er værdien for THisPropertyIWannaBuy lige efter har tjekket hvilket normal field det er " + thisPropertyIWannaBuy);
			}else if(board.fields[playerPlace].typeOfField == FieldProperties.TrainStation){
				for (int i = 0; i < board.fields.length; i++) {
					if(board.fields[i].typeOfField == FieldProperties.TrainStation){
						if(board.fields[i].isOwned()){
							if(board.fields[i].getOwnedBy().equals(playerName)){
								thisPropertyIWannaBuy = thisPropertyIWannaBuy*2;
							}else{
								thisPropertyIWannaBuy = thisPropertyIWannaBuy*3/4;
							}
						}
					}
				}
			}
			
			averageAmountOfProperties = 0;
			
			for (int i = 0; i < board.players.length; i++) {
				averageAmountOfProperties += board.players[i].ownedFields.size();
			}
			
			averageAmountOfProperties -= ownedFields.size();
			
			//Når AI'en opdatere (ticker) og der kun er en spiller tilbage aka winnerScreen dividere vi med nul
			averageAmountOfProperties = averageAmountOfProperties/(board.players.length - 1);
			
			//Dårligt fix her, den tænker efter alle har en grund kig på matematikken og se nogle eksempler på hvad der kan ske
			//for jeg er ikke sikker på er god sansynlighedsregning
			if(averageAmountOfProperties > 1){
				if(ownedFields.size() > 0){
					thisPropertyIWannaBuy = thisPropertyIWannaBuy * averageAmountOfProperties/ownedFields.size();
				}else{
					thisPropertyIWannaBuy *= 10;
				}
			}
//			System.out.println("This is the this property i wanna buy value " + thisPropertyIWannaBuy);
			
		}
//		System.out.println("Her er average price for property " + averagePriceForProperty);
		propertiesIWannaBuy = (int) (Math.sqrt((playerCash - averagePriceForProperty)*playerCash/(averagePriceForProperty+dangerousValue))*playerCash/(averagePriceForProperty+dangerousValue));
//		System.out.println("Her er starten på properties i wanna buy value " + propertiesIWannaBuy);
		propertiesIWannaBuy = propertiesIWannaBuy*amountOfFreeProperties*amountOfFreeProperties/Field.numberNormalField/4;
//		System.out.println("This is the properties i wanna buy value " + propertiesIWannaBuy);
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Gang iWannaBuyHouse med en factor der hedder value for hus, og er en fast pris for hvad det koster at lande på grunden i stedet for den fordobling for husene dividere med en konstant 
		// Find ud af hvorfor AI's kan købe mere end 5 huse!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		int houseIWannaBuy = 0;
		int mostIWannaBuyHouse = 0;
		propertyIWannaBuyHouseOn = 0;
		
		for (int i = 0; i < ownedFields.size(); i++) {
			if(ownedFields.get(i).getHouseAmounts() <= 4 && ownedFields.get(i).typeOfField == FieldProperties.NormalField){
				houseIWannaBuy = (int) Math.sqrt((playerCash - ownedFields.get(i).getPriceForHouse())*playerCash/ownedFields.get(i).getPriceForHouse()+dangerousValue)*playerCash/(ownedFields.get(i).getPriceForHouse()+dangerousValue);
				houseIWannaBuy = (int) (houseIWannaBuy * ownedFields.get(i).getStanPrice()*Math.pow(2, ownedFields.get(i).getHouseAmounts())/ownedFields.get(i).getPriceForHouse());
				
				if(houseIWannaBuy >= mostIWannaBuyHouse){
					mostIWannaBuyHouse = houseIWannaBuy;
					
					propertyIWannaBuyHouseOn = i;
				}
			}
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
//		System.out.println("The house i wanna buy value is; " + mostIWannaBuyHouse);
//		System.out.println("The property i wanna buy value is; " + thisPropertyIWannaBuy);
//		System.out.println();
		
		if(mostIWannaBuyHouse >= thisPropertyIWannaBuy ){
			if(mostIWannaBuyHouse >= propertiesIWannaBuy){
				iWannaBuy = mostIWannaBuyHouse;
				
				int randomValue = r.nextInt(100);
				
				if(playerCash >= propertyIWannaBuyHouseOn){
					if(mostIWannaBuyHouse >= randomValue){
						ownedFields.get(propertyIWannaBuyHouseOn).setHouseAmounts(ownedFields.get(propertyIWannaBuyHouseOn).getHouseAmounts() + 1);
						playerCash -= ownedFields.get(propertyIWannaBuyHouseOn).getPriceForHouse();

						ownedFields.get(propertyIWannaBuyHouseOn).setPriceLandedOn((int) ((int) ownedFields.get(propertyIWannaBuyHouseOn).getStanPrice()*Math.pow(Field.houseFactor, ownedFields.get(propertyIWannaBuyHouseOn).getHouseAmounts())));
						amountOfHouses++;
						
						functionAsAnAI();
						
						return true;
					}
				}
			}
			
		}else if(!board.fields[playerPlace].isOwned()){
			
			iWannaBuy = thisPropertyIWannaBuy;
			
			int randomValue = r.nextInt(100);
			
			if(board.fields[playerPlace].isBuyable() && !board.fields[playerPlace].isOwned()){
				if(playerCash > board.fields[playerPlace].getPrice()){
					if(iWannaBuy > randomValue){
						playerCash -= board.fields[playerPlace].getPrice();
						board.fields[playerPlace].setOwned(true);
						board.fields[playerPlace].setOwnedBy(playerName);
						ownedFields.add(ownedFields.size(), board.fields[playerPlace]);
						
						
						if(board.fields[playerPlace].typeOfField == FieldProperties.TrainStation){
							int howManyTrainsDoYouOwn = 0;
							for (int i = 0; i < board.fields.length; i++) {
								if(board.fields[i].isOwned()){
									if(board.fields[i].getOwnedBy().equals(playerName)){
										if(board.fields[i].typeOfField == FieldProperties.TrainStation){
											howManyTrainsDoYouOwn++;
										}
									}
								}
							}
							for (int i = 0; i < board.fields.length; i++) {
								if(board.fields[i].isOwned()){
									if(board.fields[i].getOwnedBy().equals(playerName)){
										if(board.fields[i].typeOfField == FieldProperties.TrainStation){
											board.fields[i].setPriceLandedOn((int) (25*Math.pow(2, howManyTrainsDoYouOwn - 1)));
										}
									}
								}
							}
						}
						
						return true;
					}
				}
				
				functionAsAnAI();
				
			}
			
			
		}
		
		return false;
		
	}
	
	
	public int checkWhatTheAveragePrisForHousesIs(){
		
		int amountOfFreeProperties = 0;
		int averagePriceForProperties = 0;
		
		for (int i = 0; i < board.fields.length; i++) {
			if(board.fields[i].typeOfField == FieldProperties.NormalField && !board.fields[i].isOwned()){
				amountOfFreeProperties++;
				averagePriceForProperties += board.fields[i].getPrice();
			}
		}
		
		averagePriceForProperties = averagePriceForProperties/amountOfFreeProperties;
		
		return averagePriceForProperties;
	}
	
	
}
