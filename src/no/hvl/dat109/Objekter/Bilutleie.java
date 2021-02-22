package no.hvl.dat109.Objekter;

import java.util.ArrayList;
import java.util.List;

public class Bilutleie {
    private String navn;
    private int telefonNummer;
    private Adresse firmaAdresse;
    private List<Bil> bilPark;
    private List<Utleiekontor> kontorer;
    private List<Utlevering> utleverteBiler;
    private List<Innlevering> returnerteBiler;
    private List<Reservasjon> reservasjoner;
    // TODO: mulighet for å kunne droppe ei eller to av de siste to listene?


    public Bilutleie(String navn, int telefonNummer, Adresse firmaAdresse, List<Bil> bilPark, List<Utleiekontor> kontorer) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.firmaAdresse = firmaAdresse;
        this.bilPark = bilPark;
        this.kontorer = kontorer;
        this.utleverteBiler = new ArrayList<Utlevering>();
        this.returnerteBiler = new ArrayList<Innlevering>();
        this.reservasjoner = new ArrayList<Reservasjon>();
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

    public List<Bil> getBilPark() {
        return bilPark;
    }

    public void setBilPark(List<Bil> bilPark) {
        this.bilPark = bilPark;
    }

    public List<Utleiekontor> getKontorer() {
        return kontorer;
    }

    public void setKontorer(List<Utleiekontor> kontorer) {
        this.kontorer = kontorer;
    }

    public void addKontorer(Utleiekontor kontor){
        kontorer.add(kontor);
    }

    public void leggTilUtlevert(Utlevering utlevering) {
        utleverteBiler.add(utlevering);
    }

    public List<Innlevering> getReturnerteBiler() {
        return returnerteBiler;
    }

    public List<Reservasjon> getReservasjoner() {
        return reservasjoner;
    }

    public void addReservasjon(Reservasjon reservasjon) {
        reservasjoner.add(reservasjon);
    }

    @Override
    public String toString() {
        return "Bilutleie" +
                "-" + navn +
                "-" + telefonNummer;
    }
}
