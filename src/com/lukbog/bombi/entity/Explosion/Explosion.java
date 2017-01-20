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
		removed = false;
		this.level = level;
		this.range = range;
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
			if (level.getTile((x >> 6 ) + i, y >> 6).solid() && !level.getTile((x >> 6 ) + i, y >> 6).breakable()) break;
			if (level.getTile((x >> 6 ) + i, y >> 6).breakable()) 
				{
				screen.renderExplosion(x+64*i, y, this);
				}
		
			if(counter == 35) if (level.getTile((x >> 6 ) + i, y >> 6).breakable()) level.brokenCarbon((x >> 6) +i , y >> 6);
			if(counter == 40) remove();
		}
		
		for (int i = 0; i <= range; i++)
		{
			if (!level.getTile((x >> 6 ) - i, y >> 6).solid()) screen.renderExplosion(x-64*i, y, this);
			if (level.getTile((x >> 6 ) - i, y >> 6).solid() && !level.getTile((x >> 6 ) - i, y >> 6).breakable()) break;
			if (level.getTile((x >> 6 ) - i, y >> 6).breakable()) 
				{
				screen.renderExplosion(x- 64*i, y, this);
				}
		
			if(counter == 35) if (level.getTile((x >> 6 ) - i, y >> 6).breakable()) level.brokenCarbon((x >> 6) -i , y >> 6);
			if(counter == 40) remove();

		}
		for (int i = 0; i <= range; i++)
		{
			if (!level.getTile((x >> 6 ), (y >> 6) + i).solid()) screen.renderExplosion(x, y+64*i, this);
			if (level.getTile((x >> 6 ), (y >> 6) + i).solid() && !level.getTile((x >> 6 ), (y >> 6) + i).breakable()) break;
			if (level.getTile((x >> 6 ), (y >> 6) + i).breakable()) 
				{
				screen.renderExplosion(x , y+64*i, this);
				}
			if (counter == 35) 	if (level.getTile((x >> 6 ), (y >> 6) + i).breakable()) level.brokenCarbon((x >> 6 ), (y >> 6) + i);
			if(counter == 40) remove();
		}
		
		for (int i = 0; i <= range; i++)
		{
			if (!level.getTile((x >> 6 ), (y >> 6) - i).solid()) screen.renderExplosion(x, y-64*i, this);
			if (level.getTile((x >> 6 ), (y >> 6) - i).solid() && !level.getTile((x >> 6 ), (y >> 6) - i).breakable()) break;
			if (level.getTile((x >> 6 ), (y >> 6) - i).breakable()) 
				{
				screen.renderExplosion(x , y-64*i, this);
				}
			
			if(counter == 35) if (level.getTile((x >> 6 ), (y >> 6) - i).breakable()) level.brokenCarbon((x >> 6 ), (y >> 6) - i);
			if(counter == 40) remove();
		}
	}
	
	public boolean explosionCollision(int x, int y)
	{
		for (int i = 0; i <= range; i++) 
			{
				//System.out.println(" X GRACZA : " + (x + 48) + "	|| X WYBUCHU	: " + ((this.x)));
				if (x + 38 >= this.x - (i*64) && x + 38 <= (this.x + 40) - (i*64) && y <= (this.y + 54) && y + 54 >= (this.y)) 
				{
					//System.out.println("Koliduje z lewej");
					return true;
				}
				if (x <= (this.x + 38) + (i*64) && x >= (this.x - 63) + (i*64) && y <= (this.y + 54) && y + 54 >= (this.y)) 
					{
					//System.out.println("KOLIDUJE Z PRAWEJ");
					return true;
					}
				if (y + 40 >= this.y - (i*64) && y + 40 <= (this.y + 63) - (i*64) && x <= (this.x + 38) && x + 38 >= (this.x))
				{
					//System.out.println("KOLIDUJE NOGAMI");
					return true;
				}
				if (y <= (this.y + 40) + (i*64) && y >= (this.y + 10) + (i*64)&& x <= (this.x + 38) && x + 38 >= (this.x))
					{
					//System.out.println("KOLIDUJE GLOWA");
					return true;
					}
			}
		
		return false;
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
