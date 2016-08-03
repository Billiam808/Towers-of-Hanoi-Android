// Sean Adams
// Bill Adona
// Nicolas Wilhoit
// CSCI 3320 Advanced Programming
// PA7
// Towers of Hanoi App
// MainActivity.java
// This file handls the main activity

package com.example.billjoshua.thrules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Button playButtn, menuButtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_layout);
        playButtn = (Button) findViewById(R.id.play_button);
        menuButtn = (Button) findViewById(R.id.menu_button);
    }

    public void playButton(View view)
    {
        Intent numberPickerScreen = new Intent(this, numberPickerActivity.class);
        startActivity(numberPickerScreen);
    }

    public void menuButton(View view)
    {
        Intent getMenuScreen = new Intent(this, menuActivity.class);
        final int result = 1;
        startActivity(getMenuScreen);
    }
}
