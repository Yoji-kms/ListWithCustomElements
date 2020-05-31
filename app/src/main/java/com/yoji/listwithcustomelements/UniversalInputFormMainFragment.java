package com.yoji.listwithcustomelements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UniversalInputFormMainFragment extends Fragment {
    private View view;
    private TextView subscriptionConfirmationTxt;
    private EditText userNameEdtTxt;
    private EditText emailEdtTxt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_universal_input_form, container, false);

        initViews();

        return view;
    }

    private void initViews(){
        Button okBtn = view.findViewById(R.id.buttonOkID);
        Button clearBtn = view.findViewById(R.id.buttonClearID);
        subscriptionConfirmationTxt = view.findViewById(R.id.subscriptionConfirmationTextID);
        userNameEdtTxt = view.findViewById(R.id.userNameEditTextID);
        emailEdtTxt = view.findViewById(R.id.emailEditTextID);

        okBtn.setOnClickListener(okBtnOnClickListener);
        clearBtn.setOnClickListener(clearBtnOnClickListener);
    }

    private View.OnClickListener okBtnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String userName = userNameEdtTxt.getText().toString();
            String email = emailEdtTxt.getText().toString();
            String confirmationMessage = getString
                    (R.string.subscription_confirmation_text, userName, email);
            subscriptionConfirmationTxt.setText(confirmationMessage);
            clearViews();
        }
    };

    private View.OnClickListener clearBtnOnClickListener = v -> clearViews();

    private void clearViews(){
        userNameEdtTxt.setText("");
        emailEdtTxt.setText("");
    }
}