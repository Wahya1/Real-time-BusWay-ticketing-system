/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;

/**
 *
 * @author khawl
 */
public class Voyage {
    private static int id=0;
    private int id_voyage ;
    private boolean Fonctionnel;
    private int nbrePlaceDisponible ;
    private Date dateVoyage;
    private Collection<Reservation> reservations;
    private Depart depart;
    private Collection<Arrets> arrets;  // I can find them another way 
    private Arrive arrive;
    private Bus bus ;

    public int getId_voyage() {
        return id_voyage;
    }

    public void setId_voyage(int id_voyage) {
        this.id_voyage = Math.max(id,id_voyage);
    }

    public Date getDateVoyage() {
        return dateVoyage;
    }

    public void setDateVoyage(Date dateVoyage) {
        this.dateVoyage = dateVoyage;
    }

    public Voyage(Date d,Depart depart, Collection<Arrets> arrets, Arrive arrive, Bus bus) {
        this.depart = depart;
        id_voyage=++id;
        this.arrets = arrets;
        this.arrive = arrive;
        this.bus = bus;
        this.reservations =  new ArrayList<Reservation>() ;
        this.Fonctionnel = true;
        this.nbrePlaceDisponible = bus.getNbrePlace();
        this.dateVoyage = d;
    }

    public void setFonctionnel(boolean Fonctionnel) {
        this.Fonctionnel = Fonctionnel;
    }

    public void setNbrePlaceDisponible(int nbrePlaceDisponible) {
        this.nbrePlaceDisponible = nbrePlaceDisponible;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    public void setArrets(Collection<Arrets> arrets) {
        this.arrets = arrets;
    }

    public void setArrive(Arrive arrive) {
        this.arrive = arrive;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public boolean isFonctionnel() {
        return Fonctionnel;
    }

    public int getNbrePlaceDisponible() {
        return nbrePlaceDisponible;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public Depart getDepart() {
        return depart;
    }

    public Collection<Arrets> getArrets() {
        return arrets;
    }

    public Arrive getArrive() {
        return arrive;
    }

    public Bus getBus() {
        return bus;
    }

    
      public String afficherArrets()
    {
        StringBuffer string = new StringBuffer();
        string.append(" [ ");
        if(arrets != null)
        {
            for(Arrets a : arrets)
            {
                string.append(a);
                string.append("->");
            }
            
        }
        string.append(" ] ");
       return string.toString();
    }
    
    @Override
    public String toString() {
        return "Voyage("  + " nbrePlaceDisponible=" + nbrePlaceDisponible
                +   ", depart=" + depart + ", arrets=" + afficherArrets() 
                + ", arrive=" +arrive+')';}

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voyage other = (Voyage) obj;
        if (!Objects.equals(this.dateVoyage, other.dateVoyage)) {
            return false;
        }
        if (!Objects.equals(this.depart, other.depart)) {
            return false;
        }
        return Objects.equals(this.arrive, other.arrive);
    }
    
    
    public void addReservation(Reservation r)
    {
        reservations.add(r);
    }
    
    public boolean verifierVoyage(String d , String a, Date dt)
    {
        return estDisponible() && verifierDepart(d) && verifierArrive(a) && verifierFonctionnel();
    }
    
    public boolean estDisponible()
    {
        return this.nbrePlaceDisponible > 0;
    }
    public boolean verifierDepart(String d) {
    return depart.getStation().getLocal().equals(d) || arrets.stream().anyMatch(arret -> arret.getStation().getLocal().equals(d));
}


public boolean verifierArrive(String a) {
    return arrive.getStation().getLocal().equals(a) || arrets.stream().anyMatch(arret -> arret.getStation().getLocal().equals(a));
}

   public boolean verifiervoyage2(String d, String a, Date dt) {
    // Obtenez la date actuelle du système
    Date dateActuelle = new Date();

    // Vérifiez si la date donnée est la même que la date actuelle
    if (!isSameDay(dt, dateActuelle)) {
       // if()
        // Si c'est le cas, la date est aujourd'hui, donc renvoyez vrai sans vérifier l'heure
        return estDisponible() && verifierDepart(d) && verifierArrive(a) && verifierFonctionnel();
    } else {
        // Sinon, vérifiez si la date de départ est après la date actuelle
        if ((depart.getHeure().after(dateActuelle) && depart.getStation().getLocal().equals(d)) || 
            arrets.stream().anyMatch(arret -> arret.getStation().getLocal().equals(d) && arret.getHeur().after(dateActuelle))) {
            // Si c'est le cas, vérifiez les autres conditions
            return estDisponible() && verifierArrive(a) && verifierFonctionnel();
        } else {
            // Si la date de départ est antérieure à la date actuelle, affichez un message
            return false;
        }
    }
}
    public void ModifierVoyage(Reservation r)
    {
         addReservation(r);
    	 nbrePlaceDisponible -= 1;
         r.setVoyage(this);}
    public boolean verifierFonctionnel()
    {
        return Fonctionnel;
    }
    
    public void update_voyage(Reservation r)
    {
        addReservation(r);
    	 nbrePlaceDisponible -= 1;
    }
     private static boolean isSameDay(Date date1, Date date2) {
        // Créez deux instances de Calendar et initialisez-les avec les dates données
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        // Comparez les années, mois et jours des deux instances de Calendar
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
               cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }


}


