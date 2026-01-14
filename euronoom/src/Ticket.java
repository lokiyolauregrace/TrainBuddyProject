public class Ticket {
    public Passagier passagier;
    public boolean isEersteKlas;

    public Ticket(Passagier p, boolean eersteKlas) {
        this.passagier = p;
        this.isEersteKlas = eersteKlas;
    }
}