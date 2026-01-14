public class Trein {
    public String type;
    public int aantalWagons;
    public int capaciteit;

    public Trein(String type, int wagons) {
        this.type = type;


        int maxWagons;
        if (type.equals("Class 373")) {
            maxWagons = 12;
        } else {
            maxWagons = 14;
        }


        if (wagons > maxWagons) {
            this.aantalWagons = maxWagons;
        } else {
            this.aantalWagons = wagons;
        }


        this.capaciteit = 80 + (this.aantalWagons * 50);
    }
}