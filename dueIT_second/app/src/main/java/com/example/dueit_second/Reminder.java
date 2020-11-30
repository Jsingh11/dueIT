package com.example.dueit_second;

import java.util.Date;

public class Reminder {

    // need to figure out how this will all go together
    private int mId;
    private String mName;
    private String mDescription;
//    private Date mDuedate;
//    private int mPriority;

    public Reminder() {}

    public Reminder(int Id, String Name, String Description){//, Date Duedate, int Priority) {
        mId = Id;
        mName = Name;
        mDescription = Description;
//        mDuedate = Duedate;
//        mPriority = Priority;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

//    public Date getDuedate() {
//        return mDuedate;
//    }
//
//    public void setDuedate(Date mDuedate) {
//        this.mDuedate = mDuedate;
//    }
//
//    public int getPriority() {
//        return mPriority;
//    }
//
//    public void setPriority(int mPriority) {
//        this.mPriority = mPriority;
//    }
}
