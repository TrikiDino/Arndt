package com.web.arndt;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new FragmentStart();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content_frame, fragment);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    //    ToDo Funktion der onNavigation auslagern, so das redundanter Code vermieden wird
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;
        switch (id) {
            case R.id.nav_katalog:
                intent = new Intent(this, ActivityKatalog.class);
                break;
            case R.id.nav_login:
//                ToDo Login für Bestandskunden
                AlertDialog loginDialog = createLoginDialog();
                loginDialog.show();
                break;
            case R.id.nav_kontakt:
                fragment = new FragmentKontakt();
                break;
            case R.id.nav_map:
                intent = new Intent(this, ActivityMaps.class);
                break;
            case R.id.app_bar_search:
//                ToDo ActivitySearch starten
                AlertDialog searchDialog = createSearchDialog();
                searchDialog.show();

                break;
            default:
                intent = new Intent(this, ActivityKatalog.class);
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        } else if(intent!=null){

            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_main);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private AlertDialog createLoginDialog() {
        // ToDo Login über Datenbankzugriff umsetzen
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        View dialogsView = inflater.inflate(R.layout.dialog_search, null);

        return builder.create();
    }

    private AlertDialog createSearchDialog() {
        // ToDo zusätzliche Suchoptionen einfügen
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        View dialogsView = inflater.inflate(R.layout.dialog_search, null);

        return builder.create();
    }

}


