package ma.fstm.ilisi.controleur;


import ma.fstm.ilisi.metier.bo.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.fstm.ilisi.presentation.AfficherTicket;

public class BusWay {
    private Catalogue catalogue;
   // private Portfeuil portfeuil;

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

//    public Portfeuil getPortfeuil() {
//        return portfeuil;
//    }
//
//    public void setPortfeuil(Portfeuil portfeuil) {
//        this.portfeuil = portfeuil;
//    }
//
public Collection<Voyage> VoyageDisponible(String d, String a, Date dt) {
    Collection<Voyage> voyages_disponibles = new ArrayList<>();
    for(Bus b:catalogue.getBus())
    {
        for (Voyage v : b.getVoyages()) {
            if (v.verifiervoyage2(d, a, dt)) 
            {
                voyages_disponibles.add(v);
            }
        }
        
    }
    return voyages_disponibles;
    }

    public void afficherBus(int n) {
        Collection<Bus> buslist = catalogue.getBus();
        
        new Afficheur().AfficherListBus(buslist, n);
    }

    public void affichervoyage() {
        for(Bus b:catalogue.getBus())
        {
             Collection<Voyage> voyagelist = b.getVoyages();
             new Afficheur().AfficherVoyage(voyagelist);
        }
       
    }

    public static Reservation ReserverVoyage(Voyage v, String n, String d, String a) throws IOException 
     //, WriterException 
    {
        return creerReservation(v, n, d, a);
    }

    public static Reservation creerReservation(Voyage v, String nom, String d, String a) throws IOException
            //, WriterException 
    {
        Reservation R = new Reservation(v, nom,d,a);
     //   ticket ticket = R.creerTicket(R);
       // R.setTicket(ticket);
        v.ModifierVoyage(R);
        return R;
    }

    public static void main(String[] args) throws IOException {
        // Création des conducteurs
        Conducteur C1 = new Conducteur("naima", "daoui", "T311489");
        Conducteur C2 = new Conducteur("Khaoula", "Abassii", "Tss311489");

        // Création des bus
        Bus bus1 = new Bus(1, "ABC123", 50, 5, C1);
        Bus bus2 = new Bus(2, "XYZ789", 60, 6, C2);

        // Création de l'instance de Catalogue et ajout des bus
        Catalogue catalogue = new Catalogue();
        catalogue.ajouterBus(bus1);
        catalogue.ajouterBus(bus2);

        // Création de l'instance de Portfeuil
       // Portfeuil portfeuil = new Portfeuil();
        List<Arrets> arr = new ArrayList<Arrets>();

        // Génération des voyages pour chaque bus
        LocalTime date0 = parseDate("29/04/2024 13:30");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date0);
        Depart depart0 = new Depart("Station A", date0);
        calendar.add(calendar.SECOND, 60);
        Arrive arrivee0 = new Arrive("Station D", calendar.getTime());
        ArrayList<Arrets> arrets0 = new ArrayList<>();
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station B", calendar.getTime())); // Ajout de 30 minutes après le départ
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station C", calendar.getTime())); // Ajout de 90 minutes après le départ
        Voyage voyage0 = new Voyage(depart0.getHeure(), depart0, arrets0, arrivee0, bus1);
        bus1.ajoutervoyagebus(voyage0);
        portfeuil.ajoutervoyage(voyage0);

        date0 = parseDate("29/02/2024 09:15");
        calendar = Calendar.getInstance();
        calendar.setTime(date0);
        depart0 = new Depart("Station A", date0);
        calendar.add(calendar.SECOND, 60);
        arrivee0 = new Arrive("Station D", calendar.getTime());
        arrets0 = new ArrayList<>();
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station B", calendar.getTime())); // Ajout de 30 minutes après le départ
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station C", calendar.getTime())); // Ajout de 90 minutes après le départ
        voyage0 = new Voyage(depart0.getHeure(), depart0, arrets0, arrivee0, bus1);
        bus1.ajoutervoyagebus(voyage0);
        portfeuil.ajoutervoyage(voyage0);

        
        date0 = parseDate("29/02/2024 10:15");
        calendar = Calendar.getInstance();
        calendar.setTime(date0);
        depart0 = new Depart("Station A", date0);
        calendar.add(calendar.SECOND, 60);
        arrivee0 = new Arrive("Station D", calendar.getTime());
        arrets0 = new ArrayList<>();
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station B", calendar.getTime())); // Ajout de 30 minutes après le départ
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station C", calendar.getTime())); // Ajout de 90 minutes après le départ
        voyage0 = new Voyage(depart0.getHeure(), depart0, arrets0, arrivee0, bus1);
        bus1.ajoutervoyagebus(voyage0);
        portfeuil.ajoutervoyage(voyage0);

