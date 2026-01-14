public abstract class Persoon {
    public String voornaam;
    public String achternaam;
    public String rijksregisternummer;
    public String geboortedatum;


    public Persoon(String voornaam, String achternaam, String rr, String geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.rijksregisternummer = rr;
        this.geboortedatum = geboortedatum;
    }
}
