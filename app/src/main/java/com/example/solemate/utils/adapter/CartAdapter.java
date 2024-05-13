package com.example.solemate.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import example.solemate.shoeapp.R;
import example.solemate.shoeapp.utils.model.ShoeCart;

import java.util.List;
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHodler> {

    private CartClickedListeners cartClickedListeners;
    private List<ShoeCart> shoeCartList;

    public CartAdapter(CartClickedListeners cartClickedListeners) {
        this.cartClickedListeners = cartClickedListeners;
    }

    public void setShoeCartList(List<ShoeCart> shoeCartList) {
        this.shoeCartList = shoeCartList;
        notifyDataSetChanged();
    }
