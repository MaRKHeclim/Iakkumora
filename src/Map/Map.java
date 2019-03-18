package Map;

import Game.Iakkumora;
import Tools.Debug;

import java.awt.*;
import java.util.ArrayList;

import static Tools.MathFunctions.fastfloor;

public class Map
{
	Section[][] map;
	
	static ArrayList<Color> colors;
	
	public Map() //Constructor
	{
		Debug debug = new Debug("Map - Constructor", false, false);
		debug.log("here");
		
		
		map = new Section[3][3];
		
		for(int i = -1; i <= 1; i++)
		{
			for(int j = -1; j <= 1; j++)
			{
				generate(i, j);
			}
		}
		
		
		debug.log("map: " + map.toString());
		
		
	}
	
	void generate (int x, int y)
	{
		Debug debug = new Debug("Map - Generate", true, false);
		
		Section newSection = new Section(x, y);
		
		debug.log("Create a new section now: x: " + x + " y: " + y);
		add(newSection, x, y);
	}
	
	void add (Section sectionToAdd, int x, int y)
	{
		Debug debug = new Debug("Map - Add", true, false);
		int mapX;
		int mapY;
		try
		{
			mapX = map[0][0].getX();
			mapY = map[0][0].getY();
			int xDiff = x - mapX;
			int yDiff = y - mapY;
			if(xDiff < 0)
			{
				//the section to add is to the left of the existing map
				//shift map left
				debug.log("xDiff < 0. x: " + x + " y: " + y + " mapX: " + mapX + " mapY: " + mapY);
			}
			else if (xDiff > 2)
			{
				//the section to add is to the right of the existing map
				//shift map right
				debug.log("xDiff > 2. x: " + x + " y: " + y + " mapX: " + mapX + " mapY: " + mapY);
			}
			else if (yDiff < 0)
			{
				//the section to add is below the existing map
				//shift map down
				debug.log("yDiff < 0. x: " + x + " y: " + y + " mapX: " + mapX + " mapY: " + mapY);
			}
			else if (yDiff > 2)
			{
				//the section to add is above the existing map
				//shift map up
				debug.log("yDiff < 2. x: " + x + " y: " + y + " mapX: " + mapX + " mapY: " + mapY);
			}
			else
			{
				map[xDiff][yDiff] = sectionToAdd;
			}
		}
		catch (NullPointerException e)
		{
			map[0][0] = sectionToAdd;
		}
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
		
		for(int i = 0; i < map[0].length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				map[i][j].draw(g2d, horizontalOffset, verticalOffset, scale);
			}
		}
		
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
