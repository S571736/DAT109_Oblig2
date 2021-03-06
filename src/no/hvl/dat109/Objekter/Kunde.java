package no.hvl.dat109.Objekter;

import java.util.List;

public class Kunde {
    private String fornavn;
    private String etternavn;
    private int tlfNr;
    private Adresse addresse;
    private long kredittKort;


    public Kunde(String fornavn, String etternavn, int tlfNr, Adresse addresse) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.tlfNr = tlfNr;
        this.addresse = addresse;
        this.kredittKort = 0;
    }

    public long getKredittKort() {
        return kredittKort;
    }

    public void setKredittKort(long kredittKort) {
        this.kredittKort = kredittKort;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public int getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(int tlfNr) {
        this.tlfNr = tlfNr;
    }

    public Adresse getAddresse() {
        return addresse;
    }

    public void setAddresse(Adresse addresse) {
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "Kunde" +
                "-" + fornavn +
                "-" + etternavn +
                "-" + tlfNr;
    }

    public static Kunde makeKunde(List<String> object) {
        Kunde kunde;
        kunde = new Kunde(object.get(0), object.get(1), Integer.parseInt(object.get(2)), null);
        return kunde;
    }
}

