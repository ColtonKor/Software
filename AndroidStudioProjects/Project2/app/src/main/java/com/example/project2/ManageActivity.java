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

import com.example.project2.databinding.ActivityManageBinding;

public class ManageActivity extends AppCompatActivity {
    EditText myPassword;
    EditText myUsername;
    private int attempts = 0;
    private ActivityManageBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityManageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myUsername = findViewById(R.id.Username);
        myPassword = findViewById(R.id.Password);

        Button back = binding.back;

        String passedString = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            passedString = extras.getString("transaction");
        }


        String finalPassedString = passedString;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = myPassword.getText().toString();
                String user = myUsername.getText().toString();
                if (user.equals("!admin2") && pass.equals("!admin2")){
                    Intent i = new Intent(ManageActivity.this, AdminActivity.class);
                    Bundle extraInfo = new Bundle();
                    extraInfo.putString("transaction", finalPassedString);
                    i.putExtras(extraInfo);
                    startActivity(i);
                } else if (user.equals("") || pass.equals("")){
                    attempts++;
                    if(attempts == 2){
                        Toast.makeText(ManageActivity.this, "Error! Too Many Attempts!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(ManageActivity.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(ManageActivity.this, "Error! Username or Password are Empty!", Toast.LENGTH_LONG).show();
                        return;
                    }
                } else {
                    attempts++;
                    if(attempts == 2){
                        Toast.makeText(ManageActivity.this, "Error! Too Many Attempts!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(ManageActivity.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(ManageActivity.this, "Error! Not and Authorized Account!", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
            }
        });
    }
}
