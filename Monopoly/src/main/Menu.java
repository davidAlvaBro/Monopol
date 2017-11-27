package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {
	int sFMenu;
	private Font leftMenuFont = new Font("arial", 1, 48), playerNameFont = new Font("arial", 1, 24), actionMenuFont = new Font("arial", 1, 32), tileFont = new Font("arial", 1, 18);
	private Board board;
	private int propertiesDistance = MainAc.height/7;

	public Menu(Board board) {
		this.board = board;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(leftMenuFont);
		if(MainAc.title == Title.ShowMyProperties){
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
			g.setColor(board.players[Operations.turn].getPlayerColor());
			g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
			g.setColor(Color.white);
			
			for (int i = 0; i < board.fields.length; i++) {
				if(board.fields[i].isOwned()){
					if(board.fields[i].getOwnedBy().equals(board.players[Operations.turn].getPlayerName())){
						g.drawRect(0, propertiesDistance, MainAc.width/4 - 20, MainAc.height*5/7/26);
						g.setFont(tileFont);
						g.setColor(board.fields[i].color);
						g.drawString(board.fields[i].getPropertyName(), 10, propertiesDistance + 20);
						g.setColor(Color.white);
						g.drawString("" + board.fields[i].getPriceForHouse(), MainAc.width/4 - 50, propertiesDistance + 20);
						propertiesDistance += MainAc.height * 5/7/26;
						g.setFont(leftMenuFont);
					}
				}
			}propertiesDistance = MainAc.height/7;
			
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height * 6 / 7);
			
			g.drawRect(0, MainAc.height / 7*6, MainAc.width / 4 - 20, MainAc.height / 7);
			g.drawString("Back", 0, MainAc.height / 7*6 + 45);
			
		}else if(MainAc.title == Title.BuyHouse){
			//Lav det oven over til det samme som det her. Med firkanter om
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
			g.setColor(board.players[Operations.turn].getPlayerColor());
			g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
			g.setColor(Color.white);
			
			for (int i = 0; i < board.fields.length; i++) {
				if(board.fields[i].isOwned() && board.fields[i].typeOfField == FieldProperties.NormalField){
					if(board.fields[i].getOwnedBy().equals(board.players[Operations.turn].getPlayerName())){
						g.drawRect(0, propertiesDistance, MainAc.width/4 - 20, MainAc.height*5/7/26);
						g.setFont(tileFont);
						g.setColor(board.fields[i].color);
						g.drawString(board.fields[i].getPropertyName(), 10, propertiesDistance + 20);
						g.setColor(Color.white);
						g.drawString("" + board.fields[i].getPriceForHouse(), MainAc.width/4 - 50, propertiesDistance + 20);
						propertiesDistance += MainAc.height * 5/7/26;
						g.setFont(leftMenuFont);
					}
				}
			}propertiesDistance = MainAc.height/7;
			
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height * 6 / 7);
			
			g.drawRect(0, MainAc.height / 7*6, MainAc.width / 4 - 20, MainAc.height / 7);
			g.drawString("Back", 0, MainAc.height / 7*6 + 45);
			
		}else if(MainAc.title == Title.PawnOrSetSale){
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
			g.setColor(board.players[Operations.turn].getPlayerColor());
			g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
			g.setColor(Color.white);
			
			g.drawRect(0, MainAc.height/7, MainAc.width/4 - 20, 5*MainAc.height/14);
			g.drawRect(0, 7*MainAc.height/14, MainAc.width/4 - 20, MainAc.height*5/7);
			
			g.setFont(leftMenuFont);
			g.drawString("Set For Sale", 10, MainAc.height*2/7 + 40);
			g.drawString("Pawn Property", 10, MainAc.height*5/7 - 20);
			
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height * 6 / 7);
			
			g.drawRect(0, MainAc.height / 7*6, MainAc.width / 4 - 20, MainAc.height / 7);
			g.drawString("Back", 0, MainAc.height / 7*6 + 45);
			
		}else if(MainAc.title == Title.SetForSale){
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
			g.setColor(board.players[Operations.turn].getPlayerColor());
			g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
			g.setColor(Color.white);
			
			for (int i = 0; i < board.fields.length; i++) {
				if(board.fields[i].isOwned()){
					if(board.fields[i].getOwnedBy().equals(board.players[Operations.turn].getPlayerName())){
						g.drawRect(0, propertiesDistance, MainAc.width/4 - 20, MainAc.height*5/7/26);
						g.setFont(tileFont);
						g.setColor(board.fields[i].color);
						g.drawString(board.fields[i].getPropertyName(), 10, propertiesDistance + 20);
						g.setColor(Color.white);
						g.drawString("" + board.fields[i].getPrice(), MainAc.width/4 - 50, propertiesDistance + 20);
						propertiesDistance += MainAc.height * 5/7/26;
						g.setFont(leftMenuFont);
					}
				}
			}propertiesDistance = MainAc.height/7;
			
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height * 6 / 7);
			
			g.drawRect(0, MainAc.height / 7*6, MainAc.width / 4 - 20, MainAc.height / 7);
			g.drawString("Back", 0, MainAc.height / 7*6 + 45);
			
		}else if(MainAc.title == Title.SettingForSale){
			//Lav det oven over til det samme som det her. Med firkanter om
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
			g.setColor(board.players[Operations.turn].getPlayerColor());
			g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
			g.setColor(Color.white);
			
			g.drawRect(0, propertiesDistance, MainAc.width/4 - 20, MainAc.height*5/7);
			g.drawRect(0, MainAc.height*3/7, MainAc.width/4 - 20, MainAc.height/7);
			g.setFont(actionMenuFont);
			g.drawString(board.fields[Board.fieldSettingForSale].getPropertyName(), 10, MainAc.height*3/7 + 50);
			g.drawString(board.fields[Board.fieldSettingForSale].priceForBuying + "", 30, MainAc.height*3/7 + 100);
			
			g.setFont(leftMenuFont);
			g.drawString("More", (MainAc.width/4 - 20) / 2 - 60, MainAc.height*2/7 + 10);
			g.drawString("Less", (MainAc.width/4 - 20) / 2 - 60, MainAc.height*5/7 + 10);
			
			
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height * 6 / 7);
			g.setFont(leftMenuFont);
			
			g.drawRect(0, MainAc.height / 7*6, MainAc.width / 4 - 20, MainAc.height / 7);
			g.drawString("Done", 0, MainAc.height / 7*6 + 45);
			
		}else if(MainAc.title == Title.Trade){
			//Lav det oven over til det samme som det her. Med firkanter om
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
			g.setColor(board.players[Operations.turn].getPlayerColor());
			g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
			g.setColor(Color.white);
			
			for (int i = 0; i < board.fields.length; i++) {
				if(board.fields[i].isOwned() && (board.fields[i].typeOfField == FieldProperties.NormalField || board.fields[i].typeOfField == FieldProperties.TrainStation) && board.fields[i].forSale){
					if(board.fields[i].getOwnedBy().equals(board.players[Operations.turn].getPlayerName())){
						
					}else{
						g.setColor(Color.white);
						g.drawRect(0, propertiesDistance, MainAc.width/4 - 20, MainAc.height*5/7/26);
						g.setFont(tileFont);
						g.setColor(board.fields[i].color);
						g.drawString(board.fields[i].getPropertyName(), 10, propertiesDistance + 20);
						for (int j = 0; j < board.players.length; j++) {
							if(board.fields[i].getOwnedBy().equals(board.players[j].getPlayerName())){
								g.setColor(board.players[j].getPlayerColor());
							}
						}
						g.drawString("" + board.fields[i].priceForBuying, MainAc.width/4 - 55, propertiesDistance + 20);
						propertiesDistance += MainAc.height * 5/7/26;
						g.setFont(leftMenuFont);
					}
				}
			}propertiesDistance = MainAc.height/7;
			
			g.setColor(Color.white);
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height * 6 / 7);
			
			g.drawRect(0, MainAc.height / 7*6, MainAc.width / 4 - 20, MainAc.height / 7);
			g.drawString("Back", 0, MainAc.height / 7*6 + 45);
			
		}else if(MainAc.title == Title.PersonToTradeWith){
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
			g.setColor(board.players[Operations.turn].getPlayerColor());
			g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
			g.setColor(Color.white);
			
			for (int i = 0; i < board.players.length; i++) {
				if(!board.players[Operations.turn].getPlayerName().equals(board.players[i].getPlayerName())){
					g.drawRect(0, propertiesDistance, MainAc.width/4 - 20, MainAc.height*5/7/26);
					g.setFont(tileFont);
					g.setColor(board.players[i].getPlayerColor());
					g.drawString(board.players[i].getPlayerName(), 10, propertiesDistance + 20);
					g.setColor(Color.white);
					propertiesDistance += MainAc.height * 5/7/26;
					g.setFont(leftMenuFont);
				}
			}propertiesDistance = MainAc.height/7;
			
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height * 6 / 7);
			
			g.drawRect(0, MainAc.height / 7*6, MainAc.width / 4 - 20, MainAc.height / 7);
			g.drawString("Back", 0, MainAc.height / 7*6 + 45);
			
		}else if(MainAc.title == Title.PropertiesTraderHas){
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
			g.setColor(board.players[Operations.turn].getPlayerColor());
			g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
			g.setColor(Color.white);
			
			for (int i = 0; i < board.fields.length; i++) {
				if(board.fields[i].isOwned()){
					if(board.fields[i].getOwnedBy().equals(board.players[Board.personToTradeWith].getPlayerName())){
						g.drawRect(0, propertiesDistance, MainAc.width/4 - 20, MainAc.height*5/7/26);
						g.setFont(tileFont);
						g.setColor(board.fields[i].color);
						g.drawString(board.fields[i].getPropertyName(), 10, propertiesDistance + 20);
						g.setColor(Color.white);
						g.drawString("" + board.fields[i].getPriceForHouse(), MainAc.width/4 - 50, propertiesDistance + 20);
						propertiesDistance += MainAc.height * 5/7/26;
						g.setFont(leftMenuFont);
					}
				}
			}propertiesDistance = MainAc.height/7;
			
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height * 6 / 7);
			
			g.drawRect(0, MainAc.height / 7*6, MainAc.width / 4 - 20, MainAc.height / 7);
			g.drawString("Back", 0, MainAc.height / 7*6 + 45);
			
		}else if(MainAc.title == Title.WhatYouWantToGive){
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
			g.setColor(board.players[Operations.turn].getPlayerColor());
			g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
			g.setColor(Color.white);
			
			for (int i = 0; i < board.fields.length; i++) {
				if(board.fields[i].isOwned()){
					if(board.fields[i].getOwnedBy().equals(board.players[Operations.turn].getPlayerName())){
						g.drawRect(0, propertiesDistance, MainAc.width/4 - 20, MainAc.height*5/7/26);
						g.setFont(tileFont);
						g.setColor(board.fields[i].color);
						g.drawString(board.fields[i].getPropertyName(), 10, propertiesDistance + 20);
						g.setColor(Color.white);
						g.drawString("" + board.fields[i].getPrice(), MainAc.width/4 - 50, propertiesDistance + 20);
						propertiesDistance += MainAc.height * 5/7/26;
						g.setFont(leftMenuFont);
					}
				}
			}propertiesDistance = MainAc.height/7;
			
			g.setColor(Color.white);
			g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height * 6 / 7);
			
			g.drawRect(0, MainAc.height / 7*6, MainAc.width / 4 - 20, MainAc.height / 7);
			g.drawString("Back", 0, MainAc.height / 7*6 + 45);
			
		}else{
			for (int i = 0; i < 7; i++) {
				g.drawRect(0, sFMenu, MainAc.width / 4 - 20, MainAc.height / 7);
	
				if(MainAc.title == Title.ActionMenu){
					g.setFont(actionMenuFont);
					if (i == 0) {
						g.drawString("Buy This Property", 0, sFMenu + 45);
						g.setFont(playerNameFont);
						
						if(board.fields[board.players[Operations.turn].getPlayerPlace()].isBuyable() && !board.fields[board.players[Operations.turn].getPlayerPlace()].isOwned()){
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
						}else{
							g.drawString("This property ", MainAc.width*1/128, sFMenu + MainAc.height/7 - 40);
							g.drawString("is not for sale", MainAc.width*1/128, sFMenu + MainAc.height/7 -10);
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
				}else if(MainAc.title == Title.MeMenu){
					if (i == 0) {
						g.setColor(board.players[Operations.turn].getPlayerColor());
						g.drawString(board.players[Operations.turn].getPlayerName(), 0, sFMenu + 45);
						g.setFont(leftMenuFont);
						g.setColor(Color.white);
					}else if( i == 1){
						g.drawString("My Stuff", 0, sFMenu + 45);
					}else if( i == 2){
						g.drawString("My Value", 0, sFMenu + 45);
						g.setFont(playerNameFont);
						g.drawString("" + board.players[Operations.turn].getPlayerValue(), MainAc.width*5/32, sFMenu + MainAc.height/7 -10);
						g.setFont(leftMenuFont);
					}else if( i == 3){
						g.drawString("Balance", 0, sFMenu + 45);
						g.setFont(playerNameFont);
						g.drawString("" + board.players[Operations.turn].getPlayerCash(), MainAc.width*5/32, sFMenu + MainAc.height/7 -10);
						g.setFont(leftMenuFont);
					}else if( i == 4){
						g.drawString("Surrender", 0, sFMenu + 45);
						g.setFont(playerNameFont);
						g.drawString(Player.amountOfPlayers + " players left", MainAc.width*3/32, sFMenu + MainAc.height/7 -10);
						g.setFont(leftMenuFont);
					}else if( i == 5){
						g.drawString("Back", 0, sFMenu + 45);
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
		}	
		sFMenu = 0;
	}

}
