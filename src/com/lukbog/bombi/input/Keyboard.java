package com.lukbog.bombi.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right, tnt, up2, down2, left2, right2, tnt2;
	public static boolean print;
	
	public void update()
	{
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		tnt = keys[KeyEvent.VK_ENTER];
		tnt2 = keys[KeyEvent.VK_SPACE];
		print = keys[KeyEvent.VK_M];
		up2 = keys[KeyEvent.VK_W];
		down2 = keys[KeyEvent.VK_S];
		left2 = keys[KeyEvent.VK_A];
		right2 = keys[KeyEvent.VK_D];
		
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
