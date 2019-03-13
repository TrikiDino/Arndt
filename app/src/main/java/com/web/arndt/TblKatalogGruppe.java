package com.web.arndt;

// ToDo Struktur für die Katalogkapitel
// Die Struktur orientiert sich an der bestehenden Struktur der Warengrppen in der fs_web
// und lehnt sich an die Struktur des Papierkataloges an

public class TblKatalogGruppe {
    private String sprache = "Sprache";
    private String kuerzel = "Kuerzel";
    private String gruppe = "Gruppe";
    private String text = "Text";
    private String zusatz = "Zusatz";
    private String uebersetzung = "Uebersetzung";
    private String php_datei = "PHP_Datei";
    private String symbol_grafik_1 = "Symbol_Grafik_1";
    private String symbol_grafik_2 = "Symbol_Grafik_2";
    private String symbol_grafik_3 = "Symbol_Grafik_3";
    private String symbol_grafik_4 = "Symbol_Grafik_4";
    private String masseinheit = "Masseinheit";
    private String artikel_zeile = "Artikel_Zeile";
    private String kenn_art_2 = "Kenn_Art_2";
    private String ausfart1 = "AusfArt1";
    private String ausfart2 = "AusfArt2";
    private String noart1 = "NoArt1";
    private String noart2 = "NoArt2";
    private String sb = "SB";
    private String stueckliste = "TblStueckliste";
    private String grafik2 = "Grafik2";
    private String zustext = "zusText";
    private String neuheit = "Neuheit";
    private String moaktion = "MoAktion";
    private String schalter = "Schalter";
    private String sort = "Sort";

    public TblKatalogGruppe(String sprache, String kuerzel, String gruppe, String text, String zusatz,
                            String uebersetzung, String php_datei, String symbol_grafik_1,
                            String symbol_grafik_2, String symbol_grafik_3, String symbol_grafik_4,
                            String masseinheit, String artikel_zeile, String kenn_art_2, String ausfart1,
                            String ausfart2, String noart1, String noart2, String sb, String stueckliste,
                            String grafik2, String zustext, String neuheit, String moaktion,
                            String schalter, String sort) {
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
        this.sort = sort;
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

    public String getSchalter() {
        return schalter;
    }

    public String getSort() {
        return sort;
    }
}
