public class Trein {
    public String type;
    public int aantalWagons;
    public int capaciteit;

    public Trein(String type, int gewensteWagons) {
        this.type = type;

        int maxWagons = type.equalsIgnoreCase("Class 373") ? 12 : 14;
        this.aantalWagons = Math.min(gewensteWagons, maxWagons);


        this.capaciteit = 80 + (this.aantalWagons * 50);
    }
}