public class Passagier extends Persoon {
    public String email;
    public String wachtwoord;

    // Deze constructor heeft 6 argumenten nodig tussen de haakjes
    public Passagier(String voornaam, String achternaam, String rr, String geboortedatum, String email, String wachtwoord) {
        super(voornaam, achternaam, rr, geboortedatum);
        this.email = email;
        this.wachtwoord = wachtwoord;
    }
}