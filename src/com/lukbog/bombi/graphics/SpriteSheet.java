package com.lukbog.bombi.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.lukbog.bombi.graphics.SpriteSheet;

public class SpriteSheet 
{
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet spriteSheet = new SpriteSheet("/textures/spritesheet64.png", 640);
	public static SpriteSheet text = new SpriteSheet("/textures/font.png", 864);
	
	public SpriteSheet(String path, int size)
	{
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load()
	{
		try 
		{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
