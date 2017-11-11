package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MainMenu {
	private int menuBoxHeight;
	private Font headLine = new Font("arial", 1, 84);
	private Font mainMenuFont = new Font("arial", 1, 64);
	
	
	public MainMenu(){
		menuBoxHeight = MainAc.height*5/26;
	}
	
	public void render(Graphics g){
		g.setColor(Color.white);
		g.setFont(headLine);
		g.drawString("MONOPOL", MainAc.width/3 - 5, 120);
		for (int i = 0; i < 4; i++) {
			g.drawRect(MainAc.width*1/3, menuBoxHeight, MainAc.width/3, MainAc.height/13*2);
			
			
			if(i == 0){
				g.setFont(mainMenuFont);
				g.drawString("New Game", MainAc.width*9/24, menuBoxHeight + MainAc.height/13 + 20);
				g.setFont(headLine);
			}else if(i == 1){
				g.setFont(mainMenuFont);
				g.drawString("Continue", MainAc.width*9/24 + 20, menuBoxHeight + MainAc.height/13 + 20);
				g.setFont(headLine);
			}else if(i == 2){
				g.setFont(mainMenuFont);
				g.drawString("Info", MainAc.width*9/24 + 100, menuBoxHeight + MainAc.height/13 + 20);
				g.setFont(headLine);
			}else if(i == 3){
				g.setFont(mainMenuFont);
				g.drawString("Quit", MainAc.width*9/24 + 90, menuBoxHeight + MainAc.height/13 + 20);
				g.setFont(headLine);
			}
			
			menuBoxHeight += MainAc.height*5/26;
		}
		
		menuBoxHeight = MainAc.height*5/26;
	}
}
