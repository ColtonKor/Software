package com.example.geoquiz;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.geoquiz.databinding.DialogAddTriviaBinding;

public class EditTriviaDialog extends DialogFragment {
    private DialogAddTriviaBinding binding;
    private RadioGroup radioGroup;

    private TriviaDatabase db;

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        binding = DialogAddTriviaBinding.inflate(LayoutInflater.from(getContext()));
        db = TriviaDatabase.getInstance(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(binding.getRoot())
                .setTitle("Add A Question")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String myq = String.valueOf(binding.qText.getText());
                        String myg = String.valueOf(binding.qGenre.getText());
                        radioGroup = binding.radioGroup;
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        boolean myBool = false;
                        switch (radioGroup.getCheckedRadioButtonId()) {
                            case R.id.answer_false:
                                myBool = false;
                                break;
                            case R.id.answer_true:
                                myBool = true;
                                break;
                        }
                        Question myQuestion = new Question(myq, myBool, myg);
                        db.question().addQuestion(myQuestion);
                    }
                    // ...
                })
                .setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
        return builder.create();
    }
}
