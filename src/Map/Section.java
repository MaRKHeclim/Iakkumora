package Map;

import Tools.Debug;

import java.awt.*;

public class Section
{
	static int n, d;
	int x, y;
	Block[][] blockArray;
	Section(int x, int y)//Constructor
	{
		Debug debug = new Debug("Section - Constructor", false, false);
		debug.log("Creating a new Section");
		this.x = x;
		this.y = y;
		blockArray = new Block[d][d];
		debug.log(d + "");
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				debug.log("Create a new block now: d: " + d + " x: " + i + " y: " + j);
				blockArray[i][j] = new Block(i, j);
			}
		}
		debug.log(d + "");
		debug.log(blockArray.length + " x " + blockArray[0].length);
	}
	
	static
	{
		n = 3;
		d = (int) Math.pow(2, n) + 1;
		Debug debug = new Debug("Section - Static", true, false);
		debug.log(d + "");
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
				blockArray[i][j].draw(g2d, (x * d * Block.getD() * Chunk.getD() * scale) + horizontalOffset, (y * d * Block.getD() * Chunk.getD() * scale) + verticalOffset, scale);
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
