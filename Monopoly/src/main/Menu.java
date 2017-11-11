package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {
	int sFMenu;
	private Font leftMenuFont = new Font("arial", 1, 48), playerNameFont = new Font("arial", 1, 24), actionMenuFont = new Font("arial", 1, 32);
	private Board board;

	public Menu(Board board) {
		this.board = board;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(leftMenuFont);
		for (int i = 0; i < 7; i++) {
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);

			if(MainAc.title == Title.ActionMenu){
				g.setFont(actionMenuFont);
				if (i == 0) {
					g.drawString("Buy This Property", 0, sFMenu + 45);
					g.setFont(playerNameFont);
					
					
					g.drawString("Balance:", MainAc.width*1/128, sFMenu + MainAc.height/7 - 40);
					
					g.setColor(board.players[Operations.turn].getPlayerColor());
					g.drawString("" + board.players[Operations.turn].getPlayerCash(), MainAc.width*1/64, sFMenu + MainAc.height/7 -10);
					
					g.setColor(Color.white);
					
					if(board.players[Operations.turn].getPlayerCash() > board.fields[board.players[Operations.turn].getPlayerPlace()].getPrice()){
						g.drawString("New Balance:", MainAc.width*14/128, sFMenu + MainAc.height/7 - 40);
						
						g.setColor(board.players[Operations.turn].getPlayerColor());
						g.drawString(board.players[Operations.turn].getPlayerCash() - board.fields[board.players[Operations.turn].getPlayerPlace()].getPrice() + "", MainAc.width*10/64, sFMenu + MainAc.height/7 -10);
						g.setFont(leftMenuFont);
						g.setColor(Color.white);
					}else{
						
						g.drawString("You Don't Have", MainAc.width*14/128, sFMenu + MainAc.height/7 - 40);
						g.drawString("The Money", MainAc.width*10/64, sFMenu + MainAc.height/7 -10);
						g.setFont(leftMenuFont);
						g.setColor(Color.white);
					}
					
					g.setFont(leftMenuFont);
					
				}else if( i == 1){
					g.drawString("Buy House", 0, sFMenu + 45);
//					///////////////// lav en boolean der kan se om vi kan købe huse og hvis det her:
//					g.setFont(playerNameFont);
//					g.setColor(board.players[Operations.turn].getPlayerColor());
//					g.drawString( board.players[Operations.turn].getPlayerName(), MainAc.width*5/32, sFMenu + MainAc.height/7 -10);
//					g.setFont(leftMenuFont);
//					g.setColor(Color.white);
				}else if( i == 2){
					g.drawString("Trade", 0, sFMenu + 45);
				}else if( i == 3){
					g.drawString("Pawn Property /", 0, sFMenu + 45);
					g.drawString("Set For Sale", 0, sFMenu + 90);
				}else if( i == 4){
					g.drawString("Buy Properties", 0, sFMenu + 45);
				}else if( i == 5){
					g.drawString("Back", 0, sFMenu + 45);
				}else if( i == 6){
					g.setFont(leftMenuFont);
					g.drawString("End Turn", 0, sFMenu + 45);
					g.setFont(playerNameFont);
					if(Operations.canRollDice){
						g.drawString("Roll First", MainAc.width*3/32 + 30, sFMenu + MainAc.height/7 -40);
					}
					g.setFont(leftMenuFont);
				}
				
			}else if(MainAc.title == Title.Game){
				if (i == 0) {
					g.drawString("Turn", 0, sFMenu + 45);
					g.setFont(playerNameFont);
					g.setColor(board.players[Operations.turn].getPlayerColor());
					g.drawString( board.players[Operations.turn].getPlayerName(), MainAc.width*5/32, sFMenu + MainAc.height/7 -10);
					g.setFont(leftMenuFont);
					g.setColor(Color.white);
				}else if( i == 1){
					g.drawString("Menu", 0, sFMenu + 45);
				}else if( i == 2){
					g.drawString("Info", 0, sFMenu + 45);
				}else if( i == 3){
					g.drawString("Me", 0, sFMenu + 45);
					g.setFont(playerNameFont);
					g.drawString("" + board.players[Operations.turn].getPlayerCash(), MainAc.width*5/32, sFMenu + MainAc.height/7 -10);
					g.setFont(leftMenuFont);
				}else if( i == 4){
					g.drawString("Players", 0, sFMenu + 45);
					g.setFont(playerNameFont);
					g.drawString(Player.amountOfPlayers + " players left", MainAc.width*3/32, sFMenu + MainAc.height/7 -10);
					g.setFont(leftMenuFont);
				}else if( i == 5){
					g.drawString("Actions", 0, sFMenu + 45);
				}else if( i == 6){
					g.drawString("End Turn", 0, sFMenu + 45);
					g.setFont(playerNameFont);
					if(Operations.canRollDice){
						g.drawString("Roll First", MainAc.width*3/32 + 30, sFMenu + MainAc.height/7 -40);
					}
					g.setFont(leftMenuFont);
				}
			}

			sFMenu += MainAc.height / 7;

		}
		sFMenu = 0;
	}

}
