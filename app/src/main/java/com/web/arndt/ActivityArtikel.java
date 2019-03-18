package com.web.arndt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ToDo Anzeige des ausgeählten Artikels
//      ToDo Artikel laden und richtige Darstellung wählen
//      ToDo für Stücklistenartikel Stückliste nachladen und darstellen
// ToDo Für angemeldete Bestandskunden mit Preisen, Rabatten, TZ
// ToDo Für angemeldete Bestandskunden mit Bestellmöglichkeit


public class ActivityArtikel extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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
    public List<TblKatalogGruppe> katGruppe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_artikel);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // gewählter Artikel (oder Artikelgruppe) wird übergeben
        katGruppe = getIntent().getParcelableArrayListExtra("katalog");

        String kuerzel[] = new String[katGruppe.size()];
        String t_text[] = new String[katGruppe.size()];
        String t_zusatz[] = new String[katGruppe.size()];
        String t_iso[] = new String[katGruppe.size()];
        Integer i_artikel[] = new Integer[katGruppe.size()];
        Integer i_symbol1[] = new Integer[katGruppe.size()];
        String t_noArt1[] = new String[katGruppe.size()];
        String t_ausfArt1[] = new String[katGruppe.size()];
        String t_noArt2[] = new String[katGruppe.size()];
        String t_ausfArt2[] = new String[katGruppe.size()];
        String sprache[] = new String[katGruppe.size()];
        String gruppe[] = new String[katGruppe.size()];
        String uebersetzung[] = new String[katGruppe.size()];
        String php_datei[] = new String[katGruppe.size()];
        String symbol_grafik_2[] = new String[katGruppe.size()];
        String symbol_grafik_3[] = new String[katGruppe.size()];
        String symbol_grafik_4[] = new String[katGruppe.size()];
        String masseinheit[] = new String[katGruppe.size()];
        int artikel_zeile[] = new int[katGruppe.size()];
        String kenn_art_2[] = new String[katGruppe.size()];
        String sb[] = new String[katGruppe.size()];
        String stueckliste[] = new String[katGruppe.size()];
        String grafik2[] = new String[katGruppe.size()];
        String zustext[] = new String[katGruppe.size()];
        String neuheit[] = new String[katGruppe.size()];
        String moaktion[] = new String[katGruppe.size()];
        int schalter[] = new int[katGruppe.size()];

        String ni_artikel;
        String ni_symbol;

        int i = 0;
        for(TblKatalogGruppe artGruppe : katGruppe){

            kuerzel[i] = artGruppe.getKuerzel();
            t_text[i] = artGruppe.getText();
            t_zusatz[i] = artGruppe.getZusatz();
            t_iso[i] = artGruppe.getZusatz();
            ni_artikel = ("p"+ artGruppe.getKuerzel())
                    .replace("-","_")
                    .replace("_mm","")
                    .replace("_inch","").trim();

            ni_symbol = ("s"+ artGruppe.getSymbol_grafik_1())
                    .replace("-","_").toLowerCase().trim();

            i_artikel[i] = getResources().getIdentifier(ni_artikel,
                    "mipmap",getPackageName());
            i_symbol1[i] = getResources().getIdentifier(ni_symbol,
                    "drawable",getPackageName());

            t_noArt1[i] = artGruppe.getNoart1();
            t_ausfArt1[i] = artGruppe.getAusfart1();
            t_noArt2[i] = artGruppe.getNoart2();
            t_ausfArt2[i] = artGruppe.getAusfart2();
            sprache[i] = artGruppe.getSprache();
            gruppe[i] = artGruppe.getGruppe();
            uebersetzung[i] = artGruppe.getUebersetzung();
            php_datei[i] = artGruppe.getPhp_datei();
            symbol_grafik_2[i] = artGruppe.getSymbol_grafik_2();
            symbol_grafik_3[i] = artGruppe.getSymbol_grafik_3();
            symbol_grafik_4[i] = artGruppe.getSymbol_grafik_4();
            masseinheit[i] = artGruppe.getMasseinheit();
            artikel_zeile[i] = artGruppe.getArtikel_zeile();
            kenn_art_2[i] = artGruppe.getKenn_art_2();
            sb[i] = artGruppe.getSb();
            stueckliste[i] = artGruppe.getStueckliste();
            grafik2[i] = artGruppe.getGrafik2();
            zustext[i] = artGruppe.getZustext();
            neuheit[i] = artGruppe.getNeuheit();
            moaktion[i] = artGruppe.getMoaktion();
            schalter[i] = artGruppe.getSchalter();

            i++;
        }

        RecyclerView recyclerView = findViewById(R.id.rcArtikel);
        recyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager;
        int orientation = getResources().getConfiguration().orientation;
        layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<CreateList.ArtGruppe> artGruppes = prepareData(kuerzel, t_text, t_zusatz, t_iso, i_artikel,
                i_symbol1, t_noArt1, t_ausfArt1, t_noArt2, t_ausfArt2);
        AdapterArtikel adapter = new AdapterArtikel(getApplicationContext(), artGruppes);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        new UtilNav().onNavigation(this, item);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private ArrayList<CreateList.ArtGruppe> prepareData(String[] kuerzel, String[] t_text, String[] t_zusatz,
                                                        String[] t_iso, Integer[] i_artikel, Integer[] i_symbol,
                                                        String[] t_noArt1, String[] t_ausfArt1,
                                                        String[] t_noArt2, String[] t_ausfArt2){

        ArrayList<CreateList.ArtGruppe> grpArtikel = new ArrayList<>();
        for(int i = 0; i< t_text.length; i++){
            CreateList.ArtGruppe createList = new CreateList.ArtGruppe();
            createList.setKuerzel(kuerzel[i]);
            createList.setT_text(t_text[i]);
            createList.setT_zusatz(t_zusatz[i]);
            createList.setT_iso(t_iso[i]);
            createList.setI_artikel(i_artikel[i]);
            createList.setI_symbol(i_symbol[i]);
            createList.setT_noArt1(t_noArt1[i]);
            createList.setT_ausfArt1(t_ausfArt1[i]);
            createList.setT_noArt2(t_noArt2[i]);
            createList.setT_ausfArt2(t_ausfArt2[i]);
            grpArtikel.add(createList);
        }
        return grpArtikel;
    }

}
