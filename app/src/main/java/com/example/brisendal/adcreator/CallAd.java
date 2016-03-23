package com.example.brisendal.adcreator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CallAd extends AppCompatActivity {

    private String SAVED_INFO = "savedInfo";
    private SharedPreferences preferences;
    private TextView phoneLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_ad);

        preferences = getSharedPreferences(SAVED_INFO, MODE_PRIVATE);

        TextView titleLabel = (TextView) findViewById(R.id.titleLabel);
        TextView nameLabel = (TextView) findViewById(R.id.nameLabel);
        TextView descLabel = (TextView) findViewById(R.id.descLabel);
        phoneLabel = (TextView) findViewById(R.id.phoneLabel);
        TextView priceLabel = (TextView) findViewById(R.id.priceLabel);

        titleLabel.setText(preferences.getString("title", "Title not found."));
        nameLabel.setText(preferences.getString("name", "Name not found."));
        descLabel.setText(preferences.getString("description", "Description not found."));
        phoneLabel.setText(preferences.getString("phone", "Phone not found."));
        priceLabel.setText(preferences.getString("price", "Price not found.") + "kr");

        if(priceLabel.getText().equals("kr")){
            priceLabel.setText("");
        }

    }

    public void startCalling(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phoneLabel.getText().toString()));

        try {
            startActivity(callIntent);
        }catch(Exception e) {

        }
    }
}
