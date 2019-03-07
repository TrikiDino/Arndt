package com.web.arndt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        //

        Katalog[] katalog = new Katalog[9];

        for(int i = 0;i<9:i++){
            katalog[i] = "katalog0" + (i+1) + ".png";
        }


        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).

        ArrayAdapter<Katalog> arrayAdapter
                = new ArrayAdapter<Katalog>(this, android.R.layout.simple_list_item_1 , katalog);


        listView.setAdapter(arrayAdapter);
    }


}