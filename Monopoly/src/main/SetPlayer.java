package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SetPlayer {
	public static int player;
	private Font textFont;
	private Font moreLessFont;
	private Font idiots;
	private Board board;
	private Boolean playerMade = false;
	
	public SetPlayer(Board board){
		player++;
		textFont = new Font("arial", 1, 30);
		moreLessFont = new Font("arial", 1, 20);
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
			g.drawString(board.players[player - 1].getPlayerName(), MainAc.width/6 + MainAc.width*19/64 + 10, MainAc.height/4 + 40);
			

			g.setColor(Color.BLUE);
			g.fillRect(MainAc.width*15/16, MainAc.width*0/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.CYAN);
			g.fillRect(MainAc.width*15/16, MainAc.width*1/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.GRAY);
			g.fillRect(MainAc.width*15/16, MainAc.width*2/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.GREEN);
			g.fillRect(MainAc.width*15/16, MainAc.width*3/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(MainAc.width*15/16, MainAc.width*4/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.MAGENTA);
			g.fillRect(MainAc.width*15/16, MainAc.width*5/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.ORANGE);
			g.fillRect(MainAc.width*15/16, MainAc.width*6/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.PINK);
			g.fillRect(MainAc.width*15/16, MainAc.width*7/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.RED);
			g.fillRect(MainAc.width*15/16, MainAc.width*8/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.WHITE);
			g.fillRect(MainAc.width*15/16, MainAc.width*9/16, MainAc.width/16, MainAc.width/16);
			
			g.setColor(Color.YELLOW);
			g.fillRect(MainAc.width*15/16, MainAc.width*10/16, MainAc.width/16, MainAc.width/16);
		
			
			
			
			
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
}
