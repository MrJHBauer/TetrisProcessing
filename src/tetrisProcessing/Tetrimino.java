package tetrisProcessing;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Tetrimino {
	
	PApplet parent;
	
	int x;
	
	int y;
		
	PImage texture;
	
	Tetriminos type;
	
	ArrayList<int[][]> states;
	
	int[][] currentState;
	
	int stateIndex = 0;
	
	public Tetrimino(int x, int y, PImage[] textures, Tetriminos type, PApplet parent) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.parent = parent;
		
		texture = textures[type.getColour().ordinal()];
		states = type.getStates();
		currentState = states.get(0);
	}
	
	public void rotate() {
		if(stateIndex < states.size() - 1) {
			stateIndex++;
			currentState = states.get(stateIndex);
		} else {
			stateIndex = 0;
			currentState = states.get(stateIndex);
		}
	}
	
	public void draw() {
		for(int row = 0; row < currentState.length; row++) {
			for(int col = 0; col < currentState[row].length; col++) {
				if(currentState[row][col] != 0) {
					parent.image(texture, x + (32 * col), y + (32 * row));
				}				
			}
		}
	}	
}
