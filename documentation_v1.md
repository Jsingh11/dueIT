# Documentation

---
gitHub with most updated information including this document: <https://github.com/Jsingh11/dueIT>

### Breakdown: 

1. Main Activity
	- The main activity holds our "home screen." On this home screen we have three buttons that will take you to the different ways in which you can see your reminders
	- These three buttons are "daily tasks", "weekly tasks", "monthly tasks"
	- Also at the bottom there are more image buttons that have not been implemented yet but will be

2. Task Screens
	- The task screens are all the same, the only thing that will differentiate them is what tasks are shown in each screeen
	- This is not 100% complete right now but the task screen will include a list view that will display our tasks to the user
	- If you are in the "daily tasks" view, only tasks that are due that day will be shown, all other tasks will be hidden
	- Right now all of the task screens only have a back button and a text view that states what activity they are

3. Floating Action Button
	- The floating action button in the bottom right corner and this will be where users will click to add reminders.
	- When this button is pressed users are taken to a screen where they are asked to type in their reminder and also assign a priority to it
	- Right now the submit and creation of the reminder is undone but will be done by the next sprint

### How it works:

For this first sprint Jose took the UI that Dhruval designed and made it actually function. Dhruval had buttons and image buttons placed and Jose made it so that when most of the buttons were pressed you would actually have something happen like in a real app.

The three main buttons all take you to seperate pages and the floating action button also takes you to a page where the user will input the reminder.

The way this works is by using Intents. Each button has an onClick() listener that when pressed sends the user to the next activity. In the next activity there is also a back button that will take the user back to the mainActivity which is our main screen.

This is how that is implemented code wise:

```java

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        Button dailyTaskButton = (Button) findViewById(R.id.dailyTaskButton);

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
     }
}

```


This code was for sending users from the 'home screen' to the 'daily task' screen via the 'daily task' button.

For all of the other screens the same logic was followed. The only difference is when we encounter an image button, this occurs with the FAB, since it is an image in our app. This is how it is implemented then, the same logic just with an imageButton

```java

// by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        ImageButton fab = (ImageButton) findViewById(R.id.fab);


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
        
```

So once a user is at the screen that we want them to be at, they must go back. In our case we used a simple back button that links our users back to the main activity. This same back button logic is used for every single page.

```java

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);


        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        Button backButton = (Button) findViewById(R.id.backButton);

        // Add_button add clicklistener
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(dailyActivity.this, MainActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });

    }
}

```

In total we have 5 activities, and 5 .java files because at the moment we have 5 'pages' the user can go to. 

### Things that are still left to do:

- FAB activity needs a submit button and a way for it to take in user reminders as well with the other information that a reminder contains. In our case, the due date, priority level, and of course the reminder
- All of the task pages must be filled with a list view that will display the correct reminders. This would probably involve some sort of logic like:

```java
 
if (reminder.date == today){
dailyTask_listView.add(reminder)
}

if (reminder.date == thisWeek){
weeklyTask_listView.add(reminder)
}

if (reminder.date == thisMonth){
monthlyTask_listView.add(reminder)
}

```

- The bottom image buttons need to have their own activity pages and those must be filled with their functions



Jose Diaz