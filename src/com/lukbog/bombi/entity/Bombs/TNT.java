/*package com.lukbog.bombi.entity.Bombs;

import java.util.ArrayList;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.mob.Mob;
import com.lukbog.bombi.graphics.Sprite;

public class TNT extends Bombs {
	
	int i = 0;
	long animationTimer = 0;
	public boolean removed = false;
	public TNT(int x, int y, int dir) 
	{
		super(x, y, dir);
		sprite = sprite.tnt;
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.now = System.currentTimeMillis();
	}

	public void update()
	{

	}
	
	
	public void render(Screen screen)
	{
		Bombs bomba;
		/*if (dir == 3) screen.renderBombs(x-64 , y , this);
		if (dir == 1) screen.renderBombs(x+64 , y , this);
		if (dir == 0) screen.renderBombs(x , y - 64, this);
		if (dir == 2) screen.renderBombs(x , y + 64, this);
		
		
		int xtt = 0, ytt = 0;
		
		double xt = (x/64.0);
		double yt = (y/64.0);
		
		if (xt >=  (int) xt + 0.5) xtt = (int) xt + 1;
		if (xt < (int) xt + 0.5) xtt = (int) xt;
		if (yt >=  (int) yt + 0.5) 	ytt = (int) yt + 1;
		if (yt < (int) yt + 0.5) ytt = (int) yt;
		if (System.currentTimeMillis() - now < 5000)
		{
			bomba = this;
			screen.renderBombs(xtt * 64, ytt * 64, bomba);
		}
		else{
			if(System.currentTimeMillis() - animationTimer > 100){
				animationTimer = System.currentTimeMillis();
				
				//now = System.currentTimeMillis();
				//Explosion exp = new Explosion(xtt, ytt, 0);
				//System.out.println("koniec");
				//screen.renderBombs(xtt * 64,  ytt * 64, exp);
				sprite = Sprite.wybuchanimacja[i];
				//bomba = exp;
				System.out.println(i);
				//level.add(expl);
				//screen.renderBombs(xtt * 64, ytt * 64, this);
				if (i <= 7) 
					{
						i++;
						Mob.bombs = new ArrayList<Bombs>();
					}
				//System.out.println(level.get(0));
				//if (i == 8) level.remove(0);
			}
		}
		screen.renderBombs(xtt * 64, ytt * 64, this);
	}
	
	public boolean solid()
	{
		return true;
	}
}
*/