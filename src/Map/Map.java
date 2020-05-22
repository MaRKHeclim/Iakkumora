package Map;

import Game.Iakkumora;
import Storage.StorageAPI;
import Tools.Debug;
import Tools.PseudoRNG;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

import static Tools.MathFunctions.fastfloor;
import static Tools.MathFunctions.scale;

public class Map
{
	Section[][] map;
	
	static ArrayList<Color> colors;
	
	static PseudoRNG mapRNG;
	static int mapSeed;

	HashSet<Point> mapIndex = new HashSet<>();
	
	public Map() //Constructor
	{
		Debug debug = new Debug("Map - Constructor", false, false);
		debug.log("here");
		
		
		
		map = new Section[3][3];
		
		for(int i = 0; i <= 2; i++)
		{
			for(int j = 0; j <= 2; j++)
			{
				generate(i, j);
			}
		}
		//generate(0, 0);
		
		debug.log("map: " + map.toString());
		
		
	}
	
	//creates a new section
	// - called by constructor and move???
	void generate (int x, int y)
	{
		Debug debug = new Debug("Map - Generate", true, false);
		
		Section newSection = new Section(x, y);
		
		debug.log("Create a new section now: x: " + x + " y: " + y);
		mapIndex.add(new Point(x, y));
		//debug.dumpObject(mapIndex);
		add(newSection, x, y);
	}
	
	//adds a section to the map
	// - called by generate and load
	void add (Section sectionToAdd, int x, int y)
	{
		Debug debug = new Debug("Map - Add", true, false);
		int mapX, mapY;
		try
		{
			mapX = map[0][0].getX();
			mapY = map[0][0].getY();
		}
		catch (NullPointerException e)
		{
			mapX = 0;
			mapY = 0;
		}
		int xDiff = x - mapX;
		int yDiff = y - mapY;
		debug.log("                                                                 mapX: " + mapX + " mapY: " + mapY + " x: " + x + " y: " + y + " xDiff: " + xDiff + " yDiff: " + yDiff);
		if((xDiff < -1) || (xDiff > 3) || (yDiff < -1) || (yDiff > 3)) // xDiff or yDiff is more than one outside of the map
		{
			debug.enableStackTracing();
			debug.log("xDiff or yDiff out of bounds... Going to have problems... xDiff: " + xDiff + " yDiff: " + yDiff);
			debug.disableStackTracing();
		}
		else
		{
			if (xDiff < 0)
			{
				//the section to add is to the left of the existing map
				//shift map left
				debug.log("xDiff < 0. x: " + x + " y: " + y + " mapX: " + mapX + " mapY: " + mapY);
				shiftLEFT();
				//recalculate xDiff and yDiff
				mapX = map[0][0].getX();
				mapY = map[0][0].getY();
				xDiff = x - mapX;
				yDiff = y - mapY;
				//add new section to map and
				// store it in case of bad things...
				map[xDiff][yDiff] = sectionToAdd;
				store(xDiff, yDiff);
				//make sure map is full
				fillMap();
			}
			else if (xDiff > 2)
			{
				//the section to add is to the right of the existing map
				//shift map right
				debug.log("xDiff > 2. x: " + x + " y: " + y + " mapX: " + mapX + " mapY: " + mapY);
				shiftRIGHT();
				//recalculate xDiff and yDiff
				mapX = map[0][0].getX();
				mapY = map[0][0].getY();
				xDiff = x - mapX;
				yDiff = y - mapY;
				//add new section to map and
				// store it in case of bad things...
				map[xDiff][yDiff] = sectionToAdd;
				store(xDiff, yDiff);
				//make sure map is full
				fillMap();
			}
			else if (yDiff < 0)
			{
				//the section to add is below the existing map
				//shift map down
				debug.log("yDiff < 0. x: " + x + " y: " + y + " mapX: " + mapX + " mapY: " + mapY);
				shiftDOWN();
				//recalculate xDiff and yDiff
				mapX = map[0][0].getX();
				mapY = map[0][0].getY();
				xDiff = x - mapX;
				yDiff = y - mapY;
				//add new section to map and
				// store it in case of bad things...
				map[xDiff][yDiff] = sectionToAdd;
				store(xDiff, yDiff);
				//make sure map is full
				fillMap();
			}
			else if (yDiff > 2)
			{
				//the section to add is above the existing map
				//shift map up
				debug.log("yDiff < 2. x: " + x + " y: " + y + " mapX: " + mapX + " mapY: " + mapY);
				shiftUP();
				//recalculate xDiff and yDiff
				mapX = map[0][0].getX();
				mapY = map[0][0].getY();
				xDiff = x - mapX;
				yDiff = y - mapY;
				//add new section to map and
				// store it in case of bad things...
				map[xDiff][yDiff] = sectionToAdd;
				store(xDiff, yDiff);
				//make sure map is full
				fillMap();
			}
			else
			{
				debug.log("In Bounds. Adding to map at: [" + xDiff + "][" + yDiff + "]");
				map[xDiff][yDiff] = sectionToAdd;
				store(xDiff, yDiff);
			}
		}
		//debug.log("map[0][0].getX(): " + map[0][0].getX() + " map[0][0].getY(): " + map[0][0].getY());

	}
	
