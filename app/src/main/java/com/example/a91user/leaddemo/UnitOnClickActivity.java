package com.example.a91user.leaddemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a91user.leaddemo.Model.Unit;

public class UnitOnClickActivity extends AppCompatActivity implements View.OnClickListener {

    //ui elements
    private TextView clickunitName;
    private TextView clickunitNumber;
    private Button backButton;

    //var
    private Unit unit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_on_click);


        clickunitName = findViewById(R.id.unitNameClick);
        clickunitNumber = findViewById(R.id.unitNumberClick);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this);


        //get parcelale data from intent into unit object.
        unit = getIntent().getParcelableExtra("click");

        //check if intent has the data or not
        if (unit != null) {
            clickunitName.setText(String.valueOf(unit.getUnitName()));
            clickunitNumber.setText(String.valueOf(unit.getUnitNumber()));

        } else {
            Log.d("unit on click", "error in on click intent");
        }


        //internet---- NOTE: method -->down
        if (!isConnected()) {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_error)
                    .setTitle("Error !")
                    .setMessage("No internet Connection")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //finish();
                            Toast.makeText(UnitOnClickActivity.this, "Try again later ", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
        } else {
            Toast.makeText(this, " Something went wrong", Toast.LENGTH_SHORT).show();
        }


    }


    //Alert dialog will be show when user clicks on back button
    @Override
    public void onClick(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation !");
        builder.setMessage("You are about to exit the unit. Do you really want to proceed ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(UnitOnClickActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Continue Unit", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }


    //check Internet
    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
