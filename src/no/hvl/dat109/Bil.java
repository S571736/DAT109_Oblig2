package no.hvl.dat109;

public class Bil {
    private String regnr;
    private String merke;
    private String modell;
    private String farge;
    private String utleiegruppe;
    private Boolean ledig;
    private int kmStand;

    public Bil(String regnr, String merke, String modell, String farge, String utleiegruppe) {
        this.regnr = regnr;
        this.merke = merke;
        this.modell = modell;
        this.farge = farge;
        this.utleiegruppe = utleiegruppe;
        this.ledig = true;
        this.kmStand = 0;

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

    public String getUtleiegruppe() {
        return utleiegruppe;
    }

    public void setUtleiegruppe(String utleiegruppe) {
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
