# Design a Max Frequency Stack

This document outlines the design and implementation of a stack data structure that supports operations such as push, top, and removing the maximum frequent element of the stack in constant time.

## Problem Statement

Design a stack data structure, called Max Frequency Stack, with the following requirements:

1. Initialize the stack object.
2. Push an element onto the stack.
3. Pop the most frequent element of the stack. If there are more than one most frequent element then remove the element that is closet to the stack's top.

4. Get the top element of the stack.

Additionally, it's required to implement a solution with O(1) time complexity for each function.

## Overview
```java
class DesignMaxFrequenyStack {
	public static void main(String[] args){
		MaxFrequencyStack mostFreqentStack = new MaxFrequencyStack();
		
		mostFreqentStack.push(5);
		mostFreqentStack.push(2);
		mostFreqentStack.push(3);
		mostFreqentStack.push(3);
		mostFreqentStack.push(5);
		mostFreqentStack.push(5);
		
		mostFreqentStack.pop(); // 5
		mostFreqentStack.pop(); // 5
		mostFreqentStack.pop(); // 3
		mostFreqentStack.pop(); // 3
		mostFreqentStack.pop(); // 2
		mostFreqentStack.pop(); // 5
	}
}
```

## Constraints

- Values to be pushed onto the stack are 32 bit integers within the range -2147483648 to 2147483647.

## Solution

To meet the requirements specified above, I implemented the MaxFrequencyStack class in such a way that all operations have O(1) time complexity. The implementation utilizes two auxiliary hash maps recording the frequency and frequency to a group mapping. Elements in a group has that exact frequency of the key.

The provided code implements the MaxFrequencyStack class with the required functionalities. Each method is designed to operate in constant time, ensuring efficient performance for large data sets and frequent operations.

## Usage

To use the MaxFrequencyStack implementation in your project:

1. Include the MaxFrequencyStack class in your codebase.
2. Instantiate a MaxFrequencyStack object.
3. Call the respective methods to push elements onto the stack, retrieve the top element, pop elements  get the most frequent element.

## Conclusion

The MaxFrequencyStack implementation provided above satisfies all the requirements specified in the problem statement. It offers efficient O(1) time complexity for push, pop, top operations, making it suitable for various applications where constant-time performance is essential. If you encounter any issues or have further questions, please don't hesitate to reach out.

---
Copyright © 2024. All rights reserved.
