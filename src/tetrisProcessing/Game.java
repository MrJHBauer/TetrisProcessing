package tetrisProcessing;

import processing.core.PApplet;
import processing.core.PImage;

public class Game extends PApplet {

	PImage[] blocks = new PImage[Colour.values().length];
	int[][] staticBlocks = {
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	};
	
	Tetrimino tetrimino;
	boolean hasLanded = false;
	int ticks = 0;
	
	boolean isRowComplete = false;
	
	public void settings() {
		size(672, 736);
	}
	
	public void setup() {
		background(0);
		
		for(int i = 0; i < blocks.length; i++) {
			blocks[i] = loadImage(Colour.values()[i].getURL());
		}
		
		tetrimino = new Tetrimino(128, 96, blocks, Tetriminos.values()[(int)random(0, Tetriminos.values().length)], this);
		
	}
	
	public void update() {
		ticks++;
		
		if(ticks > 50) {
			if(tetrimino != null) {
				tetrimino.y += 32;
				for(int i = 0; i < tetrimino.currentState.length; i++) {
					for(int j = 0; j < tetrimino.currentState[i].length; j++) {
						if(tetrimino.currentState[i][j] != 0) {
							int tetriminoX = tetrimino.x + 32 * j;
							int tetriminoY = tetrimino.y + 32 * i;
							for(int row = 0; row < staticBlocks.length; row++) {
								for(int col = 0; col < staticBlocks[row].length; col++) {
									if(staticBlocks[row][col] != 0) {
										int staticX = 32 * col;
										int staticY = 32 * row;
										if(staticX == tetriminoX && staticY - 32 == tetriminoY) {
											for(int k = 0; k < tetrimino.currentState.length; k++) {
												for(int l = 0; l < tetrimino.currentState[k].length; l++) {
													if(tetrimino.currentState[k][l] != 0) {
														staticBlocks[(tetrimino.y - 32) / 32 + k + 1][(tetrimino.x - 32) / 32 + l + 1] = tetrimino.type.getColour().ordinal() + 1;
													}
												}
											}
											hasLanded = true;
										}
									}
								}
							}
						}
					}
				}
				tetrimino = hasLanded == true ? null : tetrimino;
			} else {			
				tetrimino = new Tetrimino(128, 96, blocks, Tetriminos.values()[(int)random(0, Tetriminos.values().length)], this);
				hasLanded = false;
				for(int i = 0; i < staticBlocks.length - 1; i++) {
					for(int j = 1; j <= 10; j++) {
						if(staticBlocks[i][j] != 0) {
							isRowComplete = true;
						} else {
							isRowComplete = false;
							break;
						}
					}
					if(isRowComplete) {
						for(int col = 1; col <= 10; col++) {
							staticBlocks[i][col] = 0;
						}
						isRowComplete = false;
					}
				}
				
			}
			ticks = 0;
		}		
	}
	
	public void keyReleased() {
		if(tetrimino != null) {
			if(key == 'a' || key == 'A') {
				tetrimino.x -= 32;
			} else if(key == 'd' || key == 'D') {
				tetrimino.x += 32;				
			} else if(key == 'r' || key == 'R') {
				tetrimino.rotate();
			}
		}		
	}
	
	public void draw() {
		update();
		background(0);
		
		for(int row = 0; row < staticBlocks.length; row++) {
			for(int col = 0; col < staticBlocks[row].length; col++) {
				if(staticBlocks[row][col] != 0) {
					image(blocks[staticBlocks[row][col] - 1], col * 32, row * 32);
				}
			}
		}
		
		if(tetrimino != null) {
			tetrimino.draw();
		}
		
	}	
	
	public static void main(String[] args) {
		PApplet.main("tetrisProcessing.Game");
	}

}
