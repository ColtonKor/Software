package com.example.cipherhomework;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cipherhomework.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Encrypt;
    private ActivityResultBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Encrypt = findViewById(R.id.about_Result);

        String passedString = "";
        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            passedString = extras.getString("Encrypted Message: ");
        }

        Encrypt.setText(String.format(passedString));
        Button btn = binding.backButton;
        btn.setOnClickListener(ResultActivity.this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            finish();
        }
    }
}
