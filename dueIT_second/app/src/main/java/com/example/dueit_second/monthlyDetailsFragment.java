package com.example.dueit_second;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import java.text.ParseException;

public class monthlyDetailsFragment extends Fragment {

    private Reminder mReminder;

    public static monthlyDetailsFragment newInstance(int reminderId) {
        monthlyDetailsFragment fragment = new monthlyDetailsFragment();
        Bundle args = new Bundle();
        args.putInt("reminderId", reminderId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the reminder ID from the intent that started DetailsActivity
        int reminderId = 1;
        if (getArguments() != null) {
            reminderId = getArguments().getInt("reminderId");
        }

        try {
            mReminder = ReminderDatabase.get(getContext()).getReminder(reminderId);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.monthly_fragment_details, container, false);

        TextView nameTextView = view.findViewById(R.id.reminderName);
        nameTextView.setText(mReminder.getName());

        TextView descriptionTextView = view.findViewById(R.id.reminderDescription);
        descriptionTextView.setText(mReminder.getDescription());

        return view;
    }
}
