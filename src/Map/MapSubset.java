package Map;

import java.awt.*;

abstract class MapSubset
{
	abstract Tile getTile(int x, int y);
	abstract void draw (Graphics2D g2d, int horizontalOffset, int verticalOffset, int scale);
	
	
}
