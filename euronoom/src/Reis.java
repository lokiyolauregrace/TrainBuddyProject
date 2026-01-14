import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Reis {
    public String vertrek;
    public String aankomst;
    public String datum;
    public Trein trein;
    public ArrayList<Personeel> personeelLijst = new ArrayList<>();
    public ArrayList<Ticket> verkochteTickets = new ArrayList<>();

    public Reis(String vertrek, String aankomst, String datum) {
        this.vertrek = vertrek;
        this.aankomst = aankomst;
        this.datum = datum;
    }

    public void voegTicketToe(Ticket t) {
        if (trein != null && verkochteTickets.size() < trein.berekenCapaciteit()) {
            verkochteTickets.add(t);
            System.out.println("Ticket verkocht aan " + t.passagier.voornaam);
        } else {
            System.out.println("FOUT: Geen plek meer op de trein!");
        }
    }

    public void printBoardingLijst() {
        int bestuurders = 0;
        int stewards = 0;
        for (Personeel p : personeelLijst) {
            if (p.functie.equalsIgnoreCase("Bestuurder")) bestuurders++;
            if (p.functie.equalsIgnoreCase("Steward")) stewards++;
        }

        if (bestuurders < 1 || stewards < 3) {
            System.out.println("Kan niet boarden. Te weinig personeel!");
            return;
        }


        String bestandsnaam = vertrek + "_" + aankomst + "_" + datum + ".txt";
        try {
            FileWriter writer = new FileWriter(bestandsnaam);
            writer.write("Boardinglijst voor " + vertrek + " naar " + aankomst + "\n");
            for (Ticket t : verkochteTickets) {
                writer.write("- " + t.passagier.voornaam + " " + t.passagier.achternaam + "\n");
            }
            writer.close();
            System.out.println("Bestand " + bestandsnaam + " is aangemaakt.");
        } catch (IOException e) {
            System.out.println("Er ging iets mis met het schrijven.");
        }
    }
}