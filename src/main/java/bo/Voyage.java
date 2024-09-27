/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier.bo;

import java.time.LocalTime;
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
    private Station stationdepart;
    private Station stationarrivee;

    public Station getStationdepart() {
        return stationdepart;
    }

    public void setStationdepart(Station stationdepart) {
        this.stationdepart = stationdepart;
    }

    public Station getStationarrivee() {
        return stationarrivee;
    }

    public void setStationarrivee(Station stationarrivee) {
        this.stationarrivee = stationarrivee;
    }
    private Collection<Arrets> arrets;
    private Collection<Reservation> reservations;
    private LocalTime heuredepart;
    private LocalTime heurearrive;
    private Bus bus ;
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Voyage.id = id;
    }

    public Date getDateVoyage() {
        return dateVoyage;
    }

    public void setDateVoyage(Date dateVoyage) {
        this.dateVoyage = dateVoyage;
    }

    public LocalTime getHeuredepart() {
        return heuredepart;
    }

    public void setHeuredepart(LocalTime heuredepart) {
        this.heuredepart = heuredepart;
    }

    public LocalTime getHeurearrive() {
        return heurearrive;
    }

    public void setHeurearrive(LocalTime heurearrive) {
        this.heurearrive = heurearrive;
    }
   
    

    public int getId_voyage() {
        return id_voyage;
    }

    public void setId_voyage(int id_voyage) {
        this.id_voyage = Math.max(id,id_voyage);
    }

    public Voyage( Date dateVoyage, Station stationdepart, Station stationarrivee, Collection<Arrets> arrets, Collection<Reservation> reservations, LocalTime heuredepart, LocalTime heurearrive, Bus bus) {
        this.dateVoyage = dateVoyage;
        this.stationdepart = stationdepart;
        this.stationarrivee = stationarrivee;
        this.arrets = arrets;
        this.reservations = reservations;
        this.heuredepart = heuredepart;
        this.heurearrive = heurearrive;
        this.bus = bus;
    }

    

    public Voyage(Date d,LocalTime  depart, Collection<Arrets> arrets, LocalTime arrive, Bus bus) {
        this.heuredepart = depart;
        id_voyage=++id;
        this.arrets = arrets;
        this.heurearrive = arrive;
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

   
    public void setArrets(Collection<Arrets> arrets) {
        this.arrets = arrets;
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

   

    public Collection<Arrets> getArrets() {
        return arrets;
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
                +   ",  heure depart=" + heuredepart + ", arrets=" + afficherArrets() 
                + ",  heure  arrive=" +heurearrive+')';}

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
        if (!Objects.equals(this.heuredepart, other.heuredepart)) {
            return false;
        }
        return Objects.equals(this.heurearrive, other.heurearrive);
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
    return stationdepart.getLocal().equals(d) || arrets.stream().anyMatch(arret -> arret.getStation().getLocal().equals(d));
    } 


    public boolean verifierArrive(String a) {
        return stationarrivee.getLocal().equals(a) || arrets.stream().anyMatch(arret -> arret.getStation().getLocal().equals(a));
    }
    
    
    public boolean verifierDepart_verifierArrive(String d, String a, boolean b)
    {
        if(b)
        {
            if(stationdepart.getLocal().equals(d))
            {
                 if(stationarrivee.getLocal().equals(a) || arrets.stream().anyMatch(arret -> arret.getStation().getLocal().equals(a)))
                      return true;
                 else return false;
                   }
                else {
                for(Arrets ar : arrets )
                {
                    if(ar.getStation().getLocal().equals(d)){ 
                       LocalTime H = ar.getHeure();
                       if(stationarrivee.getLocal().equals(a)) return true;
                       else if(arrets.stream().anyMatch(arr -> arr.getStation().getLocal().equals(a) && arr.getHeure().isAfter(H) ) )return true;
                    }else return false;
                }
            }
        }else{
            if(stationdepart.getLocal().equals(d) && heuredepart.isAfter(LocalTime.now()))
                if(stationarrivee.getLocal().equals(a)|| arrets.stream().anyMatch(arret -> arret.getStation().getLocal().equals(a)))return true;
                else return false;
            else {
                 for(Arrets ar : arrets )
                {
                    if(ar.getStation().getLocal().equals(d) && ar.getHeure().isAfter(LocalTime.now())){ 
                        LocalTime H = ar.getHeure();
                       if(stationarrivee.getLocal().equals(a)) return true;
                       else if(arrets.stream().anyMatch(arrive -> arrive.getStation().getLocal().equals(a)) && heurearrive.isAfter(H) )return true;
                    }else return false;
                }
            }    
        }
        return false;
    }
    
    public boolean verifiervoyage2(String d, String a, Date dt) {
        if(PastDay(dt)) 
        {
                  return false;
        }
        else
        // Vérifiez si la date donnée est la même que la date du voyage traitee
        if( SameAsTrip(dt)){
          // Vérifiez si la date donnée est la même que la date actuelle
            if (AnotherDay(dt, new Date()) ) {
                // Si c'est le cas, la date est aujourd'hui, donc renvoyez vrai sans vérifier l'heure
                return estDisponible() && verifierFonctionnel() && verifierDepart_verifierArrive(d,a,true) ;
            } else {
                    return estDisponible() && verifierFonctionnel() && verifierDepart_verifierArrive(d,a,false);
            }
        }else return false;
    }
    
    public void ModifierVoyage(Reservation r)
    {
         addReservation(r);
    	 nbrePlaceDisponible -= 1;
         r.setVoyage(this);
    }
    public boolean verifierFonctionnel()
    {
        return Fonctionnel;
    }
  
    public void update_voyage(Reservation r)
    {
         addReservation(r);
    	 nbrePlaceDisponible -= 1;
    }
    private static boolean AnotherDay(Date date1, Date date2) {
        // Créez deux instances de Calendar et initialisez-les avec les dates données
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        // Comparez les années, mois et jours des deux instances de Calendar
        return !(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH));
    }
    
    private boolean PastDay(Date dt) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dt);
        Calendar cal2 = Calendar.getInstance(); // Obtenez la date actuelle
        cal2.setTime(dateVoyage);
        // Comparaison en ignorant l'heure
        if (cal2.get(Calendar.YEAR) <cal1.get(Calendar.YEAR)) {
            return true;
        } else if (cal2.get(Calendar.YEAR) == cal1.get(Calendar.YEAR)) {
            if (cal2.get(Calendar.MONTH) < cal1.get(Calendar.MONTH)) {
                return true;
            } else if (cal2.get(Calendar.MONTH) == cal1.get(Calendar.MONTH)) {
                if (cal2.get(Calendar.DAY_OF_MONTH) < cal1.get(Calendar.DAY_OF_MONTH)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean SameAsTrip(Date dt)
    {
         Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dt);
        Calendar cal2 = Calendar.getInstance(); // Obtenez la date actuelle
        cal2.setTime(dateVoyage);
        
        // Comparaison en ignorant l'heure
        return cal2.get(Calendar.YEAR) == cal1.get(Calendar.YEAR)&&
               cal2.get(Calendar.MONTH) == cal1.get(Calendar.MONTH) &&
               cal2.get(Calendar.DAY_OF_MONTH) == cal1.get(Calendar.DAY_OF_MONTH);
           
    }
}


