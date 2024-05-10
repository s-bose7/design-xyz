package dynamic.array.test;

import static org.junit.Assert.*;

import org.junit.Test;

import design.dynamic.array.DynamicArray;

public class DynamicArrayTest {

	@Test
	public void checkAmortizedRunTime() {
            DynamicArray arr = new DynamicArray(3);
         
            arr.add(1);
            arr.add(2);
            arr.add(4);
            arr.add(5);
            
            assertEquals(6, arr.getCapacity());
            assertEquals(4, arr.getSize());
            
            assertEquals(5, arr.get(3));
            assertEquals(4, arr.get(2));
            assertEquals(2, arr.get(1));
//            assertEquals(-1, arr.get(4));
//            assertEquals(-1, arr.get(-1));
            assertEquals(5, arr.popback());
	}

}
