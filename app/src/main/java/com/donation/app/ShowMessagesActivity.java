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
            Intent intent = new Intent(this, ReadMessageActivity.class);
            startActivity(intent);
    }


}
