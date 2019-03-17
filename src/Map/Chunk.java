package Map;

import Tools.Debug;

import java.awt.*;

public class Chunk
{
	static int n, d;
	int x, y;
	Tile[][] tileArray;
	Chunk(int x, int y)//constructor
	{
		Debug debug = new Debug("Chunk - Constructor", false, false);
		debug.log("Creating a new Chunk");
		this.x = x;
		this.y = y;
		tileArray = new Tile[d][d];
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				debug.log("Create a new tile now: d: " + d + " x: " + i + " y: " + j);
				tileArray[i][j] = new Tile(i, j);
			}
		}
	}
	
	static
	{
		n = 2;
		d = (int) Math.pow(2, n) + 1;
	}
	
	Tile getTile(int x, int y)
	{
		return tileArray[x][y];
	}
	
	void draw(Graphics2D g2d, int horizontalOffset, int verticalOffset, int scale)
	{
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				tileArray[i][j].draw(g2d, (x * d * scale) + horizontalOffset, (y * d * scale) + verticalOffset, scale);
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
