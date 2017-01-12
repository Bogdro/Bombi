package com.lukbog.bombi.graphics;

public class Sprite 
{
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	//do testow
	private static int numergracza = 1;
	
	public static Sprite wall = new Sprite(64, 4, 1, SpriteSheet.spriteSheet);
	public static Sprite brick = new Sprite(64, 2, 1, SpriteSheet.spriteSheet);
	public static Sprite voidSprite = new Sprite(64, 0xff11ff); 
	public static Sprite tnt = new Sprite(64, 5, 1, SpriteSheet.spriteSheet);
	
	
	public static Sprite player_walking_side_1 = new Sprite(64, 4, 0+numergracza*2, SpriteSheet.spriteSheet);
	public static Sprite player_walking_side_2 = new Sprite(64, 5, 0+numergracza*2, SpriteSheet.spriteSheet);
	public static Sprite player_walking_side_3 = new Sprite(64, 6, 0+numergracza*2, SpriteSheet.spriteSheet);
	public static Sprite player_walking_side_4 = new Sprite(64, 7, 0+numergracza*2, SpriteSheet.spriteSheet);
	
	public static Sprite player_walking_down_1 = new Sprite(64, 8, 0+numergracza*2, SpriteSheet.spriteSheet);
	public static Sprite player_walking_down_2 = new Sprite(64, 9, 0+numergracza*2, SpriteSheet.spriteSheet);
	
	public static Sprite player_walking_up_1 = new Sprite(64, 0, 1+numergracza*2, SpriteSheet.spriteSheet);
	public static Sprite player_walking_up_2 = new Sprite(64, 1, 1+numergracza*2, SpriteSheet.spriteSheet);
	
	public static Sprite player_idle_1 = new Sprite(64, 0, 0+numergracza*2, SpriteSheet.spriteSheet);
	public static Sprite player_idle_2 = new Sprite(64, 1, 0+numergracza*2, SpriteSheet.spriteSheet);
	public static Sprite player_idle_3 = new Sprite(64, 2, 0+numergracza*2, SpriteSheet.spriteSheet);
	public static Sprite player_idle_4 = new Sprite(64, 3, 0+numergracza*2, SpriteSheet.spriteSheet);
	
	public static Sprite explosion_1 = new Sprite(64, 0, 8, SpriteSheet.spriteSheet);
	public static Sprite explosion_2 = new Sprite(64, 1, 8, SpriteSheet.spriteSheet);
	public static Sprite explosion_3 = new Sprite(64, 2, 8, SpriteSheet.spriteSheet);
	public static Sprite explosion_4 = new Sprite(64, 3, 8, SpriteSheet.spriteSheet);
	public static Sprite explosion_5 = new Sprite(64, 4, 8, SpriteSheet.spriteSheet);
	public static Sprite explosion_6 = new Sprite(64, 5, 8, SpriteSheet.spriteSheet);
	public static Sprite explosion_7 = new Sprite(64, 6, 8, SpriteSheet.spriteSheet);
	public static Sprite explosion_8 = new Sprite(64, 7, 8, SpriteSheet.spriteSheet);
	
	
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
