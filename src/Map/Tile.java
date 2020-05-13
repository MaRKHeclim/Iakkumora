package Map;

import java.awt.*;

import static Tools.MathFunctions.scale;
import static Tools.MathFunctions.fastfloor;

public class Tile
{
	int x, y;
	int biome;
	
	/**
	 * Constructor - Used to Generate a New Tile
	 * 
	 * @param x The x value of the tile to be generated within the chunk.
	 * @param y The y value of the tile to be generated within the chunk.
	 */
	Tile(int x, int y)//constructor
	{
		this.x = x;
		this.y = y;
		biome = fastfloor(scale(Map.mapRNG.next(), 0, 65538, 0, 6));
	}
	
	/**
	 * Constructor - Used to Load a Pregenerated Tile
	 * 
	 * @param x 		The x value of the tile within the chunk.
	 * @param y 		The y value of the tile within the chunk.
	 * @param biome		The biome of the tile. 
	 */
	Tile(int x, int y, int biome)
	{
		this.x = x;
		this.y = y;
		this.biome = biome;
	}
	
	//TODO add Description here
	void draw(Graphics2D g2d, int horizontalOffset, int verticalOffset, int scale)
	{
		g2d.setColor(Map.getColor(biome));
		g2d.fillRect((x * scale) + horizontalOffset, (y * scale) + verticalOffset, scale, scale);
	}
}
