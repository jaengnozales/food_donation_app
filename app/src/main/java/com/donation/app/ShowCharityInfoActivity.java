package com.donation.app;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class ShowCharityInfoActivity extends AppCompatActivity {

    private String selectedCharity = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_charity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.selectedCharity = getIntent().getStringExtra(Constants.SELECTED_CHARITY);
        setTitle(this.selectedCharity);
    }

    public void donate(View view) {
        Intent intent = new Intent(this, ReadMessageActivity.class);
        intent.putExtra(Constants.SELECTED_CHARITY, this.selectedCharity);
        startActivity(intent);
    }
}
