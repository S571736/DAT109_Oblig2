package no.hvl.dat109;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {

    Bil[] havispark = new Bil[20];
    Utleiekontor[] havisKontor = new Utleiekontor[5];
    Adresse adr1 = new Adresse("Strengveien", 8888, "Streng");
    Bilutleie havis = new Bilutleie("Havis", 888888, adr1, havispark, havisKontor);


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
    public void readFile(){

        try {
            File file = new File("save.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String data = scan.nextLine();

                String[] split = data.split(" ");
                List<String> splitString = new ArrayList<String>();
                splitString = Arrays.asList(split);
                String type = splitString.get(0);
                List<String> object = splitString.subList(1, splitString.size());

                if (type.equals("Bilutleie")){
                    Bilutleie bilutleie = makeUtleie(object);
                }else if(type.equals("Kunde")){
                    Kunde kunde = makeKunde(object);
                }else if(type.equals("Utleiekontor")){
                    Utleiekontor kontor = makeKontor(object);
                }else if(type.equals("Bil")){
                    Bil bil = makeBil(object);
                }else {
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
        //TODO: Lag ferdig
        return adr;
    }

    private Bilutleie makeUtleie(List<String> object) {
        Bilutleie utleie;
        //TODO: Lag ferdig

        return utleie;
    }

    private Kunde makeKunde(List<String> object) {
        Kunde kunde;
        //TODO: Lag ferdig
        return kunde;
    }

    private Utleiekontor makeKontor(List<String> object) {
        Utleiekontor kontor;
        //TODO: Lag ferdig
        return kontor;
    }

    private Bil makeBil(List<String> object) {
        Bil bil;
        //TODO: Lag ferdig
        return bil;
    }

    // TODO: Lager metoder fra hovedmenyen her så ser vi kossen det går


}
