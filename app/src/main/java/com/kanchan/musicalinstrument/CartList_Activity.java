package com.kanchan.musicalinstrument;
import com.kanchan.musicalinstrument.Adapter.CartAdapter;
import com.kanchan.musicalinstrument.Model.Cart;
import com.kanchan.musicalinstrument.Url.url;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.kanchan.musicalinstrument.Api.ItemApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartList_Activity extends AppCompatActivity {
    RecyclerView RecyclerViewcart;
    public static String id = "";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list_);

        RecyclerViewcart = findViewById(R.id.REcart);
        getBook();
    }

    public void getBook() {

        String userId = id;
        ItemApi retrofitProductAPI = url.getInstance().create(ItemApi.class);
        Call<List<Cart>> ProductsCall = retrofitProductAPI.getcartlist(url.token);
        ProductsCall.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                if (response.code() == 200) {
                    CartAdapter recyclerviewAdapter = new CartAdapter(response.body(), getApplicationContext());
                    RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(getApplicationContext(), 1);
                    RecyclerViewcart.setLayoutManager(mlayoutManager);
                    RecyclerViewcart.setHasFixedSize(true);
                    RecyclerViewcart.setAdapter(recyclerviewAdapter);
                    recyclerviewAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(CartList_Activity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {
                Toast.makeText(CartList_Activity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}