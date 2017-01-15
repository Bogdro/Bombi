package com.lukbog.bombi.level.tile;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.graphics.Sprite;

public class Tile 
{
	public int x, y;
	public Sprite sprite; 
	
	public static Tile brick = new CarbonTile(Sprite.carbon);
	public static Tile wall = new WallTile(Sprite.wall);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile tnt = new tntTile(Sprite.tnt);
	
	public Tile(Sprite sprite)
	{
		this.sprite = sprite;	
	}
	
	public void render(int x, int y, Screen screen)
	{
		
	}
	
	public boolean solid()
	{
		return false;
	}
	
	public boolean breakable()
	{
		return false;
	}
}
