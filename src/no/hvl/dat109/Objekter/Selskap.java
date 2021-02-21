package no.hvl.dat109.Objekter;

import java.util.ArrayList;
import java.util.List;

public class Selskap {

    private String navn;
    private Adresse firmaAdr;
    private String tlfNr;
    private List<Reservasjon> reservasjoner;
    private List<Utleiekontor> kontorer;
    private List<Utlevering> utleverteBiler;
    private List<Innlevering> returnerteBiler;

    public Selskap(String navn, Adresse firmaAdr, String tlfNr) {
        this.navn = navn;
        this.firmaAdr = firmaAdr;
        this.tlfNr = tlfNr;
        this.reservasjoner = new ArrayList<Reservasjon>();
        this.kontorer = new ArrayList<Utleiekontor>();
        this.utleverteBiler = new ArrayList<Utlevering>();
        this.returnerteBiler = new ArrayList<Innlevering>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Adresse getFirmaAdr() {
        return firmaAdr;
    }

    public void setFirmaAdr(Adresse firmaAdr) {
        this.firmaAdr = firmaAdr;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }

    public List<Reservasjon> getReservasjoner(){
        return this.reservasjoner;
    }

    public void leggTilReservasjon(Reservasjon res) {
        reservasjoner.add(res);
    }

    public List<Utleiekontor> getKontorer(){
        return this.kontorer;
    }

    public void leggTilUtlevertBil(Utlevering utlevering) {
        utleverteBiler.add(utlevering);
    }

    public void leggTilKontor(Utleiekontor kontor) {
        kontorer.add(kontor);
    }

    public void leggTilReturnertBil(Innlevering retur) {
        returnerteBiler.add(retur);
    }

    public List<Utlevering> getUtleverteBiler() {
        return utleverteBiler;
    }

    public List<Innlevering> getReturnerteBiler() {
        return returnerteBiler;
    }

}

