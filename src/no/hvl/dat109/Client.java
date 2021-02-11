package no.hvl.dat109;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {
    /**
     * Just some testvalues, maybe deletable after the save/load methods are working somehow
     */
    Bil[] havispark = new Bil[20];
    Utleiekontor[] havisKontor = new Utleiekontor[5];
    Adresse adr1 = new Adresse("Strengveien", 8888, "Streng");
    Bilutleie havis = new Bilutleie("Havis", 888888, adr1, havispark, havisKontor);

    //TODO: Need to find somehow to save the Lists and objects within objects easier without much work, not part of main task
    public void start() {
        System.out.println("-------Main menu-------");
        System.out.println("1. Load file");
        System.out.println("2. Print something");
        System.out.println("3. Fuckings reservere ein bil eller noe?");
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
