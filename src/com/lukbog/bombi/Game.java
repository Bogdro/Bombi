package com.lukbog.bombi;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.*;

import com.lukbog.bombi.entity.mob.Player;
<<<<<<< HEAD
import com.lukbog.bombi.entity.mob.Player2;
=======
import com.lukbog.bombi.font.Font;
>>>>>>> origin/lukasz
import com.lukbog.bombi.input.Keyboard;
import com.lukbog.bombi.level.FirstLevel;
import com.lukbog.bombi.level.Level;
import com.lukbog.bombi.level.TileCoordinate;

class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	public static int width = 640;
	public static int height = 512;
	private JFrame frame;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	private Screen screen;
	public static String title = "Bombi";
	private Keyboard key;
	private Level level;
	private Player player;
<<<<<<< HEAD
	private Player2 player2;
=======
	boolean pausePressed;
	boolean isPaused;
	public Font pauseText;
>>>>>>> origin/lukasz
	
	public Game()
	{
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = new FirstLevel("/levels/firstLevel.png");
		TileCoordinate playerSpawn = new TileCoordinate(1,1);
		TileCoordinate player2Spawn = new TileCoordinate(8,1);
		player = new Player(playerSpawn.x(), playerSpawn.y(),key, level);
		player2 = new Player2(player2Spawn.x(), player2Spawn.y(),key, level);
		player.init(level);
<<<<<<< HEAD
		player2.init(level);
		
=======
		pauseText = new Font(screen.width/2, screen.height/2, "PAUSED");
>>>>>>> origin/lukasz
		
		addKeyListener(key);
	}
	
	public synchronized void start()
	{
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		
		while (running)
		{
			long now = System.nanoTime();
			delta += (now-lastTime) / ns ;
			lastTime = now;
			while (delta >= 1)
			{
				update();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				frame.setTitle(title + "  |  " + updates + " ups, " + frames +" fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void update()
	{
		key.update();
<<<<<<< HEAD
		if (player.isAlive()) player.update();
		if (player2.isAlive()) player2.update();
		player.clear();
		player2.clear();
		level.update();
=======
		if(!pausePressed && key.escape){
			pausePressed = true;
			//font = Font.paused;
			isPaused = !(isPaused);
		}else
			if(pausePressed && !key.escape){
				pausePressed = false;				
			}
		if(isPaused){
			//font.render(screen);
		}else{
			player.update();
			level.update();
		}
>>>>>>> origin/lukasz
	}
	
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x / screen.width / 2;
		int yScroll = player.y / screen.height / 2;
		
		level.render(xScroll, yScroll, screen);
		if (player.isAlive()) player.render(screen);
		if (player2.isAlive()) player2.render(screen);
		
		if(isPaused){
			pauseText.render(screen);
		}
		
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//Tutaj wrzucamy grafike
		g.drawImage(image,  0,  0,  getWidth(),  getHeight(), null);
		//dispose() Usuwa grafiki z bufora po wyrenderowaniu (?)
		g.dispose();
		//wyswietla grafiki
		bs.show();
	}
		
	public static void main(String[] args)
	{
		Game game = new Game();
		game.frame.setResizable(true);                                                                        
        game.frame.setTitle(Game.title);

        game.frame.add(game);
	    game.frame.setPreferredSize(new Dimension(width, height));
		game.frame.pack();
		//game.frame.setUndecorated(true);			
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		game.frame.setVisible(true);
		game.start();
	}
	
}