
package main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	//Vores varible, l�ngde p� bredden af sk�rmen og l�ngden p� h�jden af sk�rmen, titlen, vi importere vores spil og s� opretter vi en JFrame
	int width, height;
	String title;
	MainAc game;
	JFrame frame;
	
	public Window(int width, int height, String title, MainAc game){
//		Vi laver vores variabler til dem der er i inputtet 
		this.width = width;
		this.height = height;
		this.title = title;
		this.game = game;
		
//		Vi laver JFramen 
		frame = new JFrame(title);
//		Vi s�tter JFramens st�rrelse
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
//		Vi siger at JFramen skal lukke programmet n�r vi lukker det p� knappen, Vi siger den ikke skal kunne skalleres, vi s�tter den midt p� sk�rmen
//		Vi putter spillet ind i vores JFrame s� vi kan se vores spil, vi g�r s� JFramen er synlig og vi starter spillet 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();

		
		
		
		
	}
	
}
