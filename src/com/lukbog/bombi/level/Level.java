package com.lukbog.bombi.level;



import java.util.ArrayList;
import java.util.List;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.Entity;
import com.lukbog.bombi.entity.Bombs.Bombs;
import com.lukbog.bombi.entity.Explosion.Explosion;
import com.lukbog.bombi.level.tile.Tile;

public class Level 
{
	protected int width, height;
	protected int[] tileInt;
	protected int[] tiles;
	private List<Entity> entities = new ArrayList<Entity>();
	public static List<Bombs> bomb = new ArrayList<Bombs>();
	public static List<Explosion> explosion = new ArrayList<Explosion>();
	public static List<Bombs> bomb2 = new ArrayList<Bombs>();
	public static List<Explosion> explosion2 = new ArrayList<Explosion>();
	public static List<Integer> brokenCarbonX = new ArrayList<Integer>();
	public static List<Integer> brokenCarbonY = new ArrayList<Integer>();
	
	public Level(int width, int height)
	{
		//bomb = new ArrayList<Bombs>();
		this.width = width;
		this.height = height;
		tileInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path)
	{
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel()
	{
		
	}
	
	protected void loadLevel (String path)
	{
		
	}
	
	public void update()
	{
		for (int i = 0; i < bomb.size(); i++)
		{
			bomb.get(i).update();
		}
		for (int i = 0; i <explosion.size(); i++){
			explosion.get(i).update();
		}
		for (int i = 0; i < bomb2.size(); i++)
		{
			bomb2.get(i).update();
		}
		for (int i = 0; i <explosion2.size(); i++){
			explosion2.get(i).update();
		}
	}
	
	@SuppressWarnings("unused")
	private void time()
	{
		
	}
	
	public boolean tileCollision(int x, int y, int dx, int dy, int size)
	{
		boolean solid = false;
		for (int c = 0; c < 4; c++)
		{
			int xt = ((x + dx) + c % 2 * size) / 64;
			int yt = ((y + dy) + c / 2 * size) / 64;
			
			if (getTile(xt , yt).solid()) solid = true;
	
		}
		
		return solid;
	}
	
	public void addBomb(Bombs bomb) 
	{
		Level.bomb.add(bomb);
	}
	
	public void addExplosion(Explosion exp) 
	{
		Level.explosion.add(exp);
	}
	
	public void addBomb2(Bombs bomb) 
	{
		Level.bomb2.add(bomb);
	}
	
	public void addExplosion2(Explosion exp) 
	{
		Level.explosion2.add(exp);
	}

	public void add(Entity e)
	{
		entities.add(e);
	}
	
	public void set(int index, Entity e)
	{
		entities.set(index, e);
	}
	
	public void remove(int index)
	{
		entities.remove(index);
	}
	public void get(int index)
	{
		System.out.println(entities.get(0));
	}
	
	public void render(int xScroll, int yScroll, Screen screen)
	{
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 6;
		int x1 = (xScroll + screen.width + 64) >> 6;
		int y0 = yScroll >> 6;
		int y1 = (yScroll + screen.height + 64) >> 6;
		
		for (int y = y0; y < y1; y++)
		{
			for (int x = x0; x < x1; x++)
			{
				getTile(x, y).render(x, y, screen);	
				
			}
		}
		for (int i = 0; i <bomb.size(); i++){
			bomb.get(i).render(screen);
		}
		for (int i = 0; i <explosion.size(); i++){
			explosion.get(i).render(screen);
		}
		for (int i = 0; i <bomb2.size(); i++){
			bomb2.get(i).render(screen);
		}
		for (int i = 0; i <explosion2.size(); i++){
			explosion2.get(i).render(screen);
		}
	}
	
	
	
	public Tile getTile(int x, int y)
	{
		// Sciana = 000000;
		// Spawny = FFD000;
		// Randomowe_klocki = FFFFFF;
		Tile t = Tile.voidTile;
		if (x < 0 || y < 0 || x >= width || y >= height) t = Tile.voidTile;
		else if (tiles[x + y * width] == 0xFF000000 )  t = Tile.wall;
		else if (tiles[x + y * width] == 0xFFFFFFFF)  t = Tile.brick;
		else if (tiles[x + y * width] == 0xFFFFFFF1) t = Tile.voidTile;
		for (int i = 0; i < brokenCarbonX.size(); i++)
		{
			if(brokenCarbonX.get(i) == x && brokenCarbonY.get(i) == y) 
				{
				t = Tile.voidTile;
				}
		}
		return t;
	}
	
	public void brokenCarbon(int x, int y)
	{
		brokenCarbonX.add(x);
		brokenCarbonY.add(y);
	}
}
