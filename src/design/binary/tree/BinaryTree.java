package design.binary.tree;

public class BinaryTree {
	private Node rootNode;

	public BinaryTree() {
		this.rootNode = null;
	}

	public BinaryTree(Node rootNode) {
		this.rootNode = rootNode;
	}

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	/**
	 * Method to find a Node with a certain value
	 *
	 * @param key Value being looked for
	 * @return The node if it finds it, otherwise returns the parent
	 */
	public Node find(int key) {
		Node currNode = this.rootNode;
		while(currNode != null) {
			if(key > currNode.data) {
				if(currNode.right == null) {
					return currNode;
				}
				currNode = currNode.right;
			}
			else if(key < currNode.data) {
				if(currNode.left == null) {
					return currNode;
				}
				currNode = currNode.left;
			}
			else {
				break;
			}
		}
		return currNode;
	}

	/**
	 * Inserts certain value into the Binary Tree
	 *
	 * @param value Value to be inserted
	 */
	public void put(int value) {
		Node newNode = new Node(value);
		if(rootNode == null) {
			rootNode = newNode;
		}else {
			Node parentNode = find(value);
			if(value < parentNode.data) {
				parentNode.left = newNode;
				parentNode.left.parent = parentNode;
			}else if(value > parentNode.data) {
				parentNode.right = newNode;
				parentNode.right.parent = parentNode;
			}
		}
	}

	/**
	 * Deletes a given value from the Binary Tree
	 *
	 * @param value Value to be deleted
	 * @return If the value was deleted
	 */
	public boolean remove(int value) {
		return false;
	}

	/**
	 * Prints leftChild - root - rightChild This is the equivalent of a depth first
	 * search
	 *
	 * @param localRoot The local root of the binary tree
	 */
	public void inOrder(Node localRoot) {
		if(localRoot == null) {
			return;
		}
		inOrder(localRoot.left);
		System.out.print(localRoot.data + " ");
		inOrder(localRoot.right);
	}

	/**
	 * Prints rightChild - leftChild - root
	 *
	 * @param localRoot The local root of the binary tree
	 */
	public void postOrder(Node localRoot) {
		if(localRoot == null) {
			return;
		}
		postOrder(localRoot.left);
		postOrder(localRoot.right);
		System.out.print(localRoot.data + " ");
	}

	/**
	 * Prints root - leftChild - rightChild
	 *
	 * @param localRoot The local root of the binary tree
	 */
	public void preOrder(Node localRoot) {
		if(localRoot == null) {
			return;
		}
		System.out.print(localRoot.data + " ");
		preOrder(localRoot.left);
		preOrder(localRoot.right);
	}

	/**
	 * Prints the tree in a breadth first search order This is similar to pre-order
	 * traversal, but instead of being implemented with a stack (or recursion), it
	 * is implemented with a queue
	 *
	 * @param localRoot The local root of the binary tree
	 */
	public void levelOrder(Node localRoot) {
	}
}
