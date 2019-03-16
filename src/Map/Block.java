package Map;

import java.awt.*;

public class Block extends MapSubset
{
	
	Chunk[][] chunkArray;
	Block(int x, int y) //constructor
	{
		this.x = x;
		this.y = y;
		chunkArray = new Chunk[d][d];
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				chunkArray[i][j] = new Chunk(i, j);
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
		return null;
	}
	
	@Override
	void draw(Graphics2D g2d, int horizontalOffset, int verticalOffset, int scale)
	{
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				chunkArray[i][j].draw(g2d, d * scale + i + horizontalOffset, d * scale + j + verticalOffset, scale);
			}
		}
	}
}
