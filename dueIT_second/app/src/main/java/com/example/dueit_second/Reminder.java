package com.example.dueit_second;

import java.util.Date;

public class Reminder {

    // need to figure out how this will all go together
    private int mId;
    private String mName;
    private String mDescription;
    private Date mDuedate;
    private int mPriority;

    public Reminder() {}

    public Reminder(int mId, String mName, String mDescription, Date mDuedate, int mPriority) {
        this.mId = mId;
        this.mName = mName;
        this.mDescription = mDescription;
        this.mDuedate = mDuedate;
        this.mPriority = mPriority;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Date getmDuedate() {
        return mDuedate;
    }

    public void setmDuedate(Date mDuedate) {
        this.mDuedate = mDuedate;
    }

    public int getmPriority() {
        return mPriority;
    }

    public void setmPriority(int mPriority) {
        this.mPriority = mPriority;
    }
}
