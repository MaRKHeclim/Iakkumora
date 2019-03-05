package Map;

import java.awt.*;

import static Tools.MathFunctions.fastfloor;

public class Tile
{
	int x, y;
	int biome;
	
	Tile()//constructor
	{
		biome = fastfloor(Math.random() * 6);
	}
	
	void draw(Graphics2D g2d, int horizontalOffset, int verticalOffset, int scale)
	{
		g2d.fillRect(x * scale + horizontalOffset, y * scale + verticalOffset, scale, scale);
	}
}
