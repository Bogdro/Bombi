package com.lukbog.bombi;

import java.util.Random;

import com.lukbog.bombi.font.Font;
import com.lukbog.bombi.entity.Bombs.Bombs;
import com.lukbog.bombi.entity.Explosion.Explosion;
import com.lukbog.bombi.graphics.Sprite;
import com.lukbog.bombi.level.tile.Tile;

public class Screen 
{
	public int width, height;
	public int[] pixels;
	public final int mapSize = 64;
	public final int mapSizeMask = mapSize - 1;
	public int[] tiles = new int [mapSize*mapSize];
	public int xOffset, yOffset;
	private Random random = new Random();
	
	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for (int i = 0; i < mapSize*mapSize; i++)
		{
			tiles[i] = random.nextInt(0xFF00FF);
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
	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed)
	{
		if (fixed)
		{
			xp -= xOffset;
			yp -= yOffset;
		}
		for (int y = 0; y < sprite.getHeight(); y++ )
		{
			int ya = y + yp;
			for (int x = 0; x < sprite.getWidth(); x++ )
			{
				int xa = x + xp;
				if( xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
				pixels[x + y * width] = sprite.pixels[x + y * sprite.getWidth()];
			}
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++)
		{
			int ya = yp + y;
			for (int x = 0; x < tile.sprite.SIZE; x++)
			{
				int xa = xp + x;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = tile.sprite.pixels[x + y * tile.sprite.SIZE];
				if (col != 0xFFFF00FF) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void renderBombs(int xp, int yp, Bombs b)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < b.getSpriteSize(); y++)
		{
			int ya = yp + y;
			for (int x = 0; x < b.getSpriteSize(); x++)
			{
				int xa = xp + x;
				if (xa < -b.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = b.getSprite().pixels[x + y * b.getSprite().SIZE];
				if (col != 0xFFFF00FF)	pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void renderExplosion(int xp, int yp, Explosion b)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < b.getSpriteSize(); y++)
		{
			int ya = yp + y;
			for (int x = 0; x < b.getSpriteSize(); x++)
			{
				int xa = xp + x;
				if (xa < -b.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = b.getSprite().pixels[x + y * b.getSprite().SIZE];
				if (col != 0xFFFF00FF)	pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite, int flip)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 64; y++)
		{
			int ya = yp + y;
			int ys = y;
			if (flip == 2 || flip == 3)	ys = 63 - y;
			for (int x = 0; x < 64; x++)
			{
				int xs = x;
				if (flip == 1 || flip == 3)	xs = 63 - x;
				int xa = xp + x;
				if (xa < -64 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int color = sprite.pixels[xs + ys * 64];
				if (color != 0xFFFF00FF) pixels[xa + ya * width] = color;
			}
		}
	}
	
	public void renderText(int xp, int yp, Font font) {
		for(int y = 0; y < 32; y++) {
			int ya = y + yp;
			for(int x = 0; x < font.SIZE; x++) {
				int xa = x + xp;
				int col = font.pixels[x + y * font.SIZE];
				pixels[xa + ya * width] = col;
			}
		}
	}

}
