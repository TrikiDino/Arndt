package com.web.arndt;

// ToDo die Struktur für die Artikeldaten - OK
// Die Struktur orientiert sich an der bestehenden Struktur in der fs_web
public class TblArtikel {
    private int Teile;
    private String Warengruppe;
    private String Abmessung;
    private String Mass;
    private String Artikelnummer;
    private double Gewicht;
    private String GewichtEinh;
    private String GroesseINCH;
    private String Beschaffung;
    private String VerpackEinhText;
    private double GroesseINCHdez;

    public TblArtikel(int teile, String warengruppe, String abmessung, String mass, String artikelnummer,
                      double gewicht, String gewichtEinh, String groesseINCH, String beschaffung,
                      String verpackEinhText, double groesseINCHdez) {
        Teile = teile;
        Warengruppe = warengruppe;
        Abmessung = abmessung;
        Mass = mass;
        Artikelnummer = artikelnummer;
        Gewicht = gewicht;
        GewichtEinh = gewichtEinh;
        GroesseINCH = groesseINCH;
        Beschaffung = beschaffung;
        VerpackEinhText = verpackEinhText;
        GroesseINCHdez = groesseINCHdez;
    }
}
