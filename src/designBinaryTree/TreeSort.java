package designBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;

public class TreeSort {
	
	private BinaryTree bsTree;
	private HashMap<Integer, Integer> frequencyCounter;
	private ArrayList<Integer> outputSortedStream;
	
	
	public ArrayList<Integer> getOutputSortedStream() {
		return outputSortedStream;
	}


	public TreeSort(ArrayList<Integer> inputDataStream){
		this.bsTree = new BinaryTree();
		this.frequencyCounter = new HashMap<>();
		this.outputSortedStream = new ArrayList<>();
		/* Construct a binary tree while keeping track of the occurrences of each integer */
		construct(inputDataStream);
		/* Traverse the binary search tree and append the values to output stream*/
		sortByInOrderTraversal(bsTree.getRootNode());
	}
	
	
	private void construct(ArrayList<Integer> inputDataStream) {
		for(int i : inputDataStream) {
			bsTree.put(i);
			frequencyCounter.put(i, frequencyCounter.getOrDefault(i, 0) + 1);
		}
	}
	
	private void sortByInOrderTraversal(Node localRoot) {
		if(localRoot == null) {
			return;
		}
		sortByInOrderTraversal(localRoot.left);
		for(int i=1; i<=frequencyCounter.get(localRoot.data); i++) {
			this.outputSortedStream.add(localRoot.data);
		}
		sortByInOrderTraversal(localRoot.right);
	}
}
