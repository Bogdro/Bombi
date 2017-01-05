package com.lukbog.bombi.graphics;

public class Sprite 
{
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite player = new Sprite(64, 5, 0, SpriteSheet.spriteSheet);
	public static Sprite wall = new Sprite(64, 0, 0, SpriteSheet.spriteSheet);
	public static Sprite grass = new Sprite(64, 1, 0, SpriteSheet.spriteSheet);
	public static Sprite voidSprite = new Sprite(64, 0xff11ff); 
	
	public Sprite(int size, int x, int y, SpriteSheet sheet)
	{
		SIZE = size;
		pixels = new int[SIZE * SIZE]; 
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color) 
	{
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	private void setColor(int color)
	{
		for (int i = 0; i < SIZE * SIZE; i++) pixels[i] = color;
	}
	
	private void load()
	{
		for (int y = 0; y < SIZE; y++)
		{
			for (int x = 0; x < SIZE; x++)
			{
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
