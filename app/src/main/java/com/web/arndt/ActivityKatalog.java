package com.web.arndt;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ActivityKatalog extends AppCompatActivity {
    private static final String TAG = ActivityKatalog.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    UtilDaten holeKapitel = new UtilDaten();
    //ToDo Anzeige der Katalogkapitel dynamisch

    String para = "";

    public void onClickKat01(View view) {
        Intent intent = new Intent(this, ActivitySucherg.class);

        switch (view.getId()) {
            case R.id.imgKat01:
                Log.d(TAG, "##onClick: TblKatalog 1 gewählt");
                intent.putExtra("para","?kat=01");
                break;
            case R.id.imgKat02:
                Log.d(TAG, "##onClick: TblKatalog 2 gewählt");
                intent.putExtra("para","?kat=02");
                break;
            case R.id.imgKat03:
                Log.d(TAG, "##onClick: TblKatalog 3 gewählt");
                intent.putExtra("para","?kat=03");
                break;
            case R.id.imgKat04:
                Log.d(TAG, "##onClick: TblKatalog 4 gewählt");
                intent.putExtra("para","?kat=04");
                break;
            case R.id.imgKat05:
                Log.d(TAG, "##onClick: TblKatalog 5 gewählt");
                intent.putExtra("para","?kat=05");
                break;
            case R.id.imgKat06:
                Log.d(TAG, "##onClick: TblKatalog 6 gewählt");
                intent.putExtra("para","?kat=06");
                break;
            case R.id.imgKat07:
                Log.d(TAG, "##onClick: TblKatalog 7 gewählt");
                intent.putExtra("para","?kat=07");
                break;
            case R.id.imgKat08:
                Log.d(TAG, "##onClick: TblKatalog 8 gewählt");
                intent.putExtra("para","?kat=08");
                break;
            case R.id.imgKat09:
                Log.d(TAG, "##onClick: TblKatalog 9 gewählt");
                intent.putExtra("para","?kat=09");
                break;
            case R.id.imgKat10:
                Log.d(TAG, "##onClick: TblKatalog 10 gewählt");
                intent.putExtra("para","?kat=10");
                break;
            default:
                Log.d(TAG, "##onClick: Leider daneben");
                return;
        }
        startActivity(intent);

    }

}
