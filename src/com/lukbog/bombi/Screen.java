package com.lukbog.bombi;

import java.awt.Color;
import java.util.Random;

import com.lukbog.bombi.graphics.Sprite;

public class Screen 
{
	private int width, height;
	public int[] pixels;
	
	public final int mapSize = 64;
	public final int mapSizeMask = mapSize - 1;
	public int[] tiles = new int [mapSize*mapSize];
	
	private Random random = new Random();
	
	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for (int i = 0; i < mapSize*mapSize; i++)
		{
			tiles[i] = random.nextInt(0xffffff);
			tiles[0] = 0;
		}
	}
	
	public void clear()
	{
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = 0;
		}
	}
	
	public void render(int xOffset, int yOffset)
	{
		for (int y = 0; y < height; y++)
		{
			int yp = y + yOffset;
			if ( yp < 0 || yp >= height) continue;
			for(int x = 0; x < width; x++)
			{
				int xp = x + xOffset;
				if ( xp < 0 || xp >= width) continue;
					//pixels[xp + yp*width] = 0x1FFF00;
					pixels[xp + yp * width] = Sprite.player.pixels[(x & 15) + (y & 15) * Sprite.player.SIZE];
			}
		}
	}

}
