package com.lukbog.bombi.entity;

import java.util.Random;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.graphics.Sprite;
import com.lukbog.bombi.level.Level;

public abstract class Entity 
{
	public int x;
	public int y;
	
	public boolean removed = false;
	protected Level level;
	protected Sprite sprite;
	protected final Random random = new Random();

	public void update()
	{
		
	}
	
	public void render(Screen screen) 
	{
		
	}
	
	public void remove()
	{
		removed = true;
	}
	
	public boolean isRemoved()
	{
		return removed;
	}
	
	public void init(Level level)
	{
		this.level = level;
	}
	
	public boolean solid()
	{
		return false;
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
