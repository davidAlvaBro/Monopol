package main;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keys extends KeyAdapter{
	private MainAc game;
	private Board board;
	public static boolean ifPressed = false;
	
	public Keys(MainAc game, Board board){
		this.game = game;
		this.board = board;
		
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
			
		}else if(MainAc.title == Title.SetPlayer){
			if(key == KeyEvent.VK_DELETE){
				Operations.idiots = true;
			}else if(key == KeyEvent.VK_BACK_SPACE){
				Operations.idiots = true;
			}
		}
	}
	
	
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(MainAc.title == Title.SetPlayer && board.players[SetPlayer.player -1].getPlayerName().length() < 6){
			if(key == KeyEvent.VK_Q){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "Q");
			}
			else if(key == KeyEvent.VK_W){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "W");
			}
			else if(key == KeyEvent.VK_E){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "E");
			}
			else if(key == KeyEvent.VK_R){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "R");
			}
			else if(key == KeyEvent.VK_T){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "T");
			}
			else if(key == KeyEvent.VK_Y){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "Y");
			}
			else if(key == KeyEvent.VK_U){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "U");
			}
			else if(key == KeyEvent.VK_I){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "I");
			}
			else if(key == KeyEvent.VK_O){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "O");
			}
			else if(key == KeyEvent.VK_P){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "P");
			}
			else if(key == KeyEvent.VK_A){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "A");
			}
			else if(key == KeyEvent.VK_S){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "S");
			}
			else if(key == KeyEvent.VK_D){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "D");
			}
			else if(key == KeyEvent.VK_F){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "F");
			}
			else if(key == KeyEvent.VK_G){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "G");
			}
			else if(key == KeyEvent.VK_H){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "H");
			}
			else if(key == KeyEvent.VK_J){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "J");
			}
			else if(key == KeyEvent.VK_K){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "K");
			}
			else if(key == KeyEvent.VK_L){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "L");
			}
			else if(key == KeyEvent.VK_Z){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "Z");
			}
			else if(key == KeyEvent.VK_X){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "X");
			}
			else if(key == KeyEvent.VK_C){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "C");
			}
			else if(key == KeyEvent.VK_V){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "V");
			}
			else if(key == KeyEvent.VK_B){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "B");
			}
			else if(key == KeyEvent.VK_N){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "N");
			}
			else if(key == KeyEvent.VK_M){
				board.players[SetPlayer.player -1].setPlayerName(board.players[SetPlayer.player -1].getPlayerName() + "M");
			}
			else if(key == KeyEvent.VK_DELETE){
				Operations.idiots = false;
			}
			else if(key == KeyEvent.VK_BACK_SPACE){
				Operations.idiots = false;
			}
		}
	}
}
