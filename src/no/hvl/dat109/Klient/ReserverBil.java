package no.hvl.dat109.Klient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import no.hvl.dat109.Objekter.*;

public class ReserverBil {

    public static void reserverBil(Selskap selskap) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Skriv inn utleiekontor: ");
        String utleiekontor = sc.nextLine();

        System.out.println("Skriv inn ønsket returkontor: ");
        String returkontor = sc.nextLine();

        System.out.println("Skriv inn dato du ønsker å leie fra. (dd.mm.yyyy)");
        String stringdato = sc.nextLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.mm.yyyy");
        LocalDate dato = LocalDate.parse(stringdato, dtf);

        System.out.println("Skriv inn ønsket klokkeslett for utleie. (HH:mm)");
        String klokke = sc.nextLine();
        LocalTime tidspunkt = LocalTime.parse(klokke);


        System.out.println("Skriv inn hvor mange dager du vil leie bilen: ");
        int dager = sc.nextInt();


        List<Utleiekontor> alleKontorer = selskap.getKontorer();
        System.out.println(alleKontorer);

        Utleiekontor utleieplass = alleKontorer.stream()
                .filter(k -> utleiekontor.equals(k.getNavn()))
                .findAny()
                .orElse(null);

        Utleiekontor returplass = alleKontorer.stream()
                .filter(k -> returkontor.equals(k.getNavn()))
                .findAny()
                .orElse(null);

        System.out.println(utleieplass.getNavn());
        List<Bil> alleBiler = utleieplass.getBiler();

        List<Bil> tilgjBiler =  alleBiler.stream()
                .filter(b -> b.getLedig() == true)
                .collect(Collectors.toList());

        System.out.println("Tilgjengelige biler: ");
        tilgjBiler.stream().forEach(System.out :: println);

        System.out.println("Skriv inn regnr for ønsket bil: ");
        sc.nextLine();
        String regnr = sc.nextLine();


        Bil bil = tilgjBiler.stream()
                .filter(b -> regnr.equals(b.getRegnr()))
                .findAny()
                .orElse(null);

        if(bil == null) {
            System.out.println("Finnes ikke en bil med dette registreringsnummeret");
            sc.close();
            return;
        }

        System.out.println("Skriv inn fornavn: ");
        String fnavn = sc.nextLine();

        System.out.println("Skriv inn etternavn: ");
        String enavn = sc.nextLine();

        System.out.println("Skriv inn tlf: ");
        int tlf = sc.nextInt();

        System.out.println("Skriv inn gateadresse: ");
        sc.nextLine();
        String gateadresse = sc.nextLine();

        System.out.println("Skriv inn postnr: ");
        int postnr = sc.nextInt();

        System.out.println("Skriv inn poststed: ");
        sc.nextLine();
        String poststed = sc.nextLine();



        System.out.println("Reservasjon fullført!");
        System.out.println();


        Kunde k1 = new Kunde(fnavn, enavn, tlf, new Adresse(gateadresse, postnr, poststed));
        Reservasjon reservasjon = new Reservasjon(bil, dato, tidspunkt, dager, utleieplass, returplass, k1);
        selskap.leggTilReservasjon(reservasjon);


        Klient.valgMeny();

    }

}
