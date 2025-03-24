package com.example.fivebuttons;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fivebuttons.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    TextView Encrypt;
    private ActivityMainBinding binding;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button btn1 = binding.ButtonC;
        Button btn2 = binding.ButtonA;
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.ButtonA) {
                    Intent i = new Intent(MainActivity.this, ButtonActivity2.class);
                    startActivity(i);
                }
            }
        });
        btn1.setOnClickListener(new MyListener());

        Encrypt = findViewById(R.id.about_Result);

        String passedString = "";
        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            passedString = extras.getString("Encrypted Message: ");
        }

        Encrypt.setText(String.format(passedString));
    }

    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(final View v) {
            Intent i = new Intent(MainActivity.this, ButtonActivity1.class);
            startActivity(i);
        }
    }
}
