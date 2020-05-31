package com.yoji.listwithcustomelements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.GregorianCalendar;

public class TaskTimeLimitsMainFragment extends Fragment {

    private CalendarView startCalendarView;
    private CalendarView endCalendarView;
    private Button chooseStartDateButton;
    private Button chooseEndDateButton;
    private Button okButton;

    private long startDate;
    private String startDateText;
    private String endDateText;
    private GregorianCalendar gregorianCalendar;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_task_time_limits, container, false);

        initViews();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initViews() {
        startCalendarView = view.findViewById(R.id.startDateCalendarId);
        endCalendarView = view.findViewById(R.id.endDateCalendarId);
        chooseStartDateButton = view.findViewById(R.id.chooseStartDateButtonId);
        chooseEndDateButton = view.findViewById(R.id.chooseEndDateButtonId);
        okButton = view.findViewById(R.id.okButtonId);

        chooseStartDateButton.setOnClickListener(chooseStartDateButtonOnClickListener);
        chooseEndDateButton.setOnClickListener(chooseEndDateButtonOnClickListener);
        okButton.setOnClickListener(okButtonOnClickListener);

        startCalendarView.setOnDateChangeListener(startCalendarOnDateChangeListener);
        endCalendarView.setOnDateChangeListener(endCalendarOnDateChangeListener);

        chooseStartDateButton.setText(getString(R.string.start_date_and_time, ""));
        chooseEndDateButton.setText(getString(R.string.end_date_and_time, ""));

        startCalendarView.setVisibility(View.GONE);
        endCalendarView.setVisibility(View.GONE);
    }

    private View.OnClickListener chooseStartDateButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startCalendarView.setVisibility(View.VISIBLE);
            endCalendarView.setVisibility(View.GONE);
        }
    };

    private View.OnClickListener chooseEndDateButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startCalendarView.setVisibility(View.GONE);
            endCalendarView.setVisibility(View.VISIBLE);
        }
    };

    private View.OnClickListener okButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String toastMessage = getString(R.string.toast_message_task_time_limits, startDateText, endDateText);
            Toast.makeText(getContext(), toastMessage, Toast.LENGTH_LONG).show();
            chooseStartDateButton.setText(getString(R.string.start_date_and_time, ""));
            chooseEndDateButton.setText(getString(R.string.end_date_and_time, ""));
        }
    };

    private CalendarView.OnDateChangeListener startCalendarOnDateChangeListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
            startDateText = year + "-" + month +"-" + dayOfMonth;
            chooseStartDateButton.setText(getString(R.string.start_date_and_time, startDateText));
            gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(year, month, dayOfMonth);
            startDate = gregorianCalendar.getTimeInMillis();
            startCalendarView.setVisibility(View.GONE);
            chooseEndDateButton.setEnabled(true);
        }
    };

    private CalendarView.OnDateChangeListener endCalendarOnDateChangeListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
            endDateText = year + "-" + month + "-" + dayOfMonth;
            chooseEndDateButton.setText(getString(R.string.end_date_and_time, endDateText));
            gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(year, month, dayOfMonth);
            long endDate = gregorianCalendar.getTimeInMillis();
            endCalendarView.setVisibility(View.GONE);
            if (startDate > endDate){
                Toast.makeText(getContext(), R.string.error, Toast.LENGTH_LONG).show();
                chooseEndDateButton.setText(getString(R.string.end_date_and_time, ""));
            }else{
                okButton.setEnabled(true);
            }
        }
    };
}
