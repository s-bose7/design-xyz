/**
 * 
 */
package design.min.stack;

/**
 * @author SUDIP BOSE
 * Represents a cell of the stack
 * Contains -
 * value: cell value 
   minElementAtThisTime: the minimum element of the stack
 */
public class StackCell {
	int value;
	int minElementAtThisTime;
	StackCell next, prev;
	
	public StackCell(int value) {
		this.value = value;
		// By default minimum element will be current cell element
		this.minElementAtThisTime = this.value;
		this.next = this.prev = null;
	}
}
