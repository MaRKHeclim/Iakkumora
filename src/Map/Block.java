package Map;

import Tools.Debug;

import java.awt.*;

public class Block
{
	static int n, d;
	int x, y;
	Chunk[][] chunkArray;
	
	/**
	 * Constructor - Used to Generate a New Block
	 * 
	 * @param x The x value of the chunk to be generated within the block.
	 * @param y The y value of the chunk to be generated within the block.
	 */
	Block(int x, int y) //constructor
	{
		Debug debug = new Debug("Block - Constructor - New Block Generation", false, false);
		debug.log("Creating a new Block");
		this.x = x;
		this.y = y;
		chunkArray = new Chunk[d][d];
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				debug.log("Create a new chunk now: d: " + d + " x: " + i + " y: " + j);
				chunkArray[i][j] = new Chunk(i, j);
			}
		}
	}
	
	/**
	 * Constructor - Used to Load a Pregenerated Tile
	 * 
	 * @param x 		The x value of the chunk within the block.
	 * @param y 		The y value of the chunk within the block.
	 * @param chunkArray	The array of chunks to populate the block. 
	 */
	Block(int x, int y, Chunk[][] chunkArray)
	{
		this.x = x;
		this.y = y;
		this.chunkArray = chunkArray;
	}
	
	static
	{
		n = 2;
		d = (int) Math.pow(2, n) + 1;
	}
	
	Tile getTile(int x, int y)
	{
		return null;
	}
	
	void draw(Graphics2D g2d, int horizontalOffset, int verticalOffset, int scale)
	{
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				chunkArray[i][j].draw(g2d, (x * d * Chunk.getD() * scale) + horizontalOffset, (y * d * Chunk.getD() * scale) + verticalOffset, scale);
			}
		}
	}
	
	
	public int getN()
	{
		return n;
	}
	
	public static int getD()
	{
		return d;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
