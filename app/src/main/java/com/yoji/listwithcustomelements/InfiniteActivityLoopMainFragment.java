package com.yoji.listwithcustomelements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;

public class InfiniteActivityLoopMainFragment extends Fragment {

    private View view;
    private TextView messageTxtView;
    private FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_infinite_activity_loop, container, false);

        init();
        formMessageWithRandomNumber();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private void init() {
        messageTxtView = view.findViewById(R.id.messageTextViewID);
        Button prevBtn = view.findViewById(R.id.previousButtonID);
        Button nextBtn = view.findViewById(R.id.nextButtonID);
        fragmentManager = getFragmentManager();

        nextBtn.setOnClickListener(nextBtnOnClickListener);
        prevBtn.setOnClickListener(prevBtnOnClickListener);
    }

    private View.OnClickListener prevBtnOnClickListener = v -> fragmentManager.popBackStack();


    private View.OnClickListener nextBtnOnClickListener = v -> {
        InfiniteActivityLoopMainFragment fragment = new InfiniteActivityLoopMainFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(this);
        fragmentTransaction.add(R.id.appBarLayoutId, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    };

    private void formMessageWithRandomNumber(){
        Random random = new Random();
        String messageTxt = getString(R.string.message, (random.nextInt(100) + 1));
        messageTxtView.setText(messageTxt);
    }
}