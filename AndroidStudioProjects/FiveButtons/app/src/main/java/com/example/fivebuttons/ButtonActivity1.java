package com.example.fivebuttons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fivebuttons.databinding.ActivityButton1Binding;
import com.example.fivebuttons.databinding.ActivityButton2Binding;

public class ButtonActivity1 extends AppCompatActivity {
    private ActivityButton1Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityButton1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button btn = binding.backButton;
        btn.setOnClickListener(new MyListener());
    }


    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(final View v) {
            Intent i = new Intent(ButtonActivity1.this, MainActivity.class);


            Bundle extraInfo = new Bundle();
            extraInfo.putString("Encrypted Message: ", "named inner class approach");
            i.putExtras(extraInfo);

            startActivity(i);
        }
    }
}
