package com.lukbog.bombi.entity.Bombs;

import com.lukbog.bombi.entity.Entity;
import com.lukbog.bombi.graphics.Sprite;

public abstract class Bombs extends Entity
{
	protected final int xSpawn, ySpawn;
	protected Sprite sprite;
	protected int capacity;
	protected int dir;
	protected long now;

	
	public Bombs(int x, int y, int dir)
	{
		xSpawn = x;
		ySpawn = y;
		dir = dir;
	}
	
	
	
	protected void plant()
	{
		
	}
	
	public Sprite getSprite()
	{
		return sprite;
	}
	
	public int getSpriteSize()
	{
		return sprite.SIZE;
	}
}
