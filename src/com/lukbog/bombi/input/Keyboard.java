package com.lukbog.bombi.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
	private boolean[] keys = new boolean[200];
	public boolean up, down, left, right, tnt;
	public static boolean print;
	
	public void update()
	{
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		tnt = keys[KeyEvent.VK_ENTER];
		print = keys[KeyEvent.VK_M];
		
	}
	
	public void keyTyped(KeyEvent e) 
	{
		
	}

	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}

}
