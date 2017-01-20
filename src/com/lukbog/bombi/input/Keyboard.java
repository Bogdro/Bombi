package com.lukbog.bombi.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
<<<<<<< HEAD
	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right, tnt, up2, down2, left2, right2, tnt2;
=======
	private boolean[] keys = new boolean[200];
	public boolean up, down, left, right, tnt, escape;
>>>>>>> origin/lukasz
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
<<<<<<< HEAD
		up2 = keys[KeyEvent.VK_W];
		down2 = keys[KeyEvent.VK_S];
		left2 = keys[KeyEvent.VK_A];
		right2 = keys[KeyEvent.VK_D];
		
=======
		escape = keys[KeyEvent.VK_ESCAPE];
>>>>>>> origin/lukasz
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
