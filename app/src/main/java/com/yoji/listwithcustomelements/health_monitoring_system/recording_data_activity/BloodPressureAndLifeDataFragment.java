package com.yoji.listwithcustomelements.health_monitoring_system.recording_data_activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.yoji.listwithcustomelements.R;

public class BloodPressureAndLifeDataFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blood_pressure_and_life_data, container, false);

        BloodPressureAndLifeDataFragmentAdapter fragmentAdapter = new BloodPressureAndLifeDataFragmentAdapter(this, getChildFragmentManager(), 0);
        ViewPager viewPager = view.findViewById(R.id.swipeViewPagerId);
        viewPager.setAdapter(fragmentAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tabLayoutId);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
