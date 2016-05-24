package tetrisProcessing;

import java.util.ArrayList;

public enum Tetriminos {
	I(Colour.BLUE, TetriminoStates.I),
	L(Colour.GREEN, TetriminoStates.L),
	T(Colour.PURPLE, TetriminoStates.T),
	J(Colour.GREEN, TetriminoStates.J),
	O(Colour.YELLOW, TetriminoStates.O),
	Z(Colour.RED,TetriminoStates.Z),
	S(Colour.RED, TetriminoStates.S);
	
	private Colour colour;
	
	private TetriminoStates states;
	
	Tetriminos(Colour colour, TetriminoStates states) {
		this.colour = colour;
		this.states = states;
	}
	
	public Colour getColour() {
		return colour;
	}
	
	public ArrayList<int[][]> getStates() {
		return states.getStates();
	}
	
}
