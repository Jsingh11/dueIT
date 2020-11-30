package com.example.dueit_second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class weeklyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);



        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        Button backButton = (Button) findViewById(R.id.backButton);


        // In question1 get the TextView use by findViewById()
        // In TextView set question Answer for message


        // Add_button add clicklistener
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(weeklyListActivity.this, MainActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });
    }
}