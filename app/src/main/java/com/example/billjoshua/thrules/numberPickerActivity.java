// Sean Adams
// Bill Adona
// Nicolas Wilhoit
// CSCI 3320 Advanced Programming
// PA7
// Towers of Hanoi App
// numberPickerActivity.java
// this file handles the number picker that determines the size of the game

package com.example.billjoshua.thrules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

/**
 * Created by BillJoshua on 11/22/2015.
 */
public class numberPickerActivity extends Activity
{
    NumberPicker noPicker = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_picker_layout);
        noPicker = (NumberPicker)findViewById(R.id.NumberPicker);
        noPicker.setMaxValue(6);
        noPicker.setMinValue(3);
        noPicker.setWrapSelectorWheel(false);
    }

    public void play(View view)
    {
        int num = noPicker.getValue();
        Intent activityThatCalled = new Intent(this, playActivity.class);
        final int result = 1;
        activityThatCalled.putExtra("number", num);
        startActivity(activityThatCalled);
        //String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
    }

}