	void drop (int i, int j)
	{
		map[i][j] = null;
	}
	
	void load (int x, int y)
	{
		Debug debug = new Debug("Map - load", true, false);
		debug.log("here");
		//if can load, load then call add(loadedSection, x, y);
		// else generate(x, y);

		//if in list of generated points
		if(mapIndex.contains(new Point(x, y)))
		{
			add(Iakkumora.storageAPI.getSection(x, y),x, y);
		}
		else
		{
			generate(x, y);
		}
	}
	
	void store (int i, int j)
	{
		Iakkumora.storageAPI.store(map[i][j]);
	}
	
	/*public Section getSection(int x, int y)
	{

		return null;
	}*/
	
	void shiftUP()//trying to add a section that is above the current map... move map up -> move cells in current map down...
	{
		//store bottom sections
		// in case of modifications
		for(int i = 0; i <= 2; i++) //from left to right
		{
			//store the bottom section
			store(i,2);
		}
		//move other sections down
		for(int i = 0; i <= 2; i++)//from left to right
		{
			for(int j = 1; j >= 0; j--)//from the middle row to the bottom
			{
				//copy the section down one spot in the array
				map[i][j + 1] = map[i][j];
			}
		}
		//drop top sections
		for(int i = 0; i <= 2; i++)//from left to right
		{
			//empty out the array
			drop(i, 0);
		}
	}
	
	void shiftDOWN()//trying to add a section that is below the current map... move map down -> move cells in current map up...
	{
		//store top sections
		// in case of modifications
		for(int i = 0; i <= 2; i++)//from left to right
		{
			//store the top section
			store(i, 0);
		}
		//move other sections down
		for(int i = 0; i <= 2; i++)//from left to right
		{
			for(int j = 1; j <= 2; j++)//from the middle row to the top
			{
				//copy the section up one spot in the array
				map[i][j - 1] = map[i][j];
			}
		}
		//drop bottom sections
		for(int i = 0; i <= 2; i++)//from left to right
		{
			//empty out the array
			drop(i, 2);
		}
	}
	
	void shiftRIGHT()//trying to add a section that is to the right of the current map... move map right -> move cells in current map left...
	{
		//store left sections
		// in case of modifications
		for(int j = 0; j <= 2; j++)//from top to bottom
		{
			//store the left section
			store(0, j);
		}
		//move other sections down
		for(int i = 1; i <= 2; i++)//from the center column to right
		{
			for(int j = 0; j <= 2; j++)//from bottom to top
			{
				//copy the section up one spot in the array
				map[i - 1][j] = map[i][j];
			}
		}
		//drop right sections
		for(int j = 0; j <= 2; j++)//from left to right
		{
			//empty out the array
			drop(2, j);
		}
	}
	
	void shiftLEFT()//trying to add a section that is to the left of the current map... move map left -> move cells in current map right...
	{
		//store right sections
		// in case of modifications
		for(int j = 0; j <= 2; j++)//from top to bottom
		{
			//store the right section
			store(2, j);
		}
		//move other sections down
		for(int i = 1; i >= 0; i--)//from left to right
		{
			for(int j = 0; j <= 2; j++)//from bottom to top
			{
				//copy the section up one spot in the array
				map[i + 1][j] = map[i][j];
			}
		}
		//drop top sections
		for(int j = 0; j <= 2; j++)//from left to right
		{
			//empty out the array
			drop(0, j);
		}
	}
	
	void fillMap()
	{
		for(int i = 0; i <= 2; i++)
		{
			for(int j = 0; j <= 2; j++)
			{
				if (map[i][j] == null)
				{
					int mapX = map[0][0].getX();
					int mapY = map[0][0].getY();
					load(mapX + i, mapY + j);
				}
				//else do nothing
			}
		}
	}
	
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
		mapSeed = 1;
		mapRNG = new PseudoRNG(16, mapSeed);
		
		colors = new ArrayList<>(6);
		for(int i = 0; i < 6; i++)
		{
			colors.add(new Color(fastfloor(scale(Map.mapRNG.next(), 0, 65538, 0, 255)), 		//r
					fastfloor(scale(Map.mapRNG.next(), 0, 65538, 0, 255)),					//g
					fastfloor(scale(Map.mapRNG.next(), 0, 65538, 0, 255))));					//b
		}
	}
}
