package com.example.solemate.utils.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ShoeItem implements Parcelable {

    private String shoeName, shoeBrandName;
    private int shoeImage;
    private double shoePrice;

    public ShoeItem(String shoeName, String shoeBrandName, int shoeImage, double shoePrice) {
        this.shoeName = shoeName;
        this.shoeBrandName = shoeBrandName;
        this.shoeImage = shoeImage;
        this.shoePrice = shoePrice;
    }
}