package no.hvl.dat109.Klient;

/**
 * @author Sondre Lindaas Gjesdal & Sander Lyngbø
 * @version 1.0
 */

import no.hvl.dat109.Objekter.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.io.IOException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/*
    TODO:
    implementer "ny" Bilpark, utlevering og innlevering (bilpark: FERDIG, utlevering/innlevering: FERDIG)
    må legge inn prisutregning i innlevering
    få til lagring av informasjon på ein skikkelig måte
    bedre meny med meir info(kunne skrive ut vissvass og tilgjengelige kontor)
    bedre looping
    flytte ting inn i nye klasser, tenker å ha de klassene i logic packagen?
    Kutte ner unødvendige klasser, objekter og metoder

 */
    // TODO: Kanskje se på noe med invalid input på Scannerene som er brukt
    // TODO: Need to find somehow to save the Lists and objects within objects easier without much work, not part of main task
public class Client {
    /**
     * Just some testvalues, maybe deletable after the save/load methods are working somehow
     */
    private ArrayList<Kunde> kunder = new ArrayList<Kunde>();
    private ArrayList<Adresse> adresser = new ArrayList<Adresse>();


    private Adresse adr1 = new Adresse("Strengveien", 8888, "Streng");

    private List<Utleiekontor> havisKontor = new ArrayList<Utleiekontor>();
    private List<Utleiekontor> eidsvåg = new ArrayList<Utleiekontor>();

    private Kunde kunde1 = new Kunde("Ola", "Nordmann", 999, adr1);

    private Bilutleie havis = new Bilutleie("Havis", 888888, adr1, null, havisKontor);
    private Utleiekontor havisKontoret = new Utleiekontor("Kontoret", adr1, havis);

    private Bilutleie gravis = new Bilutleie("gravis", 888888, adr1, null, eidsvåg);
    private Utleiekontor Eidsvåg = new Utleiekontor("avd. Eidsvåg", adr1, gravis);

    private ArrayList<Bilutleie> utleieFirma = new ArrayList<Bilutleie>();



    public void init(){
        kunder.add(kunde1);
        adresser.add(adr1);
        utleieFirma.add(havis);
        utleieFirma.add(gravis);
        havis.setBilPark(Bilpark.leggTilBiler1());

        havis.addKontorer(havisKontoret);
        gravis.addKontorer(Eidsvåg);
        gravis.setBilPark(Bilpark.leggTilBiler2());
        start();
    }

    public void start() {

        System.out.println("\n");
        System.out.println("-------Main menu-------");
        System.out.println("1. Reservasjon");
        System.out.println("2. Utlevering av bil");
        System.out.println("3. Innlevering av bil");
        System.out.println("4. Avslutt");

        Scanner scan = new Scanner(System.in);
        int menu = Integer.parseInt(scan.nextLine());
        switch (menu) {
            case 1:
                reserverBil(scan);
                start();
                break;
            case 2:
                utlevering(scan);
                start();
                break;
            case 3:
                innlevering(scan);
                start();
                break;
            case 4:
                System.out.println("\nProgrammet er avsluttet.");
                break;
            default:
                break;

        }
    }

    private void utlevering(Scanner scan) {
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
            start();
            return;
        }

        Bil bil = reservasjon.getBil();

        LocalDate returdato = reservasjon.getStartDato().plusDays(reservasjon.getAntallDager());

        Utlevering utlevering = new Utlevering(reservasjon.getKunde().getKredittKort(), bil.getRegnr(),
                bil.getKmStand(), currDate, returdato);
        bilutleie.leggTilUtlevert(utlevering);

        System.out.println("Flott, her er bilen din!");

    }

    private void innlevering(Scanner scan) {
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
            start();
            return;
        }

        long kredittkort = reservasjon.getKunde().getKredittKort();
        Bil bil = reservasjon.getBil();

        System.out.println("Hva er kilometerstanden på bilen nå?");
        int kmStand = scan.nextInt();

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

    private void reserverBil(Scanner scan) {
        int i = 0;
        //TODO: Kunne velge mellom utleieselskap og deres kontor?
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
        // TODO: Legg reservasjonen til i kontoret sin reservasjonsliste

        currSelskap.addReservasjon(reservasjon);
        currCar.setLedig(false);

        System.out.println("Gratulerer, du har nå en reservasjon: ");


        /* TODO:
        Velge bil man ønsker å leie
        Velge kunde?
        Legge inn kundedataene sine
        Opprette reservasjonen
         */

    }


    /**
     * Function to save data so we don't have to put all the shit into it every time
     * Thought is to make it read the file on startup, and rewrite the entire file on saving for easier overview?
     */
    public void readFile() {

        try {
            File file = new File("save.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();

                String[] split = data.split("-");
                List<String> splitString = new ArrayList<String>();
                splitString = Arrays.asList(split);
                String type = splitString.get(0);
                List<String> object = splitString.subList(1, splitString.size());

                if (type.equals("Bilutleie")) {
                    Bilutleie bilutleie = makeUtleie(object);
                } else if (type.equals("Kunde")) {
                    Kunde kunde = makeKunde(object);
                } else if (type.equals("Utleiekontor")) {
                    Utleiekontor kontor = makeKontor(object);
                } else if (type.equals("Bil")) {
                    Bil bil = makeBil(object);
                } else {
                    Adresse adresse = makeAdresse(object);
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    /**
     * For testing lagrer vi bare et bilutleie, med et enkelt kontor
     */
    private void writeFile(Bilutleie utleie, Kunde[] kunder, Utleiekontor kontor, Bil[] biler, Adresse[] adresser) {
        File file = new File("save.txt");
        try {
            FileWriter writer = new FileWriter("save.txt");
            writer.write(utleie.toString());
            writer.write(System.lineSeparator());

            writer.write(kontor.toString());
            writer.write(System.lineSeparator());

            for (Kunde k : kunder) {
                writer.write(k.toString());
                writer.write(System.lineSeparator());
            }
            for (Bil b : biler) {
                writer.write(b.toString());
                writer.write(System.lineSeparator());
            }
            for (Adresse a : adresser) {
                writer.write(a.toString());
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //TODO: Flytte alle disse make metodene til sine respektive klasser og erstatte de med enklere metoder her

    private Adresse makeAdresse(List<String> object) {
        Adresse adr;
        adr = new Adresse(object.get(0), Integer.parseInt(object.get(1)), object.get(2));
        return adr;
    }

    private Bilutleie makeUtleie(List<String> object) {
        Bilutleie utleie;
        utleie = new Bilutleie(object.get(0), Integer.parseInt(object.get(1)), null, null, null);

        return utleie;
    }

    private Kunde makeKunde(List<String> object) {
        Kunde kunde;
        kunde = new Kunde(object.get(0), object.get(1), Integer.parseInt(object.get(2)), null);
        return kunde;
    }

    private Utleiekontor makeKontor(List<String> object) {
        Utleiekontor kontor;
        kontor = new Utleiekontor(object.get(0), null, null);
        return kontor;
    }

    private Bil makeBil(List<String> object) {
        Bil bil;
        bil = new Bil(object.get(0),
                object.get(1),
                object.get(2), object.get(3),
                Utleiegruppe.valueOf(object.get(4)),
                Boolean.parseBoolean(object.get(5)),
                Integer.parseInt(object.get(6)));
        return bil;
    }


}
