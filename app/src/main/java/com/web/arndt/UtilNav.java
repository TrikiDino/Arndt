package com.web.arndt;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class UtilNav extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public void onNavigation(Activity activity, MenuItem item){
        int id = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;
        switch (id) {
            case R.id.nav_katalog:
                intent = new Intent(activity, ActivityKatalog.class);
                break;
            case R.id.nav_login:
//                ToDo Login für Bestandskunden
                //intent = new Intent(this,ActivityLogin.class);
                break;
            case R.id.nav_kontakt:
                fragment = new FragmentKontakt();
                break;
            case R.id.nav_map:
                intent = new Intent(activity, ActivityMaps.class);
                break;
            case R.id.app_bar_search:
//                ToDo ActivitySearch starten
                intent = new Intent(activity, ActivitySearch.class);
                break;
            default:
                intent = new Intent(activity, ActivityKatalog.class);
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = new FragmentActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        } else {
            activity.startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_main);
        drawer.closeDrawer(GravityCompat.START);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }
}
