// Sean Adams
// Bill Adona
// Nicolas Wilhoit
// CSCI 3320 Advanced Programming
// PA7
// Towers of Hanoi App
// HNode.java
// this file implements the disks

package com.example.billjoshua.thrules;

public class HNode {

	int magnitude;
    int position;
	HNode next;
	
	// constructor
	public HNode(int value, int gameSize) {
		
		magnitude = value;
		next = null;
        position = (6 - gameSize + magnitude);
		
	} // end constructor
	
} // end HNode class
