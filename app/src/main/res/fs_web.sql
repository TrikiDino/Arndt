-- phpMyAdmin SQL Dump
-- version 4.0.0
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 11. Mrz 2019 um 09:37
-- Server Version: 5.5.25a
-- PHP-Version: 5.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `fs_web`
--

-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `v_aktion`
--
CREATE TABLE IF NOT EXISTS `v_aktion` (
`Artikelnummer` varchar(100)
,`Menge` int(10)
,`Preiseinheit` int(10)
,`Preis` decimal(19,4)
,`Rab1` double(15,5)
,`Rab2` double(15,5)
,`Rab3` double(15,5)
,`Aufs1` double(15,5)
,`Aufs2` double(15,5)
,`Warengruppe` varchar(15)
);
-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `v_artikel`
--
CREATE TABLE IF NOT EXISTS `v_artikel` (
`Teile` int(11)
,`Warengruppe` varchar(15)
,`Abmessung` varchar(255)
,`Mass` varchar(10)
,`Artikelnummer` varchar(100)
,`Gewicht` double(15,5)
,`GewichtEinh` varchar(3)
,`GroesseINCH` varchar(10)
,`GroesseMM` varchar(10)
,`laenge` varchar(10)
,`staerke` varchar(10)
,`Beschaffung` varchar(3)
,`VerpackEinh` int(10)
,`VerpackEinhText` varchar(3)
,`VK` decimal(19,4)
,`GroesseINCHdez` double
);
-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `v_art_wg`
--
CREATE TABLE IF NOT EXISTS `v_art_wg` (
`Artikelnummer` varchar(100)
,`Warengruppe` varchar(15)
,`Abmessung` varchar(255)
,`Bezeichnung1` varchar(255)
,`PHP_Datei` varchar(20)
,`Symbol_Grafik_1` varchar(20)
,`Symbol_Grafik_2` varchar(20)
,`Symbol_Grafik_3` varchar(20)
,`Masseinheit` char(10)
,`Artikel_Zeile` varchar(255)
,`Kenn_Art_2` char(10)
,`SB` char(3)
,`Stueckliste` varchar(255)
,`Grafik2` varchar(255)
,`zusText` varchar(255)
,`Neuheit` char(3)
,`MoAktion` varchar(15)
,`Schalter` int(3)
);
-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `v_kunden`
--
CREATE TABLE IF NOT EXISTS `v_kunden` (
`Kundennummer` int(10)
,`Vorname` varchar(50)
,`Name1` varchar(50)
,`Name2` varchar(50)
,`Name3` varchar(50)
,`Strasse` varchar(100)
,`LKZ` varchar(3)
,`Postleitzahl` varchar(10)
,`Ort` varchar(50)
,`Sprache` varchar(3)
,`Grundrabatt` double(15,5)
,`TZ` double(15,5)
,`Preisliste` varchar(255)
,`pw` varchar(20)
);
-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `v_pdatum`
--
CREATE TABLE IF NOT EXISTS `v_pdatum` (
`GueltigAb` datetime
);
-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `v_preise`
--
CREATE TABLE IF NOT EXISTS `v_preise` (
`XKunde` int(10)
,`XArtikel` varchar(100)
,`EAN` varchar(20)
,`Bezeichnung1` varchar(255)
,`XBasis` varchar(3)
,`KdArtikelnummer` varchar(255)
,`RMenge` int(10)
,`Preis` double(19,4)
,`Preiseinheit` int(10)
,`GueltigAb` datetime
,`Rab1` double(15,5)
,`Rab2` double(15,5)
,`Rab3` double(15,5)
,`Aufs1` double(15,5)
,`Aufs2` double(15,5)
,`Warengruppe` varchar(15)
);
-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `v_stuecke`
--
CREATE TABLE IF NOT EXISTS `v_stuecke` (
`Artikelnummer` varchar(100)
,`Warengruppe` varchar(15)
,`Teilartikel` varchar(100)
,`MengeTeil` int(10)
,`Abmessung` varchar(255)
,`Bezeichnung1` varchar(255)
,`PHP_Datei` varchar(20)
,`Symbol_Grafik_1` varchar(20)
,`Symbol_Grafik_2` varchar(20)
,`Symbol_Grafik_3` varchar(20)
,`Masseinheit` char(10)
,`Artikel_Zeile` varchar(255)
,`Kenn_Art_2` char(10)
,`SB` char(3)
,`Stueckliste` varchar(255)
,`Grafik2` varchar(255)
,`zusText` varchar(255)
,`Neuheit` char(3)
,`MoAktion` varchar(15)
,`Schalter` int(3)
);
-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `v_stueckeanz`
--
CREATE TABLE IF NOT EXISTS `v_stueckeanz` (
`Artikelnummer` varchar(100)
,`Warengruppe` varchar(15)
,`Anz` bigint(21)
);
-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `v_wg`
--
CREATE TABLE IF NOT EXISTS `v_wg` (
`Sprache` char(3)
,`Kuerzel` varchar(15)
,`Gruppe` varchar(25)
,`Text` text
,`Zusatz` varchar(255)
,`Uebersetzung` varchar(255)
,`PHP_Datei` varchar(20)
,`Symbol_Grafik_1` varchar(20)
,`Symbol_Grafik_2` varchar(20)
,`Symbol_Grafik_3` varchar(20)
,`Symbol_Grafik_4` varchar(25)
,`Masseinheit` char(10)
,`Artikel_Zeile` varchar(255)
,`Kenn_Art_2` char(10)
,`AusfArt1` varchar(100)
,`AusfArt2` varchar(100)
,`NoArt1` varchar(30)
,`NoArt2` varchar(30)
,`SB` char(3)
,`Stueckliste` varchar(255)
,`Grafik2` varchar(255)
,`zusText` varchar(255)
,`Neuheit` char(3)
,`MoAktion` varchar(15)
,`Schalter` int(3)
,`Sort` int(11)
);
-- --------------------------------------------------------

