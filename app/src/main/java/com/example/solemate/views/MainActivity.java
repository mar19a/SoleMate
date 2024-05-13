package com.example.solemate.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.solemate.R;
import com.example.solemate.utils.adapter.ShoeItemAdapter;
import com.example.solemate.utils.model.ShoeCart;
import com.example.solemate.utils.model.ShoeItem;
import com.example.solemate.viewmodel.CartViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements ShoeItemAdapter.ShoeClickedListeners {
    private RecyclerView recyclerView;
    private List<ShoeItem> shoeItemList;
    private ShoeItemAdapter adapter;
    private CartViewModel viewModel;
    private List<ShoeCart> shoeCartList;
    private CoordinatorLayout coordinatorLayout;
    private ImageView cartImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
        setUpList();

        adapter.setShoeItemList(shoeItemList);
        recyclerView.setAdapter(adapter);


        cartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

}
