package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.databinding.ActivityHoldBinding;

import java.util.List;

public class HoldActivity extends AppCompatActivity {
    EditText myPassword;
    EditText myUsername;
    private int attempts = 0;
    private ActivityHoldBinding binding;
    private LibraryDatabase db;
    private List<User> userData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHoldBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myUsername = findViewById(R.id.Username);
        myPassword = findViewById(R.id.Password);

        Button back = binding.back;





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = myPassword.getText().toString();
                String user = myUsername.getText().toString();
                db = LibraryDatabase.getInstance(HoldActivity.this);
                userData = db.user().getAll();

                for (int j = 0; j < userData.size(); j++) {
                    if(user.equals(userData.get(j).getUsername())&&pass.equals(userData.get(j).getPassword())){
                        Intent i = new Intent(HoldActivity.this, HoldingActivity.class);
                        Bundle extraInfo = new Bundle();
                        extraInfo.putString("Username", user);
                        extraInfo.putString("Password", pass);
                        i.putExtras(extraInfo);
                        startActivity(i);
                        return;
                    }
                }

                if (user.equals("") || pass.equals("")) {
                    attempts++;
                    if (attempts == 2) {
                        Toast.makeText(HoldActivity.this, "Error! Too Many Attempts!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(HoldActivity.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(HoldActivity.this, "Username or Password are Empty!", Toast.LENGTH_LONG).show();
                        return;
                    }
                } else {
                    attempts++;
                    if (attempts == 2) {
                        Toast.makeText(HoldActivity.this, "Error! Too Many Attempts!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(HoldActivity.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(HoldActivity.this, "Error! Not an Account!", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
            }
        });
    }
}
