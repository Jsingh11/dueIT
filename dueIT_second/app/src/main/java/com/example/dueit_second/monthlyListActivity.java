package com.example.dueit_second;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class monthlyListActivity extends AppCompatActivity implements monthlyListFragment.OnReminderSelectedListener {

    private static final String KEY_BAND_ID = "reminderId";
    private int mReminderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monthly_activity_list);

        mReminderId = -1;

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.list_fragment_container);

        if (fragment == null) {
            fragment = new monthlyListFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.list_fragment_container, fragment)
                    .commit();
        }

        // Replace DetailsFragment if state saved when going from portrait to landscape
        if (savedInstanceState != null && savedInstanceState.getInt(KEY_BAND_ID) != 0
                ) {
            mReminderId = savedInstanceState.getInt(KEY_BAND_ID);
            Fragment reminderFragment = monthlyDetailsFragment.newInstance(mReminderId);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.details_fragment_container, reminderFragment)
                    .commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Save state when something is selected
        if (mReminderId != -1) {
            savedInstanceState.putInt(KEY_BAND_ID, mReminderId);
        }
    }

    @Override
    public void onReminderSelected(int reminderId) {

        mReminderId = reminderId;

        if (findViewById(R.id.details_fragment_container) == null) {
            // Must be in portrait, so start activity
            Intent intent = new Intent(this, monthlyDetailsActivity.class);
            intent.putExtra(monthlyDetailsActivity.EXTRA_REMINDER_ID, reminderId);
            startActivity(intent);
        } else {
            // Replace previous fragment (if one exists) with a new fragment
            Fragment reminderFragment = monthlyDetailsFragment.newInstance(reminderId);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.details_fragment_container, reminderFragment)
                    .commit();
        }
    }
}
