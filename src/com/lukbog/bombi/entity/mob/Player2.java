package com.lukbog.bombi.entity.mob;

import java.awt.event.ActionEvent;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.Bombs.Bombs;
import com.lukbog.bombi.graphics.Sprite;
import com.lukbog.bombi.input.Keyboard;
import com.lukbog.bombi.level.Level;

public class Player2 extends Mob
{
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0 ;
	private boolean walking = false;
	private int flip = 1;
	private int playerBombs = 5;
	
	public Player2(int x, int y, Keyboard input, Level level)
	{
		this.input = input;
		this.level = level;
		sprite = Sprite.player_walking_side_1;
		this.x = x ;
		this.y = y ;
		this.input = input;
	}
	
	public void update()
	{
		int dx = 0, dy = 0;
		if (input.up2) dy --;
		if (input.down2) dy ++;
		if (input.right2) dx ++;
		if (input.left2) dx --;
		if (input.tnt2) 
		{
			if (playerBombs > 0)
			{
				plant(this.x, this.y);
				playerBombs --;
		
			}
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
	
	protected void plant(int x, int y)
	{
		Bombs b = new Bombs(x, y, level, 10);
		level.addBomb(b);
		/*if (bombs.size() < 1)
		{	
			if (bombs.size() == 0)
			{
				//timer.start();
				Bombs b = new Bombs(x, y, level, 10);
				//Bombs b = new Explosion(x, y, dir);
				System.out.println("Dodalem nowa bombke po raz pierwszy");
				bombPlanted = true;
				bombs.add(b);
				level.add(b);
				
			}
			for (int i = 0; i < bombs.size() ; i++)
			{
					if (bombs.get(i).x== x && bombs.get(i).y == y) break;
			}}*/
	}
	
	public void render(Screen screen)
	{
		//int flip = 0;
		if(walking){
			if (dir == left) 
				{
					flip = 0;
					sprite = Sprite.player2_walking_side_1;
					
					if (anim % 40 > 10 ) 
					{
						 sprite = Sprite.player2_walking_side_2;
					} 
					if (anim % 40 > 20)
					{
						sprite = Sprite.player2_walking_side_3;
					}
					if (anim % 40 > 30)
					{
						sprite = Sprite.player2_walking_side_4;
					
					}
				}
			if (dir == up) 
			{
					sprite = Sprite.player2_walking_up_1;
					
					if (anim % 20 > 10)
					{
						sprite = Sprite.player2_walking_up_2;
					}
					else 
					{
						sprite = Sprite.player2_walking_up_1;
					}
			}
			if (dir == down) 
			{
					sprite = Sprite.player2_walking_down_1;
					
					if (anim % 20 > 10)
					{
						sprite = Sprite.player2_walking_down_2;
					}
					else 
					{
						sprite = Sprite.player2_walking_down_1;
					}
			}
			if (dir == right) 
			{
				flip = 1;
				sprite = Sprite.player2_walking_side_1;
				if (anim % 40 > 10 ) 
				{
					 sprite = Sprite.player2_walking_side_2;
				} 
				if (anim % 40 > 20)
				{
					sprite = Sprite.player2_walking_side_3;
				}
				if (anim % 40 > 30)
				{
					sprite = Sprite.player2_walking_side_4;
				}
			}
		}
		else{
			sprite = Sprite.player2_idle_1;
			if (anim % 40 > 10 ) 
			{
				 sprite = Sprite.player2_idle_2;
			} 
			if (anim % 40 > 20)
			{
				sprite = Sprite.player2_idle_3;
			}
			if (anim % 40 > 30)
			{
				sprite = Sprite.player2_idle_4;
			}
		}
			
		screen.renderPlayer(x, y, sprite, flip);
	}

	
} 
