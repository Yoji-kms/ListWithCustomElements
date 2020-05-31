package com.yoji.listwithcustomelements.health_monitoring_system.recording_data_activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.yoji.listwithcustomelements.R;

public class BloodPressureAndLifeDataFragmentAdapter extends FragmentPagerAdapter {

    private static final int[] TAB_TITLES = new int[]{R.string.recording_blood_pressure_data, R.string.recording_lifedata};
    private final BloodPressureAndLifeDataFragment context;

    BloodPressureAndLifeDataFragmentAdapter(BloodPressureAndLifeDataFragment context, @NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.context = context;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment returningFragment;
        switch (position) {
            case 0:
                returningFragment = RecordingBloodPressureDataFragment.newInstance();
                break;
            case 1:
                returningFragment = RecordingLifedataFragment.newInstance();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return returningFragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
