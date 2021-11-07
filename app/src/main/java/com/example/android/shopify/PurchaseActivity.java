package com.example.android.shopify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class PurchaseActivity extends AppCompatActivity implements PaymentResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomnav);

        // adding on click listener to our purchase.
        bottomNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // amount of product
                String samount = "100";

                // rounding off the amount.
                int amount = Math.round(Float.parseFloat(samount) * 100);

                // initialize Razorpay account.
                Checkout checkout = new Checkout();

                // set my razorpay id as below
                checkout.setKeyID("rzp_test_BlJsi3E8a8qg0P");

                // set random image
                checkout.setImage(R.drawable.ic_launcher_background);

                // initialize json object
                JSONObject object = new JSONObject();
                try {
                    // to put name
                    object.put("name", "Sagar");

                    // put description
                    object.put("description", "Testing payment");

                    // to set theme color
                    object.put("theme.color", "");

                    // put the currency
                    object.put("currency", "INR");

                    // put amount
                    object.put("amount", amount);

                    // put mobile number
                    object.put("prefill.contact", "9896076738");

                    // put email
                    object.put("prefill.email", "sagar_0dev@gmail.com");

                    // open razorpay to checkout activity
                    checkout.open(PurchaseActivity.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        // this method is called on payment success.
        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        // on payment failed.
        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }
}