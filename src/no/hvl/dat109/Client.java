package no.hvl.dat109;

/**
 * @author Sondre Lindaas Gjesdal & Sander Lyngbø
 * @version 1.0
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {
    /**
     * Just some testvalues, maybe deletable after the save/load methods are working somehow
     */
    private ArrayList<Kunde> kunder = new ArrayList<Kunde>();
    private ArrayList<Adresse> adresser = new ArrayList<Adresse>();
    private Bil honda = new Bil("123123123", "Honda", "Civic", "Blå", Utleiegruppe.LITEN, true, 2);
    private Bil[] havispark = {honda};
    private Adresse adr1 = new Adresse("Strengveien", 8888, "Streng");
    private Utleiekontor havisKontoret = new Utleiekontor("Kontoret", adr1, null);
    private Utleiekontor[] havisKontor = {havisKontoret};
    private Kunde kunde1 = new Kunde("Ola", "Nordmann", 999, adr1);
    private Bilutleie havis = new Bilutleie("Havis", 888888, adr1, havispark, havisKontor);


    // TODO: Kanskje se på noe med invalid input på Scannerene som er brukt
    // TODO: Need to find somehow to save the Lists and objects within objects easier without much work, not part of main task


    public void start() {
        kunder.add(kunde1);
        adresser.add(adr1);
        System.out.println("-------Main menu-------");
        System.out.println("1. Load file");
        System.out.println("2. Print something");
        System.out.println("3. Fuckings reservere ein bil eller noe?");
        System.out.println("4. Save data");

        Scanner scan = new Scanner(System.in);
        int menu = Integer.parseInt(scan.nextLine());
        switch (menu) {
            case 1:
                readFile();
                start();
                break;
            case 2:
                System.out.println("Wow, you printed something!");
                start();
                break;
            case 3:
                reserverBil();
                start();
                break;
            case 4:
                writeFile(havis, (Kunde[]) kunder.toArray(), havisKontor[0], havispark, (Adresse[]) adresser.toArray());
                start();
                break;
            default:
                break;

        }
    }

    private void reserverBil() {

        //TODO: Kunne velge mellom utleieselskap?
        System.out.println("Vennligst velg bilselskap du vil leie av");
        System.out.println("1. havis");

        System.out.println("\n\n\n\n");

        System.out.println("Det valgte selskapet har disse ledige bilene");
        int i = 0;
        for (Bil b : havis.getBilPark()) {
            if (b.getLedig()) {
                i++;
                System.out.print(i + ". ");
                b.skrivUt();
            }
        }

        Scanner scan = new Scanner(System.in);
        Bil currCar = havis.getBilPark()[Integer.parseInt(scan.nextLine()) - 1];

        System.out.println("Hva er det fulle navnet ditt?");
        String navn = scan.nextLine();

        String[] deltNavn = navn.split(" ");

        Kunde currKunde = null;
        currKunde = Arrays.stream((Kunde[]) kunder.toArray())
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
        currKunde.setKredittKort(Integer.parseInt(scan.nextLine()));



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
