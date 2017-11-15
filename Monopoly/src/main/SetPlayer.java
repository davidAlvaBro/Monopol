package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SetPlayer {
	public static int player = 1;
	private Font textFont;
	private Font nextPage;
	private Font moreLessFont;
	private Font idiots;
	private Board board;
	private Boolean playerMade = false;
	
	public SetPlayer(Board board){
		textFont = new Font("arial", 1, 30);
		moreLessFont = new Font("arial", 1, 20);
		nextPage = new Font("arial", 1, 40);
		idiots = new Font("arial", 1, 75);
		this.board = board;
	}
	
	
	public void render(Graphics g){
		if(playerMade){
			g.setColor(Color.white);
			g.drawRect(MainAc.width/6, MainAc.height/4, MainAc.width*19/64, MainAc.height/16);
			g.setFont(textFont);
			g.drawString("What is player " + SetPlayer.player + "'s name?", MainAc.width/6 + 10, MainAc.height/4 + 40);
			
			g.drawRect(MainAc.width/6 + MainAc.width*19/64, MainAc.height/4, MainAc.width*19/64, MainAc.height/16);
			g.setColor(board.players[player - 1].getPlayerColor());
			g.drawString(board.players[player - 1].getPlayerName(), MainAc.width/6 + MainAc.width*19/64 + 10, MainAc.height/4 + 40);
			

			g.setColor(Color.BLUE);
			g.fillRect(MainAc.width*15/16, MainAc.width*0/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.CYAN);
			g.fillRect(MainAc.width*15/16, MainAc.width*1/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.GRAY);
			g.fillRect(MainAc.width*15/16, MainAc.width*2/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(MainAc.width*15/16, MainAc.width*3/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.white);
			g.fillRect(MainAc.width*15/16, MainAc.width*4/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.pink);
			g.fillRect(MainAc.width*15/16, MainAc.width*5/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.magenta);
			g.fillRect(MainAc.width*15/16, MainAc.width*6/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.red);
			g.fillRect(MainAc.width*15/16, MainAc.width*7/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.orange);
			g.fillRect(MainAc.width*15/16, MainAc.width*8/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.yellow);
			g.fillRect(MainAc.width*15/16, MainAc.width*9/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.green);
			g.fillRect(MainAc.width*15/16, MainAc.width*10/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.white);
			g.setFont(nextPage);
			g.drawRect(MainAc.width*2/5, MainAc.height*3/4, MainAc.width/5, MainAc.height/8);
			g.drawString("Done!", MainAc.width*2/5 + MainAc.width*7/128, MainAc.height*3/4 + MainAc.height*9/128);
			
			if(!(board.players[player - 1].getPlayerName().length() >= 1)){
				g.drawString("Pick a name!", MainAc.width*2/5 + MainAc.width*1/128, MainAc.height*3/4 - MainAc.height*5/128);
			}
			
			if(isColorOwned()){
				g.drawString("Pick a color!", MainAc.width*2/5 + MainAc.width*1/128, MainAc.height*3/4 - MainAc.height*10/128);
			}
		
			
			if(Operations.idiots){
				g.setColor(Color.white);
				g.setFont(idiots);
				g.drawString("CAN'T GO BACK NOW CAN YOU?", MainAc.width/40, MainAc.height/5);
				g.setFont(textFont);
			}
			
		}else{
			playerMade = true;
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