        date0 = parseDate("29/02/2024 10:15");
        calendar = Calendar.getInstance();
        calendar.setTime(date0);
        depart0 = new Depart("Station A", date0);
        calendar.add(calendar.SECOND, 60);
        arrivee0 = new Arrive("Station D", calendar.getTime());
        arrets0 = new ArrayList<>();
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station B", calendar.getTime())); // Ajout de 30 minutes après le départ
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station C", calendar.getTime())); // Ajout de 90 minutes après le départ
        voyage0 = new Voyage(depart0.getHeure(), depart0, arrets0, arrivee0, bus1);
        bus1.ajoutervoyagebus(voyage0);
        portfeuil.ajoutervoyage(voyage0);

        date0 = parseDate("29/02/2024 12:15");
        calendar = Calendar.getInstance();
        calendar.setTime(date0);
        depart0 = new Depart("Station A", date0);
        calendar.add(calendar.SECOND, 60);
        arrivee0 = new Arrive("Station B", calendar.getTime());
        arrets0 = new ArrayList<>();
        voyage0 = new Voyage(depart0.getHeure(), depart0, arrets0, arrivee0, bus1);
        bus1.ajoutervoyagebus(voyage0);
        portfeuil.ajoutervoyage(voyage0);

        date0 = parseDate("29/04/2024 09:15");
        calendar = Calendar.getInstance();
        calendar.setTime(date0);
        depart0 = new Depart("Station D", date0);
        calendar.add(calendar.SECOND, 60);
        arrivee0 = new Arrive("Station F", calendar.getTime());
        arrets0 = new ArrayList<>();
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station C", calendar.getTime())); // Ajout de 90 minutes après le départ
        voyage0 = new Voyage(depart0.getHeure(), depart0, arrets0, arrivee0, bus1);
        bus1.ajoutervoyagebus(voyage0);
        portfeuil.ajoutervoyage(voyage0);

        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        depart0 = new Depart("Station D", new Date());
        calendar.add(calendar.SECOND, 60);
        arrivee0 = new Arrive("Station F", calendar.getTime());
        arrets0 = new ArrayList<>();
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station C", calendar.getTime())); // Ajout de 90 minutes après le départ
        voyage0 = new Voyage(depart0.getHeure(), depart0, arrets0, arrivee0, bus1);
        bus1.ajoutervoyagebus(voyage0);
        portfeuil.ajoutervoyage(voyage0);
        
        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        depart0 = new Depart("Station A", new Date());
        calendar.add(calendar.SECOND, 60);
        arrivee0 = new Arrive("Station B", calendar.getTime());
        arrets0 = new ArrayList<>();
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station C", calendar.getTime())); // Ajout de 90 minutes après le départ
        voyage0 = new Voyage(depart0.getHeure(), depart0, arrets0, arrivee0, bus1);
        bus1.ajoutervoyagebus(voyage0);
        portfeuil.ajoutervoyage(voyage0);
        
        
        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        depart0 = new Depart("Station B", new Date());
        calendar.add(calendar.SECOND, 60);
        arrivee0 = new Arrive("Station C", calendar.getTime());
        arrets0 = new ArrayList<>();
        calendar.add(calendar.SECOND, 30 * 60 * 1000);
        arrets0.add(new Arrets("Station D", calendar.getTime())); // Ajout de 90 minutes après le départ
        voyage0 = new Voyage(depart0.getHeure(), depart0, arrets0, arrivee0, bus1);
        bus1.ajoutervoyagebus(voyage0);
       // portfeuil.ajoutervoyage(voyage0);

