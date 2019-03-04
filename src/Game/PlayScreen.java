package Game;

import Map.Map;
import Tools.Debug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class PlayScreen extends JPanel implements ActionListener
{
	Map map;
	int scale;
	PlayScreen() //constructor
	{
		Debug debug = new Debug("PlayScreen - Constructor", true, false);
		
		map = new Map();
		scale = 25;
		Timer time = new Timer(15,this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Debug debug = new Debug("PlayScreen - actionPerformed", true, false);
		debug.log("Here");
		//TODO fill this out
		//move();
		//for x and y check collisions
		//regenerate (health, stamina, mana)
		repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//TODO set font if needed
		//TODO Objects should know how to draw themselves!!!
		//TODO map.draw(); or map.draw(x, y);
		
		int windowWidth = Iakkumora.mainWindow.getWidth();
		int windowHeight = Iakkumora.mainWindow.getHeight();
		int windowCenterX = windowWidth / 2;
		int windowCenterY = windowHeight / 2;
		
		map.draw(g2d, 0, 0, windowCenterX, windowCenterY, scale);
	}
	
}
