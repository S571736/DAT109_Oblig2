package no.hvl.dat109;

public class Bil {
    private String regnr;
    private String merke;
    private String modell;
    private String farge;
    private Utleiegruppe utleiegruppe;
    private Boolean ledig;
    private int kmStand;

    public Bil(String regnr, String merke, String modell, String farge, Utleiegruppe utleiegruppe, int kmStand) {
        this.regnr = regnr;
        this.merke = merke;
        this.modell = modell;
        this.farge = farge;
        this.utleiegruppe = utleiegruppe;
        this.ledig = true;
        this.kmStand = kmStand;

    }

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public String getMerke() {
        return merke;
    }

    public int getKmStand() {
        return kmStand;
    }

    public void setKmStand(int kmStand) {
        this.kmStand = kmStand;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public Utleiegruppe getUtleiegruppe() {
        return utleiegruppe;
    }

    public void setUtleiegruppe(Utleiegruppe utleiegruppe) {
        this.utleiegruppe = utleiegruppe;
    }

    public Boolean getLedig() {
        return ledig;
    }

    public void setLedig(Boolean ledig) {
        this.ledig = ledig;

    }

    public void skrivUt() {
        // TODO
    }
}
