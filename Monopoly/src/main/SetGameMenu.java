package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SetGameMenu {
	Font textFont;
	Font moreLessFont;
	Font doneFont;
	
	public SetGameMenu(){
		textFont = new Font("arial", 1, 30);
		moreLessFont = new Font("arial", 1, 20);
		doneFont = new Font("arial", 1, 40);
	}
	
	
	public void render(Graphics g){
		g.setColor(Color.white);
		g.drawRect(MainAc.width/6, MainAc.height/4, MainAc.width*26/64, MainAc.height/16);
		g.setFont(textFont);
		g.drawString("How many players would you like?", MainAc.width/6 + 10, MainAc.height/4 + 40);
		
		g.drawRect(MainAc.width/6 + MainAc.width*26/64 , MainAc.height/4, MainAc.width*3/64, MainAc.height/16);
		g.drawString("" + Player.typedAmountOfPlayers, MainAc.width/6 + MainAc.width*26/64 + 22, MainAc.height/4 + 40);
		g.drawRect(MainAc.width/6 + MainAc.width*26/64 + MainAc.width*3/64, MainAc.height/4, MainAc.width*3/48, MainAc.height/32);
		g.drawRect(MainAc.width/6 + MainAc.width*26/64 + MainAc.width*3/64, MainAc.height/4 + MainAc.height/32, MainAc.width*3/48, MainAc.height/32);
		g.setFont(moreLessFont);
		g.drawString("More", MainAc.width/6 + MainAc.width*26/64 + MainAc.width*3/64 + 5, MainAc.height/4 + 24);
		g.drawString("Less", MainAc.width/6 + MainAc.width*26/64 + MainAc.width*3/64 + 5, MainAc.height/4 + MainAc.height/32 + 24);
		
		g.setFont(doneFont);
		g.drawRect(MainAc.width*2/5, MainAc.height*3/4, MainAc.width/5, MainAc.height/8);
		g.drawString("Done!", MainAc.width*2/5 + MainAc.width*7/128, MainAc.height*3/4 + MainAc.height*9/128);
	}
	
}
