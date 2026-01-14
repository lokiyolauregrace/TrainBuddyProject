import java.util.Scanner;
import java.util.ArrayList;

public class EuromoonApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Passagier> allePassagiers = new ArrayList<>();
    private static ArrayList<Reis> alleReizen = new ArrayList<>();

    private static Passagier ingelogdePassagier = null;
    private static String geselecteerdeBestemming = null;
    private static Reis geselecteerdeReis = null;
    private static boolean heeftTicketGekocht = false;

    public static void main(String[] args) {
        initialiseerData();
        runApp();
    }

    private static void initialiseerData() {
        Trein t1 = new Trein("Class 374", 10);
        alleReizen.add(new Reis("Brussel", "Londen", "14:00", t1));
        alleReizen.add(new Reis("Brussel", "Parijs", "16:00", t1));
    }

    private static void runApp() {
        while (true) {
            if (ingelogdePassagier == null) {
                toonStartMenu();
            } else if (geselecteerdeBestemming == null) {
                toonBestemmingsMenu();
            } else if (geselecteerdeReis == null) {
                toonTreinMenu();
            } else if (!heeftTicketGekocht) {
                toonTicketKoopMenu();
            } else {
                toonOverzichtMenu();
            }
        }
    }

    private static void toonStartMenu() {
        System.out.println("\n--- EUROMOON WELKOM ---");
        System.out.println("1. Registreren (Account maken)");
        System.out.println("2. Inloggen");
        System.out.println("3. Afsluiten");
        System.out.print("Maak uw keuze: ");
        String keuze = scanner.nextLine();

        if (keuze.equals("1")) {
            toonRegistratieMenu();
        } else if (keuze.equals("2")) {
            toonInlogMenu();
        } else if (keuze.equals("3")) {
            System.exit(0);
        }
    }

    private static void toonRegistratieMenu() {
        System.out.println("\n--- REGISTREREN ---");
        System.out.print("Voornaam: "); String v = scanner.nextLine();
        System.out.print("Achternaam: "); String a = scanner.nextLine();
        System.out.print("Rijksregisternummer: "); String rr = scanner.nextLine();
        System.out.print("Geboortedatum: "); String gb = scanner.nextLine();
        System.out.print("E-mail: "); String email = scanner.nextLine();
        System.out.print("Wachtwoord: "); String ww = scanner.nextLine();

        allePassagiers.add(new Passagier(v, a, rr, gb, email, ww));
        System.out.println("Account succesvol aangemaakt! U kunt nu inloggen.");
    }

    private static void toonInlogMenu() {
        System.out.println("\n--- INLOGGEN ---");
        System.out.print("E-mail: "); String email = scanner.nextLine();
        System.out.print("Wachtwoord: "); String ww = scanner.nextLine();

        for (Passagier p : allePassagiers) {
            if (p.email.equals(email) && p.wachtwoord.equals(ww)) {
                ingelogdePassagier = p;
                System.out.println("U bent succesvol ingelogd.");
                return;
            }
        }
        System.out.println("FOUT: Ongeldige inloggegevens.");
    }

    private static void toonBestemmingsMenu() {
        System.out.println("\n--- BESTEMMING KIEZEN ---");
        System.out.print("Waar wilt u naartoe? (Londen/Parijs): ");
        String keuze = scanner.nextLine();

        boolean geldig = false;
        for (Reis r : alleReizen) {
            if (r.aankomst.equalsIgnoreCase(keuze)) {
                geldig = true;
                break;
            }
        }

        if (geldig) {
            geselecteerdeBestemming = keuze;
        } else {
            System.out.println("FOUT: Geen treinen beschikbaar naar deze bestemming.");
        }
    }

    private static void toonTreinMenu() {
        System.out.println("\n--- TREINBESCHIKBAARHEDEN VOOR " + geselecteerdeBestemming.toUpperCase() + " ---");
        ArrayList<Reis> gevondenReizen = new ArrayList<>();

        for (Reis r : alleReizen) {
            if (r.aankomst.equalsIgnoreCase(geselecteerdeBestemming)) {
                System.out.println("- " + r.tijdstip + " (Vrije plaatsen: " + r.berekenVrijePlaatsen() + ")");
                gevondenReizen.add(r);
            }
        }

        if (gevondenReizen.isEmpty()) {
            System.out.println("Melding: Geen treinen beschikbaar voor deze bestemming.");
            geselecteerdeBestemming = null;
            return;
        }

        System.out.print("Typ het tijdstip om te kiezen (of 'terug'): ");
        String keuze = scanner.nextLine();
        if (keuze.equalsIgnoreCase("terug")) {
            geselecteerdeBestemming = null;
            return;
        }

        for (Reis r : gevondenReizen) {
            if (r.tijdstip.equals(keuze)) {
                geselecteerdeReis = r;
                return;
            }
        }
    }

    private static void toonTicketKoopMenu() {
        System.out.println("\n--- TICKET KOPEN ---");
        System.out.println("Prijs: 50.00 EUR");
        System.out.print("Bevestig aankoop? (JA/NEE): ");
        String keuze = scanner.nextLine();

        if (keuze.equalsIgnoreCase("JA")) {
            heeftTicketGekocht = true;
            geselecteerdeReis.verkochteTickets.add(new Ticket(ingelogdePassagier, 50.0));
            System.out.println("Ticket succesvol gekocht.");
        } else {
            geselecteerdeReis = null;
        }
    }

    private static void toonOverzichtMenu() {
        System.out.println("\n--- OVERZICHT AANKOOP ---");
        System.out.println("Naam: " + ingelogdePassagier.voornaam + " " + ingelogdePassagier.achternaam);
        System.out.println("Route: Brussel -> " + geselecteerdeReis.aankomst);
        System.out.print("Gegevens correct? (Bevestigen/Annuleren): ");
        String keuze = scanner.nextLine();

        if (keuze.equalsIgnoreCase("Annuleren")) {
            geselecteerdeReis.annuleerTicket(ingelogdePassagier);
            heeftTicketGekocht = false;
            geselecteerdeReis = null;
            System.out.println("Ticket geannuleerd.");
        } else {
            for (Ticket t : geselecteerdeReis.verkochteTickets) {
                if (t.passagier.equals(ingelogdePassagier)) {
                    t.bevestigTicket();
                }
            }
            System.out.println("Ticket bevestigd. Goede reis!");
            toonUitlogMenu();
        }
    }

    private static void toonUitlogMenu() {
        System.out.print("\nWilt u uitloggen? (JA/NEE): ");
        String keuze = scanner.nextLine();

        if (keuze.equalsIgnoreCase("JA")) {
            ingelogdePassagier = null;
            geselecteerdeBestemming = null;
            geselecteerdeReis = null;
            heeftTicketGekocht = false;
            System.out.println("U bent uitgelogd.");
        } else {
            System.out.println("U blijft ingelogd.");
        }
    }
}