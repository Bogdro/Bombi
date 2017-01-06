package com.lukbog.bombi.entity.Bombs;

import com.lukbog.bombi.Screen;

public class TNT extends Bombs {
	

	public TNT(int x, int y, int dir) 
	{
		super(x, y, dir);
		sprite = sprite.tnt;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void update()
	{
		plant();
	}
	
	protected void plant()
	{
		
	}
	
	public void render(Screen screen)
	{
		if (dir == 3) screen.renderBombs(x-64 , y , this);
		if (dir == 1) screen.renderBombs(x+64 , y , this);
		if (dir == 0) screen.renderBombs(x , y - 64, this);
		if (dir == 2) screen.renderBombs(x , y + 64, this);
	}
	
	public boolean solid()
	{
		return true;
	}
	
}
