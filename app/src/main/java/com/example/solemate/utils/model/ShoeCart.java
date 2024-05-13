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

}
