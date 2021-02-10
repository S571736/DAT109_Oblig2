package no.hvl.dat109;

import java.io.File;
import java.io.FileNotFoundException;
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
                String[] splitString = data.split(" ");

            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private <T> T makeObject(String[] object) {
        if (object[0].equals("Bilutleie")){


        }else if(object[0].equals("Kunde")){

        }else if(object[0].equals("Utleiekontor")){

        }else if(object[0].equals("Bil")){

        }else {

        }
    }

    // TODO: Lager metoder fra hovedmenyen her så ser vi kossen det går


}
