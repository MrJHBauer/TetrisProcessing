package tetrisProcessing;

public enum Tetriminos {
	I(Colour.BLUE, new int[][]{{1}, {1}, {1}, {1}}),
	L(Colour.GREEN, new int[][]{{1, 0}, {1, 0}, {1, 1}}),
	T(Colour.PURPLE, new int[][]{{1, 1, 1}, {0, 1, 0}}),
	J(Colour.GREEN, new int[][]{{0, 1}, {0, 1}, {1, 1}}),
	O(Colour.YELLOW, new int[][]{{1, 1}, {1, 1}}),
	Z(Colour.RED, new int[][]{{1, 1, 0}, {0, 1, 1}}),
	S(Colour.RED, new int[][]{{0, 1, 1}, {1, 1, 0}});
	
	private Colour colour;
		
	private int[][] data;
	
	Tetriminos(Colour colour, int[][] data) {
		this.colour = colour;
		this.data = data;
	}
	
	public Colour getColour() {
		return colour;
	}
	
	public int[][] getData() {
		return data;
	}
	
}
