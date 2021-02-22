package no.hvl.dat109.Logikk;

import no.hvl.dat109.Objekter.Bil;
import no.hvl.dat109.Objekter.Bilutleie;
import no.hvl.dat109.Objekter.Innlevering;
import no.hvl.dat109.Objekter.Reservasjon;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class InnleverBil {

    public static void innlevering(Scanner scan, List<Bilutleie> utleieFirma) {
        //Lage et innleveringsobjekt
        //finne og slette reservasjonsobjektet
        int i = 0;
        System.out.println("Vennligst velg bilselskap leier du av?");
        for (Bilutleie b : utleieFirma) {
            i++;
            System.out.println(i + ". " + b.getNavn());
        }

        int selskapvalg = Integer.parseInt(scan.nextLine());
        Bilutleie bilutleie = utleieFirma.get(selskapvalg-1);


        LocalDate currDate = LocalDate.now();

        System.out.println("Hva er ditt telefonnummer?");
        int tlf = scan.nextInt();

        List<Reservasjon> reservasjoner = bilutleie.getReservasjoner();

        Reservasjon reservasjon = reservasjoner.stream()
                .filter(r -> tlf == r.getKunde().getTlfNr())
                .findFirst()
                .orElse(null);

        if (reservasjon == null) {
            System.out.println("Vi fant ingen reservasjon på dette telefonnummeret");
            return;
        }

        long kredittkort = reservasjon.getKunde().getKredittKort();
        Bil bil = reservasjon.getBil();

        System.out.println("Hva er kilometerstanden på bilen nå?");
        int kmStand = scan.nextInt();

        System.out.println("Skriv inn returtidspunkt (time:minutt)");
        LocalTime returTid = LocalTime.parse(scan.next());
        // returtid brukes per dags dato til ingenting - prising går på fast dagspris. :)


        bil.setLedig(true);
        bil.setKmStand(kmStand);
        reservasjon.getReturkontor().leggTilBil(bil);

        Innlevering innlevering = new Innlevering(kredittkort, currDate, bil.getRegnr(), kmStand);
        bilutleie.getReturnerteBiler().add(innlevering);

        double pris = 0;
        switch (bil.getUtleiegruppe()){
            case LITEN -> pris = 50;
            case MELLOMSTOR -> pris = 75;
            case STASJONSVOGN -> pris = 90;
            case STOR -> pris = 100;
        }
        long dur = ChronoUnit.DAYS.between(reservasjon.getStartDato(), currDate);
        bilutleie.getReservasjoner().remove(reservasjon);
        pris = (double)pris * (double)dur;
        System.out.println("Du har nå levert bilen!");

        System.out.println("Du skylder kr" + pris + ",- for å leie bilen");

    }
}
