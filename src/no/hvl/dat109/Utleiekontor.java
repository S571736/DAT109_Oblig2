package no.hvl.dat109;

import java.util.List;

public class Utleiekontor {

    private String kontorNavn;
    private int kontorNummer;
    private Adresse kontorAdresse;
    private Reservasjon[] reservasjoner;
    private List<Bil> biler;



    public Utleiekontor(String kontorNavn, Adresse kontorAdresse, Reservasjon[] reservasjoner){

        this.kontorNavn = kontorNavn;
        this.kontorNummer = kontorNummer++;
        this.kontorAdresse = kontorAdresse;
        this.reservasjoner = reservasjoner;

    }

    public String getNavn() {
        return kontorNavn;
    }

    public void setNavn(String kontorNavn) {
        this.kontorNavn = kontorNavn;
    }

    public int getKontorNummer() {
        return kontorNummer;
    }

    public Adresse getAdresse() {
        return kontorAdresse;
    }

    public void setAdresse(Adresse adresse) {
        this.kontorAdresse = adresse;
    }


    public void leggTilBil(Bil bil) {
       // TODO
    }

    public void setBiler(List<Bil> biler) {
        // TODO
    }

    public List<Bil> getBiler() {
        // TODO
        return biler;
    }



}
