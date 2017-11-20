package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Display {
	private int feltX, feltY, stanFelt, playerX, playerY;
	private int[] peopleOnField;
	private Font dice = new Font("arial", 1, 20), rolls = new Font("arial", 1, 55);
	private Board board;
	private Graphics g;
	private Menu menu;
	private Font monopolFont = new Font("arial", 1, 130), stanFont = new Font("arial", 1, 18), cornorFont = new Font("arial", 1, 28);
	
	public Display(Board board, Graphics g){
		this.board = board;
		this.g = g;
		menu = new Menu(board);
		peopleOnField = new int[board.fields.length];
		for (int i = 0; i < board.fields.length; i++) {	
			this.peopleOnField[i] = 0;
		}
		feltX = MainAc.width/4;
		feltY = 0;
	}
	
	public void render(Graphics g, Graphics2D g2d){
		
		stanFelt = (3*MainAc.width/4)/13;
		
		menu.render(g);

		
//		Overskriften på spillet (Monopol) Vi drejer teksten og bag efter drejer vi en tilbage.
		g2d.rotate(Math.PI/4, stanFelt*14/2, stanFelt*63/16);
		g2d.setColor(Color.magenta);
		g2d.setFont(monopolFont);
		g2d.drawString("MONOPOL", stanFelt*14/2, stanFelt*63/16);
		g2d.setFont(stanFont);
		g2d.rotate(-Math.PI/4, stanFelt*14/2, stanFelt*63/16);
		
		
		
		g.setColor(Color.white);
		for (int i = 0; i < 40; i++) {
			if(i == 0){
				g.drawRect(feltX, feltY, stanFelt * 2, stanFelt * 2);
				
				g2d.setFont(cornorFont);
				g2d.rotate(-Math.PI/4, feltX+70, feltY+90);
				g2d.drawString("" + board.fields[i].getPropertyName(), feltX+70, feltY + 90);
				g2d.rotate(Math.PI/4, feltX+70, feltY+90);
				g2d.setFont(stanFont);
				
				feltX += stanFelt * 2;
				
			}else if(i > 0 && i < 10){
				g.drawRect(feltX, feltY, stanFelt, stanFelt * 2);
				//Drawing the field color
				g.setColor(board.fields[i].color);
				g.fillRect(feltX + 1, feltY + 2 + 2*4*stanFelt/5, stanFelt - 1, stanFelt * 2/5 - 1);
				g.setColor(Color.white);
				
				//if chance
				if(board.fields[i].typeOfField == FieldProperties.Chance){
					g2d.setFont(monopolFont);
					g2d.setColor(new Color(159, 0, 228));
					g2d.drawString("?", feltX - 5, feltY + stanFelt*5/3);
					g2d.setFont(stanFont);
					g2d.setColor(Color.magenta);
				}
				
				// if owned
				if(board.fields[i].isOwned()){
					for (int j = 0; j < board.players.length; j++) {
						if(board.fields[i].getOwnedBy().equals(board.players[j].getPlayerName())){
							g.setColor(board.players[j].getPlayerColor());
							g.fillRect(feltX + 1, feltY + 2 + 2*4*stanFelt/5, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
							g.setColor(Color.white);
							g.drawRect(feltX + 1, feltY + 2 + 2*4*stanFelt/5, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
						}
					}
				}
				if(board.fields[i].isBuyable() && !board.fields[i].isOwned()){
					g2d.drawString("" + board.fields[i].getPrice(), feltX, feltY + 20);
				}
				feltX += stanFelt;
				
			}else if(i == 10){
				g.drawRect(feltX, feltY, stanFelt * 2, stanFelt * 2);
				
				g2d.setFont(cornorFont);
				g2d.rotate(Math.PI/4, feltX, feltY+30);
				g2d.drawString("" + board.fields[i].getPropertyName(), feltX, feltY + 30);
				g2d.rotate(-Math.PI/4, feltX, feltY+30);
				g2d.setFont(stanFont);
				
				feltY += stanFelt * 2;
				
			}else if(i > 10 && i < 20){
				g.drawRect(feltX, feltY, stanFelt * 2, stanFelt);
				//Drawing the field color
				g.setColor(board.fields[i].color);
				g.fillRect(feltX + 1, feltY + 1, stanFelt * 2/5 - 1, stanFelt - 1);
				g.setColor(Color.white);
				
				// if chance
				if(board.fields[i].typeOfField == FieldProperties.Chance){
					g2d.setFont(monopolFont);
					g2d.setColor(new Color(159, 0, 228));
					g2d.rotate(Math.PI/2, feltX + stanFelt*2/5, feltY - 5);
					g2d.drawString("?", feltX + stanFelt*2/5, feltY - 5);
					g2d.rotate(-Math.PI/2, feltX + stanFelt*2/5, feltY - 5);
					g2d.setFont(stanFont);
					g2d.setColor(Color.magenta);
				}
				
				//if owned
				if(board.fields[i].isOwned()){
					for (int j = 0; j < board.players.length; j++) {
						if(board.fields[i].getOwnedBy().equals(board.players[j].getPlayerName())){
							g.setColor(board.players[j].getPlayerColor());
							g.fillRect(feltX + 1, feltY + 1, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
							g.setColor(Color.white);
							g.drawRect(feltX + 1, feltY + 1, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
						}
					}
				}
				if(board.fields[i].isBuyable() && !board.fields[i].isOwned()){
					g2d.drawString("" + board.fields[i].getPrice(), feltX, feltY+ 20);
				}
				feltY += stanFelt;
				
			}else if(i == 20){
				g.drawRect(feltX, feltY, stanFelt * 2, stanFelt * 2);
				
				g2d.setFont(cornorFont);
				g2d.rotate(-Math.PI/4, feltX+25, feltY+132);
				g2d.drawString("" + board.fields[i].getPropertyName(), feltX+25, feltY + 132);
				g2d.rotate(Math.PI/4, feltX+25, feltY+132);
				g2d.setFont(stanFont);
				
				feltX -= stanFelt;
				
			}else if(i > 20 && i < 29){
				g.drawRect(feltX, feltY, stanFelt, stanFelt * 2);
				
				//Drawing the field color
				g.setColor(board.fields[i].color);
				g.fillRect(feltX + 1, feltY + 1, stanFelt - 1, stanFelt * 2/5 - 1);
				g.setColor(Color.white);
				
				//if chance
				if(board.fields[i].typeOfField == FieldProperties.Chance){
					g2d.setFont(monopolFont);
					g2d.setColor(new Color(159, 0, 228));
					g2d.drawString("?", feltX - 5, feltY + stanFelt*5/3);
					g2d.setFont(stanFont);
					g2d.setColor(Color.magenta);
				}
				
				//if owned
				if(board.fields[i].isOwned()){
					for (int j = 0; j < board.players.length; j++) {
						if(board.fields[i].getOwnedBy().equals(board.players[j].getPlayerName())){
							g.setColor(board.players[j].getPlayerColor());
							g.fillRect(feltX + 1, feltY + 1, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
							g.setColor(Color.white);
							g.drawRect(feltX + 1, feltY + 1, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
						}
					}
				}
				
				if(board.fields[i].isBuyable() && !board.fields[i].isOwned()){
					g2d.drawString("" + board.fields[i].getPrice(), feltX, feltY+ 20);
				}
				feltX -= stanFelt;
				
			}else if(i == 29){
				g.drawRect(feltX, feltY, stanFelt, stanFelt * 2);
				//Drawing the field color
				g.setColor(board.fields[i].color);
				g.fillRect(feltX + 1, feltY + 1, stanFelt - 1, stanFelt * 2/5 - 1);
				g.setColor(Color.white);
					
				//if chance
				if(board.fields[i].typeOfField == FieldProperties.Chance){
					g2d.setFont(monopolFont);
					g2d.setColor(new Color(159, 0, 228));
					g2d.drawString("?", feltX - 5, feltY + stanFelt*5/3);
					g2d.setFont(stanFont);
					g2d.setColor(Color.magenta);
				}
				
				//if owned
				if(board.fields[i].isOwned()){
					for (int j = 0; j < board.players.length; j++) {
						if(board.fields[i].getOwnedBy().equals(board.players[j].getPlayerName())){
							g.setColor(board.players[j].getPlayerColor());
							g.fillRect(feltX + 1, feltY + 1, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
							g.setColor(Color.white);
							g.drawRect(feltX + 1, feltY + 1, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
						}
					}
				}
				
				if(board.fields[i].isBuyable() && !board.fields[i].isOwned()){
					g2d.drawString("" + board.fields[i].getPrice(), feltX, feltY+ 20);
				}
				feltX -= stanFelt * 2;
				
			}else if(i == 30){
				g.drawRect(feltX, feltY, stanFelt * 2, stanFelt * 2);
				
				g2d.setFont(cornorFont);
				g2d.rotate(Math.PI/4, feltX+10, feltY+25);
				g2d.drawString("" + board.fields[i].getPropertyName(), feltX+10, feltY + 25);
				g2d.rotate(-Math.PI/4, feltX+10, feltY+25);
				g2d.setFont(stanFont);
				
				feltY -= stanFelt;
				
			}else if(i > 30 && i < 40){
				g.drawRect(feltX, feltY, stanFelt * 2, stanFelt);
				//Drawing the field color
				g.setColor(board.fields[i].color);
				g.fillRect(feltX + 2 + 2*4*stanFelt/5, feltY + 1, stanFelt * 2/5 - 1, stanFelt - 1);
				g.setColor(Color.white);
				
				//If Chance
				if(board.fields[i].typeOfField == FieldProperties.Chance){
					g2d.setFont(monopolFont);
					g2d.setColor(new Color(159, 0, 228));
					g2d.rotate(-Math.PI/2, feltX + stanFelt*8/5, feltY + stanFelt + 3);
					g2d.drawString("?", feltX + stanFelt*8/5, feltY + stanFelt + 3);
					g2d.rotate(Math.PI/2, feltX + stanFelt*8/5, feltY + stanFelt + 3);
					g2d.setFont(stanFont);
					g2d.setColor(Color.magenta);
				}
				
				//If owned
				if(board.fields[i].isOwned()){
					for (int j = 0; j < board.players.length; j++) {
						if(board.fields[i].getOwnedBy().equals(board.players[j].getPlayerName())){
							g.setColor(board.players[j].getPlayerColor());
							g.fillRect(feltX + 2 + 2*4*stanFelt/5, feltY + 1, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
							g.setColor(Color.white);
							g.drawRect(feltX + 2 + 2*4*stanFelt/5, feltY + 1, stanFelt * 2/5 - 1, stanFelt * 2/5 - 1);
						}
					}
				}
				
				if(board.fields[i].isBuyable() && !board.fields[i].isOwned()){
					g2d.drawString("" + board.fields[i].getPrice(), feltX, feltY+ 20);
				}
				
				feltY -= stanFelt;
			}
		}
		feltX = MainAc.width/4;
		feltY = 0;
		
		g.setColor(Color.cyan);
		g.setFont(rolls);
		g.drawRoundRect(MainAc.width/4 + 19*stanFelt/2, 5*stanFelt/2, stanFelt, stanFelt, 50, 50);
		g.drawString("" + Dice.diceRight, MainAc.width/4 + 19*stanFelt/2 + 23, 5*stanFelt/2 + 55);
		
		g.drawRoundRect(MainAc.width/4 + 8*stanFelt, 5*stanFelt/2, stanFelt, stanFelt, 50, 50);
		g.drawString("" + Dice.diceLeft, MainAc.width/4 +  8*stanFelt + 23, 5*stanFelt/2 + 55);
		
		g.drawRect(MainAc.width/4 + 66*stanFelt/8, 15*stanFelt/4, 5/2*stanFelt, 50);
		g.setFont(dice);
		g.drawString("Roll the dice", MainAc.width/4 + 66*stanFelt/8 + 15, 15*stanFelt/4 + 30);
		
		for (int j = 0; j < board.fields.length; j++) {
			for (int k = 0; k < board.fields[j].getHouseAmounts(); k++) {
				for (int l = 0; l < board.players.length; l++) {
					if(board.players[l].getPlayerName().equals(board.fields[j].getOwnedBy())){
						g.setColor(board.players[l].getPlayerColor());
					}
				}
				
				getFieldCorner(j);
				g.fillRect(playerX + k*stanFelt/5, playerY, stanFelt/5, stanFelt/5);
				g.setColor(Color.white);
				g.drawRect(playerX + k*stanFelt/5, playerY, stanFelt/5, stanFelt/5);
			}
		}
		
		for (int j = 0; j < board.players.length; j++) {
			peopleOnField[board.players[j].getPlayerPlace()]++;
			g.setColor(board.players[j].getPlayerColor());
			getFieldCorner(board.players[j].getPlayerPlace());
			g.fillRect(playerX, playerY, stanFelt/4, stanFelt/4);	
			g.setColor(Color.white);
			g.drawRect(playerX, playerY, stanFelt/4, stanFelt/4);
		}
		
		for (int j = 0; j < board.players.length; j++) {
			peopleOnField[board.players[j].getPlayerPlace()]--;	
		}
		
		if(board.shouldShowField()){
			for (int j = 0; j < board.fields.length; j++) {
				if(board.showFields[j]){
					g.setColor(Color.black);
					g.fillRect(MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2, MainAc.width - (3*MainAc.width/4)/13*4 - MainAc.width/4 - 11, MainAc.height - (3*MainAc.width/4)/13*4 - 11);
					g.setColor(Color.white);
					g.drawRect(MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2, MainAc.width - (3*MainAc.width/4)/13*4 - MainAc.width/4 - 11, MainAc.height - (3*MainAc.width/4)/13*4 - 11);
					g.drawString(board.fields[j].getPropertyName(), MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2 + 40);
					g.drawString("" + j, MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2 + 100);
					if(board.fields[j].isOwned()){
						g.drawString("This Field Is Owned By " + board.fields[j].getOwnedBy(), MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2 + 160);
					}
					
					if(board.fields[j].isBuyable() && !board.fields[j].isOwned()){
						g.drawString("This Field is Buyable", MainAc.width/4 + (3*MainAc.width/4)/13*2, (3*MainAc.width/4)/13*2 + 220);
					}
				}
			}
		}
	}
	
	public void getFieldCorner(int numField){
		playerX = MainAc.width/4;
		playerY = 0;
		
		for (int i = 0; i < numField; i++) {
			if(i == 0){
				playerX += stanFelt * 2;
			}else if(i > 0 && i < 10){
				playerX += stanFelt;
			}else if(i == 10){
				playerY += stanFelt * 2;
			}else if(i > 10 && i < 20){
				playerY += stanFelt;
			}else if(i == 20){
				playerX -= stanFelt;
			}else if(i > 20 && i < 29){
				playerX -= stanFelt;
			}else if(i == 29){
				playerX -= stanFelt * 2;
			}else if(i == 30){
				playerY -= stanFelt;
			}else if(i > 30 && i < 40){
				playerY -= stanFelt;
			}
		}
		playerX += (peopleOnField[numField] - 1)*stanFelt/4;
		playerY += stanFelt/4;
		playerX++;
		playerY++;
	}
}





















//for (int i = 0; i < 40; i++) {
//	if(i == 0){
//		g.drawRect(feltX, feltY, stanFelt * 2, stanFelt * 2);
//		feltX += stanFelt * 2;
//	}else if(i > 0 && i < 10){
//		g.drawRect(feltX, feltY, stanFelt, stanFelt * 2);
//		feltX += stanFelt;
//	}else if(i == 10){
//		g.drawRect(feltX, feltY, stanFelt * 2, stanFelt * 2);
//		feltY += stanFelt * 2;
//	}else if(i > 10 && i < 20){
//		g.drawRect(feltX, feltY, stanFelt * 2, stanFelt);
//		feltY += stanFelt;
//	}else if(i == 20){
//		g.drawRect(feltX, feltY, stanFelt * 2, stanFelt * 2);
//		feltX -= stanFelt;
//	}else if(i > 20 && i < 29){
//		g.drawRect(feltX, feltY, stanFelt, stanFelt * 2);
//		feltX -= stanFelt;
//	}else if(i == 29){
//		g.drawRect(feltX, feltY, stanFelt, stanFelt * 2);
//		feltX -= stanFelt * 2;
//	}else if(i == 30){
//		g.drawRect(feltX, feltY, stanFelt * 2, stanFelt * 2);
//		feltY -= stanFelt;
//	}else if(i > 30 && i < 40){
//		g.drawRect(feltX, feltY, stanFelt * 2, stanFelt);
//		feltY -= stanFelt;
//	}
//}

