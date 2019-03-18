package com.web.arndt;

public class CreateList {
    // Ausgabeklassen für RecyclingViews

    public static class Gruppe {
        // Ausgabe für rcKatGruppe in activity_sucherg (Ausgabelayout cell_katalog)
        private String t_artikel;
        private String t_mass;
        private Integer i_artikel;
        private Integer i_symbol;

        public String getT_artikel() {
            return t_artikel;
        }

        public void setT_artikel(String t_artikel) {
            this.t_artikel = t_artikel;
        }

        public String getT_mass() {
            return t_mass;
        }

        public void setT_mass(String t_mass) {
            this.t_mass = t_mass;
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
    }

    public static class ArtGruppe{
        String kuerzel;
        String t_text;
        String t_zusatz;
        String t_iso;
        Integer i_artikel;
        Integer i_symbol;
        String t_noArt1;
        String t_ausfArt1;
        String t_noArt2;
        String t_ausfArt2;
        String sprache;
        String gruppe;
        String uebersetzung;
        String php_datei;
        String symbol_grafik_2;
        String symbol_grafik_3;
        String symbol_grafik_4;
        String masseinheit;
        int artikel_zeile;
        String kenn_art_2;
        String sb;
        String stueckliste;
        String grafik2;
        String zustext;
        String neuheit;
        String moaktion;
        int schalter;

        public String getSprache() {return sprache;}
        public void setSprache(String sprache) { this.sprache = sprache; }

        public String getGruppe() {return gruppe;}
        public void setGruppe(String gruppe) {this.gruppe = gruppe;}

        public String getUebersetzung() {return uebersetzung;}
        public void setUebersetzung(String uebersetzung) {this.uebersetzung = uebersetzung;}

        public String getPhp_datei() {return php_datei;}
        public void setPhp_datei(String php_datei) {this.php_datei = php_datei;}

        public String getSymbol_grafik_2() {return symbol_grafik_2;}
        public void setSymbol_grafik_2(String symbol_grafik_2) {this.symbol_grafik_2 = symbol_grafik_2;}

        public String getSymbol_grafik_3() {return symbol_grafik_3;}
        public void setSymbol_grafik_3(String symbol_grafik_3) {this.symbol_grafik_3 = symbol_grafik_3;}

        public String getSymbol_grafik_4() {return symbol_grafik_4;}
        public void setSymbol_grafik_4(String symbol_grafik_4) {this.symbol_grafik_4 = symbol_grafik_4;}

        public String getMasseinheit() {return masseinheit;}
        public void setMasseinheit(String masseinheit) {this.masseinheit = masseinheit;}

        public int getArtikel_zeile() {return artikel_zeile;}
        public void setArtikel_zeile(int artikel_zeile) {this.artikel_zeile = artikel_zeile;}

        public String getKenn_art_2() {return kenn_art_2;}
        public void setKenn_art_2(String kenn_art_2) {this.kenn_art_2 = kenn_art_2;}

        public String getSb() {return sb;}
        public void setSb(String sb) {this.sb = sb;}

        public String getStueckliste() {return stueckliste;}
        public void setStueckliste(String stueckliste) {this.stueckliste = stueckliste;}

        public String getGrafik2() {return grafik2;}
        public void setGrafik2(String grafik2) {this.grafik2 = grafik2;}

        public String getZustext() {return zustext;}
        public void setZustext(String zustext) {this.zustext = zustext;}

        public String getNeuheit() {return neuheit;}
        public void setNeuheit(String neuheit) {this.neuheit = neuheit;}

        public String getMoaktion() {return moaktion;}
        public void setMoaktion(String moaktion) {this.moaktion = moaktion;}

        public int getSchalter() {return schalter;}
        public void setSchalter(int schalter) {this.schalter = schalter;}

        public String getKuerzel() {return kuerzel;}
        public void setKuerzel(String kuerzel) {this.kuerzel = kuerzel;}

        public String getT_text() {return t_text;}
        public void setT_text(String t_text) {
            this.t_text = t_text;
        }

        public String getT_zusatz() {
            return t_zusatz;
        }
        public void setT_zusatz(String t_zusatz) {
            this.t_zusatz = t_zusatz;
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

        public String getT_noArt1() {
            return t_noArt1;
        }
        public void setT_noArt1(String t_noArt1) {
            this.t_noArt1 = t_noArt1;
        }

        public String getT_ausfArt1() {
            return t_ausfArt1;
        }
        public void setT_ausfArt1(String t_ausfArt1) {
            this.t_ausfArt1 = t_ausfArt1;
        }

        public String getT_noArt2() {
            return t_noArt2;
        }
        public void setT_noArt2(String t_noArt2) {
            this.t_noArt2 = t_noArt2;
        }

        public String getT_ausfArt2() {
            return t_ausfArt2;
        }
        public void setT_ausfArt2(String t_ausfArt2) {
            this.t_ausfArt2 = t_ausfArt2;
        }
    }

    public static class Artikel {
        // Ausgabe für rcArtikel in fragment_artikel (Ausgabelayout cell_artikel_xxx)

        private String t_beschreibung;
        private String t_ausfuehrung;
        private String t_iso;
        private Integer i_artikel;
        private Integer i_symbol;
        private String t_artnr1;
        private String t_farbe1;
        private String t_artnr2;
        private String t_farbe2;

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

    public static class Variante {
        // Ausgabe für rcVarianten in cell_Artikel_xxx (Ausgabelayout cell_art_varianten_xxx)
        private String t_mass;
        private String t_abm;
        private int t_verp;
        private double t_gew;
        private String t_no1;
        private String t_no2;

        public String getT_mass() {
            return t_mass;
        }

        public void setT_mass(String t_mass) {
            this.t_mass = t_mass;
        }

        public String getT_abm() {
            return t_abm;
        }

        public void setT_abm(String t_abm) {
            this.t_abm = t_abm;
        }

        public int getT_verp() {
            return t_verp;
        }

        public void setT_verp(int t_verp) {
            this.t_verp = t_verp;
        }

        public double getT_gew() {
            return t_gew;
        }

        public void setT_gew(double t_gew) {
            this.t_gew = t_gew;
        }

        public String getT_no1() {
            return t_no1;
        }

        public void setT_no1(String t_no1) {
            this.t_no1 = t_no1;
        }

        public String getT_no2() {
            return t_no2;
        }

        public void setT_no2(String t_no2) {
            this.t_no2 = t_no2;
        }
    }

    public class Stuecke {
        // Ausgabe für rcStuecke in ??? (Ausgabelayout ???)
        // ToDo Ausgabelayout für Stücklisten anlegen

    }
}
