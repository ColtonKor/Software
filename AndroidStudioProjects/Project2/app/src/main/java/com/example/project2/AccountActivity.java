package com.example.project2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.project2.databinding.ActivityAccountBinding;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {
    EditText myPassword;
    EditText myUsername;
    private int attempts = 0;
    private ActivityAccountBinding binding;
    private LibraryDatabase db;
    private List<User> userData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myUsername = findViewById(R.id.Username);
        myPassword = findViewById(R.id.Password);

        Button back = binding.back;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = myPassword.getText().toString();
                String user = myUsername.getText().toString();
                db = LibraryDatabase.getInstance(AccountActivity.this);
                userData = db.user().getAll();
                for (int j = 0; j < userData.size(); j++) {
                    if(user.equals(userData.get(j).getUsername())){
                        attempts++;
                        if(attempts == 2){
                            Toast.makeText(AccountActivity.this, "Error! Too Many Attempts!", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(AccountActivity.this, MainActivity.class);
                            startActivity(i);
                            return;
                        } else {
                            Toast.makeText(AccountActivity.this, "Error! Username Already in Use!", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                }
                if(user.isEmpty() || pass.isEmpty()){
                    attempts++;
                    if(attempts == 2){
                        Toast.makeText(AccountActivity.this, "Error! Too Many Attempts!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(AccountActivity.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(AccountActivity.this, "Error! Username or Password are Empty!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    db = LibraryDatabase.getInstance(AccountActivity.this);
                    User myUser = new User(user, pass);
                    db.user().addUser(myUser);
                    db.transaction().addTransaction(new Transaction("New Account: Username ", user));
                    Toast.makeText(AccountActivity.this, "Creating Account", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(AccountActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
