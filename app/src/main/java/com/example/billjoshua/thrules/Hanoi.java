// Sean Adams
// Bill Adona
// Nicolas Wilhoit
// CSCI 3320 Advanced Programming
// PA7
// Towers of Hanoi App
// Hanoi.java
// this file represents the entire game, and contains functionality
// for the user to alter the state of the game

package com.example.billjoshua.thrules;


import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;
import android.graphics.Color;


public class Hanoi extends View {
	
	HStack left;
	HStack middle;
	HStack right;
	
	int temp;
	int diskNum;
    int moveCount;
	
	Boolean complete;


    // constructor
    public Hanoi(Context context, AttributeSet attrs) {

        super(context, attrs);

    } // end constructor



	// sets the initial state of the game
	public void initialize(int size) {
		
		temp = 0;

        moveCount = 0;
		
		diskNum = size;
		
		left = new HStack(diskNum);
		for(int i = size; i >= 1; --i) {
			
			left.push(i);
			
		} // end for loop
		
		middle = new HStack(diskNum);
		right = new HStack(diskNum);
		
		complete = false;
		
	} // end initialize
	
	
	// handles the activation of a stack based on context
	public void activate(HStack stack) {

        ++moveCount;

		// if there is nothing in 'temp' and the stack is not empty
		if(temp == 0 && !stack.isEmpty()) {
			
			temp = stack.pop();
			
		} // end if statement
		
		// if there is something in temp
		else if(temp != 0) {
			
			// if the stack is empty
			if(stack.isEmpty()) {
				
				stack.push(temp);
				temp = 0;
				
			} // end inner if statement
			
			// if the stack wasn't empty and temp is a smaller disk than the top of the stack
			else if(stack.peek() > temp) {
			
				stack.push(temp);
				temp = 0;
			
			} // end inner else-if statement
			
		} // end outer else-if statement


        // display the state of the game
        invalidate();

		// check to see if game is finished
        assess();

	} // end activate function


    // checks to see if the game is finished and modifies 'complete' accordingly
    public void assess() {

        if(middle.size == diskNum || right.size == diskNum) {

            complete = true;

        }

    } // end assess


    // displays the game
    public void onDraw(Canvas canvas) {

        // data necessary for properly displaying the towers themselves
        int topOffset = 0;
        int bottomOffset = canvas.getHeight();
        int towerWidth = 40;
        int leftTowerOffset = (canvas.getWidth() / 6) - 50;
		int middleTowerOffset = (canvas.getWidth() / 2) - 20;
        int rightTowerOffset = ((canvas.getWidth() * 5) / 6);


        // sets the color to black
        Paint blackP = new Paint();
        blackP.setColor(Color.BLACK);

        // makes a rectangle for each tower
        Rect towers = new Rect();

        towers.set(leftTowerOffset, topOffset, leftTowerOffset + towerWidth, bottomOffset);
        canvas.drawRect(towers, blackP);

        towers.set(middleTowerOffset, topOffset, middleTowerOffset + towerWidth, bottomOffset);
        canvas.drawRect(towers, blackP);

        towers.set(rightTowerOffset, topOffset, rightTowerOffset + towerWidth, bottomOffset);
        canvas.drawRect(towers, blackP);


        // data necessary for displaying the disks on each tower
        int diskHeight = (canvas.getHeight() / 6) - 50;
        int diskWidth = 0;
        int diskBottomOffset = 0;
        int diskTopOffset = 0;
        int diskLeftOffset = 0;
        int diskRightOffset = 0;


        Rect disks = new Rect();
        HNode iterator = left.head.next;

        // print left tower disks
        for(int i = 0; i < left.size; ++i) {

            diskWidth = towerWidth + (50 * iterator.magnitude);
            diskLeftOffset = leftTowerOffset - (50 * iterator.magnitude);
            diskRightOffset = leftTowerOffset + diskWidth;
            diskBottomOffset = (canvas.getHeight() / 6) * iterator.position;
            diskTopOffset = diskBottomOffset - diskHeight;

            disks.set(diskLeftOffset, diskTopOffset, diskRightOffset, diskBottomOffset);
            canvas.drawRect(disks, blackP);

            iterator = iterator.next;

        } // end left disks for loop


        iterator = middle.head.next;

        // print middle tower disks
        for(int i = 0; i < middle.size; ++i) {

            diskWidth = towerWidth + (50 * iterator.magnitude);
            diskLeftOffset = middleTowerOffset - (50 * iterator.magnitude);
            diskRightOffset = middleTowerOffset + diskWidth;
            diskBottomOffset = (canvas.getHeight() / 6) * iterator.position;
            diskTopOffset = diskBottomOffset - diskHeight;

            disks.set(diskLeftOffset, diskTopOffset, diskRightOffset, diskBottomOffset);
            canvas.drawRect(disks, blackP);

            iterator = iterator.next;

        } // end middle disks for loop


        iterator = right.head.next;

        // print right tower disks
        for(int i = 0; i < right.size; ++i) {

            diskWidth = towerWidth + (50 * iterator.magnitude);
            diskLeftOffset = rightTowerOffset - (50 * iterator.magnitude);
            diskRightOffset = rightTowerOffset + diskWidth;
            diskBottomOffset = (canvas.getHeight() / 6) * iterator.position;
            diskTopOffset = diskBottomOffset - diskHeight;

            disks.set(diskLeftOffset, diskTopOffset, diskRightOffset, diskBottomOffset);
            canvas.drawRect(disks, blackP);

            iterator = iterator.next;

        } // end right disks for loop

    }
	
} // end Hanoi class