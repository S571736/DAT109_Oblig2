package no.hvl.dat109.Logikk;

import no.hvl.dat109.Objekter.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileMGMT {
    /**
     * Function to save data so we don't have to put all the shit into it every time
     * Thought is to make it read the file on startup, and rewrite the entire file on saving for easier overview?
     * NOT IN USE
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
                    Bilutleie bilutleie = Bilutleie.makeUtleie(object);
                } else if (type.equals("Kunde")) {
                    Kunde kunde = Kunde.makeKunde(object);
                } else if (type.equals("Utleiekontor")) {
                    Utleiekontor kontor = Utleiekontor.makeKontor(object);
                } else if (type.equals("Bil")) {
                    Bil bil = Bil.makeBil(object);
                } else {
                    Adresse adresse = Adresse.makeAdresse(object);
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    /**
     * For testing lagrer vi bare et bilutleie, med et enkelt kontor
     * NOT IN USE
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
}
