package com.donation.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void login(View view) {
        Intent intent = new Intent(this, HomeActivity.class);;
        EditText mEdit   = (EditText) findViewById(R.id.editText);
        System.out.println("======================================");
        System.out.println(mEdit.getText().toString());
        if(mEdit != null && mEdit.getText() != null)
            intent.putExtra(Constants.USER, mEdit.getText().toString());
        UserSingleton.getInstance().setUser(mEdit.getText().toString());
        startActivity(intent);
    }
}
