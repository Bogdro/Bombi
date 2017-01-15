package com.lukbog.bombi.entity.Explosion;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.Entity;
import com.lukbog.bombi.graphics.Sprite;
import com.lukbog.bombi.level.Level;

public class Explosion extends Entity {
	
	int i = 0;
	Sprite[] sprites;
	private int counter, anim, range;
	
	public Explosion(int x, int y, int range, Sprite sprite, Level level){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.sprites = sprites;
		removed = false;
		this.level = level;
		this.range = range;
		System.out.println("nowa explosia");
	}
	
	public void render(Screen screen)
	{
		if(anim % 40 > 35) 
		{
			sprite = Sprite.explosion_8;
		}
		else if(anim % 40 > 30) 
		{
			sprite = Sprite.explosion_7;
		}
		else if(anim % 40 > 25) 
		{
			sprite = Sprite.explosion_6;
		}
		else if(anim % 40 > 20) 
		{
			sprite = Sprite.explosion_5;
		}
		else if(anim % 40 > 15) 
		{
			sprite = Sprite.explosion_4;
		}
		else if(anim % 40 > 10) 
		{
			sprite = Sprite.explosion_3;
		}
		else if(anim % 40 > 5) 
		{
			sprite = Sprite.explosion_2;
		}
		else 
		{
			sprite = Sprite.explosion_1;
		}
		for (int i = 0; i <= range; i++)
		{
			if (!level.getTile((x >> 6 ) + i, y >> 6).solid()) screen.renderExplosion(x+64*i, y, this);
			if (level.getTile((x >> 6 ) + i, y >> 6).solid() && !level.getTile((x >> 6 ) + i, y >> 6).breakable()) continue;
			if (level.getTile((x >> 6 ) + i, y >> 6).breakable()) screen.renderExplosion(x+64*i, y, this);
			
			if (!level.getTile((x >> 6 ) - i, y >> 6).solid()) screen.renderExplosion(x-64*i, y, this);
			if (level.getTile((x >> 6 ) - i, y >> 6).solid() && !level.getTile((x >> 6 ) - i, y >> 6).breakable()) continue;
			if (level.getTile((x >> 6 ) - i, y >> 6).breakable()) screen.renderExplosion(x- 64*i, y, this);
			
			if (!level.getTile((x >> 6 ), y + i>> 6).solid()) screen.renderExplosion(x, y+64*i, this);
			if (level.getTile((x >> 6 ), y + i>> 6).solid() && !level.getTile((x >> 6 ), (y >> 6) - i).breakable()) continue;
			if (level.getTile((x >> 6 ), y + i>> 6).breakable()) screen.renderExplosion(x , y+64*i, this);
			
			if (!level.getTile((x >> 6 ), y - i >> 6).solid()) screen.renderExplosion(x, y-64*i, this);
			if (level.getTile((x >> 6 ), y - i >> 6).solid() && !level.getTile((x >> 6 ), (y >> 6) - i).breakable()) continue;
			if (level.getTile((x >> 6 ), y - i >> 6).breakable()) screen.renderExplosion(x, y-64*i, this);
		
			if(counter == 25)
			{
				if (level.getTile((x >> 6 ) + i, y >> 6).breakable()) level.brokenCarbon((x >> 6) +i , y >> 6);
				if (level.getTile((x >> 6 ) - i, y >> 6).breakable()) level.brokenCarbon((x >> 6) -i , y >> 6);
				if (level.getTile((x >> 6 ), (y >> 6) + i).breakable()) level.brokenCarbon((x >> 6 ), (y >> 6) + i);
				if (level.getTile((x >> 6 ), (y >> 6) - i).breakable()) level.brokenCarbon((x >> 6 ), (y >> 6) - i);
				remove();
			}
		}
		//System.out.println(level.getTile((x >> 6 ) + 1, y >> 6));
		//if (level.getTile((x >> 6 ) + 1, y >> 6).breakable()) System.out.println("Wungiel");
		
	}
	
	public void remove()
	{
		removed = true;
	}
	public void update(){
		counter ++;
		
		if (anim < 7500) 
			{
				anim ++;
			}
		else anim = 0;
	}
}
