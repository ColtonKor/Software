package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.project2.databinding.ActivityMainBinding;
import com.example.project2.databinding.ActivityStockBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private LibraryDatabase db;
    private List<Book> bookList;
    private List<User> userList;
    private List<Transaction> transactionList;

    private static int attempts = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(attempts == 0){
            db = LibraryDatabase.getInstance(this);
            bookList = db.book().getAll();
            userList = db.user().getAll();
            transactionList = db.transaction().getAll();
            for (int i = 0; i < bookList.size(); i++) {
                db.book().delete(bookList.get(i));
            }
            for (int i = 0; i < userList.size(); i++) {
                db.user().delete(userList.get(i));
            }
            for (int i = 0; i < transactionList.size(); i++) {
                db.transaction().delete(transactionList.get(i));
            }
            db.populateInitialData();
        }

        attempts++;

        Button btn1 = binding.create;
        Button btn2 = binding.place;
        Button btn3 = binding.manage;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HoldActivity.class);
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ManageActivity.class);
                startActivity(i);
            }
        });
    }
}
