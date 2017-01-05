package com.lukbog.bombi.entity;

import java.util.Random;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.level.Level;

public abstract class Entity 
{
	public int x, y;
	
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public void update()
	{
		
	}
	
	public void render(Screen screen) 
	{
		
	}
	
	public void remove()
	{
		//Usuwanie z levelu
		
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
}
