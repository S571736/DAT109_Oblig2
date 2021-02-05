package no.hvl.dat109;

public class Utleiekontor {

    private int kontorNummer;
    private int kontorAdresse;
    private Reservasjon[] reservasjoner;


    public Utleiekontor(int kontorNummer, int kontorAdresse, Reservasjon[] reservasjoner){

        this.kontorNummer = kontorNummer;
        this.kontorAdresse = kontorAdresse;
        this.reservasjoner = reservasjoner;

    }
}
