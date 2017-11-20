package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class WinnerScreen {
	Board board; 
	
	public WinnerScreen(Board board){
		this.board = board;
	}
	
	public void render(Graphics g){
		g.setColor(board.players[0].getPlayerColor());
		g.fillRect(0, 0, MainAc.width, MainAc.height);
		g.setColor(Color.white);
		g.setFont(new Font("arial", 1, 40));
		g.drawString( "WINNER", 0, 200);
		g.drawString( "WINNER", 0, 300);
		g.drawString( "CHICKEN", 0, 400);
		g.drawString( "DINNER", 0, 500);
	}
}
