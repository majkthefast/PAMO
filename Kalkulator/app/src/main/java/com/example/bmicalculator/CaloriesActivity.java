package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CaloriesActivity extends AppCompatActivity {

    private EditText weightInput, heightInput, ageInput;
    private RadioButton maleButton, femaleButton;
    private TextView caloriesResult;
    private double extractPalValue(String palString) {
        try {
            String numberPart = palString.substring(palString.lastIndexOf("-") + 1).trim();
            return Double.parseDouble(numberPart);
        } catch (Exception e) {
            Log.e("extractPalValue", "Failed to extract PAL value", e);
            return 1.2; // Domyślna wartość w przypadku błędu
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        weightInput = findViewById(R.id.weightInputCalories);
        heightInput = findViewById(R.id.heightInputCalories);
        ageInput = findViewById(R.id.ageInput);
        maleButton = findViewById(R.id.radioMale);
        femaleButton = findViewById(R.id.radioFemale);
        caloriesResult = findViewById(R.id.caloriesResult);

        findViewById(R.id.calculateCaloriesButton).setOnClickListener(v -> calculateCalories());

        Spinner palSpinner = findViewById(R.id.palSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pal_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        palSpinner.setAdapter(adapter);


        Button goToBmiCalculatorButton = findViewById(R.id.goToBmiCalculatorButton);
        goToBmiCalculatorButton.setOnClickListener(v -> {
            Intent intent = new Intent(CaloriesActivity.this, MainActivity.class);
            startActivity(intent);
        });
        Button goToRecipesButton = findViewById(R.id.goToRecipesButton);
        goToRecipesButton.setOnClickListener(v -> {
            Intent intent = new Intent(CaloriesActivity.this, RecipeActivity.class);
            startActivity(intent);
        });
    }


    private void calculateCalories() {
        double weight = Double.parseDouble(weightInput.getText().toString());
        double height = Double.parseDouble(heightInput.getText().toString());
        int age = Integer.parseInt(ageInput.getText().toString());
        double BMR;

        if (maleButton.isChecked()) {
            BMR = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else if (femaleButton.isChecked()) {
            BMR = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        } else {
            caloriesResult.setText("Wybierz płeć");
            return;
        }

        // Odczytanie wybranej opcji z spinnera
        String selectedPalString = ((Spinner) findViewById(R.id.palSpinner)).getSelectedItem().toString();
        // Ekstrakcja wartości liczbowej współczynnika PAL
        double palValue = extractPalValue(selectedPalString);

        double TDEE = BMR * palValue;


        caloriesResult.setText(String.format("Zapotrzebowanie kaloryczne: %.2f kcal", TDEE));
    }
}
