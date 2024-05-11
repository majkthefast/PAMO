package com.example.bmicalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingListActivity extends AppCompatActivity {
    private ArrayList<ShoppingItem> shoppingItems;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        RecyclerView recyclerView = findViewById(R.id.shoppingListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ShoppingItem> shoppingItems = getIntent().getParcelableArrayListExtra("shoppingItems");
        if (shoppingItems == null) {
            shoppingItems = new ArrayList<>();
            // Możesz dodać komunikat lub logowanie w przypadku braku danych
            Log.e("ShoppingListActivity", "Brak składników przekazanych do aktywności");
        }

        ShoppingListAdapter adapter = new ShoppingListAdapter(shoppingItems);
        recyclerView.setAdapter(adapter);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ShoppingListActivity.this, RecipeActivity.class);
            startActivity(intent);
        });
    }


    public ArrayList<ShoppingItem> loadShoppingItems() {
        String json = sharedPreferences.getString("items", "");
        if (!json.isEmpty()) {
            Gson gson = new Gson();
            ShoppingItem[] itemsArray = gson.fromJson(json, ShoppingItem[].class);
            return new ArrayList<>(Arrays.asList(itemsArray));
        }
        return new ArrayList<>();
    }
    public void saveShoppingItems(ArrayList<ShoppingItem> items) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(items);
        editor.putString("items", json);
        editor.apply();
        Toast.makeText(this, "Lista zakupów zaktualizowana!", Toast.LENGTH_SHORT).show();
    }
}
