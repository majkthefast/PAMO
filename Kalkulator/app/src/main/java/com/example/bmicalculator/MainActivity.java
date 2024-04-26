package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weightInput, heightInput;
    Button calculateButton;
    TextView bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        bmiResult = findViewById(R.id.bmiResult);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float weight = Float.parseFloat(weightInput.getText().toString());
                    float height = Float.parseFloat(heightInput.getText().toString());  // Wzrost w centymetrach
                    float bmi = BmiCalculator.computeBMI(weight, height);
                    bmiResult.setText(String.format("Twoje BMI: %.2f", bmi));
                } catch (NumberFormatException e) {
                    bmiResult.setText("Proszę wprowadzić prawidłową masę i wzrost.");
                }
            }
        });
    }
}
