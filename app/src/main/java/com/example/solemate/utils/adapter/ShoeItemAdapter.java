package com.example.solemate.utils.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.solemate.R;
import com.example.solemate.utils.model.ShoeItem;

import java.util.List;

public class ShoeItemAdapter extends RecyclerView.Adapter<ShoeItemAdapter.ShoeItemViewHolder> {

    private List<ShoeItem> shoeItemList;
    private ShoeClickedListeners shoeClickedListeners;
    public ShoeItemAdapter(ShoeClickedListeners shoeClickedListeners){
        this.shoeClickedListeners = shoeClickedListeners;
    }
    public void setShoeItemList(List<ShoeItem> shoeItemList){
        this.shoeItemList = shoeItemList;
    }
    @NonNull
    @Override
    public ShoeItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_shoe , parent , false);
        return new ShoeItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoeItemViewHolder holder, int position) {
        ShoeItem shoeItem = shoeItemList.get(position);
        holder.shoeNameTv.setText(shoeItem.getShoeName());
        holder.shoeBrandNameTv.setText(shoeItem.getShoeBrandName());
        holder.shoePriceTv.setText(String.valueOf(shoeItem.getShoePrice()));
        holder.shoeImageView.setImageResource(shoeItem.getShoeImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoeClickedListeners.onCardClicked(shoeItem);
            }
        });

        holder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoeClickedListeners.onAddToCartBtnClicked(shoeItem);
            }
        });
    }

}
