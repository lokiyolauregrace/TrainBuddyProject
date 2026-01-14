public class Trein {
    public String type;
    public int aantalWagons;
    public int capaciteit; // Deze variabele ontbrak waarschijnlijk

    public Trein(String type, int gewensteWagons) {
        this.type = type;

        int maxWagons = type.equalsIgnoreCase("Class 373") ? 12 : 14;
        this.aantalWagons = Math.min(gewensteWagons, maxWagons);

        // Berekening op basis van de opdracht: 80 + (wagons * 50)
        this.capaciteit = 80 + (this.aantalWagons * 50);
    }
}