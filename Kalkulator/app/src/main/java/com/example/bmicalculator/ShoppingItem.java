package com.example.bmicalculator;

import android.os.Parcel;
import android.os.Parcelable;

public class ShoppingItem implements Parcelable {
    private String name;
    private boolean isPurchased;

    public ShoppingItem(String name) {
        this.name = name;
        this.isPurchased = false;
    }

    protected ShoppingItem(Parcel in) {
        name = in.readString();
        isPurchased = in.readByte() != 0;
    }

    public static final Creator<ShoppingItem> CREATOR = new Creator<ShoppingItem>() {
        @Override
        public ShoppingItem createFromParcel(Parcel in) {
            return new ShoppingItem(in);
        }

        @Override
        public ShoppingItem[] newArray(int size) {
            return new ShoppingItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeByte((byte) (isPurchased ? 1 : 0));
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }
}
