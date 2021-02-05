package no.hvl.dat109;

public class Utleiekontor extends Bilutleie{

    private int kontorNummer;
    private int kontorAdresse;
    private Reservasjon[] reservasjoner;

    public Utleiekontor(String navn, int telefonNummer, Adresse firmaAdresse, Bil[] bilPark, int kontorNummer, int kontorAdresse, Reservasjon[] reservasjoner){
        super(navn, telefonNummer, firmaAdresse, bilPark);
        this.kontorNummer = kontorNummer;
        this.kontorAdresse = kontorAdresse;
        this.reservasjoner = reservasjoner;

    }
}
