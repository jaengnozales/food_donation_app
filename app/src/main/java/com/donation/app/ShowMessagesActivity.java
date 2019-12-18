package com.donation.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShowMessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_messages);
    }


    public void readMessage(View view) {
        System.out.println(UserSingleton.getInstance().getUser());
        System.out.println("======================================");
        if(UserSingleton.getInstance().getUser().equalsIgnoreCase("charity")) {
            Intent intent = new Intent(this, ReadMessageFromRestaurantActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, ReadMessageActivity.class);
            startActivity(intent);
        }

    }


}
