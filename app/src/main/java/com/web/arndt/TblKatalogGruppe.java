package com.web.arndt;

// ToDo Struktur für die Katalogkapitel - OK
// Die Struktur orientiert sich an der bestehenden Struktur der Warengrppen in der fs_web
// und lehnt sich an die Struktur des Papierkataloges an

import android.os.Parcel;
import android.os.Parcelable;

public class TblKatalogGruppe implements Parcelable {
    private String sprache;
    private String kuerzel;
    private String gruppe;
    private String text;
    private String zusatz;
    private String uebersetzung;
    private String php_datei;
    private String symbol_grafik_1;
    private String symbol_grafik_2;
    private String symbol_grafik_3;
    private String symbol_grafik_4;
    private String masseinheit;
    private String artikel_zeile;
    private String kenn_art_2;
    private String ausfart1;
    private String ausfart2;
    private String noart1;
    private String noart2;
    private String sb;
    private String stueckliste;
    private String grafik2;
    private String zustext;
    private String neuheit;
    private String moaktion;
    private int schalter;

    public TblKatalogGruppe(Parcel parcel){
        this.sprache = parcel.readString();
        this.kuerzel = parcel.readString();
        this.gruppe = parcel.readString();
        this.text = parcel.readString();
        this.zusatz = parcel.readString();
        this.uebersetzung = parcel.readString();
        this.php_datei = parcel.readString();
        this.symbol_grafik_1 = parcel.readString();
        this.symbol_grafik_2 = parcel.readString();
        this.symbol_grafik_3 = parcel.readString();
        this.symbol_grafik_4 = parcel.readString();
        this.masseinheit = parcel.readString();
        this.artikel_zeile = parcel.readString();
        this.kenn_art_2 = parcel.readString();
        this.ausfart1 = parcel.readString();
        this.ausfart2 = parcel.readString();
        this.noart1 = parcel.readString();
        this.noart2 = parcel.readString();
        this.sb = parcel.readString();
        this.stueckliste = parcel.readString();
        this.grafik2 = parcel.readString();
        this.zustext = parcel.readString();
        this.neuheit = parcel.readString();
        this.moaktion = parcel.readString();
        this.schalter = parcel.readInt();
    }

    public TblKatalogGruppe(String sprache, String kuerzel, String gruppe, String text, String zusatz,
                            String uebersetzung, String php_datei, String symbol_grafik_1,
                            String symbol_grafik_2, String symbol_grafik_3, String symbol_grafik_4,
                            String masseinheit, String artikel_zeile, String kenn_art_2, String ausfart1,
                            String ausfart2, String noart1, String noart2, String sb, String stueckliste,
                            String grafik2, String zustext, String neuheit, String moaktion, int schalter) {
        this.sprache = sprache;
        this.kuerzel = kuerzel;
        this.gruppe = gruppe;
        this.text = text;
        this.zusatz = zusatz;
        this.uebersetzung = uebersetzung;
        this.php_datei = php_datei;
        this.symbol_grafik_1 = symbol_grafik_1;
        this.symbol_grafik_2 = symbol_grafik_2;
        this.symbol_grafik_3 = symbol_grafik_3;
        this.symbol_grafik_4 = symbol_grafik_4;
        this.masseinheit = masseinheit;
        this.artikel_zeile = artikel_zeile;
        this.kenn_art_2 = kenn_art_2;
        this.ausfart1 = ausfart1;
        this.ausfart2 = ausfart2;
        this.noart1 = noart1;
        this.noart2 = noart2;
        this.sb = sb;
        this.stueckliste = stueckliste;
        this.grafik2 = grafik2;
        this.zustext = zustext;
        this.neuheit = neuheit;
        this.moaktion = moaktion;
        this.schalter = schalter;
    }

    public String getSprache() {
        return sprache;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public String getGruppe() {
        return gruppe;
    }

    public String getText() {
        return text;
    }

    public String getZusatz() {
        return zusatz;
    }

    public String getUebersetzung() {
        return uebersetzung;
    }

    public String getPhp_datei() {
        return php_datei;
    }

    public String getSymbol_grafik_1() {
        return symbol_grafik_1;
    }

    public String getSymbol_grafik_2() {
        return symbol_grafik_2;
    }

    public String getSymbol_grafik_3() {
        return symbol_grafik_3;
    }

    public String getSymbol_grafik_4() {
        return symbol_grafik_4;
    }

    public String getMasseinheit() {
        return masseinheit;
    }

    public String getArtikel_zeile() {
        return artikel_zeile;
    }

    public String getKenn_art_2() {
        return kenn_art_2;
    }

    public String getAusfart1() {
        return ausfart1;
    }

    public String getAusfart2() {
        return ausfart2;
    }

    public String getNoart1() {
        return noart1;
    }

    public String getNoart2() {
        return noart2;
    }

    public String getSb() {
        return sb;
    }

    public String getStueckliste() {
        return stueckliste;
    }

    public String getGrafik2() {
        return grafik2;
    }

    public String getZustext() {
        return zustext;
    }

    public String getNeuheit() {
        return neuheit;
    }

    public String getMoaktion() {
        return moaktion;
    }

    public int getSchalter() {
        return schalter;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(sprache);
        parcel.writeString(kuerzel);
        parcel.writeString(gruppe);
        parcel.writeString(text);
        parcel.writeString(zusatz);
        parcel.writeString(uebersetzung);
        parcel.writeString(php_datei);
        parcel.writeString(symbol_grafik_1);
        parcel.writeString(symbol_grafik_2);
        parcel.writeString(symbol_grafik_3);
        parcel.writeString(symbol_grafik_4);
        parcel.writeString(masseinheit);
        parcel.writeString(artikel_zeile);
        parcel.writeString(kenn_art_2);
        parcel.writeString(ausfart1);
        parcel.writeString(ausfart2);
        parcel.writeString(noart1);
        parcel.writeString(noart2);
        parcel.writeString(sb);
        parcel.writeString(stueckliste);
        parcel.writeString(grafik2);
        parcel.writeString(zustext);
        parcel.writeString(neuheit);
        parcel.writeString(moaktion);
        parcel.writeInt(schalter);
    }

    public static final Parcelable.Creator<TblKatalogGruppe> CREATOR =
            new Parcelable.Creator<TblKatalogGruppe>(){

                @Override
                public TblKatalogGruppe createFromParcel(Parcel source) {
                    return new TblKatalogGruppe(source);
                }

                @Override
                public TblKatalogGruppe[] newArray(int size) {
                    return new TblKatalogGruppe[size];
                }
            };
}
