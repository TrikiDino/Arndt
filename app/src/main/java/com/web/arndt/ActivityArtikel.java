package com.web.arndt;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// ToDo Anzeige des ausgeählten Artikels
//      ToDo Artikel laden und richtige Darstellung wählen
//      ToDo für Stücklistenartikel Stückliste nachladen und darstellen
// ToDo Für angemeldete Bestandskunden mit Preisen, Rabatten, TZ
// ToDo Für angemeldete Bestandskunden mit Bestellmöglichkeit


public class ActivityArtikel extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // TblArtikel
    private static final String TEILE = "Teile";
    private static final String WARENGRUPPE = "Warengruppe";
    private static final String ABMESSUNG = "Abmessung";
    private static final String MASS = "Mass";
    private static final String ARTIKELNUMMER = "Artikelnummer";
    private static final String GEWICHT = "Gewicht";
    private static final String GEWICHTEINH = "GewichtEinh";
    private static final String GROESSEINCH = "GroesseINCH";
    private static final String BESCHAFFUNG = "Beschaffung";
    private static final String VERPACKEINHTEXT = "VerpackEinhText";
    private static final String GROESSEINCHDEZ = "GroesseINCHdez";

    // Stückliste
    // private static final String ARTIKELNUMMER = "artikelnummer";
    private static final String warengruppe = "warengruppe";
    private static final String TEILARTIKEL = "teilartikel";
    private static final String MENGETEIL = "mengeteil";
    // private static final String ABMESSUNG = "abmessung";
    private static final String BEZEICHNUNG1 = "bezeichnung1";
    private static final String PHP_DATEI = "php_datei";
    private static final String SYMBOL_GRAFIK_1 = "symbol_grafik_1";
    private static final String SYMBOL_GRAFIK_2 = "symbol_grafik_2";
    private static final String SYMBOL_GRAFIK_3 = "symbol_grafik_3";
    private static final String MASSEINHEIT = "masseinheit";
    private static final String ARTIKEL_ZEILE = "artikel_zeile";
    private static final String KENN_ART_2 = "kenn_art_2";
    private static final String SB = "sb";
    private static final String GRAFIK2 = "grafik2";
    private static final String ZUSTEXT = "zustext";
    private static final String NEUHEIT = "neuheit";
    private static final String MOAKTION = "moaktion";
    private static final String SCHALTER = "schalter";

    private static final String TAG = ActivitySucherg.class.getSimpleName();
    public String para = "";

    List<TblArtikel> artGruppe = new ArrayList<TblArtikel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);

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

        new ActivityArtikel.get_Artikel().execute();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        new UtilNav().onNavigation(this, item);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public class CreateList {

        private String t_beschreibung;
        private String t_ausfuehrung;
        String t_iso;
        Integer i_artikel;
        Integer i_symbol;
        String t_artnr1;
        String t_farbe1;
        String t_artnr2;
        String t_farbe2;

        public String getT_beschreibung() {
            return t_beschreibung;
        }

        public void setT_beschreibung(String t_beschreibung) {
            this.t_beschreibung = t_beschreibung;
        }

        public String getT_ausfuehrung() {
            return t_ausfuehrung;
        }

        public void setT_ausfuehrung(String t_ausfuehrung) {
            this.t_ausfuehrung = t_ausfuehrung;
        }

        public String getT_iso() {
            return t_iso;
        }

        public void setT_iso(String t_iso) {
            this.t_iso = t_iso;
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

        public String getT_artnr1() {
            return t_artnr1;
        }

        public void setT_artnr1(String t_artnr1) {
            this.t_artnr1 = t_artnr1;
        }

        public String getT_farbe1() {
            return t_farbe1;
        }

        public void setT_farbe1(String t_farbe1) {
            this.t_farbe1 = t_farbe1;
        }

        public String getT_artnr2() {
            return t_artnr2;
        }

        public void setT_artnr2(String t_artnr2) {
            this.t_artnr2 = t_artnr2;
        }

        public String getT_farbe2() {
            return t_farbe2;
        }

        public void setT_farbe2(String t_farbe2) {
            this.t_farbe2 = t_farbe2;
        }
    }

    private ArrayList<ActivityArtikel.CreateList> prepareArtikel(String t_beschreibung[],
                                                                 String t_ausfuehrung[], String t_iso[],
                                                                 Integer i_artikel[], Integer i_symbol[],
                                                                 String t_artnr1[], String t_farbe1[],
                                                                 String t_artnr2[], String t_farbe2[]){

        ArrayList<ActivityArtikel.CreateList> imgArtikel = new ArrayList<>();
        for(int i = 0; i< t_beschreibung.length; i++){
            CreateList createList = new CreateList();
            createList.setT_beschreibung(t_beschreibung[i]);
            createList.setT_ausfuehrung(t_ausfuehrung[i]);
            createList.setT_iso(t_iso[i]);
            createList.setI_artikel(i_artikel[i]);
            createList.setI_symbol(i_symbol[i]);
            createList.setT_artnr1(t_artnr1[i]);
            createList.setT_farbe1(t_farbe1[i]);
            createList.setT_artnr2(t_artnr2[i]);
            createList.setT_farbe2(t_farbe2[i]);
            imgArtikel.add(createList);
        }
        return imgArtikel;
    }

    private class get_Artikel extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                String url = "http://www.arndt-tool.de/app/php/json.php" + para;
                JSONArray jsonArray = new JSONArray(UtilDaten.getFromServer(url));

                TblArtikel artikel;

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    artikel = new TblArtikel(
                            jsonObject.has(TEILE) ? jsonObject.getInt(TEILE) : 1,
                            jsonObject.has(WARENGRUPPE) ? jsonObject.getString(WARENGRUPPE) : para,
                            jsonObject.has(ABMESSUNG) ? jsonObject.getString(ABMESSUNG) : "",
                            jsonObject.has(MASS) ? jsonObject.getString(MASS) : "",
                            jsonObject.has(ARTIKELNUMMER) ? jsonObject.getString(ARTIKELNUMMER) : "",
                            jsonObject.has(GEWICHT) ? jsonObject.getDouble(GEWICHT) : 0,
                            jsonObject.has(GEWICHTEINH) ? jsonObject.getString(GEWICHTEINH) : "",
                            jsonObject.has(GROESSEINCH) ? jsonObject.getString(GROESSEINCH) : "",
                            jsonObject.has(BESCHAFFUNG) ? jsonObject.getString(BESCHAFFUNG) : "",
                            jsonObject.has(VERPACKEINHTEXT) ? jsonObject.getString(VERPACKEINHTEXT) : "",
                            jsonObject.has(GROESSEINCHDEZ) ? jsonObject.getDouble(GROESSEINCHDEZ) : 0);

                    Log.d(TAG, "##getKapitel 164: " + artikel.toString());

                    artGruppe.add(artikel);
                    // ToDo Artikel-Daten in SQLite oder Firebase ablegen, evtl Firebase <=> mySQL Verbindung
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
            Log.d(TAG, "##onCreate: " + artGruppe.toString());
            String t_beschreibung[] = new String[artGruppe.size()];
            String t_ausfuehrung[] = new String[artGruppe.size()];
            String t_iso[] = new String[artGruppe.size()];
            Integer i_artikel[] = new Integer[artGruppe.size()];
            Integer i_symbol[] = new Integer[artGruppe.size()];
            String t_artnr1[] = new String[artGruppe.size()];
            String t_farbe1[] = new String[artGruppe.size()];
            String t_artnr2[] = new String[artGruppe.size()];
            String t_farbe2[] = new String[artGruppe.size()];

            int i = 0;
            for(TblArtikel gruppe : artGruppe){


                i++;
            }

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcKatGruppe);
            recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager;
            int orientation = getResources().getConfiguration().orientation;
            layoutManager = new GridLayoutManager(getApplicationContext(),1);
            recyclerView.setLayoutManager(layoutManager);
            ArrayList<ActivityArtikel.CreateList> artikelGruppes = prepareArtikel(t_beschreibung, t_ausfuehrung, t_iso, i_artikel, i_symbol, t_artnr1, t_farbe1, t_artnr2, t_farbe2);
            AdapterArtikel adapter = new AdapterArtikel(getApplicationContext(), artikelGruppes);
            recyclerView.setAdapter(adapter);

        }
    }
}
