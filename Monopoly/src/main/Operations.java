package main;

public class Operations {
	public static int turn = 0;
	public static int tempTurn = turn;
	public static int move = 0;
	public static int round = 1;
	public static boolean canRollDice = true;
	public static boolean buying = false;
	public static boolean idiots = false;
	public static int tempMove = move;
	private Board board;
	public static int copyOfTempTurn;
	int triesToGetOutOfJail = 0;
	
	
	public Operations(Board board){
		this.board = board;
		copyOfTempTurn = tempTurn;
		
	}
	
	public void tick(){
		copyOfTempTurn = tempTurn;
		
		if(board.createdPlayers){
			if(board.players[tempTurn] instanceof AI){
				AI.isAITurn = true;
				((AI) board.players[tempTurn]).runAI();
			}
		}
		
		if(Dice.rollDice){
			Dice.rollTheDice();
		}
		
		board.tick();
		
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
