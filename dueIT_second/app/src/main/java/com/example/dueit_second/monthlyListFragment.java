package com.example.dueit_second;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.List;



public class monthlyListFragment extends Fragment {

    // For the activity to implement
    public interface OnReminderSelectedListener {
        void onReminderSelected(int reminderId);
    }

    // Reference to the activity
    private OnReminderSelectedListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.monthly_fragment_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.reminder_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Send reminders to recycler view
        ReminderAdapter adapter = null;
        try {
            adapter = new ReminderAdapter(ReminderDatabase.get(getContext()).getReminders());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);

        return view;
    }

    private class ReminderHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Reminder mReminder;

        private TextView mNameTextView;

        public ReminderHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.monthly_list_item_reminder, parent, false));
            itemView.setOnClickListener(this);
            mNameTextView = (TextView) itemView.findViewById(R.id.reminderName);
        }

        public void bind(Reminder reminder) {
            mReminder = reminder;
            mNameTextView.setText(mReminder.getName());
        }

        @Override
        public void onClick(View view) {
            // Tell ListActivity what reminder was clicked
            mListener.onReminderSelected(mReminder.getId());
        }
    }

    private class ReminderAdapter extends RecyclerView.Adapter<ReminderHolder> {

        private List<Reminder> mReminders;

        public ReminderAdapter(List<Reminder> reminders) {
            mReminders = reminders;
        }

        @Override
        public ReminderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ReminderHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ReminderHolder holder, int position) {
            Reminder reminder = mReminders.get(position);
            holder.bind(reminder);
        }

        @Override
        public int getItemCount() {
            return mReminders.size();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnReminderSelectedListener) {
            mListener = (OnReminderSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnReminderSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Notify activity of reminder selection
            String reminderId = (String) view.getTag();
            mListener.onReminderSelected(Integer.parseInt(reminderId));
        }
    };

}