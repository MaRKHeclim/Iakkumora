package Map;

import java.awt.*;

abstract class MapSubset
{
	static int n, d;
	int x, y;
	
	abstract Tile getTile(int x, int y);
	abstract void draw (Graphics2D g2d, int horizontalOffset, int verticalOffset, int scale);
	
	public static int getN()
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
