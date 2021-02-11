package no.hvl.dat109;

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
    private Bil[] havispark = new Bil[20];
    private Utleiekontor[] havisKontor = new Utleiekontor[5];
    private Adresse adr1 = new Adresse("Strengveien", 8888, "Streng");
    private Kunde kunde1 = new Kunde("Ola", "Nordmann", 999, adr1);
    private Bilutleie havis = new Bilutleie("Havis", 888888, adr1, havispark, havisKontor);
    private Kunde[] kunder = {kunde1};
    private Adresse[] adresser = {adr1};


    //TODO: Need to find somehow to save the Lists and objects within objects easier without much work, not part of main task


    public void start() {
        System.out.println("-------Main menu-------");
        System.out.println("1. Load file");
        System.out.println("2. Print something");
        System.out.println("3. Fuckings reservere ein bil eller noe?");
        System.out.println("4. Save data");

        Scanner scan = new Scanner(System.in);
        int menu = Integer.parseInt(scan.nextLine());
        switch (menu){
            case 1:
                readFile();
                start();
                break;
            case 2:
                System.out.println("Wow, you printed something!");
                start();
                break;
            case 3:
                System.out.println("Function not implemented");
                start();
                break;
            case 4:
                writeFile(havis, kunder, havisKontor[0], havispark, adresser);
                break;
            default:
                break;

        }
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

                String[] split = data.split(" ");
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
            writer.write(kontor.toString());

            for (Kunde k : kunder) {
                writer.write(k.toString());
            }
            for (Bil b: biler) {
                writer.write(b.toString());
            }
            for (Adresse a:adresser) {
                writer.write(a.toString());
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
                Integer.parseInt(object.get(5)));
        return bil;
    }


}
