package com.example.dueit_second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        Button dailyTaskButton = (Button) findViewById(R.id.dailyTaskButton);


        // In question1 get the TextView use by findViewById()
        // In TextView set question Answer for message


        // Add_button add clicklistener
        dailyTaskButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, dailyActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });


        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        Button weeklyTaskButton = (Button) findViewById(R.id.weeklyTaskButton);


        // In question1 get the TextView use by findViewById()
        // In TextView set question Answer for message


        // Add_button add clicklistener

        weeklyTaskButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, weeklyActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });



        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        Button monthlyTaskButton = (Button) findViewById(R.id.monthlyTaskButton);


        // In question1 get the TextView use by findViewById()
        // In TextView set question Answer for message


        // Add_button add clicklistener

        monthlyTaskButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, monthlyActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });



        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        ImageButton fab = (ImageButton) findViewById(R.id.addTaskButton);


        // In question1 get the TextView use by findViewById()
        // In TextView set question Answer for message


        // Add_button add clicklistener

        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, fabActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

}