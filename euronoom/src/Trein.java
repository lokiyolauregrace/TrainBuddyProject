public class Trein {
    public String typeLocomotief;
    public int aantalWagons;
    public int maxWagons;

    public Trein(String typeLocomotief, int aantalWagons) {
        this.typeLocomotief = typeLocomotief;


        if (typeLocomotief.equals("Class 373")) {
            this.maxWagons = 12;
        } else {
            this.maxWagons = 14;
        }


        if (aantalWagons > this.maxWagons) {
            this.aantalWagons = this.maxWagons;
        } else {
            this.aantalWagons = aantalWagons;
        }
    }

    public int berekenCapaciteit() {
        return 80 + (aantalWagons * 50);
    }
}

