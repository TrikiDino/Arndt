package com.web.arndt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UtilDaten {
    private static final String TAG = UtilDaten.class.getSimpleName();
    private static final String URL = "http://www.arndt-tool.de/app/php/json.php";
    private static final String KEY = "d5c4b212974962c8406a035fe3c4b5fc";

    //TblKatalog Kapitel
    private static final String KAPITEL = "Kapitel";
    private static final String IMGNAME = "imgName";
    private static final String KATGRUPTEXT = "katGrupText";
    private static final String VON = "von";
    private static final String BIS = "bis";

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

    public static String getFromServer(String url) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        java.net.URL _url = new URL(url);
        Log.d(TAG, "##getFromServer 64: " + url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) _url.openConnection();
        Log.d(TAG, "##getFromServer 66: " + httpURLConnection.toString());
//        final int responseCode = httpURLConnection.getResponseCode();
        Log.d(TAG, "##getFromServer 68: " + URL);

//        if (responseCode == HttpURLConnection.HTTP_OK) {
        if(true){
            Log.d(TAG, "##getFromServer 72: ");
            InputStreamReader streamReader = new InputStreamReader(httpURLConnection.getInputStream());
            Log.d(TAG, "##getFromServer 74: " + streamReader.toString());
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
        }
        httpURLConnection.disconnect();
        Log.d(TAG, "##getFromServer: " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static TblKatalog[] getKatalog() throws JSONException, IOException {

        TblKatalog[] ergKat = null;

        JSONObject jsonObject = new JSONObject(getFromServer(R.string.json + ""));


        Log.d(TAG, "##getKatalog: " + jsonObject.toString());


        return ergKat;
    }

    public static TblKatalogGruppe[] get_Kapitel(String para) throws JSONException, IOException {

        Log.d(TAG, "##get_Kapitel: " + para);
        Log.d(TAG, "##get_Kapitel: " + R.string.json);
        JSONArray jsonArray = new JSONArray(getFromServer("http://www.arndt-tool.de/app/php/json.php" + para));
        TblKatalogGruppe[] katGruppe = new TblKatalogGruppe[jsonArray.length()];

        Log.d(TAG, "##getKapitel: " + jsonArray.toString());

        for(int i = 0; i < jsonArray.length(); i++) {
            Log.d(TAG, "##getKapitel: " + jsonArray.length());
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            katGruppe[i] = new TblKatalogGruppe(
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
                    jsonObject.has(SCHALTER) ? jsonObject.getString(SCHALTER) : "",
                    jsonObject.has(SORT) ? jsonObject.getString(SORT) : "");

            Log.d(TAG, "##getKapitel: " + katGruppe[i].toString());
            // ToDo Kapitel-Daten in SQLite ablegen
        }

        return katGruppe;

    }

    public static TblArtikel[] getArtikel(String para) throws JSONException, IOException {

        // ToDo TblArtikel abrufen und zu Anzeige bereit stellen
        JSONObject jsonObject = new JSONObject(getFromServer(R.string.json + para));

        // ToDo Artikel-Daten in SQLite ablegen
        return null;

    }

    public static TblStueckliste[] getStueckliste(String para) throws JSONException, IOException {

        // ToDo Stückliste abrufen und zur Anzeige bereit stellen
        JSONObject jsonObject = new JSONObject(getFromServer(R.string.json + para));

        // ToDo Stücklisten-Daten in SQLite ablegen
        return null;

    }

    public static Bitmap getImage(TblKatalog katalog) throws IOException {

        // ToDo Grafik aus Web laden, wenn nicht lokal vorhanden
        java.net.URL req = new URL(katalog.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) req.openConnection();
        Bitmap bmp = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        httpURLConnection.disconnect();
        return bmp;

        // ToDo wenn Lokal gesetzt, Grafik im mipmap speichern
    }

}
