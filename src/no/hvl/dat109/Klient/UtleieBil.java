package no.hvl.dat109.Klient;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import no.hvl.dat109.Objekter.Bil;
import no.hvl.dat109.Objekter.Kunde;
import no.hvl.dat109.Objekter.Reservasjon;
import no.hvl.dat109.Objekter.Selskap;
import no.hvl.dat109.Objekter.Utlevering;

public class UtleieBil {

    public static void leiUt(Selskap selskap) {
        Scanner sc = new Scanner(System.in);

        LocalDate currDate = LocalDate.now();

        System.out.println("Skriv inn telefonnummer: ");
        int telefonnummer = sc.nextInt();

        List<Reservasjon> alleReservasjoner = selskap.getReservasjoner();

        Reservasjon res = alleReservasjoner.stream()
                .filter(r -> telefonnummer == r.getKunde().getTlfNr())
                .findAny()
                .orElse(null);

        if (res == null) {
            System.out.println("Finnes ikke en reservasjon med dette telefonnummeret");
            sc.close();
            //Klient.valgMeny();
            return;


        }

        Kunde kunde = res.getKunde();

        System.out.println("Skriv inn kredittkortnummer: ");
        long kortNummer = sc.nextLong();
        int kort = (int) kortNummer;

        kunde.setKredittKort(kort);
        String regNr = res.getBil().getRegnr();
        int kmstand = res.getBil().getKmStand();

        Utlevering utlevering = new Utlevering(kunde.getKredittKort(), regNr, kmstand, currDate, res.getStartDato().plusDays(res.getAntallDager()));
        selskap.leggTilUtlevertBil(utlevering);
        System.out.println();
        System.out.println("Her er bilen din! :)");
        Klient.valgMeny();

        Klient.valgMeny();
    }
}
