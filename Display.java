package display;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private int width, height;
	private String title;
	
	private Canvas canvas;
	private JFrame frame;
	
	public Display(String title, int width, int height) {
		this.height = height; 
		this.width = width; 
		this.title = title; 
		createDisplay();
		
	}
	
	public void createDisplay() {
		JFrame frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Canvas canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		
		frame.add(canvas);
		frame.pack();
	}
		
		public Canvas getCanvas() {
			return canvas;
		}
		



}
