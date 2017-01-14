package com.lukbog.bombi.entity.Bombs;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.Entity;
import com.lukbog.bombi.entity.Explosion.Explosion;
import com.lukbog.bombi.graphics.Sprite;
import com.lukbog.bombi.level.Level;

public class Bombs extends Entity
{
	protected Sprite sprite;
	protected long now;
	private int bombCounter;
	private int range;
	private int anim;

	
	public Bombs(int x, int y, Level level, int range)
	{
		this.x = x;
		this.y = y;
		this.level = level;
		this.range = range;
		removed = false;
		anim = 0;
		bombCounter = 0;
	}
	
	
	
	protected void plant()
	{
		
	}
	
	public void update()
	{
		if (anim < 7500) anim ++;
		else anim = 0;
		
		if (bombCounter > 600)
		{
			//System.out.println("Wybuchh");
			Level.explosion.add(new Explosion(x, y, 1, Sprite.explosion_1, level));
			remove();
		}
	}
	
	public void remove()
	{
		removed = true;
	}
	
	public void render(Screen screen) 
	{
		if(anim % 30 > 20) {
			sprite = Sprite.tnt;
		}else if(anim % 30 > 10) {
			sprite = Sprite.tnt;
		}else {
			sprite = Sprite.tnt;
			bombCounter++;
		}
		int xtt = 0, ytt = 0;
		
		double xt = (x/64.0);
		double yt = (y/64.0);
		if (xt >=  (int) xt + 0.5) xtt = (int) xt + 1;
		if (xt < (int) xt + 0.5) xtt = (int) xt;
		if (yt >=  (int) yt + 0.5) 	ytt = (int) yt + 1;
		if (yt < (int) yt + 0.5) ytt = (int) yt;
		screen.renderBombs(xtt * 64, ytt * 64, this);
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
