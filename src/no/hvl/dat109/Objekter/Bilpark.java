package no.hvl.dat109.Objekter;

import java.util.ArrayList;
import java.util.List;

public class Bilpark {

    public static List<Bil> leggTilBiler1() {

        List<Bil> biler =new ArrayList<Bil>();
        Bil b1 = new Bil("SU99999", "Fiat", "500", "Blå", Utleiegruppe.LITEN, false, 0);biler.add(b1);
        Bil b2 = new Bil("EL99999", "Nissan", "Leaf", "Grå", Utleiegruppe.MELLOMSTOR, true, 0);
        biler.add(b2);
        Bil b3 = new Bil("SV99999", "BMW", "X3", "Blå", Utleiegruppe.STOR,true,0);
        biler.add(b3);
        Bil b4 = new Bil("BS99999", "Volvo", "V70", "Svart", Utleiegruppe.STASJONSVOGN,true,0);
        biler.add(b4);
        return biler;
}
    public static List<Bil> leggTilBiler2() {

        List<Bil> biler =new ArrayList<Bil>();
        Bil b1 = new Bil("SU88888", "Fiat", "500", "Blå", Utleiegruppe.LITEN, false, 0);
        biler.add(b1);
        Bil b2 = new Bil("EL88888", "Nissan", "Leaf", "Grå", Utleiegruppe.MELLOMSTOR, true, 0);
        biler.add(b2);
        Bil b3 = new Bil("SV88888", "BMW", "X3", "Blå", Utleiegruppe.STOR,true,0);
        biler.add(b3);
        Bil b4 = new Bil("BS88888", "Volvo", "V70", "Svart", Utleiegruppe.STASJONSVOGN,true,0);
        biler.add(b4);
        return biler;
    }

}