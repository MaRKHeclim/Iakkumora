package Map;

import Tools.Debug;

import java.awt.*;

public class Section extends MapSubset
{
	Section(int x, int y)//Constructor
	{
		this.x = x;
		this.y = y;
	}
	
	static
	{
		n = 3;
		d = (int) Math.pow(2, n) + 1;
		Debug debug = new Debug("Section - Static", true, false);
	}
	
	@Override
	Tile getTile(int x, int y)
	{
		return null;
	}
	
	@Override
	void draw(Graphics2D g2d, int horizontalOffset, int verticalOffset, int scale)
	{
	
	}
}
