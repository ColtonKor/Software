package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.databinding.ActivityHoldingBinding;

import java.util.ArrayList;
import java.util.List;

public class HoldingActivity extends AppCompatActivity {
    private ActivityHoldingBinding binding;
    private String genre = "";
    private LibraryDatabase db;
    private List<Book> bookList;
    private List<Book> temp = new ArrayList();;
    private ListView bookListView;
    private ArrayAdapter<Book> bookAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHoldingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String passedUser = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            passedUser = extras.getString("Username");
        }

        Button btn1 = binding.CS;
        Button btn2 = binding.Fiction;
        Button btn3 = binding.Memoir;
        Button btn4 = binding.back;
        String finalPassedUser = passedUser;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genre = "Computer Science";
                Intent i = new Intent(HoldingActivity.this, StockActivity.class);
                Bundle extraInfo = new Bundle();
                extraInfo.putString("Genre", genre);
                extraInfo.putString("Username", finalPassedUser);
                i.putExtras(extraInfo);
                startActivity(i);
            }
        });
        String finalPassedUser2 = passedUser;
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genre = "Fiction";
                Intent i = new Intent(HoldingActivity.this, StockActivity.class);
                Bundle extraInfo = new Bundle();
                extraInfo.putString("Genre", genre);
                extraInfo.putString("Username", finalPassedUser2);
                i.putExtras(extraInfo);
                startActivity(i);
            }
        });
        String finalPassedUser1 = passedUser;
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genre = "Memoir";
                Intent i = new Intent(HoldingActivity.this, StockActivity.class);
                Bundle extraInfo = new Bundle();
                extraInfo.putString("Genre", genre);
                extraInfo.putString("Username", finalPassedUser1);
                i.putExtras(extraInfo);
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HoldingActivity.this, MainActivity.class);
                startActivity(i);
            }
        });




    }
}
