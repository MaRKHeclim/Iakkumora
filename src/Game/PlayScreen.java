package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayScreen extends JPanel implements ActionListener
{
	
	
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
		
	}
	
	//TODO Keyboard Events
	private class KL extends KeyAdapter
	{
		@Override
		public void keyReleased(KeyEvent e)
		{
		
		}
		
		@Override
		public void keyPressed(KeyEvent e)
		{
		
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
}
