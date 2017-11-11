package main;

public class Operations {
	public static int turn = 0;
	public static int move = 0;
	public static boolean canRollDice = true;
	public static boolean buying = false;
	private int tempTurn = turn, tempMove = move;
	private Board board;
	public static int copyOfTempTurn;
	
	
	public Operations(Board board){
		this.board = board;
		copyOfTempTurn = tempTurn;
		
	}
	
	public void tick(){
		copyOfTempTurn = tempTurn;
		
		if(Dice.rollDice){
			Dice.rollTheDice();
		}
		
		board.tick();
		
		if(buying){
			board.players[tempTurn].setPlayerCash(board.players[tempTurn].getPlayerCash()- board.fields[board.players[tempTurn].getPlayerPlace()].getPrice());
			board.fields[board.players[tempTurn].getPlayerPlace()].setOwned(true);
			board.fields[board.players[tempTurn].getPlayerPlace()].setOwnedBy(board.players[tempTurn].getPlayerName());
			board.players[tempTurn].ownedFields.add(board.players[tempTurn].ownedFields.size(), board.fields[board.players[tempTurn].getPlayerPlace()]);
			buying = false;
		}
		
		if(tempMove != move){
			board.players[tempTurn].setPlayerPlace(board.players[tempTurn].getPlayerPlace() + Dice.diceLeft + Dice.diceRight);
			if(board.players[tempTurn].getPlayerPlace() > board.fields.length - 1){
				board.players[tempTurn].setPlayerPlace(board.players[tempTurn].getPlayerPlace() - board.fields.length);
			}
			tempMove = move;
		}
		tempTurn = turn;
	}
	
	public static void buyField(){
		buying = true;
	}
}
