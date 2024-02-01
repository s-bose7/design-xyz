package design.sudoku.engine;

import java.util.Random;

public class BoardGenerator {
	
	private String difficultyLevel;
	private int[][] grid;
	private BackTrackingAlgorithm backtrack;
	private Random random;
	private int[] randomizedFirstRow;
	
	// Constructor
	public BoardGenerator(String level) {
		this.difficultyLevel = level;
		this.grid = new int[9][9];
		this.backtrack = new BackTrackingAlgorithm();
		this.random = new Random();
		this.randomizedFirstRow = new int[9];
	}

	private void randomizedRemovalMagic() {
		int k, r, c;
		if (difficultyLevel == "EASY") {
			k = 20;
		}else if(difficultyLevel == "MEDIUM") {
			k = 30;
		}else {
			k = 50;
		}
		for(int i=1; i<=k; i++) {
			r = random.nextInt(8)+1;
			c = random.nextInt(8)+1;
			grid[r][c] = 0;
		}
		
	}
	
	private boolean notInRow(int n) {
		for(int i=0; i<randomizedFirstRow.length; i++) {
			if(n == randomizedFirstRow[i]) {
				return true;
			}
		}
		return false;
	}
	
	private void randomlyGenerateFirstRow() {
		int size = randomizedFirstRow.length;
		while(size != 1) {
			int n = random.nextInt(9)+1;
			if(!notInRow(n)) {
				randomizedFirstRow[size-1] = n;
				--size;
			}
		}
		int row = 0;
		for(int i=0; i<9; i++) {
			grid[row][i] = randomizedFirstRow[i];
		}
	}
	
	public int[][] generateBoard(){
		// Generate First row randomly
		randomlyGenerateFirstRow();
		// Solve the rest of the board
		if(backtrack.solve(grid, 1)) {
			// Randomly remove k numbers from the board
			randomizedRemovalMagic();
		}
		// return the board
		return grid;
	}

}
