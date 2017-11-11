package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseEvents extends MouseAdapter{
	private int stanFelt = (3*MainAc.width/4)/13; 
	private int mx, my;
	private Board board;
	
	public MouseEvents(Board board){
		this.board = board;
	}
	
	public void mousePressed(MouseEvent e){
		mx = e.getX();
		my = e.getY();
		
		if(MainAc.title == Title.Game){
			if(Operations.canRollDice && mx >= MainAc.width/4 + 66*stanFelt/8 && mx <= MainAc.width/4 + 66*stanFelt/8 + 5/2*stanFelt && my >= 15*stanFelt/4 && my <= 15*stanFelt/4 +50){
				Dice.rollDice = true;
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 0 && my <= MainAc.height / 7){
				//Impliment method ????
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= MainAc.height/7 && my <= MainAc.height/7  + MainAc.height / 7){
				MainAc.title = Title.MainMenu;
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 2*MainAc.height/7 && my <= 2*MainAc.height/7  + MainAc.height / 7){
				//Impliment method 
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 3*MainAc.height/7 && my <= 3*MainAc.height/7  + MainAc.height / 7){
				//Implement method
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 4*MainAc.height/7 && my <= 4*MainAc.height/7  + MainAc.height / 7){
				//Implement method
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 5*MainAc.height/7 && my <= 5*MainAc.height/7  + MainAc.height / 7){
				MainAc.title = Title.ActionMenu;
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 6*MainAc.height/7 && my <= 6*MainAc.height/7  + MainAc.height / 7 && !Operations.canRollDice){
				if(Operations.turn > Player.amountOfPlayers - 2){
					Operations.turn -= Player.amountOfPlayers;
				}
				Operations.turn++;
				Operations.canRollDice = true;
			}
			
			
		}else if(MainAc.title == Title.ActionMenu){
			if(Operations.canRollDice && mx >= MainAc.width/4 + 66*stanFelt/8 && mx <= MainAc.width/4 + 66*stanFelt/8 + 5/2*stanFelt && my >= 15*stanFelt/4 && my <= 15*stanFelt/4 +50){
				Dice.rollDice = true;
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 0 && my <= MainAc.height / 7 && (board.fields[board.players[Operations.copyOfTempTurn].getPlayerPlace()].isBuyable() && !board.fields[board.players[Operations.copyOfTempTurn].getPlayerPlace()].isOwned())){
				Operations.buyField();
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= MainAc.height/7 && my <= MainAc.height/7  + MainAc.height / 7){
				//Implement Method
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 2*MainAc.height/7 && my <= 2*MainAc.height/7  + MainAc.height / 7){
				//Implement method 
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 3*MainAc.height/7 && my <= 3*MainAc.height/7  + MainAc.height / 7){
				//Implement method
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 4*MainAc.height/7 && my <= 4*MainAc.height/7  + MainAc.height / 7){
				//Implement method
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 5*MainAc.height/7 && my <= 5*MainAc.height/7  + MainAc.height / 7){
				MainAc.title = Title.Game;
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 6*MainAc.height/7 && my <= 6*MainAc.height/7  + MainAc.height / 7 && !Operations.canRollDice){
				if(Operations.turn > Player.amountOfPlayers - 2){
					Operations.turn -= Player.amountOfPlayers;
				}
				Operations.turn++;
				Operations.canRollDice = true;
				MainAc.title = Title.Game;
			}
			
			
		}else if(MainAc.title == Title.MainMenu){
			if(mx >= MainAc.width*1/3 && mx <= MainAc.width*1/3 + MainAc.width/3 && my >= MainAc.height*5/26 && my <= MainAc.height*5/26 + MainAc.height/13*2){
				MainAc.title = Title.Game;
			}else if(mx >= MainAc.width*1/3 && mx <= MainAc.width*1/3 + MainAc.width/3 && my >= 2*MainAc.height*5/26 && my <= 2*MainAc.height*5/26 + MainAc.height/13*2){
				MainAc.title = Title.Game;
			}else if(mx >= MainAc.width*1/3 && mx <= MainAc.width*1/3 + MainAc.width/3 && my >= 3*MainAc.height*5/26 && my <= 3*MainAc.height*5/26 + MainAc.height/13*2){
				//Implement method
			}else if(mx >= MainAc.width*1/3 && mx <= MainAc.width*1/3 + MainAc.width/3 && my >= 4*MainAc.height*5/26 && my <= 4*MainAc.height*5/26 + MainAc.height/13*2){
				System.exit(2);
			}
		}
	
	}
	
	public void mouseReleased(MouseEvent e){
		if(Operations.canRollDice && mx >= MainAc.width/4 + 66*stanFelt/8 && mx <= MainAc.width/4 + 66*stanFelt/8 + 5/2*stanFelt && my >= 15*stanFelt/4 && my <= 15*stanFelt/4 +50){
			Dice.rollDice = false;
			if(Operations.move > Player.amountOfPlayers - 2){
				Operations.move -= Player.amountOfPlayers;
			}
			Operations.move++;
			Operations.canRollDice = false;
		}
	}
}
