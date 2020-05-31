package com.yoji.listwithcustomelements;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class NotebookMainFragment extends Fragment {

    private EditText noteEditTxt;
    private Button saveNoteBtn;

    private View view;

    private SharedPreferences savedNoteShapedPrefs;
    private static String NOTE_TXT = "note_txt";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_notebook, container, false);

        initViews();
        getDataFromSharedPrefs();
        return view;
    }

    private void initViews(){
        noteEditTxt = view.findViewById(R.id.noteEditTxtId);
        saveNoteBtn = view.findViewById(R.id.saveNoteBtnId);
        savedNoteShapedPrefs = Objects.requireNonNull(this.getActivity()).getSharedPreferences("Saved Note", MODE_PRIVATE);

        saveNoteBtn.setOnClickListener(saveNoteOnClickListener);
        noteEditTxt.addTextChangedListener(noteTextWatcher);
    }

    private View.OnClickListener saveNoteOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = savedNoteShapedPrefs.edit();
            String savedNoteTxt = noteEditTxt.getText().toString().trim();
            editor.putString(NOTE_TXT, savedNoteTxt);
            editor.apply();
            Toast.makeText(getActivity(), R.string.data_saved, Toast.LENGTH_LONG).show();
        }
    };

    private TextWatcher noteTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String noteTxt = noteEditTxt.getText().toString();
            saveNoteBtn.setEnabled(!noteTxt.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private void getDataFromSharedPrefs(){
        String savedNoteTxt = savedNoteShapedPrefs.getString(NOTE_TXT, "");
        noteEditTxt.setText(savedNoteTxt);
    }
}
