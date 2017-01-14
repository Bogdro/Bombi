package com.lukbog.bombi.entity.mob;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.Entity;
import com.lukbog.bombi.entity.Bombs.Bombs;
//import com.lukbog.bombi.entity.Bombs.Explosion;
//import com.lukbog.bombi.entity.Bombs.TNT;
import com.lukbog.bombi.graphics.Sprite;

public abstract class Mob extends Entity //implements ActionListener
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
	public long now = System.currentTimeMillis();
	//public Timer timer = new Timer(1000, new MyTimerActionListener());
	
	public static List<Bombs> bombs = new ArrayList<Bombs>();
	
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
	
	
	private boolean collision(int dx, int dy)
	{
		boolean solid = false;
		for (int c = 0; c < 4; c++)
		{
			int xt = ((x + dx) + c % 2 * 31 + 16) / 64;
			int yt = ((y + dy) + c / 2 * 61 + 2) / 64;
			
			if (level.getTile(xt , yt).solid()) solid = true;
	
		}
		
		return solid;
	}
	
	public void render(Screen screen)
	{
		
	}
	
}
