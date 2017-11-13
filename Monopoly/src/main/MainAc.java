package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class MainAc extends Canvas implements Runnable {
//	Vi opretter en højde og en bredde til vores JFrame, de skal være public static så vi kan bruge dem alle steder. 
	public static int height, width;
//	Vi laver en thread til at kører vores program i, vi laver en boolean der siger om programmet kører 
//	og vi laver et inctence af vores display for at kunne kører dens render funktion i vores mainAc render funktion
//	Vi laver vores vindu
	private Thread thread;
	private boolean running = false;
	private Display display;
	private Window window;
	private Board board;
	private Operations operations;
	private MainMenu mainMenu;
	private SetGameMenu setGameMenu;
	private SetPlayer setPlayer;
	BufferStrategy bs;
	Graphics g;
	public static Title title;

//	Vores construcktor til MainAc
	public MainAc(){
//		Vi sætter og opretter vores variabler: 
		width = 1280;
		height = width/4 * 3;
		
		window = new Window(width, height, "Monopoly", this);
		
		board = new Board();
		
//		Vi opretter en KeyListener og en MouseListener 
		this.addKeyListener(new Keys(this, board));
		this.addMouseListener(new MouseEvents(board));
		
		operations = new Operations(board);
		
		display = new Display(board, g);
		
		mainMenu = new MainMenu();
		
		setGameMenu = new SetGameMenu();
		
		setPlayer = new SetPlayer(board);
		
		title = Title.MainMenu;
	
	}
	
	
//	###########################
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
//	Her kører programmet og hvis running ikke er true stopper det med at render programmet
	public void run(){
		this.requestFocus();
		System.out.println("Nu kører den");
		while(running) {
			if(running){
				render();
				tick();
			}
		}
	}
	
//	Her er alle aktiviteter der sker per tick
	public void tick(){
		operations.tick();
		
		
	}
	
//	Her opretter render funktionen og i den laver vi en bufferstrategy vi sætter ind grafics så vi kan lave grafic
	public void render(){
		bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics/**2D**/ g = /**(Graphics2D)**/ bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		
//		Vi laver en sort baggrund 
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
//		Vi kalder det vi render fra display funktionen. 
		if(title == Title.Game || title == Title.ActionMenu){
			display.render(g, g2d);
		}else if(title == Title.MainMenu){
			mainMenu.render(g);
		}else if(title == Title.SetGameMenu){
			setGameMenu.render(g);
		}else if(title == Title.SetPlayer){
			setPlayer.render(g);
		}
		
		
		
		g.dispose();
		g2d.dispose();
		bs.show();
		
	}
	
//	Vi opretter en instance af MainAc og derfor kører spillet 
	public static void main(String[] args) {
		new MainAc();
	}
}
