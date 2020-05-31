package com.yoji.listwithcustomelements.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.yoji.listwithcustomelements.MainActivity;
import com.yoji.listwithcustomelements.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainFragment extends Fragment {

    private View view;

    private List<MainFragmentItemData> itemList;
    private List<Drawable> screenList;
    private List<String> titleList;
    private List<String> subtitleList;

    private AdapterView.OnItemClickListener appListOnItemClickListener = (parent, view, position, id) -> {
        switch (position){
            case MainFragmentItem.HEALTH_MONITORING_SYSTEM:
                ((MainActivity) Objects.requireNonNull(getActivity())).openHealthMonitoringSystemFragment();
                break;
            case MainFragmentItem.NOTEBOOK:
                ((MainActivity) Objects.requireNonNull(getActivity())).openNotebookFragment();
                break;
            case MainFragmentItem.SPLASH_SCREEN:
                ((MainActivity) Objects.requireNonNull(getActivity())).openSplashScreenFragment();
                break;
            case MainFragmentItem.UNIVERSAL_INPUT_FORM:
                ((MainActivity) Objects.requireNonNull(getActivity())).openUniversalInputFormFragment();
                break;
            case MainFragmentItem.VIEW_PHOTOS:
                ((MainActivity) Objects.requireNonNull(getActivity())).openInfiniteActivityLoopFragment();
                break;
            case MainFragmentItem.RADIOBUTTON_BY_CHECKBOXES:
                ((MainActivity) Objects.requireNonNull(getActivity())).openRadiobuttonByCheckboxesFragment();
                break;
            case MainFragmentItem.COUNTRIES_CITIES_STREETS:
                ((MainActivity) Objects.requireNonNull(getActivity())).openCountiesCitiesStreetsFragment();
                break;
            case MainFragmentItem.TASK_TIME_LIMITS:
                ((MainActivity) Objects.requireNonNull(getActivity())).openTaskTimeLimitsFragment();
                break;
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        init();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void init(){
        ListView appListView = view.findViewById(R.id.appListView);

        initItemListArray();
        MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(getContext(), itemList);

        appListView.setAdapter(mainFragmentAdapter);
        appListView.setOnItemClickListener(appListOnItemClickListener);
    }

    private void initItemListArray(){
        initTitleListArray();
        initSubtitleListArray();
        initScreenListArray();
        itemList = new ArrayList<>();
        for (int i=0; i<titleList.size(); i++) {
            MainFragmentItemData item = new MainFragmentItemData(screenList.get(i), titleList.get(i),
                    subtitleList.get(i));
            itemList.add(item);
        }
    }

    private void initScreenListArray(){
        screenList = new ArrayList<>();
        screenList.add(ContextCompat.getDrawable(view.getContext(), R.drawable.fragment_main_health_monitoring_system_screen));
        screenList.add(ContextCompat.getDrawable(view.getContext(), R.drawable.fragment_main_notebook_screen));
        screenList.add(ContextCompat.getDrawable(view.getContext(), R.drawable.fragment_main_splash_screen_screen));
        screenList.add(ContextCompat.getDrawable(view.getContext(), R.drawable.fragment_main_universal_input_form_screen));
        screenList.add(ContextCompat.getDrawable(view.getContext(), R.drawable.fragment_main_infinite_activity_loop_screen));
        screenList.add(ContextCompat.getDrawable(view.getContext(), R.drawable.fragment_main_radiobutton_by_checkboxes_screen));
        screenList.add(ContextCompat.getDrawable(view.getContext(), R.drawable.fragment_main_countrise_cities_streets_screen));
        screenList.add(ContextCompat.getDrawable(view.getContext(), R.drawable.fragment_main_task_time_limits_screen));
    }

    private void initTitleListArray(){
        titleList = new ArrayList<>();
        titleList.add(getString(R.string.complex_health_monitoring_system_title));
        titleList.add(getString(R.string.notebook_title));
        titleList.add(getString(R.string.splash_screen_title));
        titleList.add(getString(R.string.universal_input_form_title));
        titleList.add(getString(R.string.infinite_activity_loop_title));
        titleList.add(getString(R.string.radio_button_by_checkboxes_title));
        titleList.add(getString(R.string.countries_cities_streets_title));
        titleList.add(getString(R.string.task_time_limits_title));
    }

    private void initSubtitleListArray(){
        subtitleList = Arrays.asList(getResources().getStringArray(R.array.subtitle));
    }
}
