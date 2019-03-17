package Map;

import Game.Iakkumora;
import Tools.Debug;

import java.awt.*;
import java.util.ArrayList;

import static Tools.MathFunctions.fastfloor;

public class Map
{
	Section[][] map;
	ArrayList<Integer> xCoordinate;
	ArrayList<Integer> yCoordinate;
	
	static ArrayList<Color> colors;
	
	public Map() //Constructor
	{
		Debug debug = new Debug("Map - Constructor", true, false);
		debug.log("here");
		
//		map = new ArrayList<>(0);
		xCoordinate = new ArrayList<>(0);
		yCoordinate = new ArrayList<>(0);
		
		
		
//		for(int i = -1; i <= 1; i++)
//		{
//			for(int j = -1; j <= 1; j++)
//			{
//				generate(i, j);
//			}
//		}
		
		map = new Section(0,0);
		
		debug.log("map: " + map.toString());
		debug.log("xCoordinate: " + xCoordinate.toString());
		debug.log("yCoordinate: " + yCoordinate.toString());
		
		
	}
	
	void generate (int x, int y)
	{
//		map.add(fastfloor(Math.random() * 6));
//		xCoordinate.add(x);
//		yCoordinate.add(y);
	}
	
	void add (int x, int y)
	{
	
	}
	
	void drop (int x, int y)
	{
	
	}
	
	void load (int x, int y)
	{
	
	}
	
	void store (int x, int y)
	{
	
	}
	
	/*public Section getSection(int x, int y)
	{

		return null;
	}*/
	
	public void draw (Graphics2D g2d, int x, int y, int windowCenterX, int windowCenterY, int scale)
	{
		Debug debug = new Debug("Map - draw", false, false);
		debug.log("map: ");
		debug.dumpObject(map);
		
		int horizontalOffset = windowCenterX - scale * Chunk.getD() * Block.getD() * Section.getD() / 2;
		int verticalOffset = windowCenterY - scale * Chunk.getD() * Block.getD() * Section.getD() / 2;
		
//		for(int i = 0; i < map.size(); i++)
//		{
//			g2d.setColor(colors.get(map.get(i)));
//			g2d.fillRect(xCoordinate.get(i) * scale + horizontalOffset, yCoordinate.get(i) * scale + verticalOffset, scale, scale);
//		}
		
		map.draw(g2d, horizontalOffset, verticalOffset, scale);
	}
	
	//TODO determine if this is necessary
	//probably not... will probably get replaced by something in biome...
	public static Color getColor(int i)
	{
		return colors.get(i);
	}
	
	static
	{
		colors = new ArrayList<>(6);
		for(int i = 0; i < 6; i++)
		{
			colors.add(new Color(fastfloor(Math.random() * 255), fastfloor(Math.random() * 255), fastfloor(Math.random() * 255)));
		}
	}
}