--
-- Struktur des Views `v_aktion`
--
DROP TABLE IF EXISTS `v_aktion`;

CREATE ALGORITHM=UNDEFINED DEFINER=`BSteiner`@`%` SQL SECURITY DEFINER VIEW `v_aktion` AS select `pa`.`Artikelnummer` AS `Artikelnummer`,`pa`.`Menge` AS `Menge`,`pa`.`Preiseinheit` AS `Preiseinheit`,`pa`.`Preis` AS `Preis`,`pa`.`Rab1` AS `Rab1`,`pa`.`Rab2` AS `Rab2`,`pa`.`Rab3` AS `Rab3`,`pa`.`Aufs1` AS `Aufs1`,`pa`.`Aufs2` AS `Aufs2`,`art`.`Warengruppe` AS `Warengruppe` from (`faktura simplicisimus`.`artikelaktionspreise` `pa` join `v_artikel` `art` on((`pa`.`Artikelnummer` = `art`.`Artikelnummer`))) where (`pa`.`AktivAb` <= curdate());

-- --------------------------------------------------------

--
-- Struktur des Views `v_artikel`
--
DROP TABLE IF EXISTS `v_artikel`;

CREATE ALGORITHM=UNDEFINED DEFINER=`BSteiner`@`%` SQL SECURITY DEFINER VIEW `v_artikel` AS select `sta`.`Teile` AS `Teile`,`sta`.`Warengruppe` AS `Warengruppe`,`sta`.`Abmessung` AS `Abmessung`,`sta`.`Mass` AS `Mass`,`sta`.`Artikelnummer` AS `Artikelnummer`,`sta`.`Gewicht` AS `Gewicht`,`sta`.`GewichtEinh` AS `GewichtEinh`,`sta`.`GroesseINCH` AS `GroesseINCH`,`sta`.`GroesseMM` AS `GroesseMM`,`sta`.`laenge` AS `laenge`,`sta`.`staerke` AS `staerke`,`sta`.`Beschaffung` AS `Beschaffung`,`sta`.`VerpackEinh` AS `VerpackEinh`,`sta`.`VerpackEinhText` AS `VerpackEinhText`,`sta`.`VK` AS `VK`,(left(`sta`.`GroesseINCH`,(locate('/',`sta`.`GroesseINCH`) - 1)) / right(`sta`.`GroesseINCH`,(length(`sta`.`GroesseINCH`) - locate('/',`sta`.`GroesseINCH`)))) AS `GroesseINCHdez` from (`faktura simplicisimus`.`artikelstammdaten` `sta` join `faktura simplicisimus`.`warengruppe` `wg` on((`sta`.`Warengruppe` = `wg`.`Kuerzel`))) where ((`wg`.`Schalter` > 0) and (`wg`.`Schalter` is not null));

