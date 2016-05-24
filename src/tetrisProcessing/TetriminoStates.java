package tetrisProcessing;

import java.util.ArrayList;

public enum TetriminoStates {
	I(new int[][]{{1}, {1}, {1}, {1}}, new int[][]{{1, 1, 1, 1}}),
	L(new int[][]{{1, 0}, {1, 0}, {1, 1}}, new int[][]{{0, 0, 1}, {1, 1, 1}}, new int[][]{{1, 1}, {0, 1}, {0, 1}}, new int[][]{{1, 1, 1}, {1, 0, 0}}),
	T(new int[][]{{1, 1, 1}, {0, 1, 0}}, new int[][]{{1, 0}, {1, 1}, {1, 0}}, new int[][]{{0, 1, 0}, {1, 1, 1}}, new int[][]{{0, 1}, {1, 1}, {0, 1}}),
	J(new int[][]{{0, 1}, {0, 1}, {1, 1}}, new int[][]{{1, 1, 1}, {0, 0, 1}}, new int[][]{{1, 1}, {1, 0}, {1, 0}}, new int[][]{{1, 0, 0}, {1, 1, 1}}),
	O(new int[][]{{1, 1}, {1, 1}}),
	Z(new int[][]{{1, 1, 0}, {0, 1, 1}}, new int[][]{{0, 1}, {1, 1}, {1, 0}}),
	S(new int[][]{{0, 1, 1}, {1, 1, 0}}, new int[][]{{1, 0}, {1, 1}, {0, 1}});
	
	private ArrayList<int[][]> states = new ArrayList<int[][]>();
	
	TetriminoStates(int[][] stateAlpha) {
		states.add(stateAlpha);
	}
	
	TetriminoStates(int[][] stateAlpha, int[][] stateBeta) {
		states.add(stateAlpha);
		states.add(stateBeta);
	}
	
	TetriminoStates(int[][] stateAlpha, int[][] stateBeta, int[][] stateCharlie, int[][] stateDelta) {
		states.add(stateAlpha);
		states.add(stateBeta);
		states.add(stateCharlie);
		states.add(stateDelta);
	}
	
	public ArrayList<int[][]> getStates() {
		return states;
	}
	
}
