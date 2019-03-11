package com.web.arndt;

// ToDo die Struktur für die Anzeige des Kataloginhaltes - OK
// Die Struktur lehnt sich an die Struktur des Papierkataloges und der Web-Site an

public class Katalog {
    private String kapitel;
    private String imgName;
    private String katGrupText;
    private int von;
    private int bis;

    public Katalog(String kapitel, String imgName, String katGrupText, int von, int bis){
        this.kapitel = kapitel;
        this.imgName = imgName;
        this.katGrupText = katGrupText;
        this.von = von;
        this.bis = bis;
    }

    public String getImgName(){
        return imgName;
    }

    public String getKatGrupText(){
        return katGrupText;
    }

    public String getKapitel() {
        return kapitel;
    }

    public int getVon() {
        return von;
    }

    public int getBis() {
        return bis;
    }

    public String toSQL(){
         return "?kat" + kapitel;
    }

    @Override
    public String toString() {
        return "http://www.arndt-tool.de/app/img/menu/" + imgName;
    }
}