-- --------------------------------------------------------

--
-- Struktur des Views `v_art_wg`
--
DROP TABLE IF EXISTS `v_art_wg`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_art_wg` AS select `sta`.`Artikelnummer` AS `Artikelnummer`,`sta`.`Warengruppe` AS `Warengruppe`,`sta`.`Abmessung` AS `Abmessung`,`sta`.`Bezeichnung1` AS `Bezeichnung1`,`v_wg`.`PHP_Datei` AS `PHP_Datei`,`v_wg`.`Symbol_Grafik_1` AS `Symbol_Grafik_1`,`v_wg`.`Symbol_Grafik_2` AS `Symbol_Grafik_2`,`v_wg`.`Symbol_Grafik_3` AS `Symbol_Grafik_3`,`v_wg`.`Masseinheit` AS `Masseinheit`,`v_wg`.`Artikel_Zeile` AS `Artikel_Zeile`,`v_wg`.`Kenn_Art_2` AS `Kenn_Art_2`,`v_wg`.`SB` AS `SB`,`v_wg`.`Stueckliste` AS `Stueckliste`,`v_wg`.`Grafik2` AS `Grafik2`,`v_wg`.`zusText` AS `zusText`,`v_wg`.`Neuheit` AS `Neuheit`,`v_wg`.`MoAktion` AS `MoAktion`,`v_wg`.`Schalter` AS `Schalter` from (`faktura simplicisimus`.`artikelstammdaten` `sta` join `v_wg` on((`sta`.`Warengruppe` = `v_wg`.`Kuerzel`)));

-- --------------------------------------------------------

--
-- Struktur des Views `v_kunden`
--
DROP TABLE IF EXISTS `v_kunden`;

CREATE ALGORITHM=UNDEFINED DEFINER=`BSteiner`@`%` SQL SECURITY DEFINER VIEW `v_kunden` AS select `faktura simplicisimus`.`kundenstammdaten`.`Kundennummer` AS `Kundennummer`,`faktura simplicisimus`.`kundenstammdaten`.`Vorname` AS `Vorname`,`faktura simplicisimus`.`kundenstammdaten`.`Name1` AS `Name1`,`faktura simplicisimus`.`kundenstammdaten`.`Name2` AS `Name2`,`faktura simplicisimus`.`kundenstammdaten`.`Name3` AS `Name3`,`faktura simplicisimus`.`kundenstammdaten`.`Strasse` AS `Strasse`,`faktura simplicisimus`.`kundenstammdaten`.`LKZ` AS `LKZ`,`faktura simplicisimus`.`kundenstammdaten`.`Postleitzahl` AS `Postleitzahl`,`faktura simplicisimus`.`kundenstammdaten`.`Ort` AS `Ort`,`faktura simplicisimus`.`kundenstammdaten`.`Sprache` AS `Sprache`,`faktura simplicisimus`.`kundenstammdaten`.`Grundrabatt` AS `Grundrabatt`,`faktura simplicisimus`.`kundenstammdaten`.`TZ` AS `TZ`,`faktura simplicisimus`.`kundenstammdaten`.`Preisliste` AS `Preisliste`,`faktura simplicisimus`.`kundenstammdaten`.`pw` AS `pw` from `faktura simplicisimus`.`kundenstammdaten`;

-- --------------------------------------------------------

--
-- Struktur des Views `v_pdatum`
--
DROP TABLE IF EXISTS `v_pdatum`;

CREATE ALGORITHM=UNDEFINED DEFINER=`BSteiner`@`%` SQL SECURITY DEFINER VIEW `v_pdatum` AS select max(`faktura simplicisimus`.`preissystem`.`GueltigAb`) AS `GueltigAb` from `faktura simplicisimus`.`preissystem` where ((`faktura simplicisimus`.`preissystem`.`Status` = 'A') and (`faktura simplicisimus`.`preissystem`.`GueltigAb` < curdate()));

-- --------------------------------------------------------

--
-- Struktur des Views `v_preise`
--
DROP TABLE IF EXISTS `v_preise`;

CREATE ALGORITHM=UNDEFINED DEFINER=`BSteiner`@`%` SQL SECURITY DEFINER VIEW `v_preise` AS select `ap`.`XKunde` AS `XKunde`,`ap`.`XArtikel` AS `XArtikel`,`ap`.`EAN` AS `EAN`,`ap`.`Bezeichnung1` AS `Bezeichnung1`,`ap`.`XBasis` AS `XBasis`,`ap`.`KdArtikelnummer` AS `KdArtikelnummer`,`ap`.`RMenge` AS `RMenge`,`ap`.`Preis` AS `Preis`,`ap`.`Preiseinheit` AS `Preiseinheit`,`ap`.`GueltigAb` AS `GueltigAb`,`ap`.`Rab1` AS `Rab1`,`ap`.`Rab2` AS `Rab2`,`ap`.`Rab3` AS `Rab3`,`ap`.`Aufs1` AS `Aufs1`,`ap`.`Aufs2` AS `Aufs2`,`art`.`Warengruppe` AS `Warengruppe` from (`faktura simplicisimus`.`v_aktpreise` `ap` join `v_artikel` `art` on((`ap`.`XArtikel` = `art`.`Artikelnummer`)));

-- --------------------------------------------------------

--
-- Struktur des Views `v_stuecke`
--
DROP TABLE IF EXISTS `v_stuecke`;

CREATE ALGORITHM=UNDEFINED DEFINER=`BSteiner`@`%` SQL SECURITY DEFINER VIEW `v_stuecke` AS select `astl`.`Artikelnummer` AS `Artikelnummer`,`sta`.`Warengruppe` AS `Warengruppe`,`astl`.`TeilArtikel` AS `Teilartikel`,`astl`.`MengeTeil` AS `MengeTeil`,`sta`.`Abmessung` AS `Abmessung`,`sta`.`Bezeichnung1` AS `Bezeichnung1`,`v_wg`.`PHP_Datei` AS `PHP_Datei`,`v_wg`.`Symbol_Grafik_1` AS `Symbol_Grafik_1`,`v_wg`.`Symbol_Grafik_2` AS `Symbol_Grafik_2`,`v_wg`.`Symbol_Grafik_3` AS `Symbol_Grafik_3`,`v_wg`.`Masseinheit` AS `Masseinheit`,`v_wg`.`Artikel_Zeile` AS `Artikel_Zeile`,`v_wg`.`Kenn_Art_2` AS `Kenn_Art_2`,`v_wg`.`SB` AS `SB`,`v_wg`.`Stueckliste` AS `Stueckliste`,`v_wg`.`Grafik2` AS `Grafik2`,`v_wg`.`zusText` AS `zusText`,`v_wg`.`Neuheit` AS `Neuheit`,`v_wg`.`MoAktion` AS `MoAktion`,`v_wg`.`Schalter` AS `Schalter` from ((`faktura simplicisimus`.`artikelstammdaten` `sta` join `v_wg` on((`sta`.`Warengruppe` = `v_wg`.`Kuerzel`))) join `faktura simplicisimus`.`stueckliste` `astl` on((`sta`.`Artikelnummer` = `astl`.`TeilArtikel`))) order by `astl`.`TeilArtikel`;

-- --------------------------------------------------------

--
-- Struktur des Views `v_stueckeanz`
--
DROP TABLE IF EXISTS `v_stueckeanz`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_stueckeanz` AS select `astl`.`Artikelnummer` AS `Artikelnummer`,`sta`.`Warengruppe` AS `Warengruppe`,count(`astl`.`TeilArtikel`) AS `Anz` from (`faktura simplicisimus`.`artikelstammdaten` `sta` join `faktura simplicisimus`.`stueckliste` `astl` on((`sta`.`Artikelnummer` = `astl`.`TeilArtikel`))) group by `astl`.`Artikelnummer`,`sta`.`Warengruppe`;

