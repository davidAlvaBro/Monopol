package main;

public class Operations {
	//Variabler der bruges til at finde spileren hvis tur det er
	public static int turn = 0;
	public static int tempTurn = turn;
	//Variabler der styre hvor meget folk bevæger sig
	public static int move = 0;
	public static int tempMove = move;
	public static int copyOfTempTurn = tempTurn;
	//Runden
	public static int round = 1;
	//Styre om man kan slå flere gange, og derfor også om man kan slutte sin tur
	public static boolean canRollDice = true;
	//Bruges til at tjekke om folk køber
	public static boolean buying = false;
	//Hvis folk prøver at slette viser den cant go back now can you
	public static boolean idiots = false;
	//Boardet så man kan redigere på ting
	private Board board;
	//Tjekker om man slår så man kan komme ud af Jail, og tæller til tre
	int triesToGetOutOfJail = 0;
	
	//Construktor
	public Operations(Board board){
		this.board = board;
	}
	
	//Det her sker hver gang MainAc ticker
	public void tick(){
		copyOfTempTurn = tempTurn;
		
		//Tjekker om det er en AI og sætter derfor isAITurn = true, tjekker først om spillerene er lavet
		if(board.createdPlayers){
			if(board.players[tempTurn] instanceof AI){
				AI.isAITurn = true;
				((AI) board.players[tempTurn]).runAI();
			}
		}
		
		//Ruller med terningerne hvis de holdes nede
		if(Dice.rollDice){
			Dice.rollTheDice();
		}
		
		//Ticker alt i bordet
		board.tick();
		
		//Køber ting 
		if(buying){
			board.players[tempTurn].setPlayerCash(board.players[tempTurn].getPlayerCash()- board.fields[board.players[tempTurn].getPlayerPlace()].getPrice());
			board.fields[board.players[tempTurn].getPlayerPlace()].setOwned(true);
			board.fields[board.players[tempTurn].getPlayerPlace()].setOwnedBy(board.players[tempTurn].getPlayerName());
			board.players[tempTurn].ownedFields.add(board.players[tempTurn].ownedFields.size(), board.fields[board.players[tempTurn].getPlayerPlace()]);
			if(board.fields[board.players[tempTurn].getPlayerPlace()].typeOfField == FieldProperties.TrainStation){
				int howManyTrainsDoYouOwn = 0;
				for (int i = 0; i < board.fields.length; i++) {
					if(board.fields[i].isOwned()){
						if(board.fields[i].getOwnedBy().equals(board.players[tempTurn].getPlayerName())){
							if(board.fields[i].typeOfField == FieldProperties.TrainStation){
								howManyTrainsDoYouOwn++;
							}
						}
					}
				}
				for (int i = 0; i < board.fields.length; i++) {
					if(board.fields[i].isOwned()){
						if(board.fields[i].getOwnedBy().equals(board.players[tempTurn].getPlayerName())){
							if(board.fields[i].typeOfField == FieldProperties.TrainStation){
								board.fields[i].setPriceLandedOn((int) (25*Math.pow(2, howManyTrainsDoYouOwn - 1)));
							}
						}
					}
				}
			}
			buying = false;
		}
		
		//Bevæger spilleren hvis de har slået med terningen
		if(tempMove != move){
			if(board.players[tempTurn].inJail){
				
				if(Dice.diceLeft == Dice.diceRight){
					board.players[tempTurn].setPlayerPlace(board.players[tempTurn].getPlayerPlace() + Dice.diceLeft + Dice.diceRight);
					board.players[tempTurn].inJail = false;
				}else if(triesToGetOutOfJail < 3){
					System.out.println("Try Again");
					canRollDice = true;
					triesToGetOutOfJail++;
				}else{
					System.out.println("lol nub");
					triesToGetOutOfJail = 0;
				}
				
			}else{
				board.players[tempTurn].setPlayerPlace(board.players[tempTurn].getPlayerPlace() + Dice.diceLeft + Dice.diceRight);
				if(board.players[tempTurn].getPlayerPlace() > board.fields.length - 1){
					board.players[tempTurn].setPlayerPlace(board.players[tempTurn].getPlayerPlace() - board.fields.length);
					board.players[tempTurn].setPlayerCash(board.players[tempTurn].getPlayerCash() + MainAc.passingStart);
					board.players[tempTurn].laps++;
				}
			}
			tempMove = move;
			board.landedOn();
		}
		tempTurn = turn;
	}
	
	public static void buyField(){
		buying = true;
	}
}
