// Sean Adams
// Bill Adona
// Nicolas Wilhoit
// CSCI 3320 Advanced Programming
// PA7
// Towers of Hanoi App
// playActivity.java
// This is the main file for the play screen



package com.example.billjoshua.thrules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.Toast;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by BillJoshua on 11/15/2015.
 */
public class playActivity extends Activity
{
    Hanoi game;
    Temp tempSlot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_layout);

        // get the number from numberPickerActivity.java
        Intent prevActivity = getIntent();
        int numberFromPrevAct = prevActivity.getExtras().getInt("number");

        // create and initialize a Hanoi object
        game = (Hanoi) findViewById(R.id.Hanoi);
        game.initialize(numberFromPrevAct);

        // creates a Temp object for the temporary disk placement
        tempSlot = (Temp) findViewById(R.id.Temp);

        // display the initial state of the game
        game.invalidate();

    }

    // connects to the menu button and brings user to menu
    public void menuButton(View view)
    {
        Intent getMenuScreen = new Intent(this, menuActivity.class);
        final int result = 1;
        startActivity(getMenuScreen);
    }

    // brings user to rules screen
    public void rulesButton(View view)
    {
        Intent getRulesScreen = new Intent(this, MainActivity.class);
        startActivity(getRulesScreen);
    }

    // activates the left tower
    public void activateLeft(View view) {

        // if the game is still going, make a move
        if(!game.complete) {
            game.activate(game.left);

            // gives the Temp object information about the disk (if any) that is not on a tower and prints it
            tempSlot.setTemp(game.temp);
            tempSlot.invalidate();


            // if the game is complete display victory message and prompt user to exit
            if (game.complete) {

                // calculates a grade for the user based on the number of moves they made
                int min = (int)Math.pow(2, game.diskNum) - 1;
                int grade = 100 - (((game.moveCount) / 2) - min);

                Context context = getApplicationContext();
                CharSequence text = "You Won!!! Your grade for this game is " + grade +
                                    " out of 100! Please return to the menu or exit the app!";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);

                // handles font size of toast
                ViewGroup group = (ViewGroup) toast.getView();
                TextView messageTextView = (TextView) group.getChildAt(0);
                messageTextView.setTextSize(25);


                toast.show();
            }
        }

    }


    // activate middle tower
    public void activateMiddle(View view) {

        // if the game is still going, make a move
        if(!game.complete) {
            game.activate(game.middle);

            // gives the Temp object information about the disk (if any) that is not on a tower and prints it
            tempSlot.setTemp(game.temp);
            tempSlot.invalidate();


            // if the game is complete display victory message and prompt user to exit
            if (game.complete) {

                // calculates a grade for the user based on the number of moves they made
                int min = (int)Math.pow(2, game.diskNum) - 1;
                int grade = 100 - (((game.moveCount) / 2) - min);

                Context context = getApplicationContext();
                CharSequence text = "You Won!!! Your grade for this game is " + grade +
                                    " out of 100! Please return to the menu or exit the app!";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);

                // handles font size of toast
                ViewGroup group = (ViewGroup) toast.getView();
                TextView messageTextView = (TextView) group.getChildAt(0);
                messageTextView.setTextSize(25);


                toast.show();
            }
        }

    }


    // activates right tower
    public void activateRight(View view) {

        // if the game is still going, make a move
        if(!game.complete) {
            game.activate(game.right);

            tempSlot.setTemp(game.temp);
            tempSlot.invalidate();


            // if the game is complete display victory message and prompt user to exit
            if (game.complete) {

                // calculates a grade for the user based on the number of moves they made
                int min = (int)Math.pow(2, game.diskNum) - 1;
                int grade = 100 - (((game.moveCount) / 2) - min);

                Context context = getApplicationContext();
                CharSequence text = "You Won!!! Your grade for this game is " + grade +
                                    " out of 100! Please return to the menu or exit the app!";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);

                // handles font size of toast
                ViewGroup group = (ViewGroup) toast.getView();
                TextView messageTextView = (TextView) group.getChildAt(0);
                messageTextView.setTextSize(25);

                toast.show();
            }
        }

    }


} // end playActivity
