package Game;

import Tools.Debug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static Tools.MathFunctions.fastfloor;

public class PlayScreen extends JPanel implements ActionListener
{
	int [][] map;
	Color [] colors;
	PlayScreen() //constructor
	{
		Debug debug = new Debug("PlayScreen - Constructor", true, false);
		
		map = new int[17][17];
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				map[i][j] = (fastfloor(Math.random() * 6));
			}
		}
		
		colors = new Color[6];
		for(int i = 0; i < colors.length; i++)
		{
			colors[i] = new Color(fastfloor(Math.random() * 255), fastfloor(Math.random() * 255), fastfloor(Math.random() * 255));
		}
		
		Timer time = new Timer(15,this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
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
		
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				g2d.setColor(colors[map[i][j]]);
				g2d.fillRect(i * 25, j * 25, 25, 25);
			}
		}
	}
	
}
