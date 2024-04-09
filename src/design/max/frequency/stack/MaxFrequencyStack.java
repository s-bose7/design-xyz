package design.max.frequency.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * @author s-bose7 
 * */

public class MaxFrequencyStack {
	// Map to store frequencies of elements
	private Map<Integer, Integer> frequencyCounterMap;
	// Map to store stacks of elements for each frequency
	private Map<Integer, List<Integer>> freqencyGroupMap;
	// Variable to keep track of maximum frequency
    private int maxFreq;
	
	// Constructor to initialize data structures
    public MaxFrequencyStack() {
    	this.freqencyGroupMap = new HashMap<>();
    	this.frequencyCounterMap = new HashMap<>();
    	
        this.maxFreq = Integer.MIN_VALUE;
    }
    
    /**
     * Pushes the given element onto the stack.
     * @param val The element to be pushed onto the stack.
     */
    public void push(int val) {
    	frequencyCounterMap.put(val, frequencyCounterMap.getOrDefault(val, 0) + 1);
    	int freq = frequencyCounterMap.get(val);
    	
    	if(freqencyGroupMap.getOrDefault(freq, null) == null) {
    		List<Integer> stackGroup =  new ArrayList<>();
    		freqencyGroupMap.put(freq, stackGroup);
    	}
    	freqencyGroupMap.get(freq).add(val);
    	
    	if(freq > maxFreq) {
    		maxFreq = freq;
    	}
    }
    
    /**
     * Pops the top element from the stack and returns it.
     * If there are multiple elements with the same maximum frequency, return the one that is closest to
     * the stack's top.
     * @return The most frequent element popped from the stack.
     */
    public int pop() {
    	List<Integer> mostFrequentGroup = freqencyGroupMap.get(maxFreq);
    	int size = mostFrequentGroup.size(), mostFrequentElement;
    	if(size > 1) {
    		mostFrequentElement = mostFrequentGroup.remove(size-1);
    	}else {
    		mostFrequentElement = mostFrequentGroup.remove(0);
    		mostFrequentGroup = null;
    		maxFreq = maxFreq - 1;
    	}
    	frequencyCounterMap.put(mostFrequentElement, frequencyCounterMap.get(mostFrequentElement)-1);
    	return mostFrequentElement;
    }
    
    /**
     * Returns the top element of the stack without popping it.
     * @return The top element of the stack.
     * @deprecated
     */
    public int top() {
    	if(frequencyCounterMap.isEmpty()) {
    		return -1;
    	}
    	return -1;
    }
}
