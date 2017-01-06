package com.lukbog.bombi.level;



import java.util.ArrayList;
import java.util.List;

import com.lukbog.bombi.Screen;
import com.lukbog.bombi.entity.Entity;
import com.lukbog.bombi.level.tile.Tile;

public class Level 
{
	protected int width, height;
	protected int[] tileInt;
	protected int[] tiles;
	private List<Entity> entities = new ArrayList<Entity>();
	
	public Level(int width, int height)
	{
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
		for (int i = 0; i < entities.size(); i++)
		{
			entities.get(i).update();
		}
	}
	
	@SuppressWarnings("unused")
	private void time()
	{
		
	}
	
	public void add(Entity e)
	{
		entities.add(e);
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
		for (int i = 0; i <entities.size(); i++){
			entities.get(i).render(screen);
		}
	}
	
	
	
	public Tile getTile(int x, int y)
	{
		// Sciana = 000000;
		// Spawny = FFD000;
		// Randomowe_klocki = FFFFFF;
		
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == 0xFF000000 )  return Tile.wall;
		if (tiles[x + y * width] == 0xFFFFFFFF)  return Tile.brick;
		if (tiles[x + y * width] == 0xFFFFFFF1) return Tile.voidTile;
		return Tile.voidTile;
	}
}
