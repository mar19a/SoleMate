package com.example.solemate.viewmodel;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.solemate.repository.CartRepo;
import com.example.solemate.utils.model.ShoeCart;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private CartRepo cartRepo;

    public CartViewModel(@NonNull Application application) {
        super(application);
        cartRepo = new CartRepo(application);
    }

    public LiveData<List<ShoeCart>> getAllCartItems() {
        return cartRepo.getAllCartItemsLiveData();
    }

    public void insertCartItem(ShoeCart shoeCart) {
        cartRepo.insertCartItem(shoeCart);
    }

}
