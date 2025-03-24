package com.example.fivebuttons;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fivebuttons.databinding.ActivityButton2Binding;


public class ButtonActivity2 extends AppCompatActivity {

    private ActivityButton2Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityButton2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button btn = binding.backButton;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ButtonActivity2.this, MainActivity.class);


                Bundle extraInfo = new Bundle();
                extraInfo.putString("Encrypted Message: ", "anonymous inner class approach");
                i.putExtras(extraInfo);

                startActivity(i);
//                if (view.getId() == R.id.back_button) {
//                    finish();
//                }
            }
        });
    }
}
