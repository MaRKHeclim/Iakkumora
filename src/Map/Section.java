package Map;

import java.awt.*;

public class Section extends MapSubset
{
	Section(int x, int y)//Constructor
	{
		this.x = x;
		this.y = y;
		n = 3;
	}
	
	@Override
	Tile getTile(int x, int y)
	{
		return null;
	}
	
	@Override
	void draw(Graphics2D g2d, int x, int y, int horizontalOffset, int verticalOffset, int scale)
	{
	
	}
}
