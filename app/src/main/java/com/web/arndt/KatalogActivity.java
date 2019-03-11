package com.web.arndt;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class KatalogActivity extends AppCompatActivity {
    private static final String TAG = KatalogActivity.class.getSimpleName();

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

    DatenUtil holeKapitel = new DatenUtil();
    String para = "";

    public void onClickKat01(View view) {

        switch (view.getId()) {
            case R.id.imgKat01:
                Log.d(TAG, "onClick: Katalog 1 gewählt");
                para = "?kat=01";
                break;
            case R.id.imgKat02:
                Log.d(TAG, "onClick: Katalog 2 gewählt");
                para = "?kat=02";
                break;
            case R.id.imgKat03:
                Log.d(TAG, "onClick: Katalog 3 gewählt");
                para = "?kat=03";
                break;
            case R.id.imgKat04:
                Log.d(TAG, "onClick: Katalog 4 gewählt");
                para = "?kat=04";
                break;
            case R.id.imgKat05:
                Log.d(TAG, "onClick: Katalog 5 gewählt");
                para = "?kat=05";
                break;
            case R.id.imgKat06:
                Log.d(TAG, "onClick: Katalog 6 gewählt");
                para = "?kat=06";
                break;
            case R.id.imgKat07:
                Log.d(TAG, "onClick: Katalog 7 gewählt");
                para = "?kat=07";
                break;
            case R.id.imgKat08:
                Log.d(TAG, "onClick: Katalog 8 gewählt");
                para = "?kat=08";
                break;
            case R.id.imgKat09:
                Log.d(TAG, "onClick: Katalog 9 gewählt");
                para = "?kat=09";
                break;
            case R.id.imgKat10:
                Log.d(TAG, "onClick: Katalog 10 gewählt");
                para = "?kat=10";
                break;
            default:
                Log.d(TAG, "onClick: Leider daneben");
                break;
        }

        try {
            holeKapitel.getKapitel(para);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class HoleDatenTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            final String baseUrl = "";
            final String requestUrl = baseUrl + strings[0];
            Log.d(TAG, "##doInBackground: " + requestUrl);
            StringBuilder result = new StringBuilder();
            URL url = null;

            try {
                url = new URL(requestUrl);
            } catch (MalformedURLException e) {
                Log.e(TAG, "", e);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

            } catch (IOException e) {

            }
            Log.d(TAG, "##doInBackground: " + result.toString());
            return result.toString();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected void onPostExecute(String[] strings) {
            if (strings != null) {
                Log.d(TAG, "gelesene Daten: " + strings.toString());
            }
        }


    }
}
