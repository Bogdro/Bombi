package com.lukbog.bombi.entity.mob;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.graphics.Sprite;
import com.lukbog.bombi.input.Keyboard;

public class Player extends Mob
{
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0 ;
	private boolean walking = false;
	
	public Player(Keyboard input)
	{
		this.input = input;
		sprite = Sprite.player_walking_side_1;
	}
	
	public Player(int x, int y, Keyboard input)
	{
		this.x = x ;
		this.y = y ;
		this.input = input;
	}
	
	public void update()
	{
		int dx = 0, dy = 0;
		if (input.up) dy --;
		if (input.down) dy ++;
		if (input.right) dx ++;
		if (input.left) dx --;
		if (input.tnt) 
			{
				plant(this.x, this.y, this.dir);
			}
		if (anim < 7500) anim++; else anim = 0;
		if (dx != 0 || dy != 0) 
			{
				move(dx, dy);
				walking = true;
			}
		else 
		{
			walking = false;
		}
	}
	
	public void render(Screen screen)
	{
		int flip =0;
		if (dir == left) 
			{
				sprite = Sprite.player_walking_side_1;
				if (walking)
				{
					if (anim % 40 > 10 ) 
					{
						 sprite = Sprite.player_walking_side_2;
					} 
					if (anim % 40 > 20)
					{
						sprite = Sprite.player_walking_side_3;
					}
					if (anim % 40 > 30)
					{
						sprite = Sprite.player_walking_side_4;
					}
				}
			}
		if (dir == up) 
			{
				sprite = Sprite.player_walking_up_1;
				if (walking)
				{
					if (anim % 20 > 10)
					{
						sprite = Sprite.player_walking_up_2;
					}
					else 
					{
						sprite = Sprite.player_walking_up_1;
					}
				}
			}
		if (dir == down) 
			{
				sprite = Sprite.player_walking_down_1;
				if (walking)
				{
					if (anim % 20 > 10)
					{
						sprite = Sprite.player_walking_down_2;
					}
					else 
					{
						sprite = Sprite.player_walking_down_1;
					}
				}
			}
		if (dir == right) 
			{
			flip = 1;
			sprite = Sprite.player_walking_side_1;
			if (walking)
			{
				if (anim % 40 > 10 ) 
				{
					 sprite = Sprite.player_walking_side_2;
				} 
				if (anim % 40 > 20)
				{
					sprite = Sprite.player_walking_side_3;
				}
				if (anim % 40 > 30)
				{
					sprite = Sprite.player_walking_side_4;
				}
			}
			}
			
		screen.renderPlayer(x, y, sprite, flip);
	}
} 
