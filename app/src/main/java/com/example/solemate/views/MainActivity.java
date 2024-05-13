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
    @Override
    protected void onResume() {
        super.onResume();

        viewModel.getAllCartItems().observe(this, new Observer<List<ShoeCart>>() {
            @Override
            public void onChanged(List<ShoeCart> shoeCarts) {
                shoeCartList.addAll(shoeCarts);
            }
        });
    }

    private void setUpList() {
        shoeItemList.add(new ShoeItem("Nike Revolution", "Nike", R.drawable.nike_revolution_road, 15));
        shoeItemList.add(new ShoeItem("Nike Flex Run 2021", "NIKE", R.drawable.flex_run_road_running, 20));
        shoeItemList.add(new ShoeItem("Court Zoom Vapor", "NIKE", R.drawable.nikecourt_zoom_vapor_cage, 18));
        shoeItemList.add(new ShoeItem("EQ21 Run COLD.RDY", "ADIDAS", R.drawable.adidas_eq_run, 16.5));
        shoeItemList.add(new ShoeItem("Adidas Ozelia", "ADIDAS", R.drawable.adidas_ozelia_shoes_grey, 20));
        shoeItemList.add(new ShoeItem("Adidas Questar", "ADIDAS", R.drawable.adidas_questar_shoes, 22));
        shoeItemList.add(new ShoeItem("Adidas Questar", "ADIDAS", R.drawable.adidas_questar_shoes, 12));
        shoeItemList.add(new ShoeItem("Adidas Ultraboost", "ADIDAS", R.drawable.adidas_ultraboost, 15));

    }
}
