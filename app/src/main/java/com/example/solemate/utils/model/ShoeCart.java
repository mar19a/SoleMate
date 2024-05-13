package com.example.solemate.utils.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "shoe_table")
public class ShoeCart {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String shoeName, shoeBrandName;
    private int shoeImage;
    private double shoePrice;

    private int quantity;
    private double totalItemPrice;

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getShoeBrandName() {
        return shoeBrandName;
    }

    public void setShoeBrandName(String shoeBrandName) {
        this.shoeBrandName = shoeBrandName;
    }

    public int getShoeImage() {
        return shoeImage;
    }


}
