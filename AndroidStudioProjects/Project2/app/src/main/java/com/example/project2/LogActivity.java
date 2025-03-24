package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.databinding.ActivityLogBinding;


public class LogActivity extends AppCompatActivity {
    private ActivityLogBinding binding;
    private LibraryDatabase db;
    private int attempts = 0;
    EditText myTitle;
    EditText myAuthor;
    EditText myGenre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myTitle = findViewById(R.id.Title);
        myAuthor = findViewById(R.id.Author);
        myGenre = findViewById(R.id.Genre);

        Button btn = binding.back;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = myTitle.getText().toString();
                String a = myAuthor.getText().toString();
                String g = myGenre.getText().toString();
                if(t.isEmpty() || a.isEmpty() || g.isEmpty()){
                    attempts++;
                    if(attempts == 2){
                        Toast.makeText(LogActivity.this, "Error! Too Many Failed Attempts", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(LogActivity.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(LogActivity.this, "Error! Username/Password/Genre are Empty!", Toast.LENGTH_LONG).show();
                        return;
                    }
                } else {
                    db = LibraryDatabase.getInstance(LogActivity.this);
                    Book myBook = new Book(t, a, g);
                    db.book().addBook(myBook);
                    Intent i = new Intent(LogActivity.this, MainActivity.class);
                    startActivity(i);
                }

            }
        });
    }

}
