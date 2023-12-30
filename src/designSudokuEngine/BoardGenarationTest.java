package designSudokuEngine;

public class BoardGenarationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardGenerator sudokuBoard = new BoardGenerator("MEDIUM");
		int[][] grid = new int[9][9];
		for(int i=0; i<100; i++) {
			grid = sudokuBoard.generateBoard();
			for(int j=0; j<grid.length; j++) {
				for(int k=0; k<grid[0].length; k++) {
					System.out.print(grid[j][k]);
				}
				System.out.println();
			}
			System.out.println("\n");
		}
	}

}