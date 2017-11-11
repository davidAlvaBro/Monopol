
package main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	//Vores varible, længde på bredden af skærmen og længden på højden af skærmen, titlen, vi importere vores spil og så opretter vi en JFrame
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
//		Vi sætter JFramens størrelse
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
//		Vi siger at JFramen skal lukke programmet når vi lukker det på knappen, Vi siger den ikke skal kunne skalleres, vi sætter den midt på skærmen
//		Vi putter spillet ind i vores JFrame så vi kan se vores spil, vi gør så JFramen er synlig og vi starter spillet 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();

		
		
		
		
	}
	
}
