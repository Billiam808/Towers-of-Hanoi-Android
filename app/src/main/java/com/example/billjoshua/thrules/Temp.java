// Sean Adams
// Bill Adona
// Nicolas Wilhoit
// CSCI 3320 Advanced Programming
// PA7
// Towers of Hanoi App
// Temp.java
// This file implements the View that displays the temporary holder for disks

package com.example.billjoshua.thrules;

/**
 * Created by Overlord on 11/29/15.
 */

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;
import android.graphics.Color;

public class Temp extends View {

    // the disk that is in the temporary holder
    int temp;

    // constructor
    public Temp(Context context, AttributeSet attrs) {

        super(context, attrs);

    } // end constructor


    // allows the temp to be altered
    public void setTemp(int input) {

        temp = input;

    }

    // draws the temp disk to the top of the screen
    public void onDraw(Canvas canvas) {

        if (temp != 0) {

            // sets the color to black
            Paint blackP = new Paint();
            blackP.setColor(Color.BLACK);

            Rect tempRect = new Rect();


            // set rectangle dimensions and print it
            tempRect.set((canvas.getWidth() / 2) - (50 * temp) - 15, 5, (canvas.getWidth() / 2) + (50 * temp) + 15, 75);
            canvas.drawRect(tempRect, blackP);

        }
    }

}
