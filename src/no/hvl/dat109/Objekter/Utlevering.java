package no.hvl.dat109.Objekter;

import java.time.LocalDate;

public class Utlevering {

    private int kredittkort;
    private String regnr;
    private int kmStand;
    private LocalDate utleieDato;
    private LocalDate returDato;


    public Utlevering(int kredittkort, String regnr, int kmStand, LocalDate utleieDato, LocalDate returDato) {
        super();
        this.kredittkort = kredittkort;
        this.regnr = regnr;
        this.kmStand = kmStand;
        this.utleieDato = utleieDato;
        this.returDato = returDato;
    }

}
