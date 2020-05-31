package com.yoji.listwithcustomelements.health_monitoring_system;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.yoji.listwithcustomelements.R;
import com.yoji.listwithcustomelements.health_monitoring_system.RoomDB.UserData;
import com.yoji.listwithcustomelements.health_monitoring_system.RoomDB.UserRepository;
import com.yoji.listwithcustomelements.health_monitoring_system.recording_data_activity.BloodPressureAndLifeDataFragment;
import com.yoji.listwithcustomelements.health_monitoring_system.recording_data_activity.RecordingBloodPressureDataFragment;
import com.yoji.listwithcustomelements.health_monitoring_system.recording_data_activity.RecordingLifedataFragment;

import java.util.Objects;

public class HealthMonitoringSystemMainFragment extends Fragment {
    private View view;
    private Button saveButton;
    private EditText surnameEditText;
    private EditText nameEditText;
    private EditText secondNameEditText;
    private EditText ageEditText;

    private UserRepository userRepository;
    private String LOG_TAG = "Logs";

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String surname = surnameEditText.getText().toString().trim();
            String name = nameEditText.getText().toString().trim();
            String secondName = secondNameEditText.getText().toString().trim();
            String age = ageEditText.getText().toString().trim();

            saveButton.setEnabled(!surname.isEmpty() && !name.isEmpty()
                    && !secondName.isEmpty() && !age.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_health_monitoring_system, container, false);

        initViews();
        initDb();
        saveButtonAction();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initDb() {
        userRepository = new UserRepository(Objects.requireNonNull(getActivity()).getApplication());
    }

    private void initViews() {
        surnameEditText = view.findViewById(R.id.surnameEditTextId);
        nameEditText = view.findViewById(R.id.nameEditTextId);
        secondNameEditText = view.findViewById(R.id.seccondNameEditTextId);
        ageEditText = view.findViewById(R.id.ageEditTextId);

        surnameEditText.addTextChangedListener(textWatcher);
        nameEditText.addTextChangedListener(textWatcher);
        secondNameEditText.addTextChangedListener(textWatcher);
        ageEditText.addTextChangedListener(textWatcher);
    }

    private void saveButtonAction() {
        saveButton = view.findViewById(R.id.saveUserDataButtonId);

        saveButton.setOnClickListener(v -> {
            Log.i(LOG_TAG, "Нажата кнопка \"Сохранить\" на регистрационном экране");

            saveUserDataToDb();

            BloodPressureAndLifeDataFragment fragment = new BloodPressureAndLifeDataFragment();
            FragmentManager fragmentManager = getFragmentManager();
            assert fragmentManager != null;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.appBarLayoutId, fragment);
            fragmentTransaction.commit();


            logUserDataDb();
        });
    }

    private void saveUserDataToDb() {
        UserData userData = new UserData();
        String surname = surnameEditText.getText().toString().trim();
        String name = nameEditText.getText().toString().trim();
        String secondName = secondNameEditText.getText().toString().trim();
        String userName = name + " " + secondName + " " + surname;
        int age = Integer.parseInt(ageEditText.getText().toString().trim());
        userData.setUserName(userName);
        userData.setAge(age);
        long userId = userRepository.insertUserData(userData);
        RecordingBloodPressureDataFragment.setUserId(userId);
        RecordingLifedataFragment.setUserId(userId);

        Toast.makeText(getContext(), R.string.data_saved, Toast.LENGTH_SHORT).show();
    }

    private void logUserDataDb() {
        Log.d(LOG_TAG, "--- Rows in User Data table: ---");
        userRepository.getAllUsersData().observe(this, usersData -> {
            assert usersData != null;
            for (UserData user : usersData) {
                Log.d(LOG_TAG, "ID = " + user.getUserId() + "; name = " +
                        user.getUserName() + "; age = " + user.getAge());
            }
        });
    }
}
