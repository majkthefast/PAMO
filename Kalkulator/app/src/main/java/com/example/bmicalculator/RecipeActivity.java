package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Button goToBmiCalculatorButton = findViewById(R.id.goToBmiCalculatorButton);
        goToBmiCalculatorButton.setOnClickListener(v -> {
            Intent intent = new Intent(RecipeActivity.this, MainActivity.class);
            startActivity(intent);
        });
        Button goToCaloriesCalculatorButton = findViewById(R.id.goToCaloriesCalculatorButton);
        goToCaloriesCalculatorButton.setOnClickListener(v -> {
            Intent intent = new Intent(RecipeActivity.this, CaloriesActivity.class);
            startActivity(intent);
        });

        final ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe(
                "Sałatka grecka",
                "Klasyczna sałatka grecka.",
                "Składniki:\n- pomidory\n- ogórek\n- cebula\n- oliwki\n- ser feta\n- oliwa z oliwek",
                "Sposób przygotowania:\n1. Pokrój warzywa.\n2. Wymieszaj składniki.\n3. Dodaj oliwę i ser feta na wierzch."));

        recipes.add(new Recipe(
                "Smoothie owocowe",
                "Orzeźwiający napój owocowy.",
                "Składniki:\n- banan\n- truskawki\n- jogurt naturalny\n- miód",
                "Sposób przygotowania:\n1. Wszystkie składniki umieść w blenderze.\n2. Blenduj do uzyskania gładkiej konsystencji."));
        recipes.add(new Recipe(
                "Kanapka z awokado",
                "Pyszna kanapka z awokado.",
                "Składniki:\n- chleb\n- awokado\n- pomidor\n- jajko\n- szczypiorek",
                "Sposób przygotowania:\n1. Ugotuj jajko na twardo.\n2. Awokado rozgnieć widelcem.\n3. Na chlebie ułóż pokrojone warzywa i jajko."));
        recipes.add(new Recipe(
                "Pasta z ciecierzycy",
                "Pasta z ciecierzycy z dodatkiem przypraw.",
                "Składniki:\n- ciecierzyca\n- tahini\n- czosnek\n- sok z cytryny\n- oliwa z oliwek",
                "Sposób przygotowania:\n1. Wszystkie składniki umieść w blenderze.\n2. Blenduj do uzyskania gładkiej konsystencji."));
        recipes.add(new Recipe(
                "Kurczak z warzywami",
                "Danie obiadowe z kurczakiem.",
                "Składniki:\n- filet z kurczaka\n- marchew\n- groszek\n- cebula\n- papryka\n- przyprawy",
                "Sposób przygotowania:\n1. Pokrój warzywa i kurczaka.\n2. Podsmaż na patelni.\n3. Dopraw do smaku."));

        ListView listView = findViewById(R.id.recipeListView);
        ArrayAdapter<Recipe> adapter = new ArrayAdapter<Recipe>(this, android.R.layout.simple_list_item_1, recipes) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                }
                TextView textView = convertView.findViewById(android.R.id.text1);
                textView.setText(Objects.requireNonNull(getItem(position)).getName());
                return convertView;
            }
        };
        listView.setAdapter(adapter);

        Button viewShoppingListButton = findViewById(R.id.viewIngredientsButton);
        viewShoppingListButton.setOnClickListener(v -> {
            Intent intent = new Intent(RecipeActivity.this, ShoppingListActivity.class);
            startActivity(intent);
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Recipe recipe = recipes.get(position);
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(RecipeActivity.this);
            dialogBuilder.setTitle(recipe.getName());
            dialogBuilder.setMessage(recipe.getDescription() + "\n\n" + recipe.getIngredients() + "\n\n" + recipe.getInstructions());
            dialogBuilder.setPositiveButton("OK", null);
            dialogBuilder.setNegativeButton("Dodaj składniki do listy", (dialog, which) -> {
                ArrayList<ShoppingItem> items = new ArrayList<>();
                for (String ingredient : recipe.getIngredients()) {
                    items.add(new ShoppingItem(ingredient));
                }
                Intent intent = new Intent(RecipeActivity.this, ShoppingListActivity.class);
                intent.putParcelableArrayListExtra("shoppingItems", items);
                startActivity(intent);
            });
            dialogBuilder.show();
        });


    }
}
