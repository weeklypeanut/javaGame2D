package GameVersion1_2D;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;

public class Game implements Runnable {

	private Display display;

	public int width, height;
	
	public String title;
	
	private Thread thread;
	
	private boolean running = false;
	
	private BufferStrategy bs;
	
	private Graphics g;

	public Game(String title, int width,int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		display = new Display(title,width,height);
	}

	
	private void init() {
		
	}
	
	private void tick() {
		
	}
	private void render() {
		
		if(!(display.getCanvas().getBufferStrategy() == null)) {
			return;
		}
		else {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		System.out.println("bs?");
		bs = display.getCanvas().getBufferStrategy();
		System.out.println("bs!!");
		// sets buffer strategy to whatever the bs of the canvas is 
		// bs is a way for the computer to draw things
		// how they draw things
		// buffer is a screen in the computer 
		// a bunch of data that holds the same info as your screen
		// this helps prevent flickering

		g = bs.getDrawGraphics(); // gets the draw graphics of buffer strat
		// be used to draw graphics
		// draws images lines, 'magic paint brush'
		
		//DRAW HERE!
		g.fillRect(0, 0, width, height);
		
		// End Drawing!
		bs.show(); //bs shows
		g.dispose(); // finishes graphics object
	}
	
	public void run() {
		init(); // Initiates Display
		
		while(running) {
			tick(); // updates
			render();  // renders images
			
		}
		stop();
		
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start(); // calls RUN
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


