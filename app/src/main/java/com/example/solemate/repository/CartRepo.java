package com.example.solemate.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.solemate.dao.CartDAO;
import com.example.solemate.database.CartDatabase;
import com.example.solemate.utils.model.ShoeCart;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class CartRepo {

    private CartDAO cartDAO;
    private LiveData<List<ShoeCart>> allCartItemsLiveData;
    private Executor executor = Executors.newSingleThreadExecutor();

    public LiveData<List<ShoeCart>> getAllCartItemsLiveData() {
        return allCartItemsLiveData;
    }

    public CartRepo(Application application){
        cartDAO = CartDatabase.getInstance(application).cartDAO();
        allCartItemsLiveData = cartDAO.getAllCartItems();
    }

    public void insertCartItem(ShoeCart shoeCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.insertCartItem(shoeCart);
            }
        });
    }

    public void deleteCartItem(ShoeCart shoeCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.deleteCartItem(shoeCart);
            }
        });
    }


}
