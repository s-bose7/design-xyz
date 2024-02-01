package design.binary.tree;

public class Node {

    /**
     * Data for the node
     */
    public int data;
    /**
     * The Node to the left of this one
     */
    public Node left;
    /**
     * The Node to the right of this one
     */
    public Node right;
    /**
     * The parent of this node
     */
    public Node parent;

    /**
     * Constructor of Node
     *
     * @param value Value to put in the node
     */
    public Node(int value) {
        data = value;
        left = null;
        right = null;
        parent = null;
    }
}
