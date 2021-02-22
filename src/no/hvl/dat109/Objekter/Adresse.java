package no.hvl.dat109.Objekter;

import java.util.List;

public class Adresse {

    private String gateadresse;
    private int postnr;
    private String poststed;

    public Adresse(String gateadresse, int postnr, String poststed) {
        this.gateadresse = gateadresse;
        this.postnr = postnr;
        this.poststed = poststed;
    }

    public String getGateadresse() {
        return gateadresse;
    }

    public int getPostnr() {
        return postnr;
    }

    public String getPoststed() {
        return poststed;
    }

    public String toString(){
        return "Adresse-" + this.gateadresse + "-" + this.postnr + "-" + this.poststed;
    }

    public static Adresse makeAdresse(List<String> object) {
        Adresse adr;
        adr = new Adresse(object.get(0), Integer.parseInt(object.get(1)), object.get(2));
        return adr;
    }
}
