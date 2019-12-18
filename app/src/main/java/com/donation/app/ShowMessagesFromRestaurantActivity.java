package com.donation.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMessagesFromRestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_messages_from_restaurant);
    }


    public void readMessage(View view) {
            Intent intent = new Intent(this, ReadMessageFromRestaurantActivity.class);
            startActivity(intent);

    }


}
