package com.lukbog.bombi.entity.Bombs;

import com.lukbog.bombi.Screen;

public class TNT extends Bombs {
	

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
		/*if (dir == 3) screen.renderBombs(x-64 , y , this);
		if (dir == 1) screen.renderBombs(x+64 , y , this);
		if (dir == 0) screen.renderBombs(x , y - 64, this);
		if (dir == 2) screen.renderBombs(x , y + 64, this);
		*/
		
		int xtt = 0, ytt = 0;
		
		double xt = (x/64.0);
		double yt = (y/64.0);
		
		if (xt >=  (int) xt + 0.5) xtt = (int) xt + 1;
		if (xt < (int) xt + 0.5) xtt = (int) xt;
		if (yt >=  (int) yt + 0.5) 	ytt = (int) yt + 1;
		if (yt < (int) yt + 0.5) ytt = (int) yt;
		if (System.currentTimeMillis() - now < 5000){
		}
		else{
			now = System.currentTimeMillis();
			System.out.println("koniec");
			Explosion expl = new Explosion(this.x, this.y, this.dir);
		}
		screen.renderBombs(xtt * 64, ytt * 64, this);
	}
	
	public boolean solid()
	{
		return true;
	}
	
}
