package com.lukbog.bombi.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;



public class FirstLevel extends Level
{
	private static final Random random = new Random();
	
	public FirstLevel(String path) 
	{
		super(path);
	}

	protected void loadLevel (String path)
	{
		
			try 
			{
				BufferedImage image = ImageIO.read(FirstLevel.class.getResource(path));
				int w = width = image.getWidth();
				int h = height = image.getHeight();
				tiles = new int[w * h];
				image.getRGB(0, 0, w, h, tiles, 0, w);
				
				for (int i = 0; i < width * height; i++) {
				    if (tiles[i] == 0xFFFFFFFF) {
				        if (random.nextInt(2) == 1) tiles[i] = 0xFFFFFFF1;
				    }
				}
				
			}
			catch (IOException e)
			{
				e.printStackTrace();
				System.out.println("Exception! Could not load level file!");
			}
	}
	
	protected void generateLevel()
	{
		
	}
	
}
