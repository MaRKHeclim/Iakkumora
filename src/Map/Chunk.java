package Map;

import java.awt.*;

public class Chunk extends MapSubset
{
	Tile[][] tileArray;
	Chunk(int x, int y)//constructor
	{
		this.x = x;
		this.y = y;
		tileArray = new Tile[d][d];
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				tileArray[i][j] = new Tile(i, j);
			}
		}
	}
	
	static
	{
		n = 2;
		d = (int) Math.pow(2, n) + 1;
	}
	
	@Override
	Tile getTile(int x, int y)
	{
		return tileArray[x][y];
	}
	
	@Override
	void draw(Graphics2D g2d, int horizontalOffset, int verticalOffset, int scale)
	{
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				tileArray[i][j].draw(g2d, horizontalOffset, verticalOffset, scale);
			}
		}
	}
}
