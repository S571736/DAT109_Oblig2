package no.hvl.dat109;

import java.util.Arrays;

public class Bilutleie {
    private String navn;
    private int telefonNummer;
    private Adresse firmaAdresse;
    private Bil[] bilPark;
    private Utleiekontor[] kontorer;

    public Bilutleie(String navn, int telefonNummer, Adresse firmaAdresse, Bil[] bilPark, Utleiekontor[] kontorer) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.firmaAdresse = firmaAdresse;
        this.bilPark = bilPark;
        this.kontorer = kontorer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(int telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public Adresse getFirmaAdresse() {
        return firmaAdresse;
    }

    public void setFirmaAdresse(Adresse firmaAdresse) {
        this.firmaAdresse = firmaAdresse;
    }

    public Bil[] getBilPark() {
        return bilPark;
    }

    public void setBilPark(Bil[] bilPark) {
        this.bilPark = bilPark;
    }

    public Utleiekontor[] getKontorer() {
        return kontorer;
    }

    public void setKontorer(Utleiekontor[] kontorer) {
        this.kontorer = kontorer;
    }

    @Override
    public String toString() {
        return "Bilutleie" +
                "-" + navn +
                "-" + telefonNummer;
    }
}
