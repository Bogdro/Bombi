package com.lukbog.bombi.level.tile;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.graphics.Sprite;

public class CarbonTile extends Tile
{
	public CarbonTile(Sprite sprite) 
	{
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen)
	{
		screen.renderTile(x << 6 ,  y << 6, this);
	}
	
	public boolean solid()
	{
		return true;
	}
	
	public boolean breakable()
	{
		return true;
	}
}
