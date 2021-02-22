package no.hvl.dat109.Logikk;
import no.hvl.dat109.Klient.*;
import no.hvl.dat109.Objekter.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReserverBil {

    public static void reserverBil(Scanner scan, List<Bilutleie> utleieFirma, List<Kunde> kunder) {
        int i = 0;

        System.out.println("Vennligst velg bilselskap du vil leie av");
        for (Bilutleie b : utleieFirma) {
        i++;
        System.out.println(i + ". " + b.getNavn());
        }

        int selskapvalg = Integer.parseInt(scan.nextLine());
        Bilutleie currSelskap = utleieFirma.get(selskapvalg-1);

        // Kommet frem for tidlig.


        System.out.println("Vennligst velg hvilket bilutleiekontor du ønsker å leie fra");
        for (int j = 0; j < currSelskap.getKontorer().size(); j++) {
        System.out.println((j + 1) + ". " + currSelskap.getKontorer().get(j).skrivUt());
        }

        int kontorvalg = Integer.parseInt(scan.nextLine());
        Utleiekontor kontor = currSelskap.getKontorer().get(kontorvalg-1);

        System.out.println("\n\n");

        // Kommer frem  for tidlig.

        System.out.println("Det valgte selskapet har disse ledige bilene, hvilken ønsker du å leie?");
        i = 0;
        for (Bil b : currSelskap.getBilPark()) {
        if (b.getLedig()) {
        i++;
        System.out.print(i + ". ");
        b.skrivUt();
        }
        }

        Bil currCar = currSelskap.getBilPark().get(Integer.parseInt(scan.nextLine()) - 1);

        System.out.println("Hva er det fulle navnet ditt? Fornavn og etternavn");
        String navn = scan.nextLine();

        String[] deltNavn = navn.split(" ");

        Kunde currKunde = null;
        currKunde = Arrays.stream((Kunde[]) kunder.toArray(new Kunde[kunder.size()]))
        .filter(p -> p.getFornavn().equals(deltNavn[0])
        && p.getEtternavn().equals(deltNavn[1]))
        .findFirst()
        .orElse(null);


        if (currKunde != null) {
        System.out.println("Du bruker nå: " + currKunde.getFornavn() + " sin konto");
        } else {
        System.out.println("Fant ikke brukeren, vennligst opprett ny: ");
        System.out.println("Gateadresse: ");
        String gateAdresse = scan.nextLine();
        System.out.println("Postnummer: ");
        int postnr = Integer.parseInt(scan.nextLine());
        System.out.println("Poststed");
        String poststed = scan.nextLine();

        Adresse ad = new Adresse(gateAdresse, postnr, poststed);


        String fornavn = deltNavn[0];
        String etternavn = deltNavn[1];
        System.out.println("Telefonnummer");
        int tlfNr = Integer.parseInt(scan.nextLine());
        currKunde = new Kunde(fornavn, etternavn, tlfNr, ad);
        }

        System.out.println("Hva er kredittkortnummeret ditt");
        long kort = scan.nextLong();
        currKunde.setKredittKort(kort);


        System.out.println("Skriv inn ønsket leiedato (dd.mm.yyyy)");
        String dato = scan.next();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate utleie = LocalDate.parse(dato, format);

        System.out.println("Skriv inn ønsket utleietidspunkt (time:minutt)");
        LocalTime startTid = LocalTime.parse(scan.next());


        System.out.println("Oppgi hvor mange dager du ønsker å leie");
        int dager = Integer.parseInt(scan.next());


        Reservasjon reservasjon = new Reservasjon(currCar, utleie, startTid, dager, kontor, kontor, currKunde);

        currSelskap.addReservasjon(reservasjon);
        currCar.setLedig(false);

        System.out.println("Gratulerer, du har nå en reservasjon: ");

        }
}