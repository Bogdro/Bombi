package com.lukbog.bombi.entity.mob;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.graphics.Sprite;
import com.lukbog.bombi.input.Keyboard;

public class Player extends Mob
{
	private Keyboard input;
	
	public Player(Keyboard input)
	{
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input)
	{
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update()
	{
		int dx = 0, dy = 0;
		if (input.up) dy --;
		if (input.down) dy ++;
		if (input.right) dx ++;
		if (input.left) dx --;
		
		if (dx != 0 || dy != 0) move(dx, dy);
	}
	
	public void render(Screen screen)
	{
		screen.renderPlayer(x, y, Sprite.player);
	}
} 
