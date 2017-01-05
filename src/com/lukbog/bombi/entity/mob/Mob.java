package com.lukbog.bombi.entity.mob;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.Entity;
import com.lukbog.bombi.graphics.Sprite;

public abstract class Mob extends Entity
{
	/**
	 * Klasa obs³uguj¹ca postacie mobilne
	 */
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	//0 - góra, 1 - prawo, 2 dó³, 3 lewo
	protected int up = 0, right = 1, down = 2, left = 3;
	
	public void move(int dx, int dy)
	{
		if (dx > 0) dir = right;
		if (dx < 0) dir = left;
		if (dy > 0) dir = down;
		if (dy < 0) dir = up;
		
		if (!collision(dx, dy))
		{
			x += dx;
			y += dy;
		}
	}
	
	public void update()
	{
		
	}
	
	private boolean collision(int dx, int dy)
	{
		boolean solid = false;
		if (level.getTile((x + dx) / 64, (y + dy) / 64 ).solid()) solid = true;
		return solid;
	}
	
	public void render(Screen screen)
	{
		
	}
	
}
