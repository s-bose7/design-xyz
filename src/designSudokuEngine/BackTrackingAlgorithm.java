package designSudokuEngine;

public class BackTrackingAlgorithm {
	protected static final int GRID_SIZE = 9;
	
	
	private static boolean isInRowOrCol(int[][] grid, int n, int r, int c) {
		for(int i=0; i<GRID_SIZE; i++) {
			if(grid[r][i] == n) {
				return true;
			}
			if(grid[i][c] == n) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	private static boolean isInBox(int[][] grid, int n, int r, int c) {
		int localRow = r - r%3;
		int localCol = c - c%3;
		for(int i=localRow; i<localRow+3; i++) {
			for(int j=localCol; j<localCol+3; j++) {
				if(grid[i][j] == n) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	private static boolean isValidPlacement(int[][] grid, int num, int r, int c) {
		return !isInRowOrCol(grid, num, r, c) && !isInBox(grid, num, r, c);
	}
	
	
	public boolean solve(int[][] grid, int start) {
		for(int row=start; row<GRID_SIZE; row++) {
			for(int col=0; col<GRID_SIZE; col++) {
				if(grid[row][col] == 0) {
					for(int numToTry = 1; numToTry <= GRID_SIZE; numToTry++) {
						if(isValidPlacement(grid, numToTry, row, col)) {
							// place numToTry at grid[row][column] and go to next empty cell
							grid[row][col] = numToTry;
							
							// going to the next cell, using recursion, 
							// so it will start looking for empty cells from grid[0][0]
							if(solve(grid, start)) {
								return true;
							}
							else {
								// will be executed if any recursive solve(grid) returns FALSE
								// clear the number placed at grid[row][column] with 0 & try numToTry+1 number
								grid[row][col] = 0;
							}
						}
					}
					// meaning: the algorithm tried every number from 1 to 9 to place at grid[row][column]
					// But, none of them is a valid placement
					// so we need to backtrack and have to go to the prior decision
					// which is apparently the prior call stack in memory, because it is recursive
					// so the recursive solve(grid) at some numToTry, which just proven to be an invalid placement
					// needs to remove, so it needs to be 0 again, to represent an empty cell.
					return false;
				}
			}
		}
		// traversed the whole grid
		// no cell is empty now
		return true;
	}
	
	
	
	public void printBoardToConsole(int[][] grid) {
		for(int row=0; row<GRID_SIZE; row++) {
			for(int column=0; column<GRID_SIZE; column++) {
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}

}
