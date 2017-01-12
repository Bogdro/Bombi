package com.lukbog.bombi.entity.Bombs;

import java.time.Duration;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.graphics.Sprite;

public class Explosion extends Bombs {
	
	int i = 0;
	Sprite[] sprites;
	public Explosion(int x, int y, int dir){
		super(x, y, dir);
		this.x = x;
		this.y = y;
		System.out.println("nowa explosia");
		Sprite[] sprites = {Sprite.explosion_1,Sprite.explosion_2, Sprite.explosion_3,
				Sprite.explosion_4, Sprite.explosion_5, Sprite.explosion_6, Sprite.explosion_7,
				Sprite.explosion_8,Sprite.voidSprite};
		this.sprites = sprites;
		sprite = this.sprites[i];
		this.now = System.currentTimeMillis();
	}
	
	public void render(Screen screen)
	{
		screen.renderBombs(x, y, this);
	}
	
	public void update(){
		if (System.currentTimeMillis() - now > 100){
			i++;
			if(i<sprites.length){
				sprite = this.sprites[i];
			}
			now = System.currentTimeMillis();
		}
	}
}
