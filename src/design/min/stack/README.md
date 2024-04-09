# Design MinStack

Welcome to the MinStack solution documentation! This document outlines the design and implementation of a stack data structure that supports operations such as push, pop, top, and retrieving the minimum element in constant time.

## Problem Statement

Design a stack data structure, called MinStack, with the following requirements:

1. Initialize the stack object.
2. Push an element onto the stack.
3. Pop the element from the top of the stack.
4. Get the top element of the stack.
5. Retrieve the minimum element in the stack.

Additionally, it's required to implement a solution with O(1) time complexity for each function.

## Overview

```java
class DesignMaxFrequenyStack {
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        
        minStack.push(5);
        minStack.push(2);
        minStack.push(3);
        minStack.push(3);
        minStack.push(5);
        minStack.push(5);
        
        minStack.pop(); // 5
        minStack.top(): // 5
        minStack.getMin(); // 2
        minStack.pop(); // 5
        minStack.pop(); // 3
        minStack.pop(); // 3
        minStack.pop(); // 2
        minStack.getMin(); // 5
    }
}
```

## Constraints

- Values to be pushed onto the stack are 32 bit integers within the range -2147483648 to 2147483647.

## Solution

To meet the requirements specified above, we implement the MinStack class in such a way that all operations have O(1) time complexity. The implementation utilizes an auxiliary singly-linked list implementation of stack data structure

The provided code implements the MinStack class with the required functionalities. Each method is designed to operate in constant time, ensuring efficient performance for large datasets and frequent operations.

## Usage

To use the MinStack implementation in your project:

1. Include the MinStack class in your codebase.
2. Instantiate a MinStack object.
3. Call the respective methods to push elements onto the stack, pop elements, retrieve the top element, or get the minimum element.

## Conclusion

The MinStack implementation provided above satisfies all the requirements specified in the problem statement. It offers efficient O(1) time complexity for push, pop, top, and getMin operations, making it suitable for various applications where constant-time performance is essential. If you encounter any issues or have further questions, please don't hesitate to reach out.


---
Copyright © 2024. All rights reserved.
