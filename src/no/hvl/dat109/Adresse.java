package no.hvl.dat109;

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
        return "Adresse " + this.gateadresse + " " + this.postnr + " " + this.poststed;
    }
}
