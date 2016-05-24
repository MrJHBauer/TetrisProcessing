package tetrisProcessing;

import processing.core.PApplet;
import processing.core.PImage;

public class Tetrimino {
	
	PApplet parent;
	
	int x;
	
	int y;
		
	PImage texture;
	
	Tetriminos type;
	
	int[][] data;
	
	public Tetrimino(int x, int y, PImage[] textures, Tetriminos type, PApplet parent) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.parent = parent;
		
		texture = textures[type.getColour().ordinal()];
		data = type.getData();
	}
	
	public void rotate() {
		int[][] newData = new int[data[0].length][data.length];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++){
				newData[j][i] = data[i][j];
			}
		}
		data = newData;
	}
	
	public void draw() {
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] != 0) {
					parent.image(texture, x + (32 * col), y + (32 * row));
				}				
			}
		}
	}	
}
