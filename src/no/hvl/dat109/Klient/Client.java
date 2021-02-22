package no.hvl.dat109.Klient;

/**
 * @author Sondre Lindaas Gjesdal & Sander Lyngbø
 * @version 1.0
 */

import no.hvl.dat109.Logikk.InnleverBil;
import no.hvl.dat109.Logikk.ReserverBil;
import no.hvl.dat109.Logikk.UtleverBil;
import no.hvl.dat109.Objekter.*;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Client {
    /**
     * Just some testvalues, maybe deletable after the save/load methods are working somehow
     */
    private static ArrayList<Kunde> kunder = new ArrayList<Kunde>();
    private ArrayList<Adresse> adresser = new ArrayList<Adresse>();
    private Adresse adr1 = new Adresse("Strengveien", 8888, "Streng");
    private List<Utleiekontor> havisKontor = new ArrayList<Utleiekontor>();
    private List<Utleiekontor> eidsvåg = new ArrayList<Utleiekontor>();
    private Kunde kunde1 = new Kunde("Ola", "Nordmann", 999, adr1);
    private Bilutleie havis = new Bilutleie("Havis", 888888, adr1, null, havisKontor);
    private Utleiekontor havisKontoret = new Utleiekontor("Kontoret", adr1, havis);
    private Bilutleie gravis = new Bilutleie("gravis", 888888, adr1, null, eidsvåg);
    private Utleiekontor Eidsvåg = new Utleiekontor("avd. Eidsvåg", adr1, gravis);
    private static ArrayList<Bilutleie> utleieFirma = new ArrayList<Bilutleie>();

    public static void main(String[] args) {
        Client klient = new Client();
        klient.init();
    }

    public void init() {
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

    public static void start() {

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
                ReserverBil.reserverBil(scan, utleieFirma, kunder);
                start();
                break;
            case 2:
                UtleverBil.utlevering(scan, utleieFirma);
                start();
                break;
            case 3:
                InnleverBil.innlevering(scan, utleieFirma);
                start();
                break;
            case 4:
                System.out.println("\nProgrammet er avsluttet.");
                break;
            default:
                break;

        }
    }
}
