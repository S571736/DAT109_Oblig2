package no.hvl.dat109.Klient;
import no.hvl.dat109.Objekter.Adresse;
import no.hvl.dat109.Objekter.Bilpark;
import no.hvl.dat109.Objekter.Utleiekontor;
import no.hvl.dat109.Objekter.Selskap;

import java.util.Scanner;

public class Klient {

    private static Selskap Havis = new Selskap("Havis", new Adresse("Eliasmarken 25", 5164, "Laksevåg"), "91244483");
    private static Utleiekontor Kokstad = new Utleiekontor("Kokstad", new Adresse("Kokstadflaten 35", 5257, "Bergen"), Havis);
    private static Utleiekontor Eidsvåg = new Utleiekontor("Eidsvåg", new Adresse("Eidsvågveien 150", 5105, "Eidsvåg"), Havis);

    public static void main(String[] args) {

        Kokstad.setBiler(Bilpark.leggTilBiler1());
        Eidsvåg.setBiler(Bilpark.leggTilBiler2());
        Havis.leggTilKontor(Kokstad);
        Havis.leggTilKontor(Eidsvåg);

        valgMeny();

    }

    public static void valgMeny() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hei og velkommen til Havis. Meny: ");
        System.out.println("1. Reservasjon");
        System.out.println("2. Utlevering av bil");
        System.out.println("3. Innlevering av bil");
        System.out.println("4. Avslutt");
        System.out.println("\nSkriv inn tallet for ønsket valg:\n");

        int valg = sc.nextInt();

        switch (valg) {
            case 1:
                ReserverBil.reserverBil(Havis);
                break;
            case 2:
                UtleieBil.leiUt(Havis);
                break;
            case 3:
                InnleveringBil.leverInn(Havis);
                break;
            case 4:
                System.out.println("\nProgrammet er avsluttet.");
            default:
                System.out.println("Noe gikk galt.");
        }

    }

}