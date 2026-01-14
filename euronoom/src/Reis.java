import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

    public class Reis {
        public String vertrek;
        public String aankomst;
        public String tijdstip;
        public Trein trein;
        public ArrayList<Passagier> geboektePassagiers = new ArrayList<>();

        public Reis(String vertrek, String aankomst, String tijdstip, Trein trein) {
            this.vertrek = vertrek;
            this.aankomst = aankomst;
            this.tijdstip = tijdstip;
            this.trein = trein;
        }

        public int berekenVrijePlaatsen() {
            return trein.capaciteit - geboektePassagiers.size();
        }

        public void exporteerLijst() {
            String fileName = vertrek + "_" + aankomst + "_" + tijdstip.replace(":", "-") + ".txt";

            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write("EUROMOON BOARDINGLIJST\n");
                writer.write("Route: " + vertrek + " - " + aankomst + " om " + tijdstip + "\n");
                writer.write("------------------------------------\n");
                for (Passagier p : geboektePassagiers) {
                    writer.write(p.voornaam + " " + p.achternaam + " (" + p.email + ")\n");
                }
                System.out.println("Bestand '" + fileName + "' succesvol aangemaakt in je projectmap!");
            } catch (IOException e) {
                System.out.println("Fout bij schrijven naar bestand.");
            }
        }
    }

