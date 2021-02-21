package no.hvl.dat109.Klient;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat109.Objekter.Bil;
import no.hvl.dat109.Objekter.Utleiekontor;
import no.hvl.dat109.Objekter.Reservasjon;
import no.hvl.dat109.Objekter.Innlevering;
import no.hvl.dat109.Objekter.Selskap;

public class InnleveringBil {

    public static void leverInn(Selskap selskap) {
        //Dato for innlevering
        LocalDate currDate = LocalDate.now();
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv inn telefonnummer: ");
        int telefonnummer = sc.nextInt();

        List<Reservasjon> alleReservasjoner = selskap.getReservasjoner();

        Reservasjon res = alleReservasjoner.stream()
                .filter(r -> telefonnummer == r.getKunde().getTlfNr())
                .findAny()
                .orElse(null);

        if(res == null) {
            System.out.println("Finnes ikke en reservasjon med dette telefonnummeret");
            sc.close();
            return;
        }

        //kmStand ved innlevering
        System.out.println("Hvor mange km viser km-teller i bilen? ");
        int kmStand = sc.nextInt();

        //Setter ny kmStand på bil og setter bil som ledig.
        Bil bil = res.getBil();
        bil.setKmStand(kmStand);
        bil.setLedig(true);

        //Henter returkontor og legger til bil i deres billiste
        Utleiekontor returKontor = res.getReturkontor();
        returKontor.leggTilBil(bil);
        int kort = res.getKunde().getKredittKort();
        alleReservasjoner.remove(res);

        Innlevering retur = new Innlevering(kort, currDate, bil.getRegnr(), kmStand);
        List<Innlevering> returListe = selskap.getReturnerteBiler();
        returListe.add(retur);

        Klient.valgMeny();

        System.out.println("Bilen er innlevert! :)");
        System.out.println();
        Klient.valgMeny();

    }
}