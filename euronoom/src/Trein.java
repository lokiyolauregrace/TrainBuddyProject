public class Trein {
    public String type; // Class 373 of 374
    public int aantalWagons;
    public int capaciteit;

    public Trein(String type, int wagons) {
        this.type = type;

        // Regel: max wagons bepalen op basis van type
        int maxWagons;
        if (type.equals("Class 373")) {
            maxWagons = 12;
        } else {
            maxWagons = 14;
        }

        // Als invoer te hoog is, zetten we het op het maximum
        if (wagons > maxWagons) {
            this.aantalWagons = maxWagons;
        } else {
            this.aantalWagons = wagons;
        }

        // Capaciteit berekenen: 80 in loco + 50 per wagon
        this.capaciteit = 80 + (this.aantalWagons * 50);
    }
}