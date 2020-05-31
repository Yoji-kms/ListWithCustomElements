package com.yoji.listwithcustomelements;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class CountriesCitiesStreetsMainFragment extends Fragment {

    private Spinner countriesSpinner;
    private Spinner citiesSpinner;
    private Spinner housesSpinner;
    private View view;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_countries_cities_streets, container, false);
        context = getContext();

        initViews();
        initCountriesSpinnerAdapter();
        initHouseNumberSpinnerAdapter();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initViews() {
        countriesSpinner = view.findViewById(R.id.countriesSpinnerId);
        citiesSpinner = view.findViewById(R.id.citiesSpinnerId);
        housesSpinner = view.findViewById(R.id.housesSpinnerId);
        Button okButton = view.findViewById(R.id.okButtonId);

        okButton.setOnClickListener(onClickListener);
    }

    private void initCountriesSpinnerAdapter() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countriesSpinner.setAdapter(adapter);

        countriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getResources().getStringArray(R.array.countries);
                initCitiesSpinnerAdapter(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initCitiesSpinnerAdapter(int countryIndex) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (countryIndex) {
            case 0:
                adapter = ArrayAdapter.createFromResource(context, R.array.russian_cities, android.R.layout.simple_spinner_item);
                break;
            case 1:
                adapter = ArrayAdapter.createFromResource(context, R.array.ukrainian_cities, android.R.layout.simple_spinner_item);
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(context, R.array.belorussian_cities, android.R.layout.simple_spinner_item);
                break;
        }
        if (adapter != null){
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            citiesSpinner.setAdapter(adapter);
        }
    }

    private void initHouseNumberSpinnerAdapter() {
        Integer[] houseNumbers = new Integer[50];
        for (int i = 0; i < 50; i++) {
            houseNumbers[i] = i + 1;
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, houseNumbers);
        housesSpinner.setAdapter(adapter);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String toastMessage = getString(R.string.toast_message_countries_cities_streets, countriesSpinner.getSelectedItem().toString(),
                    citiesSpinner.getSelectedItem().toString(), housesSpinner.getSelectedItem().toString());
            Toast.makeText(getActivity(), toastMessage, Toast.LENGTH_LONG).show();
        }
    };
}
