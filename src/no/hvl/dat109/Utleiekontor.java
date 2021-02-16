package no.hvl.dat109;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public Reservasjon lagReservasjon(Bil bil, LocalDate startDato, LocalTime startTid, int antDager, Utleiekontor utleieKontor, Utleiekontor returKontor, Kunde kunde) {
        Reservasjon reservasjon = new Reservasjon(bil, startDato, startTid, antDager, utleieKontor, returKontor, kunde);
        return reservasjon;
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

    @Override
    public String toString() {
        return "Utleiekontor" +
                "-" + kontorNavn +
                "-" + kontorNummer;
    }


}
