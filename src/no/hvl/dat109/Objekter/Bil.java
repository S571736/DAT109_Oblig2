package no.hvl.dat109.Objekter;

import java.util.List;

public class Bil {
    private String regnr;
    private String merke;
    private String modell;
    private String farge;
    private Utleiegruppe utleiegruppe;
    private Boolean ledig;
    private int kmStand;

    /**
     * Constructor with possibility to set ledig variable
     *
     * @param regnr        bilens reg nr
     * @param merke        bilens merke
     * @param modell       type bil
     * @param farge        fargen på bilen
     * @param utleiegruppe Hvilken type gruppe bilen er registrert som, i guess.
     * @param ledig        Om bilen er ledig eller ikkje
     * @param kmStand      kor langt bilen har kjørt
     */
    public Bil(String regnr, String merke, String modell, String farge, Utleiegruppe utleiegruppe, boolean ledig, int kmStand) {
        this.regnr = regnr;
        this.merke = merke;
        this.modell = modell;
        this.farge = farge;
        this.utleiegruppe = utleiegruppe;
        this.ledig = true;
        this.kmStand = kmStand;

    }


    /**
     * Constructor without possibility to set ledig variable, ledis is therefor set to true by default
     *
     * @param regnr        bilens reg nr
     * @param merke        bilens merke
     * @param modell       type bil
     * @param farge        fargen på bilen
     * @param utleiegruppe Utleiegruppen som leier ut bilen
     * @param kmStand      kor langt bilen har kjørt
     */
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

    @Override
    public String toString() {
        return "Bil" +
                "-" + regnr +
                "-" + merke +
                "-" + modell +
                "-" + farge +
                "-" + utleiegruppe +
                "-" + ledig +
                "-" + kmStand;
    }

    public void skrivUt() {
        System.out.println(
                regnr +
                " " + merke +
                " " + modell +
                " " + farge +
                " " + utleiegruppe +
                " " + kmStand);
    }

    public static Bil makeBil(List<String> object) {
        Bil bil;
        bil = new Bil(object.get(0),
                object.get(1),
                object.get(2), object.get(3),
                Utleiegruppe.valueOf(object.get(4)),
                Boolean.parseBoolean(object.get(5)),
                Integer.parseInt(object.get(6)));
        return bil;
    }
}
