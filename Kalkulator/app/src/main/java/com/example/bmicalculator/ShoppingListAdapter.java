package com.example.bmicalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {
    private ArrayList<ShoppingItem> shoppingItems;

    public ShoppingListAdapter(ArrayList<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShoppingItem item = shoppingItems.get(position);
        holder.checkBox.setText(item.getName());
        holder.checkBox.setChecked(item.isPurchased());
    }

    @Override
    public int getItemCount() {
        return shoppingItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        ViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.shoppingItemCheckbox);
        }
    }
}

