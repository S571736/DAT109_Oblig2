package no.hvl.dat109.Logikk;

import no.hvl.dat109.Klient.Client;
import no.hvl.dat109.Objekter.Bil;
import no.hvl.dat109.Objekter.Bilutleie;
import no.hvl.dat109.Objekter.Reservasjon;
import no.hvl.dat109.Objekter.Utlevering;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UtleverBil {
    public static void utlevering(Scanner scan, List<Bilutleie> utleieFirma) {
        int i = 0;
        System.out.println("Vennligst velg bilselskap leier du av?");
        for (Bilutleie b : utleieFirma) {
            i++;
            System.out.println(i + ". " + b.getNavn());
        }

        int selskapvalg = Integer.parseInt(scan.nextLine());
        Bilutleie bilutleie = utleieFirma.get(selskapvalg-1);

        LocalDate currDate = LocalDate.now();

        System.out.println("Skriv inn telefonnummeret ditt");
        int tlf = scan.nextInt();

        List<Reservasjon> reservasjoner = bilutleie.getReservasjoner();

        Reservasjon reservasjon = reservasjoner.stream()
                .filter(r -> r.getKunde().getTlfNr() == tlf)
                .findFirst()
                .orElse(null);

        if (reservasjon == null) {
            System.out.println("Vi fant ingen reservasjoner på dette telefonnummeret");
            return;
        }

        Bil bil = reservasjon.getBil();

        LocalDate returdato = reservasjon.getStartDato().plusDays(reservasjon.getAntallDager());

        Utlevering utlevering = new Utlevering(reservasjon.getKunde().getKredittKort(), bil.getRegnr(),
                bil.getKmStand(), currDate, returdato);
        bilutleie.leggTilUtlevert(utlevering);

        System.out.println("Flott, her er bilen din!");

    }
}
