package no.hvl.dat109;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservasjon {

    private Bil bil;
    private LocalDate startDato;
    private LocalTime startTid;
    private int antallDager;
    private Utleiekontor utleiested;
    private Utleiekontor retursted;
    private Kunde kunde;


    public Reservasjon(Bil bil, LocalDate startDato, LocalTime startTid, int antallDager, Utleiekontor utleiested, Utleiekontor retursted, Kunde kunde) {
        this.bil = bil;
        this.startDato = startDato;
        this.startTid = startTid;
        this.antallDager = antallDager;
        this.utleiested = utleiested;
        this.retursted = retursted;
        this.kunde = kunde;

        reserver(bil);
    }

    public void reserver(Bil bil) {
        LocalDate currDate = LocalDate.now();
        LocalDate sluttDato = startDato.plusDays(antallDager);

        // Setter bil til opptatt så lenge dato er mellom start og slutt.
        while (currDate.isAfter(startDato) && currDate.isBefore(sluttDato)) {
            bil.setLedig(false);
        }

    }

    public Bil getBil() {
        return bil;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public int getAntallDager() {
        return antallDager;
    }

    public Utleiekontor getUtleiekontor() {
        return utleiested;
    }

    public Utleiekontor getReturkontor() {
        return retursted;
    }

    public Kunde getKunde() {
        return kunde;
    }





}
