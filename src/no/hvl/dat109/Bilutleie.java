package no.hvl.dat109;

public class Bilutleie {
    private String navn;
    private int telefonNummer;
    private Adresse firmaAdresse;
    private Bil[] bilPark;
    private Utleiekontor[] kontorer;

    public Bilutleie(String navn, int telefonNummer, Adresse firmaAdresse, Bil[] bilPark, Utleiekontor[] kontorer) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.firmaAdresse = firmaAdresse;
        this.bilPark = bilPark;
        this.kontorer = kontorer;
    }


}
