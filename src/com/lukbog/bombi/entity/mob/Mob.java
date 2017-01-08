package com.lukbog.bombi.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.Entity;
import com.lukbog.bombi.entity.Bombs.Bombs;
import com.lukbog.bombi.entity.Bombs.TNT;
import com.lukbog.bombi.graphics.Sprite;
import com.lukbog.bombi.input.Keyboard;

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
	public boolean bombPlanted = false;
	
	protected List<Bombs> bombs = new ArrayList<Bombs>();
	
	public void move(int dx, int dy)
	{
		if (dx != 0 && dy != 0)
		{
			move (dx, 0);
			move (0, dy);
			return;
		}
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
	
	protected void plant(int x, int y, int dir)
	{
		if (bombs.size() < 50)
		{	
			if (bombs.size() == 0)
			{
				Bombs b = new TNT(x, y, dir);
				bombPlanted = true;
				bombs.add(b);
				level.add(b);
			}
			for (int i = 0; i < bombs.size() ; i++)
			{
					if (bombs.get(i).x== x && bombs.get(i).y == y) System.out.println(bombs.get(i));
					else 
					{
						Bombs b = new TNT(x, y, dir);
						bombPlanted = true;
						bombs.add(b);
						level.add(b);
					}
		
			}
		}
	}
	
	private boolean collision(int dx, int dy)
	{
		boolean solid = false;
		for (int c = 0; c < 4; c++)
		{
			int xt = ((x + dx) + c % 2 * 31 + 16) / 64;
			int yt = ((y + dy) + c / 2 * 61 + 2) / 64;
			
			if (level.getTile(xt , yt).solid()) solid = true;
			if (bombPlanted && Keyboard.print) 
				{
					System.out.println(bombs.get(0).x/64);
					System.out.println("gracz : " + (((x + dx) + c % 2 * 31 + 16) / 64));
					if (bombs.get(0).x == ((x + dx) + c % 2 * 31 + 16) / 64) solid = true; 
				}
		}
		
		return solid;
	}
	
	public void render(Screen screen)
	{
		
	}
	
}
