public class Personeel extends Persoon {
    public String functie;
    public String certificaten;

    public Personeel(String voornaam, String achternaam, String rr, String geboortedatum, String functie, String certificaten) {
        super(voornaam, achternaam, rr, geboortedatum);
        this.functie = functie;
        this.certificaten = certificaten;
    }
}