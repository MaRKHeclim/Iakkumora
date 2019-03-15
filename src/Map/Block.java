package Map;

import java.awt.*;

public class Block extends MapSubset
{
	
	Chunk[][] chunkArray;
	Block(int x, int y) //constructor
	{
		this.x = x;
		this.y = y;
		n = 2;
		d = (int) Math.pow(n, 2) + 1;
		chunkArray = new Chunk[d][d];
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				chunkArray[i][j] = new Chunk(i, j);
			}
		}
	}
	
	@Override
	Tile getTile(int x, int y)
	{
		return null;
	}
	
	@Override
	void draw(Graphics2D g2d, int x, int y, int horizontalOffset, int verticalOffset, int scale)
	{
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				chunkArray[i][j].draw(g2d, horizontalOffset * d * scale + i, verticalOffset * d * scale + j,0,0, scale);
			}
		}
	}
}
