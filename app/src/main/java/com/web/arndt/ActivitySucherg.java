package com.web.arndt;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// ToDo Anzeige des Suchergebnisses und Auswählmöglichkeit
// Anzeige von Kataloggruppe und Suchergebnis

public class ActivitySucherg extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // TblKatalog Kapitel Verzeichnis
    private static final String SPRACHE = "Sprache";
    private static final String KUERZEL = "Kuerzel";
    private static final String GRUPPE = "Gruppe";
    private static final String TEXT = "Text";
    private static final String ZUSATZ = "Zusatz";
    private static final String UEBERSETZUNG = "Uebersetzung";
    private static final String PHP_DATEI = "PHP_Datei";
    private static final String SYMBOL_GRAFIK_1 = "Symbol_Grafik_1";
    private static final String SYMBOL_GRAFIK_2 = "Symbol_Grafik_2";
    private static final String SYMBOL_GRAFIK_3 = "Symbol_Grafik_3";
    private static final String SYMBOL_GRAFIK_4 = "Symbol_Grafik_4";
    private static final String MASSEINHEIT = "Masseinheit";
    private static final String ARTIKEL_ZEILE = "Artikel_Zeile";
    private static final String KENN_ART_2 = "Kenn_Art_2";
    private static final String AUSFART1 = "AusfArt1";
    private static final String AUSFART2 = "AusfArt2";
    private static final String NOART1 = "NoArt1";
    private static final String NOART2 = "NoArt2";
    private static final String SB = "SB";
    private static final String STUECKLISTE = "TblStueckliste";
    private static final String GRAFIK2 = "Grafik2";
    private static final String ZUSTEXT = "zusText";
    private static final String NEUHEIT = "Neuheit";
    private static final String MOAKTION = "MoAktion";
    private static final String SCHALTER = "Schalter";
    private static final String SORT = "Sort";

    private static final String TAG = ActivitySucherg.class.getSimpleName();
    public String para = "";

    List<TblKatalogGruppe> katGruppe = new ArrayList<TblKatalogGruppe>();

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            TblKatalogGruppe thisItem = katGruppe.get(position);
            Log.d(TAG, "##onClick: es wurde Artikel "+ thisItem.getKuerzel() + " geklickt");
            Intent intArt = new Intent(ActivitySucherg.this, ActivityArtikel.class);

            intArt.putExtra("katalog", thisItem);
            startActivity(intArt);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucherg);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_sucherg);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        para = getIntent().getExtras().getString("para", "");

        new get_Kapitel().execute();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        new UtilNav().onNavigation(this, item);
        return true;
    }

    public class CreateList {

        private String t_artikel;
        private String t_mass;
        private Integer i_artikel;
        private Integer i_symbol;

        public String getT_artikel() {
            return t_artikel;
        }

        public void setT_artikel(String t_artikel) {
            this.t_artikel = t_artikel;
        }

        public String getT_mass() {
            return t_mass;
        }

        public void setT_mass(String t_mass) {
            this.t_mass = t_mass;
        }

        public Integer getI_artikel() {
            return i_artikel;
        }

        public void setI_artikel(Integer i_artikel) {
            this.i_artikel = i_artikel;
        }

        public Integer getI_symbol() {
            return i_symbol;
        }

        public void setI_symbol(Integer i_symbol) {
            this.i_symbol = i_symbol;
        }
    }

    private ArrayList<CreateList> prepareData(String[] t_artikel, String[] t_mass, Integer[] i_artikel, Integer[] i_symbol){

        ArrayList<CreateList> imgArtikel = new ArrayList<>();
        for(int i = 0; i< t_artikel.length; i++){
            CreateList createList = new CreateList();
            createList.setT_artikel(t_artikel[i]);
            createList.setT_mass(t_mass[i]);
            createList.setI_artikel(i_artikel[i]);
            createList.setI_symbol(i_symbol[i]);
            imgArtikel.add(createList);
        }
        return imgArtikel;
    }

    private class get_Kapitel extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                String url = "http://www.arndt-tool.de/app/php/json.php" + para;
                JSONArray jsonArray = new JSONArray(UtilDaten.getFromServer(url));

                TblKatalogGruppe gruppe;

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    gruppe = new TblKatalogGruppe(
                            jsonObject.has(SPRACHE) ? jsonObject.getString(SPRACHE) : "D",
                            jsonObject.has(KUERZEL) ? jsonObject.getString(KUERZEL) : "",
                            jsonObject.has(GRUPPE) ? jsonObject.getString(GRUPPE) : "",
                            jsonObject.has(TEXT) ? jsonObject.getString(TEXT) : "",
                            jsonObject.has(ZUSATZ) ? jsonObject.getString(ZUSATZ) : "",
                            jsonObject.has(UEBERSETZUNG) ? jsonObject.getString(UEBERSETZUNG) : "",
                            jsonObject.has(PHP_DATEI) ? jsonObject.getString(PHP_DATEI) : "",
                            jsonObject.has(SYMBOL_GRAFIK_1) ? jsonObject.getString(SYMBOL_GRAFIK_1) : "",
                            jsonObject.has(SYMBOL_GRAFIK_2) ? jsonObject.getString(SYMBOL_GRAFIK_2) : "",
                            jsonObject.has(SYMBOL_GRAFIK_3) ? jsonObject.getString(SYMBOL_GRAFIK_3) : "",
                            jsonObject.has(SYMBOL_GRAFIK_4) ? jsonObject.getString(SYMBOL_GRAFIK_4) : "",
                            jsonObject.has(MASSEINHEIT) ? jsonObject.getString(MASSEINHEIT) : "",
                            jsonObject.has(ARTIKEL_ZEILE) ? jsonObject.getString(ARTIKEL_ZEILE) : "",
                            jsonObject.has(KENN_ART_2) ? jsonObject.getString(KENN_ART_2) : "",
                            jsonObject.has(AUSFART1) ? jsonObject.getString(AUSFART1) : "",
                            jsonObject.has(AUSFART2) ? jsonObject.getString(AUSFART2) : "",
                            jsonObject.has(NOART1) ? jsonObject.getString(NOART1) : "",
                            jsonObject.has(NOART2) ? jsonObject.getString(NOART2) : "",
                            jsonObject.has(SB) ? jsonObject.getString(SB) : "",
                            jsonObject.has(STUECKLISTE) ? jsonObject.getString(STUECKLISTE) : "",
                            jsonObject.has(GRAFIK2) ? jsonObject.getString(GRAFIK2) : "",
                            jsonObject.has(ZUSTEXT) ? jsonObject.getString(ZUSTEXT) : "",
                            jsonObject.has(NEUHEIT) ? jsonObject.getString(NEUHEIT) : "",
                            jsonObject.has(MOAKTION) ? jsonObject.getString(MOAKTION) : "",
                            !jsonObject.has(SCHALTER) ? jsonObject.getInt(SCHALTER) : 1);

                    Log.d(TAG, "##getKapitel 164: " + gruppe.toString());

                    katGruppe.add(gruppe);
                    // ToDo Kapitel-Daten in SQLite oder Firebase ablegen, evtl Firebase <=> mySQL Verbindung
                }
                return "";
            } catch (IOException e) {
                Log.e(TAG, "doInBackground: ", e);
            } catch (JSONException e) {
                Log.e(TAG, "doInBackground: ", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d(TAG, "##onCreate: " + katGruppe.toString());
            String t_artikel[] = new String[katGruppe.size()];
            String t_mass[] = new String[katGruppe.size()];
            Integer i_artikel[] = new Integer[katGruppe.size()];
            Integer i_symbol[] = new Integer[katGruppe.size()];
            String ni_artikel[] = new String[katGruppe.size()];
            String ni_symbol[] = new String[katGruppe.size()];

            int i = 0;
            for(TblKatalogGruppe gruppe : katGruppe){

                ni_artikel[i] = ("p"+ gruppe.getKuerzel())
                        .replace("-","_")
                        .replace("_mm","")
                        .replace("_inch","").trim();

                ni_symbol[i] = ("s"+ gruppe.getSymbol_grafik_1())
                        .replace("-","_").toLowerCase().trim();

                i_artikel[i] = getResources().getIdentifier(ni_artikel[i],
                        "mipmap",getPackageName());
                i_symbol[i] = getResources().getIdentifier(ni_symbol[i],
                        "drawable",getPackageName());

                t_artikel[i] = gruppe.getKuerzel().replace("_mm","")
                        .replace("_inch","").toUpperCase();
                t_mass[i] = gruppe.getMasseinheit();
                
                i++;
            }

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcKatGruppe);
            recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager;
            int orientation = getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                layoutManager = new GridLayoutManager(getApplicationContext(),5);// In landscape
            } else {
                layoutManager = new GridLayoutManager(getApplicationContext(),3);// In portrait
            }
            recyclerView.setLayoutManager(layoutManager);
            ArrayList<CreateList> katalogGruppes = prepareData(t_artikel, t_mass, i_artikel, i_symbol);
            AdapterSucherg adapter = new AdapterSucherg(getApplicationContext(), katalogGruppes);
            recyclerView.setAdapter(adapter);

            adapter.setOnItemClickListener(onItemClickListener);


        }
    }


}
