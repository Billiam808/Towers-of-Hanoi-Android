// Sean Adams
// Bill Adona
// Nicolas Wilhoit
// CSCI 3320 Advanced Programming
// PA7
// Towers of Hanoi App
// menuActivity.java
// this file handles the main menu

package com.example.billjoshua.thrules;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;


public class menuActivity extends AppCompatActivity
{
    //private static Button button2;
    private Button playButt, rulesButt;
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        playButt = (Button) findViewById(R.id.playButton);
        rulesButt = (Button) findViewById(R.id.rulesButton);


    }
    //play button in menu screen
    public void playButton(View view)
    {
        Intent numberPickerScreen = new Intent(this, numberPickerActivity.class);
        startActivity(numberPickerScreen);
        final int result = 1;

        //getInputScreen.putExtra("CallingActivity", "TowersOfHanoi");
        //startActivityForResult(getInputScreen, result);
    }

    public void rulesButton(View view)
    {
        Intent getRulesScreen = new Intent(this, MainActivity.class);
        startActivity(getRulesScreen);
    }


}
