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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class ActivityKatalog extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = ActivityKatalog.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_kat);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        } else {
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_main);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
