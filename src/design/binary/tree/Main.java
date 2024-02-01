package design.binary.tree;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[] {5, 4, 9, 3, 1, 1, 3, 4, 2, 5, 6, 8, 7, 10};
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			array.add(arr[i]);
		}
		ArrayList<Integer> sortedArray = new TreeSort(array).getOutputSortedStream();
		for(int i32t : sortedArray) {
			System.out.print(i32t +" ");
		}
	}

}
