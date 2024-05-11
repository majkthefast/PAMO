package com.example.bmicalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe {
    private String name;
    private String description;
    private String ingredients;
    private String instructions;

    public Recipe(String name, String description, String ingredients, String instructions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Gettery
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getIngredients() {
        // Rozbijamy linie i omijamy pierwszą linię ("Składniki:")
        List<String> allLines = Arrays.asList(ingredients.split("\n"));
        if (allLines.size() > 1) {
            // Pomijamy pierwszy element i przekształcamy resztę na ArrayList
            return new ArrayList<>(allLines.subList(1, allLines.size()));
        }
        return new ArrayList<>();
    }

    public String getInstructions() {
        return instructions;
    }

}
