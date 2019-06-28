package ocp.ch3._03;

import java.util.ArrayDeque;

public class ArrayDequeMethods {

	public static void main(String[] args) {
		ArrayDeque<String> deque = new ArrayDeque<>();

		// Q - queue, S - stack

		deque.add("test"); 		// Q - add to END will, throw EXCEPTION if is not successful
		deque.offer("test"); // Q - add to END, won't throw EXCEPTION if is not successful

		deque.push("test"); 	// Q S add to FRONT, makes a double ended queue

		deque.element(); 		// Q - returns next or EXCEPTION if empty
		deque.peek(); 			// Q S returns the next or NULL

		deque.remove();			// Q - removes and returns the next or throws EXCEPTION if empty
		deque.pop(); 			// - S removes and returns the next or throws EXCEPTION if empty
		deque.poll(); 			// Q - removes and returns the next or NULL

		// LIFO (stack) 			 - push  / poll / peek
		// FIFO (single-ended queue) - offer / poll / peek
	}
}
