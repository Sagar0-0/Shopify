package com.example.android.shopify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView addToCart;
    TextView buyNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        addToCart=findViewById(R.id.addToCart);
        addToCart.setOnClickListener(view -> {
            Intent intent=new Intent(this,CartActivity.class);
            startActivity(intent);
        });
        buyNow=findViewById(R.id.buyNow);
        buyNow.setOnClickListener(view -> {
            Intent intent=new Intent(this,PurchaseActivity.class);
            startActivity(intent);
        });
    }
}