-- --------------------------------------------------------

--
-- Struktur des Views `v_wg`
--
DROP TABLE IF EXISTS `v_wg`;

CREATE ALGORITHM=UNDEFINED DEFINER=`BSteiner`@`%` SQL SECURITY DEFINER VIEW `v_wg` AS select `faktura simplicisimus`.`warengruppe`.`Sprache` AS `Sprache`,`faktura simplicisimus`.`warengruppe`.`Kuerzel` AS `Kuerzel`,`faktura simplicisimus`.`warengruppe`.`Gruppe` AS `Gruppe`,`faktura simplicisimus`.`warengruppe`.`Text` AS `Text`,`faktura simplicisimus`.`warengruppe`.`Zusatz` AS `Zusatz`,`faktura simplicisimus`.`warengruppe`.`Uebersetzung` AS `Uebersetzung`,`faktura simplicisimus`.`warengruppe`.`PHP_Datei` AS `PHP_Datei`,`faktura simplicisimus`.`warengruppe`.`Symbol_Grafik_1` AS `Symbol_Grafik_1`,`faktura simplicisimus`.`warengruppe`.`Symbol_Grafik_2` AS `Symbol_Grafik_2`,`faktura simplicisimus`.`warengruppe`.`Symbol_Grafik_3` AS `Symbol_Grafik_3`,`faktura simplicisimus`.`warengruppe`.`Symbol_Grafik_4` AS `Symbol_Grafik_4`,`faktura simplicisimus`.`warengruppe`.`Masseinheit` AS `Masseinheit`,`faktura simplicisimus`.`warengruppe`.`Artikel_Zeile` AS `Artikel_Zeile`,`faktura simplicisimus`.`warengruppe`.`Kenn_Art_2` AS `Kenn_Art_2`,`faktura simplicisimus`.`warengruppe`.`AusfArt1` AS `AusfArt1`,`faktura simplicisimus`.`warengruppe`.`AusfArt2` AS `AusfArt2`,`faktura simplicisimus`.`warengruppe`.`NoArt1` AS `NoArt1`,`faktura simplicisimus`.`warengruppe`.`NoArt2` AS `NoArt2`,`faktura simplicisimus`.`warengruppe`.`SB` AS `SB`,`faktura simplicisimus`.`warengruppe`.`Stueckliste` AS `Stueckliste`,`faktura simplicisimus`.`warengruppe`.`Grafik2` AS `Grafik2`,`faktura simplicisimus`.`warengruppe`.`zusText` AS `zusText`,`faktura simplicisimus`.`warengruppe`.`Neuheit` AS `Neuheit`,`faktura simplicisimus`.`warengruppe`.`MoAktion` AS `MoAktion`,`faktura simplicisimus`.`warengruppe`.`Schalter` AS `Schalter`,`faktura simplicisimus`.`warengruppe`.`Sort` AS `Sort` from `faktura simplicisimus`.`warengruppe` where ((`faktura simplicisimus`.`warengruppe`.`Schalter` > 0) and (`faktura simplicisimus`.`warengruppe`.`Schalter` is not null));

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
