package main;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keys extends KeyAdapter{
	
	MainAc game;
	public static boolean ifPressed = false;
	
	public Keys(MainAc game){
		this.game = game;
		
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
	}
	
}
