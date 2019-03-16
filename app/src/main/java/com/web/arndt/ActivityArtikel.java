package com.web.arndt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

// ToDo Anzeige des ausgeählten Artikels
//      ToDo Artikel laden und richtige Darstellung wählen
//      ToDo für Stücklistenartikel Stückliste nachladen und darstellen
// ToDo Für angemeldete Bestandskunden mit Preisen, Rabatten, TZ
// ToDo Für angemeldete Bestandskunden mit Bestellmöglichkeit


public class ActivityArtikel extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
