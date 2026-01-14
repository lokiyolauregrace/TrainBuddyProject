import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Reis {
    public String vertrek;
    public String aankomst;
    public String tijdstip;
    public Trein trein;
    public ArrayList<Ticket> verkochteTickets = new ArrayList<>();
    public ArrayList<Personeel> personeelLijst = new ArrayList<>();

    public Reis(String vertrek, String aankomst, String tijdstip, Trein trein) {
        this.vertrek = vertrek;
        this.aankomst = aankomst;
        this.tijdstip = tijdstip;
        this.trein = trein;
    }

    public int berekenVrijePlaatsen() {

        return trein.capaciteit - verkochteTickets.size();
    }

    public void annuleerTicket(Passagier p) {
        verkochteTickets.removeIf(t -> t.passagier.equals(p));
    }

    public void exporteerLijst() {
        String fileName = aankomst + "_" + tijdstip.replace(":", "-") + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("BOARDINGLIJST " + aankomst + "\n");
            for (Ticket t : verkochteTickets) {
                if (t.isBevestigd) {
                    writer.write(t.passagier.voornaam + " " + t.passagier.achternaam + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Fout bij schrijven.");
        }
    }
}