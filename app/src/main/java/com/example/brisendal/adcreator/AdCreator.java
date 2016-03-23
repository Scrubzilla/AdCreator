package com.example.brisendal.adcreator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.brisendal.punishers.Pew;

public class AdCreator extends AppCompatActivity {
    private String SAVED_INFO = "savedInfo";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_creator);

        preferences = getSharedPreferences(SAVED_INFO, MODE_PRIVATE);
        editor = preferences.edit();

        Pew niet = new Pew();
    }

    @Override
    protected void onResume(){
        super.onResume();
        EditText titleField = (EditText) findViewById(R.id.titleField);
        EditText nameField = (EditText) findViewById(R.id.nameField);
        EditText descField = (EditText) findViewById(R.id.descField);
        EditText phoneField = (EditText) findViewById(R.id.phoneField);
        EditText priceField = (EditText) findViewById(R.id.priceField);

        titleField.setText(preferences.getString("title", ""));
        nameField.setText(preferences.getString("name", ""));
        descField.setText(preferences.getString("description", ""));
        phoneField.setText(preferences.getString("phone", ""));
        priceField.setText(preferences.getString("price", ""));
    }

    public void saveData(View view){
        editor.putString("title", ((EditText) findViewById(R.id.titleField)).getText().toString());
        editor.putString("name", ((EditText) findViewById(R.id.nameField)).getText().toString());
        editor.putString("description",((EditText) findViewById(R.id.descField)).getText().toString());
        editor.putString("phone",((EditText) findViewById(R.id.phoneField)).getText().toString());
        editor.putString("price",((EditText) findViewById(R.id.priceField)).getText().toString());
        editor.commit();

        Intent activitySwap = new Intent(AdCreator.this, CallAd.class);
        startActivity(activitySwap);
    }
}