package ma.fstm.ilisi.controleur;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ma.fstm.ilisi.metier.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BusWay {
    private Catalogue catalogue;
    private Portfeuil portfeuil;

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Portfeuil getPortfeuil() {
        return portfeuil;
    }

    public void setPortfeuil(Portfeuil portfeuil) {
        this.portfeuil = portfeuil;
    }
    
    public Collection<Voyage> VoyageDisponible(String d, String a, Date dt) {
        return portfeuil.ChercherVoyageDispo(d, a, dt);
    }
    
    public void afficherBus(int n) {
        Collection<Bus> buslist = catalogue.getBus();
        new Afficheur().AfficherListBus(buslist,n);
    }
    
    
    public void affichervoyage() {
        Collection<Voyage> voyagelist = portfeuil.getVoyages();
        new Afficheur().AfficherVoyage(voyagelist);
    }
   public static Reservation  ReserverVoyage(Voyage v,String n) 
    {
         return creerReservation(v,n);
    }
    
    public static Reservation creerReservation(Voyage v,String nom) 
    {
       // Scanner clavier = new Scanner(System.in);
        //System.out.println("C'est quoi votre nom :");
       // String nom = clavier.next();
        Reservation R = new Reservation(v,nom);
        ticket ticket = R.creerTicket(R);
        R.setTicket(ticket);
        v.ModifierVoyage(R);
       return R;
      }
    public static void main(String[] args) {
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
        Portfeuil portfeuil = new Portfeuil();
        List<Arrets> arr = new ArrayList<Arrets>();
       // arr.add(new Arrets("station B"));

        // Génération des voyages pour chaque bus
        // Voyage 1
        Depart depart1 = new Depart("Station A", new Date());
        Arrive arrivee1 = new Arrive("Station D", new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000));
        ArrayList<Arrets> arrets1 = new ArrayList<>();
       arrets1.add(new Arrets("Station B", new Date(depart1.getHeure().getTime() + 30 * 60 * 1000))); // Ajout de 30 minutes après le départ
arrets1.add(new Arrets("Station C", new Date(depart1.getHeure().getTime() + 90 * 60 * 1000))); // Ajout de 90 minutes après le départ
        Voyage voyage1 = new Voyage(new Date(), depart1, arrets1, arrivee1, bus1);
        bus1.ajoutervoyagebus(voyage1);
        portfeuil.ajoutervoyage(voyage1);

        // Voyage 2
        Depart depart2 = new Depart("Station A", new Date());
        Arrive arrivee2 = new Arrive("Station D", new Date(System.currentTimeMillis() + 3 * 60 * 60 * 1000));
        ArrayList<Arrets> arrets2 = new ArrayList<>();
       arrets2.add(new Arrets("Station E", new Date(depart2.getHeure().getTime() + 30 * 60 * 1000))); // Ajout de 30 minutes après le départ
       arrets2.add(new Arrets("Station F", new Date(depart2.getHeure().getTime() + 90 * 60 * 1000))); // Ajout de 90 minutes après le départ
       arrets2.add(new Arrets("Station G", new Date(depart2.getHeure().getTime() + 120 * 60 * 1000))); // Ajout de 120 minutes après le départ

        Voyage voyage2 = new Voyage(new Date(), depart2, arrets2, arrivee2, bus2);
        bus2.ajoutervoyagebus(voyage2);
        portfeuil.ajoutervoyage(voyage2);

        // Voyage 3
        Depart depart3 = new Depart("Station A", new Date());
        Arrive arrivee3 = new Arrive("Station D", new Date(System.currentTimeMillis() + 3 * 60 * 60 * 1000));
        ArrayList<Arrets> arrets3 = new ArrayList<>();
        arrets3.add(new Arrets("Station H", new Date(depart3.getHeure().getTime() + 30 * 60 * 1000))); // Ajout de 30 minutes après le départ
        arrets3.add(new Arrets("Station I", new Date(depart3.getHeure().getTime() + 90 * 60 * 1000))); // Ajout de 90 minutes après le départ

        Voyage voyage3 = new Voyage(new Date(), depart3, arrets3, arrivee3, bus1);
        bus1.ajoutervoyagebus(voyage3);
        portfeuil.ajoutervoyage(voyage3);

        // Voyage 4
        Depart depart4 = new Depart("Station A", new Date());
        Arrive arrivee4 = new Arrive("Station D", new Date(System.currentTimeMillis() + 4 * 60 * 60 * 1000));
        ArrayList<Arrets> arrets4 = new ArrayList<>();
        arrets4.add(new Arrets("Station J", new Date(depart4.getHeure().getTime() + 30 * 60 * 1000))); // Ajout de 30 minutes après le départ
        arrets4.add(new Arrets("Station K", new Date(depart4.getHeure().getTime() + 90 * 60 * 1000))); // Ajout de 90 minutes après le départ
        arrets4.add(new Arrets("Station L", new Date(depart4.getHeure().getTime() + 120 * 60 * 1000))); // Ajout de 120 minutes après le départ

        Voyage voyage4 = new Voyage(new Date(), depart4, arrets4, arrivee4, bus2);
        bus2.ajoutervoyagebus(voyage4);
        portfeuil.ajoutervoyage(voyage4);

        // Voyage 5
        Depart depart5 = new Depart("Station A", new Date());
        Arrive arrivee5 = new Arrive("Station D", new Date(System.currentTimeMillis() + 5* 60 * 60 * 1000));
        ArrayList<Arrets> arrets5 = new ArrayList<>();
        arrets5.add(new Arrets("Station M", new Date(depart5.getHeure().getTime() + 30 * 60 * 1000))); // Ajout de 30 minutes après le départ
        arrets5.add(new Arrets("Station N", new Date(depart5.getHeure().getTime() + 90 * 60 * 1000))); // Ajout de 90 minutes après le départ
        arrets5.add(new Arrets("Station O", new Date(depart5.getHeure().getTime() + 120 * 60 * 1000))); // Ajout de 120 minutes après le départ
        arrets5.add(new Arrets("Station P", new Date(depart5.getHeure().getTime() + 150 * 60 * 1000))); // Ajout de 150 minutes après le départ

        Voyage voyage5 = new Voyage(new Date(), depart5, arrets5, arrivee5, bus1);
        bus1.ajoutervoyagebus(voyage5);
        portfeuil.ajoutervoyage(voyage5);

        // Création de l'instance de BusWay et assignation du catalogue et du portfeuil
        BusWay busWay = new BusWay();
        busWay.setCatalogue(catalogue);
        busWay.setPortfeuil(portfeuil);

        // Affichage des bus et des voyages
        // busWay.afficherBus();
       // busWay.affichervoyage();
        Scanner scanner = new Scanner(System.in);
         int choice;

        do {
            // Afficher le menu
            System.out.println("\nMenu:");
            System.out.println("1. Afficher les bus disponibles");
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
        // Méthode pour convertir une chaîne en objet Date
      
        Date date = parseDate(dateString); // Méthode pour convertir la chaîne en objet Date

        // Test de recherche de voyages disponibles
        List<Voyage> test = new ArrayList<Voyage>();
                    System.out.println("Voila l'ensemble des voyages allant de "+depart+" à "+arrivee);
        test = (List<Voyage>) busWay.VoyageDisponible(depart, arrivee, date);
        new Afficheur().AfficherVoyage(test);
                    break;
               case 4:
    // Afficher tous les voyages disponibles
     System.out.print("Entrez la station de départ : ");
         depart = scanner.nextLine();

        // Demander à l'utilisateur de saisir la station d'arrivée
        System.out.print("Entrez la station d'arrivée : ");
        arrivee = scanner.nextLine();

        // Demander à l'utilisateur de saisir la date
        System.out.print("Entrez la date (au format dd/MM/yyyy HH:mm) : ");
        dateString = scanner.nextLine();
        // Méthode pour convertir une chaîne en objet Date
      
         date = parseDate(dateString); // Méthode pour convertir la chaîne en objet Date

        // Test de recherche de voyages disponibles
               //test.clear();
             List<Voyage>  testt= new ArrayList<Voyage>();
               System.out.println("Voila l'ensemble des voyages allant de "+depart+" à "+arrivee);
               testt = (List<Voyage>) busWay.VoyageDisponible(depart, arrivee, date);
               new Afficheur().AfficherVoyage(testt);
    
             // Demander à l'utilisateur de choisir un voyage
    System.out.print("Veuillez sélectionner le numéro du voyage que vous souhaitez réserver : ");
    int voyageSelectionne = scanner.nextInt();
    scanner.nextLine(); // Pour consommer la nouvelle ligne
    
    // Récupérer le voyage sélectionné
    Voyage voyageChoisi = testt.get(voyageSelectionne - 1); // -1 car les indices commencent à 0
    
    // Demander à l'utilisateur de saisir le nom
    System.out.print("Entrez votre nom : ");
    String nom = scanner.nextLine();
    
    // Réserver le voyage choisi
    Reservation reservation = ReserverVoyage(voyageChoisi,nom);
    System.out.println("Votre réservation a été effectuée avec succès ! Voici les détails :");
    //  System.out.println(reservation); // Vous pouvez personnaliser l'affichage de la réservation si nécessaire
    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choice != 5); // Continuer jusqu'à ce que l'utilisateur choisisse de quitter
    }
        // Demander à l'utilisateur de saisir la station de départ
    
    
    private static Date parseDate(String dateString)
    {
        SimpleDateFormat format;
        Date date=null;
        try {
            if(dateString.matches("\\d{2}/\\d{2}/\\d{4}\\s+\\d{2}:\\d{2}")){
                format=new SimpleDateFormat("dd/MM/yyyy HH:mm");
            }else {
                format=new SimpleDateFormat("dd/MM/yyyy");
            }
            date=format.parse(dateString);
            
        }catch(ParseException e)
        {
            e.printStackTrace();
        }
        if(date==null)
        {
            date=new Date();
            
        }
        return date;
    }
}

