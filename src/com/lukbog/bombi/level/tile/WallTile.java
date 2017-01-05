package com.lukbog.bombi.level.tile;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.graphics.Sprite;

public class WallTile extends Tile 
{

	public WallTile(Sprite sprite) 
	{
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen)
	{
		screen.renderTile(x << 5,  y << 5, this);
	}

}
