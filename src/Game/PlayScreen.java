package Game;

import Tools.Debug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayScreen extends JPanel implements ActionListener
{
	Debug debug = new Debug("PlayScreen", true, false);
	
	PlayScreen() //constructor
	{
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//TODO fill this out
		//move();
		//for x and y check collisions
		//regenerate (health, stamina, mana)
		//repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//TODO set font if needed
		//TODO Objects should know how to draw themselves!!!
		//TODO map.draw(); or map.draw(x, y);
		
	}
	
	//TODO Keyboard Events
	//Adapter over listener so that not all methods have to be defined
	//there is a keyTyped event that may be useful if non-keyboard characters may be entered
	//		for example if an alt-code is used - it may??? provide the character
	// 			≈ instead of ALT, 0, 2, 4, 7...
	private class KL extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			int keyCode = e.getKeyCode();
			switch (keyCode) {
				case KeyEvent.VK_ESCAPE:
					//TODO add a prompt hefore exiting
					System.exit(0);
				break;
				
				default:
				
				break;
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e)
		{
			int keyCode = e.getKeyCode();
			switch (keyCode) {
				default:
				
				break;
			}
		}
	}
	
	//TODO Mouse Events
	private class ML extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e)
		{
		
		}
	}
	
	//TODO Window Events
	private class WL extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			//try {Thread.currentThread().join();} catch (interruptedException ex) {}
		}
	}
}
