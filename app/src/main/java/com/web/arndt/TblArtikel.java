package com.web.arndt;

// ToDo die Struktur für die Artikeldaten - OK
// Die Struktur orientiert sich an der bestehenden Struktur in der fs_web
public class TblArtikel {
    private int Teile;
    private String Warengruppe;
    private String Abmessung;
    private String Mass;
    private String Artikelnummer;
    private String Artikelnummer2;
    private double Gewicht;
    private String GewichtEinh;
    private String GroesseINCH;
    private String GroesseMM;
    private String laenge;
    private String staerke;
    private String Beschaffung;
    private int VerpackEinh;
    private String VerpackEinhText;
    private double VK;
    private double GroesseINCHdez;

    public TblArtikel(int teile, String warengruppe, String abmessung, String mass, String artikelnummer,
                      String artikelnummer2, double gewicht, String gewichtEinh, String groesseINCH,
                      String groesseMM, String laenge, String staerke, String beschaffung, int verpackEinh,
                      String verpackEinhText, double VK, double groesseINCHdez) {
        Teile = teile;
        Warengruppe = warengruppe;
        Abmessung = abmessung;
        Mass = mass;
        Artikelnummer = artikelnummer;
        Artikelnummer2 = artikelnummer2;
        Gewicht = gewicht;
        GewichtEinh = gewichtEinh;
        GroesseINCH = groesseINCH;
        GroesseMM = groesseMM;
        this.laenge = laenge;
        this.staerke = staerke;
        Beschaffung = beschaffung;
        VerpackEinh = verpackEinh;
        VerpackEinhText = verpackEinhText;
        this.VK = VK;
        GroesseINCHdez = groesseINCHdez;
    }

    public int getTeile() {
        return Teile;
    }

    public void setTeile(int teile) {
        Teile = teile;
    }

    public String getWarengruppe() {
        return Warengruppe;
    }

    public void setWarengruppe(String warengruppe) {
        Warengruppe = warengruppe;
    }

    public String getAbmessung() {
        return Abmessung;
    }

    public void setAbmessung(String abmessung) {
        Abmessung = abmessung;
    }

    public String getMass() {
        return Mass;
    }

    public void setMass(String mass) {
        Mass = mass;
    }

    public String getArtikelnummer() {
        return Artikelnummer;
    }

    public void setArtikelnummer(String artikelnummer) {
        Artikelnummer = artikelnummer;
    }

    public String getArtikelnummer2() {
        return Artikelnummer2;
    }

    public void setArtikelnummer2(String artikelnummer2) {
        Artikelnummer2 = artikelnummer2;
    }

    public double getGewicht() {
        return Gewicht;
    }

    public void setGewicht(double gewicht) {
        Gewicht = gewicht;
    }

    public String getGewichtEinh() {
        return GewichtEinh;
    }

    public void setGewichtEinh(String gewichtEinh) {
        GewichtEinh = gewichtEinh;
    }

    public String getGroesseINCH() {
        return GroesseINCH;
    }

    public void setGroesseINCH(String groesseINCH) {
        GroesseINCH = groesseINCH;
    }

    public String getBeschaffung() {
        return Beschaffung;
    }

    public void setBeschaffung(String beschaffung) {
        Beschaffung = beschaffung;
    }

    public String getVerpackEinhText() {
        return VerpackEinhText;
    }

    public void setVerpackEinhText(String verpackEinhText) {
        VerpackEinhText = verpackEinhText;
    }

    public double getGroesseINCHdez() {
        return GroesseINCHdez;
    }

    public void setGroesseINCHdez(double groesseINCHdez) {
        GroesseINCHdez = groesseINCHdez;
    }

    public String getGroesseMM() {
        return GroesseMM;
    }

    public void setGroesseMM(String groesseMM) {
        GroesseMM = groesseMM;
    }

    public String getLaenge() {
        return laenge;
    }

    public void setLaenge(String laenge) {
        this.laenge = laenge;
    }

    public String getStaerke() {
        return staerke;
    }

    public void setStaerke(String staerke) {
        this.staerke = staerke;
    }

    public int getVerpackEinh() {
        return VerpackEinh;
    }

    public void setVerpackEinh(int verpackEinh) {
        VerpackEinh = verpackEinh;
    }

    public double getVK() {
        return VK;
    }

    public void setVK(double VK) {
        this.VK = VK;
    }
}
