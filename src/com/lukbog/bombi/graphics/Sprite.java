package com.lukbog.bombi.graphics;

public class Sprite 
{
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite wall = new Sprite(64, 0, 0, SpriteSheet.spriteSheet);
	public static Sprite brick = new Sprite(64, 1, 0, SpriteSheet.spriteSheet);
	public static Sprite voidSprite = new Sprite(64, 0xff11ff); 
	
	public static Sprite player_walking_side_1 = new Sprite(64, 6, 0, SpriteSheet.spriteSheet);
	public static Sprite player_walking_side_2 = new Sprite(64, 7, 0, SpriteSheet.spriteSheet);
	public static Sprite player_walking_side_3 = new Sprite(64, 8, 0, SpriteSheet.spriteSheet);
	public static Sprite player_walking_side_4 = new Sprite(64, 9, 0, SpriteSheet.spriteSheet);
	
	public static Sprite player_walking_down_1 = new Sprite(64, 0, 1, SpriteSheet.spriteSheet);
	public static Sprite player_walking_down_2 = new Sprite(64, 1, 1, SpriteSheet.spriteSheet);
	
	public static Sprite player_walking_up_1 =new Sprite(64, 2, 1, SpriteSheet.spriteSheet);
	public static Sprite player_walking_up_2 =new Sprite(64, 3, 1, SpriteSheet.spriteSheet);
	
	public static Sprite tnt = new Sprite(64, 4, 1, SpriteSheet.spriteSheet);
	
	
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
