package com.example.dueit_second;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class monthlyDetailsActivity extends AppCompatActivity {

    public static String EXTRA_REMINDER_ID = "reminderId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Terminate if two panes are displaying since ListActivity should be displaying both panes
//        boolean isTwoPanes = getResources().getBoolean(R.bool.twoPanes);
//        if (isTwoPanes) {
//            finish();
//            return;
//        }

        setContentView(R.layout.monthly_activity_details);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.details_fragment_container);

        if (fragment == null) {
            // Use reminder ID from ListFragment to instantiate DetailsFragment
            int reminderId = getIntent().getIntExtra(EXTRA_REMINDER_ID, 1);
            fragment = monthlyDetailsFragment.newInstance(reminderId);
            fragmentManager.beginTransaction()
                    .add(R.id.details_fragment_container, fragment)
                    .commit();
        }
    }
}
