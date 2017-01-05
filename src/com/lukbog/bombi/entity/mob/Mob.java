package com.lukbog.bombi.entity.mob;

import com.lukbog.bombi.entity.Entity;
import com.lukbog.bombi.graphics.Sprite;

public abstract class Mob extends Entity
{
	/**
	 * Klasa obs�uguj�ca postacie mobilne
	 */
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	//0 - g�ra, 1 - prawo, 2 d�, 3 lewo
	private int up = 0, right = 1, down = 2, left = 3;
	
	public void move(int dx, int dy)
	{
		if (dx > 0) dir = right;
		if (dx < 0) dir = left;
		if (dy > 0) dir = down;
		if (dy < 0) dir = up;
		
		if (!collision())
		{
			x += dx;
			y += dy;
		}
	}
	
	public void update()
	{
		
	}
	
	private boolean collision()
	{
		return false;
	}
	
	public void render()
	{
		
	}
	
}
