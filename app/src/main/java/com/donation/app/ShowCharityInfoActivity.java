package com.donation.app;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

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
        EditText mEdit   = (EditText) findViewById(R.id.number_of_donations);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Donate to "+ this.selectedCharity);
        alert.setMessage("You are about to donate "+mEdit.getText().toString()+ " pax worth of foods to "+this.selectedCharity+". Are you sure?");
        // alert.setMessage("Message");

        alert.setPositiveButton("Ok", new CustomDialog(this.selectedCharity));

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });

        alert.show();

//        Intent intent = new Intent(this, ReadMessageActivity.class);
//        intent.putExtra(Constants.SELECTED_CHARITY, this.selectedCharity);
//        startActivity(intent);
    }

    public class CustomDialog implements DialogInterface.OnClickListener {

        private String charity;

        public  CustomDialog(String selectedCharity) {
            this.charity = selectedCharity;
        }

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(ShowCharityInfoActivity.this, ReadMessageActivity.class);
            intent.putExtra(Constants.SELECTED_CHARITY, this.charity);
            startActivity(intent);
        }
    }
}
