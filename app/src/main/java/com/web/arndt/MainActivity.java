package com.web.arndt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.nav_open_drawer,R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new FragmentStart();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content_frame,fragment);
        transaction.commit();


        TblKatalog[] katalog = new TblKatalog[9];

        for(int i = 0;i<9;i++){
            //katalog[i] = "katalog0" + (i+1) + ".png";
        }


        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).

        ArrayAdapter<TblKatalog> arrayAdapter
                = new ArrayAdapter<TblKatalog>(this, android.R.layout.simple_list_item_1 , katalog);

        //listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;
        switch (id) {
            case R.id.nav_katalog:
                intent = new Intent(this, ActivityKatalog.class);
                break;
            case R.id.nav_kontakt:
                fragment = new FragmentKontakt();
                break;
            case R.id.nav_login:
                //intent = new Intent(this,ActivityLogin.class);
                break;
            case R.id.nav_map:
                fragment = new FragmentMap();
                break;
            default:
                intent = new Intent(this, ActivityKatalog.class);
                break;
        }

        if(fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame,fragment);
            ft.commit();
        } else {
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


        protected void onProgressUpdate(Integer... values) {
            //Toast.makeText(this, values[0] + " von " + values[1] + " geladen", Toast.LENGTH_SHORT).show();
        }

    }


