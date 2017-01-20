package com.lukbog.bombi.entity.mob;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.Bombs.Bombs;
import com.lukbog.bombi.graphics.Sprite;
import com.lukbog.bombi.input.Keyboard;
import com.lukbog.bombi.level.Level;

public class Player extends Mob
{
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0 ;
	private boolean walking = false;
	private int flip = 1;
	private int playerBombs = 1;
	
	public Player(int x, int y, Keyboard input, Level level)
	{
	
		this.input = input;
		this.level = level;
		sprite = Sprite.player_walking_side_1;
		this.x = x ;
		this.y = y ;
		this.input = input;
		alive = true;
	}
	
	public void update()
	{
		//System.out.println(" PLAYER  : " + this.x + "PLAYER Y : " + this.y);
		int dx = 0, dy = 0;
		if (input.up) dy --;
		if (input.down) dy ++;
		if (input.right) dx ++;
		if (input.left) dx --;
		if (input.tnt) 
			{
				if (playerBombs > 0 && !checkSpot())
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
		//clear();
		
		for (int i = 0; i < Level.explosion.size(); i++)
		{
			/*if (Level.bomb2.size() > 0)	
				{
				if (Level.explosion.get(i).explosionCollision(Level.bomb2.get(0).x, Level.bomb2.get(0).y))
				
					{
						System.out.println("ASDKASKDASDA");
						Level.bomb2.get(0).explosion();
						break;
					}	
				}*/
			
			if (Level.explosion.get(i).explosionCollision(x,  y))
					{
						
						System.out.println("SIEMANECZKO DZIALA");
						clear(); 
						alive = false;
					}
		}
	}
	
	protected void plant(int x, int y)
	{
		Bombs b = new Bombs(x, y, level, 1);
		level.addBomb(b);
	}
	
	public void clear() 
	{

		for(int i = 0; i < Level.bomb.size(); i++) {
			if(Level.bomb.get(i).removed) {
				Level.bomb.remove(i);
				playerBombs++;
			}
			}
		for(int i = 0; i < Level.explosion.size(); i++) {
			if(Level.explosion.get(i).removed) {
				Level.explosion.remove(i);
			}
		}	
	}

	private boolean checkSpot()
	//Do poprawy bo jak sie ruszasz to wywala ze juz nie koliduje a powinno.
	// X trzeba zmienic na x bomby ktora chcemy postawic a y na y bomby ktora chcemy postawic
	// A nie gracza tak jak teraz.
	{
		for (int i = 0; i < Level.bomb.size() ; i++)
		{
				if (Level.bomb.get(i).x == x && Level.bomb.get(i).y == y) return true;
		}
		return false;
	}
	
	public void render(Screen screen)
	{
		//int flip = 0;
		if(walking){
			if (dir == left) 
				{
					flip = 0;
					sprite = Sprite.player_walking_side_1;
					
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
			if (dir == up) 
			{
					sprite = Sprite.player_walking_up_1;
					
					if (anim % 20 > 10)
					{
						sprite = Sprite.player_walking_up_2;
					}
					else 
					{
						sprite = Sprite.player_walking_up_1;
					}
			}
			if (dir == down) 
			{
					sprite = Sprite.player_walking_down_1;
					
					if (anim % 20 > 10)
					{
						sprite = Sprite.player_walking_down_2;
					}
					else 
					{
						sprite = Sprite.player_walking_down_1;
					}
			}
			if (dir == right) 
			{
				flip = 1;
				sprite = Sprite.player_walking_side_1;
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
		else{
			sprite = Sprite.player_idle_1;
			if (anim % 40 > 10 ) 
			{
				 sprite = Sprite.player_idle_2;
			} 
			if (anim % 40 > 20)
			{
				sprite = Sprite.player_idle_3;
			}
			if (anim % 40 > 30)
			{
				sprite = Sprite.player_idle_4;
			}
		}
			
		screen.renderPlayer(x, y, sprite, flip);
	}

	
} 
