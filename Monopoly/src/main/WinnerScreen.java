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
		g.setFont(new Font("arial", 1, 100));
		//g.drawString( "WINNER", 200, 200);
		//g.drawString( "WINNER", 300, 300);
		//g.drawString( "CHICKEN", 400, 400);
		//g.drawString( "DINNER", 500, 500);
		g.drawString( "NUTID", 200, 200);
		g.drawString( "DATID", 300, 300);
		g.drawString( "ØLTID", 400, 400);
		g.drawString( "ALTID", 500, 500);
	}
}
