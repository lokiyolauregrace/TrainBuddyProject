public class Ticket {
    public Passagier passagier;
    public double prijs;
    public boolean isBevestigd;

    public Ticket(Passagier passagier, double prijs) {
        this.passagier = passagier;
        this.prijs = prijs;
        this.isBevestigd = false;
    }

    public void bevestigTicket() {
        this.isBevestigd = true;
    }
}