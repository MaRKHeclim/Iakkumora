package Map;

import java.awt.*;

public class Chunk extends MapSubset
{
	Tile[][] tileArray;
	Chunk(int x, int y)//constructor
	{
		this.x = x;
		this.y = y;
		n = 2;
		d = (int) Math.pow(n, 2) + 1;
		tileArray = new Tile[d][d];
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				tileArray[i][j] = new Tile(i, j);
			}
		}
	}
	
	@Override
	Tile getTile(int x, int y)
	{
		return tileArray[x][y];
	}
	
	@Override
	void draw(Graphics2D g2d, int x, int y, int horizontalOffset, int verticalOffset, int scale)
	{
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				tileArray[i][j].draw(g2d, x * d * scale + i + horizontalOffset, y * d * scale + j + verticalOffset, scale);
			}
		}
	}
}
