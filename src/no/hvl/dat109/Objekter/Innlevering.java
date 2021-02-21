package no.hvl.dat109.Objekter;

import java.time.LocalDate;

public class Innlevering {

    private int kredittkort;
    private LocalDate returdato;
    private String regnr;
    private int kmStand;

    public Innlevering(int kredittkort, LocalDate returdato, String regnr, int kmStand) {
        super();
        this.kredittkort = kredittkort;
        this.returdato = returdato;
        this.regnr = regnr;
        this.kmStand = kmStand;
    }

}
