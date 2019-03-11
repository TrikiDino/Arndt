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
import java.text.MessageFormat;

public class DatenUtil {
    private static final String TAG = DatenUtil.class.getSimpleName();
    private static final String URL = "http://www.arndt-tool.de/app/php/json.php";
    private static final String KEY = "d5c4b212974962c8406a035fe3c4b5fc";

    //Katalog Kapitel
    private static final String KAPITEL = "Kapitel";
    private static final String IMGNAME = "imgName";
    private static final String KATGRUPTEXT = "katGrupText";
    private static final String VON = "von";
    private static final String BIS = "bis";

    // Katalog Kapitel Verzeichnis
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
    private static final String STUECKLISTE = "Stueckliste";
    private static final String GRAFIK2 = "Grafik2";
    private static final String ZUSTEXT = "zusText";
    private static final String NEUHEIT = "Neuheit";
    private static final String MOAKTION = "MoAktion";
    private static final String SCHALTER = "Schalter";
    private static final String SORT = "Sort";

    // Artikel

    // Stückliste

    public static String getFromServer(String url) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        java.net.URL _url = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) _url.openConnection();
        final int responseCode = httpURLConnection.getResponseCode();
        Log.d(TAG, "getFromServer: " + URL+KEY);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
        }
        httpURLConnection.disconnect();
        Log.d(TAG, "getFromServer: " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static Katalog[] getKatalog() throws JSONException, IOException {
        String kapitel = null;
        String imgName = null;
        String katGrupText = null;
        int von = 0;
        int bis = 0;
        Katalog[] ergKat = null;

        JSONObject jsonObject = new JSONObject(getFromServer(R.string.json + ""));

        Log.d(TAG, "getKatalog: " + jsonObject.toString());


        return ergKat;
    }

    public static KatalogGruppe[] getKapitel(String para) throws JSONException, IOException {

        JSONObject jsonObject = new JSONObject(getFromServer(R.string.json + para));
        return null;

    }

    public static Artikel[] getArtikel(String para) throws JSONException, IOException {

        // ToDo Artikel abrufen und zu Anzeige bereit stellen
        JSONObject jsonObject = new JSONObject(getFromServer(R.string.json + para));
        return null;

    }

    public static Stueckliste[] getStueckliste(String para) throws JSONException, IOException {

        // ToDo Stückliste abrufen und zur Anzeige bereit stellen
        JSONObject jsonObject = new JSONObject(getFromServer(R.string.json + para));
        return null;

    }

    public static Bitmap getImage(Katalog katalog) throws IOException {

        // ToDo Grafik aus Web laden, wenn nicht lokal vorhanden
        java.net.URL req = new URL(katalog.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) req.openConnection();
        Bitmap bmp = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        httpURLConnection.disconnect();
        return bmp;
    }

}
