package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.databinding.ActivityAdminBinding;

import java.util.List;

public class AdminActivity extends AppCompatActivity {
    private ActivityAdminBinding binding;
    private LibraryDatabase db;
    private List<Transaction> transactionList;
//    TextView transaction;
    private ListView transactionListView;
    private ArrayAdapter<Transaction> bookAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = LibraryDatabase.getInstance(AdminActivity.this);
        transactionListView = binding.TranList;
        transactionList = db.transaction().getAll();
        if(transactionList.isEmpty()){
            transactionList.add(new Transaction("There has been no ", "Transactions yet!"));
        }
        bookAdapter = new ArrayAdapter<>(this, R.layout.item_book, R.id.book_item, transactionList);
        transactionListView.setAdapter(bookAdapter);

        Button btn1 = binding.OK;
        Button btn2 = binding.NOTOK;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, LogActivity.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
