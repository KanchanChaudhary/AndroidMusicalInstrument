package com.kanchan.musicalinstrument;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.kanchan.musicalinstrument.Api.UserApi;
import com.kanchan.musicalinstrument.Bll.CartBll;
import com.kanchan.musicalinstrument.Url.url;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Item_Details_Activity extends AppCompatActivity {

    ImageView imgMain1;
    TextView tvdname, tvdprice, tvdesc;
    Context mcontext;
    public static String id = null;
    String itemid = "";
    String Image = "";
    private FloatingActionButton fav;
    Button buttonCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__details_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        imgMain1 = findViewById(R.id.ImgMain1);
        tvdesc = findViewById(R.id.tvdes);
        tvdprice = findViewById(R.id.tvprice);
        tvdname = findViewById(R.id.tvname);
        buttonCart = findViewById(R.id.Cart);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String imgPath = url.imagePath + (bundle.getString("image"));

            itemid = bundle.getString("_id");
            String Images = bundle.getString("image");
            Picasso.get().load(url.base_url + "uploads/" + Images).into(imgMain1);
            tvdname.setText(bundle.getString("itemname"));
            tvdprice.setText("Rs: " + bundle.getString("price"));
            tvdesc.setText(bundle.getString("detail"));


        }
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = id;
                String itemID = itemid;
                CartBll CartBll = new CartBll();
                if (CartBll.checkcart(userid, itemID)) {
                    Register();
                    Snackbar.make(view, "Added to Cart", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                } else {
                    fav.setEnabled(false);
                    Snackbar.make(view, "Already Added! Check cart", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }


            }
        });
        fav = (FloatingActionButton) findViewById(R.id.fav);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = id;
                String itemID = itemid;
                CartBll CartBll = new CartBll();
                if (CartBll.checkcart(userid, itemID)) {
                    Register();
                    Snackbar.make(view, "Added to Cart", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    fav.setEnabled(false);
                    Snackbar.make(view, "Already Added! Check cart", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }


            }
        });
    }
    private void Register() {

        String userid = id;
        String itemID = itemid;
        String itemName = tvdname.getText().toString();
        String price = tvdprice.getText().toString();
        String disc = tvdesc.getText().toString();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi user1 = retrofit.create(UserApi.class);
    }
    private class AddtoCartOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }
}