        BusWay busWay = new BusWay();
        busWay.setCatalogue(catalogue);
     //   busWay.setPortfeuil(portfeuil);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Afficher le menu
            System.out.println("\nMenu:");
            System.out.println("1. Afficher les bus ");
            System.out.println("2. Afficher les voyages disponibles");
            System.out.println("3. Rechercher un voyage");
            System.out.println("4. Réserver un billet");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            // Lire le choix de l'utilisateur
            choice = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            // Traitement en fonction du choix
            switch (choice) {
                case 1:
                    busWay.afficherBus(0);
                    break;
                case 2:
                    busWay.affichervoyage();
                    break;
                case 3:
                    System.out.print("Entrez la station de départ : ");
                    String depart = scanner.nextLine();

                    // Demander à l'utilisateur de saisir la station d'arrivée
                    System.out.print("Entrez la station d'arrivée : ");
                    String arrivee = scanner.nextLine();

                    // Demander à l'utilisateur de saisir la date
                    System.out.print("Entrez la date (au format dd/MM/yyyy HH:mm) : ");
                    String dateString = scanner.nextLine();

                    Date date = parseDate(dateString); // Méthode pour convertir la chaîne en objet Date

                    // Test de recherche de voyages disponibles
                    List<Voyage> test = new ArrayList<Voyage>();
                    test = (List<Voyage>) busWay.VoyageDisponible(depart, arrivee, date);
                    if (!test.isEmpty())
                        System.out.println("Voila l'ensemble des voyages allant de " + depart + " à " + arrivee);
                    else
                        System.out.println("pas de voyage trouvee allant de " + depart + " à " + arrivee);

                    new Afficheur().AfficherVoyage(test);
                    break;
                case 4:
                    // Afficher tous les voyages disponibles
                    System.out.print("Entrez la station de départ : ");
                    depart = scanner.nextLine();

                    // Demander à l'utilisateur de saisir la station d'arrivée
                    System.out.print("Entrez la station d'arrivée : ");
                    arrivee = scanner.nextLine();

                    System.out.print("Entrez la date (au format dd/MM/yyyy HH:mm) : ");
                    dateString = scanner.nextLine();

                    date = parseDate(dateString); // Méthode pour convertir la chaîne en objet Date

                    List<Voyage> testt = new ArrayList<Voyage>();
                    testt = (List<Voyage>) busWay.VoyageDisponible(depart, arrivee, date);
                    if (!testt.isEmpty())
                        System.out.println("Voila l'ensemble des voyages allant de " + depart + " à " + arrivee);
                    else
                        System.out.println("pas de voyage trouvee allant de " + depart + " à " + arrivee);

                    new Afficheur().AfficherVoyage(testt);
                    if (!testt.isEmpty()) {
                        // Demander à l'utilisateur de choisir un voyage
                        System.out.print("Veuillez sélectionner le numéro du voyage que vous souhaitez réserver : ");
                        int voyageSelectionne = scanner.nextInt();
                        scanner.nextLine(); // Pour consommer la nouvelle ligne

                        Voyage voyageChoisi = null;
                        // Récupérer le voyage sélectionné
                        for (Voyage v : testt) {
                            if (v.getId_voyage() == voyageSelectionne) {
                                voyageChoisi = v;
                                break;
                            }
                        }
                        
                        System.out.print("Entrez votre nom : ");
                        String nom = scanner.nextLine();

                        Reservation reservation = ReserverVoyage(voyageChoisi, nom, depart, arrivee);
                        System.out.println("Votre réservation a été effectuée avec succès  :");
                        new AfficherTicket(reservation.getTicket()).setVisible(true);
                    }
                    break;

                case 5:
                    System.out.println("Merci d'avoir utilisé notre service. À bientôt !");
                    break;

                default:
                    System.err.println("Choix erroné. Veuillez sélectionner une option valide.");
            }
        } while (choice != 5); // Continuer jusqu'à ce que l'utilisateur choisisse de quitter
    }

    private static Date parseDate(String dateString) {
        SimpleDateFormat format;
        Date date = null;
        try {
            if (dateString.matches("\\d{2}/\\d{2}/\\d{4}\\s+\\d{2}:\\d{2}")) {
                format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            } else {
                format = new SimpleDateFormat("dd/MM/yyyy");
            }
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            date = new Date();
        }
        return date;
    }
    public static Voyage createVoyage(Date date, LocalTime departureTime) {
        Station stationA = new Station("Station A");
        Station stationD = new Station("Station D");
        Arrets arretB = new Arrets("Station B", LocalTime.of(departureTime.getHour(), departureTime.getMinute() + 30));
        Arrets arretC = new Arrets("Station C", LocalTime.of(departureTime.getHour(), departureTime.getMinute() + 90));
        ArrayList<Arrets> arretsList = new ArrayList<>();
        arretsList.add(arretB);
        arretsList.add(arretC);
        
        return new Voyage(date, stationA, stationD, arretsList, null, departureTime, null, null);
    }
}
