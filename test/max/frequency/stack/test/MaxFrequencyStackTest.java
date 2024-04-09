package max.frequency.stack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import design.max.frequency.stack.MaxFrequencyStack;

public class MaxFrequencyStackTest {

	@Test
	public void testMaxFrequencyStack() {
		MaxFrequencyStack mostFreqentStack = new MaxFrequencyStack();
        mostFreqentStack.push(5);
        mostFreqentStack.push(2);
        mostFreqentStack.push(3);
        mostFreqentStack.push(3);
        mostFreqentStack.push(5);
        mostFreqentStack.push(5);
        
        assertEquals(5, mostFreqentStack.pop());
        assertEquals(5, mostFreqentStack.pop());
        assertEquals(3, mostFreqentStack.pop());
        assertEquals(3, mostFreqentStack.pop());
        assertEquals(2, mostFreqentStack.pop());
        assertEquals(5, mostFreqentStack.pop());
	}

}
