package com.example.ctof;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText celsiusInput;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsiusInput = findViewById(R.id.editTextText);
        resultText = findViewById(R.id.resultid);

        Button calculateButton = findViewById(R.id.button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCelsiusToFahrenheit();
            }
        });
    }

    private void convertCelsiusToFahrenheit() {
        String celsiusString = celsiusInput.getText().toString();

        if (!celsiusString.isEmpty()) {
            double celsius = Double.parseDouble(celsiusString);
            double fahrenheit = (celsius * 9/5) + 32;
            resultText.setText(String.format("%.2f °F", fahrenheit));
        } else {
            resultText.setText("Please enter a valid temperature in Celsius.");
        }
    }
}
