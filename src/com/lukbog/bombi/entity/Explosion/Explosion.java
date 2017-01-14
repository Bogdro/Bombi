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
		Sprite[] sprites = {Sprite.explosion_1,Sprite.explosion_2, Sprite.explosion_3,
				Sprite.explosion_4, Sprite.explosion_5, Sprite.explosion_6, Sprite.explosion_7,
				Sprite.explosion_8,Sprite.voidSprite};
		//sprite = this.sprites[i];
		//this.now = System.currentTimeMillis();
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
			screen.renderExplosion(x+64*i, y, this);
			if(counter == 25)
			{
				System.out.println("HEJO");
				remove();
			}
		}
		
	}
	
	public void remove()
	{
		removed = true;
	}
	public void update(){
	/*	if (System.currentTimeMillis() - now > 100){
			i++;
			if(i<sprites.length){
				sprite = this.sprites[i];
			}
			now = System.currentTimeMillis();
		}*/
		counter ++;
		
		if (anim < 7500) 
			{
				anim ++;
			}
		else anim = 0;
	}
}
