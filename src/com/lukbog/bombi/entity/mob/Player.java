package com.lukbog.bombi.entity.mob;

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
	
	public void render()
	{
		
	}
} 
