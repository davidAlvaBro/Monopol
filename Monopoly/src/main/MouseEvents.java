package main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseEvents extends MouseAdapter{
	private int stanFelt = (3*MainAc.width/4)/13; 
	private int mx, my, fieldX, fieldY, stanField, propertiesDistance;
	private Board board;
	
	public MouseEvents(Board board){
		this.board = board;
		propertiesDistance = MainAc.height/7 + 35;
	}
	
	public void mousePressed(MouseEvent e){
		mx = e.getX();
		my = e.getY();
		propertiesDistance = MainAc.height/7 + 35;
		
		if(MainAc.title == Title.Game){
			if(!board.shouldShowField() && Operations.canRollDice && mx >= MainAc.width/4 + 66*stanFelt/8 && mx <= MainAc.width/4 + 66*stanFelt/8 + 5/2*stanFelt && my >= 15*stanFelt/4 && my <= 15*stanFelt/4 + 50){
				Dice.rollDice = true;
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 0 && my <= MainAc.height / 7){
				//Impliment method ???? Nothing just turn and player
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= MainAc.height/7 && my <= MainAc.height/7  + MainAc.height / 7){
				MainAc.title = Title.MainMenu; //Back to Menu
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 2*MainAc.height/7 && my <= 2*MainAc.height/7  + MainAc.height / 7){
				//Impliment method Info
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 3*MainAc.height/7 && my <= 3*MainAc.height/7  + MainAc.height / 7){
				MainAc.title = Title.MeMenu;
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 4*MainAc.height/7 && my <= 4*MainAc.height/7  + MainAc.height / 7){
				//Implement method Players
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
				MainAc.title = Title.BuyHouse;
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 2*MainAc.height/7 && my <= 2*MainAc.height/7  + MainAc.height / 7){
				//Implement method Trade
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 3*MainAc.height/7 && my <= 3*MainAc.height/7  + MainAc.height / 7){
				//Implement method Pawn/set for sale
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 4*MainAc.height/7 && my <= 4*MainAc.height/7  + MainAc.height / 7){
				//Implement method Buy Properties
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
			
			
		}else if(MainAc.title == Title.MeMenu){
			if(Operations.canRollDice && mx >= MainAc.width/4 + 66*stanFelt/8 && mx <= MainAc.width/4 + 66*stanFelt/8 + 5/2*stanFelt && my >= 15*stanFelt/4 && my <= 15*stanFelt/4 +50){
				Dice.rollDice = true;
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 0 && my <= MainAc.height / 7 && (board.fields[board.players[Operations.copyOfTempTurn].getPlayerPlace()].isBuyable() && !board.fields[board.players[Operations.copyOfTempTurn].getPlayerPlace()].isOwned())){
				//
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= MainAc.height/7 && my <= MainAc.height/7  + MainAc.height / 7){
				MainAc.title = Title.ShowMyProperties; //DRAW MORE SHIIIIIIT
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 2*MainAc.height/7 && my <= 2*MainAc.height/7  + MainAc.height / 7){
				//Implement method Trade
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 3*MainAc.height/7 && my <= 3*MainAc.height/7  + MainAc.height / 7){
				//Implement method Pawn/set for sale
			}else if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 4*MainAc.height/7 && my <= 4*MainAc.height/7  + MainAc.height / 7){
				//Implement method Buy Properties
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
			
			
		}else if(MainAc.title == Title.ShowMyProperties){
			if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 6*MainAc.height/7 && my <= 6*MainAc.height/7  + MainAc.height / 7){
				MainAc.title = Title.Game;
			}
			
			
		}else if(MainAc.title == Title.BuyHouse){
			for (int i = 0; i < board.fields.length; i++){
				if(board.fields[i].isOwned()){
					if(board.fields[i].getOwnedBy().equals(board.players[Operations.turn].getPlayerName())){
						if(mx>= 0 && mx <= propertiesDistance && my >= MainAc.width/4 && my <= MainAc.width/4 + MainAc.height*5/7/26){
							board.players[Operations.turn].setPlayerCash(board.players[Operations.turn].getPlayerCash() - board.fields[i].getPriceForHouse());
							board.fields[i].setHouseAmounts(board.fields[i].getHouseAmounts() + 1);
						}
						propertiesDistance += MainAc.height/7/26;
					}
				}	
			}
			propertiesDistance = MainAc.height/7 + 35;
			
			if(mx >= 0 && mx <= MainAc.width / 4 - 20 && my >= 6*MainAc.height/7 && my <= 6*MainAc.height/7  + MainAc.height / 7){
				MainAc.title = Title.Game;
			}
			
			
		}else if(MainAc.title == Title.MainMenu){
			if(mx >= MainAc.width*1/3 && mx <= MainAc.width*1/3 + MainAc.width/3 && my >= MainAc.height*5/26 && my <= MainAc.height*5/26 + MainAc.height/13*2){
				MainAc.title = Title.SetGameMenu;
			}else if(mx >= MainAc.width*1/3 && mx <= MainAc.width*1/3 + MainAc.width/3 && my >= 2*MainAc.height*5/26 && my <= 2*MainAc.height*5/26 + MainAc.height/13*2){
				if(board.createdPlayers){
					MainAc.title = Title.Game;
				}
			}else if(mx >= MainAc.width*1/3 && mx <= MainAc.width*1/3 + MainAc.width/3 && my >= 3*MainAc.height*5/26 && my <= 3*MainAc.height*5/26 + MainAc.height/13*2){
				//Implement method
			}else if(mx >= MainAc.width*1/3 && mx <= MainAc.width*1/3 + MainAc.width/3 && my >= 4*MainAc.height*5/26 && my <= 4*MainAc.height*5/26 + MainAc.height/13*2){
				System.exit(2);
			}
			
			
		}else if(MainAc.title == Title.SetGameMenu){
			if(mx >= MainAc.width/6 + MainAc.width*26/64 + MainAc.width*3/64 && mx <= MainAc.width/6 + MainAc.width*26/64 + MainAc.width*3/64 + MainAc.width*3/48 && my >= MainAc.height/4 && my <= MainAc.height/4 + MainAc.height/32){
				if(Player.typedAmountOfPlayers < 5){
					Player.typedAmountOfPlayers++;
				}
			}else if(mx >= MainAc.width/6 + MainAc.width*26/64 + MainAc.width*3/64 && mx <= MainAc.width/6 + MainAc.width*26/64 + MainAc.width*3/64 + MainAc.width*3/48 && my >= MainAc.height/4 + MainAc.height/32 && my <= MainAc.height/4 + MainAc.height/32 + MainAc.height/32){
				if(Player.typedAmountOfPlayers > 2){
					Player.typedAmountOfPlayers--;
				}
			}else if(mx >= MainAc.width*2/5 && mx <= MainAc.width*2/5 + MainAc.width/5 && my >= MainAc.height*3/4 && my <= MainAc.height*3/4 + MainAc.height/8){
				MainAc.title = Title.SetPlayer;
			}
			
			
		}else if(MainAc.title == Title.SetPlayer){
			if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*0/16 && my <= MainAc.width*0/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.blue);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*1/16 && my <= MainAc.width*1/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.cyan);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*2/16 && my <= MainAc.width*2/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.gray);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*3/16 && my <= MainAc.width*3/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.LIGHT_GRAY);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*4/16 && my <= MainAc.width*4/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.white);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*5/16 && my <= MainAc.width*5/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.pink);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*6/16 && my <= MainAc.width*6/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.magenta);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*7/16 && my <= MainAc.width*7/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.red);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*8/16 && my <= MainAc.width*8/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.orange);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*9/16 && my <= MainAc.width*9/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.yellow);
				
			}else if(mx >= MainAc.width*15/16 && mx <= MainAc.width && my >= MainAc.width*10/16 && my <= MainAc.width*10/16 + MainAc.width/16){
				board.players[SetPlayer.player - 1].setPlayerColor(Color.green);
				
			}else if(mx >= MainAc.width*2/5 && mx <= MainAc.width*2/5 + MainAc.width/5 && my >= MainAc.height*3/4 && my <= MainAc.height*3/4 + MainAc.height/8 && !isColorOwned() && board.players[SetPlayer.player - 1].getPlayerName().length() != 0){
				if(SetPlayer.player < Player.typedAmountOfPlayers){
					SetPlayer.player++;
				}else{
					MainAc.title = Title.Game;
					board.createdPlayers = true;
				}
			}			
		}
		
		if(MainAc.title == Title.Game || MainAc.title == Title.ActionMenu || MainAc.title == Title.MeMenu || MainAc.title == Title.ShowMyProperties){
			stanField = (3*MainAc.width/4)/13;
			fieldX = MainAc.width/4; 
			fieldY = 0;
			
			if(!(mx >= MainAc.width/4 + (3*MainAc.width/4)/13*2 && mx <= MainAc.width/4 + ((3*MainAc.width/4)/13*2 + MainAc.width - (3*MainAc.width/4)/13*4 - MainAc.width/4 - 20) && my >= (3*MainAc.width/4)/13*2 && my <= (3*MainAc.width/4)/13*2 + (MainAc.height - (3*MainAc.width/4)/13*4 - 20))){
				for (int j = 0; j < board.showFields.length; j++) {
					board.showFields[j] = false;
				}
			}
			
			for (int i = 0; i < board.fields.length; i++) {
				
				if(i == 0){
					//StartField
					if(mx >= fieldX && mx <= fieldX + stanField * 2 && my >= fieldY && my <= fieldY + stanField * 2){
						board.showFields[i] = true;							
						System.out.println("kage");
					}
					fieldX += stanField * 2;
				}else if(i > 0 && i < 10){
					//First row
					if(mx >= fieldX && mx <= fieldX + stanField && my >= fieldY && my <= fieldY + stanField * 2){
						board.showFields[i] = true;
					}
					fieldX += stanField;
				}else if(i == 10){
					//Visit Jail
					if(mx >= fieldX && mx <= fieldX + stanField * 2 && my >= fieldY && my <= fieldY + stanField * 2){
						board.showFields[i] = true;
					}
					fieldY += stanField * 2;
				}else if(i > 10 && i < 20){
					//Second row
					if(mx >= fieldX && mx <= fieldX + stanField * 2 && my >= fieldY && my <= fieldY + stanField){
						board.showFields[i] = true;
					}
					fieldY += stanField;
				}else if(i == 20){
					//Free Parking
					if(mx >= fieldX && mx <= fieldX + stanField * 2 && my >= fieldY && my <= fieldY + stanField * 2){
						board.showFields[i] = true;
					}
					fieldX -= stanField;
				}else if(i > 20 && i < 29){
					//Third row
					if(mx >= fieldX && mx <= fieldX + stanField && my >= fieldY && my <= fieldY + stanField * 2){
						board.showFields[i] = true;
					}
					fieldX -= stanField;
				}else if(i == 29){
					//Last Field in Third row
					if(mx >= fieldX && mx <= fieldX + stanField && my >= fieldY && my <= fieldY + stanField * 2){
						board.showFields[i] = true;
					}
					fieldX -= stanField * 2;
				}else if(i == 30){
					//Go To Jail
					if(mx >= fieldX && mx <= fieldX + stanField * 2 && my >= fieldY && my <= fieldY + stanField * 2){
						board.showFields[i] = true;
					}
					fieldY -= stanField;
				}else if(i > 30 && i < 40){
					//Final row
					if(mx >= fieldX && mx <= fieldX + stanField * 2 && my >= fieldY && my <= fieldY + stanField){
						board.showFields[i] = true;
					}
					fieldY -= stanField;
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		if(!board.shouldShowField() && Operations.canRollDice && mx >= MainAc.width/4 + 66*stanFelt/8 && mx <= MainAc.width/4 + 66*stanFelt/8 + 5/2*stanFelt && my >= 15*stanFelt/4 && my <= 15*stanFelt/4 +50){
			Dice.rollDice = false;
			if(Operations.move > Player.amountOfPlayers - 2){
				Operations.move -= Player.amountOfPlayers;
			}
			Operations.move++;
			Operations.canRollDice = false;
		}
	}
	
	public boolean isColorOwned(){
		int b = 0;
		for (int i = 0; i < Player.ownedColors.size(); i++) {
			if(board.players[SetPlayer.player - 1].getPlayerColor() == Player.ownedColors.get(i)){
				b++;
			}
		}
		if(b >= 2){
			return true;
		}else{
			return false;
		}
		
	}
}
