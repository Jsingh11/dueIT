package com.example.dueit_second;

import android.content.Context;
import android.content.res.Resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReminderDatabase {

    private static ReminderDatabase sReminderDatabase;
    private List<Reminder> mReminders;


    public static ReminderDatabase get(Context context) throws ParseException {
        if (sReminderDatabase == null){
            sReminderDatabase = new ReminderDatabase(context);
        }
        return sReminderDatabase;
    }

    private ReminderDatabase(Context context) throws ParseException {
        mReminders = new ArrayList<>();
        Resources res = context.getResources();
        String[] reminders = res.getStringArray(R.array.reminders);
        String[] descriptions = res.getStringArray(R.array.descriptions);
//        String[] dueDates = res.getStringArray(R.array.dueDates);
//        int[] priorities = res.getIntArray(R.array.priorities);

        for(int i = 0; i < reminders.length; i++){
//            Date tempDate = new SimpleDateFormat("dd/MM/yyyy").parse(dueDates[i]);

            mReminders.add(new Reminder(i+1,reminders[i],descriptions[i]));//,tempDate,priorities[i]));
        }

    }

    public List<Reminder> getReminders() {
        return mReminders;
    }

    public Reminder getReminder(int reminderId){
        for(Reminder reminder : mReminders){
            if(reminder.getId() == reminderId){
                return reminder;
            }
        }
        return null;
    }
}
