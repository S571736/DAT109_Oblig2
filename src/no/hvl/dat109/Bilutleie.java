package no.hvl.dat109;

public abstract class Bilutleie {
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

    //TODO: vurdere om vi skal ha utleiekontorene som separate objekter, eller fortsette å ha de som underobjekter av Biluleie
    public Bilutleie(String navn, int telefonNummer, Adresse firmaAdresse, Bil[] bilPark) {
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.firmaAdresse = firmaAdresse;
        this.bilPark = bilPark;
    }
}
