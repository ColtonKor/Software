package com.example.geoquiz;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.geoquiz.databinding.ActivityTriviaManageBinding;

import java.util.List;

public class TriviaManageActivity extends AppCompatActivity {

    private TriviaDatabase db;
    private ActivityTriviaManageBinding binding;
    private List<Question> triviaList;
    private ListView triviaListView;
    private ArrayAdapter<Question> triviaAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTriviaManageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = TriviaDatabase.getInstance(this);
        triviaListView = binding.triviaList;
        triviaList = db.question().getAll();
        triviaAdapter = new ArrayAdapter<>(this, R.layout.item_question, R.id.question_item, triviaList);
        triviaListView.setAdapter(triviaAdapter);
    }
}
