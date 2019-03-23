package com.web.arndt;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

public class UtilNav extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public boolean onNavigation(Activity activity, MenuItem item){
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
                intent = new Intent(this, MainActivity.class);
                fragment = new FragmentKontakt();
                break;
            case R.id.nav_map:
                intent = new Intent(this, ActivityMaps.class);
                break;
            case R.id.nav_einstellung:
                intent = new Intent(this, ActivityEinstellungen.class);
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
            startActivity(intent);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        } else if (intent != null) {

            startActivity(intent);
        }

        return true;

    }

    private AlertDialog createLoginDialog() {
        // ToDo Login über Datenbankzugriff umsetzen
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        View dialogsView = inflater.inflate(R.layout.dialog_login, null);

        builder.setView(dialogsView)
                .setTitle("Login für Kunden")
                .setPositiveButton("Anmelden", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

    private AlertDialog createSearchDialog() {
        // ToDo zusätzliche Suchoptionen einfügen
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        View dialogsView = inflater.inflate(R.layout.dialog_search, null);

        builder.setView(dialogsView)
                .setTitle("Artikelsuche")
                .setPositiveButton("Suche starten", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }
}
