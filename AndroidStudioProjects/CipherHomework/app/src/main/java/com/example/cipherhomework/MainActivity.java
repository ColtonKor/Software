package com.example.cipherhomework;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cipherhomework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    EditText Secret;
    EditText Key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Secret = findViewById(R.id.cinput_Text);
        Key = findViewById(R.id.cinput_Key);

        Button calculateButton = binding.calculateButton;
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                EncryptMessage();
                Log.d("MAIN", "about button clicked");
                Intent i = new Intent(MainActivity.this, ResultActivity.class);


                Bundle extraInfo = new Bundle();
                extraInfo.putString("Encrypted Message: ", EncryptMessage());
                i.putExtras(extraInfo);

                startActivity(i);
            }
        });
    }

    private String EncryptMessage(){
        String Run = Secret.getText().toString();
        String Bring = Key.getText().toString();
        char[] encryption = new char[Run.length()];
        int size = 0;
        int Overflow = 0;
        int Character;
        for (int i = 0; i < Run.length(); i++) {
            if(Bring.charAt(size) > 96 && Bring.charAt(size) < 123){
                Character = Bring.charAt(size) - 97;
            } else if (Bring.charAt(size) > 64 && Bring.charAt(size) < 91) {
                Character = Bring.charAt(size) - 65;
            } else {
                size = (size + 1) % Bring.length();
                i--;
                continue;
            }
            if(Run.charAt(i) > 96 && Run.charAt(i) < 123){
                if((Run.charAt(i)) + Character > 122){
                    Overflow = (Run.charAt(i)) + Character;
                    Overflow = Overflow - 122;
                    Overflow = Overflow + 96;
                    encryption[i] = (char) Overflow;
                    size = (size + 1) % Bring.length();
                } else {
                    encryption[i] = (char) ((Run.charAt(i)) + Character);
                    size = (size + 1) % Bring.length();
                }
            } else if ((Run.charAt(i) > 64 && Run.charAt(i) < 91)){
                if((Run.charAt(i)) + Character > 90){
                    Overflow = (Run.charAt(i)) + Character;
                    Overflow = Overflow - 90;
                    Overflow = Overflow + 64;
                    encryption[i] = (char) Overflow;
                    size = (size + 1) % Bring.length();
                } else {
                    encryption[i] = (char) ((Run.charAt(i)) + Character);
                    size = (size + 1) % Bring.length();
                }
            } else {
                encryption[i] = Run.charAt(i);
            }
        }
        String EM = new String(encryption);
        return EM;
    }
}