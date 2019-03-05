package Map;

import java.awt.*;

abstract class MapSubset
{
	int n, x, y;
	
	abstract Tile getTile(int x, int y);
	abstract void draw (Graphics2D g2d, int x, int y, int horizontalOffset, int verticalOffset, int scale);
}
