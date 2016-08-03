// Sean Adams
// Bill Adona
// Nicolas Wilhoit
// CSCI 3320 Advanced Programming
// PA7
// Towers of Hanoi App
// HStack.java
// this file implements the towers

package com.example.billjoshua.thrules;

public class HStack {

	HNode head;
	int size;
	int diskNum;
	
	// default constructor
	public HStack(int numOfDisks) {

		diskNum = numOfDisks;
		head = new HNode(0,diskNum);
		head.next = null;
		size = 0;
		
	} // end default constructor
	
	
	// adds a value to the top of the stack
	public void push(int value) {
		
		HNode newValue = new HNode(value, diskNum);
		newValue.next = head.next;
		head.next = newValue;
		
		++size;
		
	} // end push function
	
	
	// removes a value from the top of the stack
	public int pop() {
		
		if(head.next != null) {
			
			int temp = head.next.magnitude;
			head.next = head.next.next;
		
			--size;
		
			return temp;
			
		} // end if statement
		
		else return 0;
		
	} // end pop function
	
	
	// checks to see if the stack is empty
	public Boolean isEmpty() {
		
		if(size == 0) {
			
			return true;
			
		} // end if statement
		
		else return false;
		
	} // end isEmpty function
	
	
	// returns value of the top of the stack
	public int peek() {
		
		return head.next.magnitude;
		
	} // end peek function
	
	
} // end HStack class
