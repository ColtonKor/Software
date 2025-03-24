package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.databinding.ActivityStockBinding;

import java.util.ArrayList;
import java.util.List;


public class StockActivity extends AppCompatActivity {
    private LibraryDatabase db;
    private List<Book> bookList;
    private List<Book> temp = new ArrayList();
    private Book test;
    private ListView bookListView;
    private ArrayAdapter<Book> bookAdapter;
    private ActivityStockBinding binding;
    private int attempts = 0;
    EditText myTitle;
    EditText myAuthor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStockBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button btn = binding.confirm;
        myTitle = findViewById(R.id.title);
        myAuthor = findViewById(R.id.author);

        db = LibraryDatabase.getInstance(StockActivity.this);
        bookListView = binding.bookList;
        bookList = db.book().getAll();


        String passedString = "";
        String passedUser = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            passedString = extras.getString("Genre");
            passedUser = extras.getString("Username");
        }
        for (int i = 0; i < bookList.size(); i++) {
            if (passedString.equals(bookList.get(i).getGenre())) {
                if(checkRepeat(temp, bookList.get(i))){
                    temp.add(bookList.get(i));
                }
            }
        }
        if(temp.isEmpty()){
            test = new Book("Currently no \"" + passedString, "\" books", "Enter any input to Continue");
            temp.add(test);
        }
        bookAdapter = new ArrayAdapter<>(this, R.layout.item_book, R.id.book_item, temp);
        bookListView.setAdapter(bookAdapter);

        String finalPassedString = passedString;
        String finalPassedUser = passedUser;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempts++;
                String first = myTitle.getText().toString();
                String second = myAuthor.getText().toString();
                if(temp.contains(test)){
                    Toast.makeText(StockActivity.this, "No Books Returning to Start!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(StockActivity.this, MainActivity.class);
                    startActivity(i);
                    return;
                }
                if(first.equals("") || second.equals("")){
                    if(attempts == 2){
                        Toast.makeText(StockActivity.this, "Error! Too Many Attempts!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(StockActivity.this, MainActivity.class);
                        startActivity(i);
                        return;
                    } else {
                        Toast.makeText(StockActivity.this, "Error! Title or Author are Empty!", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                if(!checkValid(second, first)){
                    if (attempts == 2){
                        Toast.makeText(StockActivity.this, "Error! Too Many Attempts!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(StockActivity.this, MainActivity.class);
                        startActivity(i);
                        return;
                    } else {
                        Toast.makeText(StockActivity.this, "Error! Title or Author not Valid!", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
//                holdBook(temp, first, second);
                for (int i = 0; i < bookList.size(); i++) {
                    if(bookList.get(i).getAuthor().equals(second) && bookList.get(i).getTitle().equals(first)){
                        db.book().delete(bookList.get(i));
                    }
                }
                int reservation = 0;
                for (int i = 0; i < bookList.size(); i++) {
                    if(bookList.get(i).getAuthor().equals(second) && bookList.get(i).getTitle().equals(first)){
                        reservation = bookList.get(i).getId();
                    }
                }
                db.transaction().addTransaction(new Transaction(" - Hold Book: ", first + " by " + second + " \"" + finalPassedString
                        + "\"\n- Account Username: " + finalPassedUser));
                Toast.makeText(StockActivity.this, finalPassedUser +" "+ first + " " + reservation, Toast.LENGTH_LONG).show();
                Intent i = new Intent(StockActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }

    public Boolean checkRepeat(List<Book> newList, Book old){
        for (int i = 0; i < newList.size(); i++) {
            if(old.getAuthor().equals(newList.get(i).getAuthor()) &&
                    old.getTitle().equals(newList.get(i).getTitle())){
                return false;
            }
        }
        return true;
    }

    public Boolean checkValid(String A, String T){
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getAuthor().equals(A) && temp.get(i).getTitle().equals(T)){
                return true;
            }
        }
        return false;
    }

//    public void holdBook(List<Book> hold, String name, String prof){
//        for (int i = 0; i < bookList.size(); i++) {
//            if(bookList.get(i).getAuthor().equals(name) && bookList.get(i).getTitle().equals(prof)){
//                db.book().delete(bookList.get(i));
////                hold.remove(hold.get(i));
//            }
//        }
//    }
}
