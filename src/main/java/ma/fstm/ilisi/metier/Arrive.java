/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package ma.fstm.ilisi.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author khawl
 */
public class Arrive {
    private Voyage voyage;
    private Station station;
    private Date heur;

    public Arrive(Voyage voyage, Station station) {
        this.voyage = voyage;
        this.station = station;
    }
     public Arrive( String station,Date d) {
       this.setStation(new Station(station));
      this.heur=d;
       //voyage=null;
    }
    public Voyage getVoyage() {
        return voyage;
    }

    public Station getStation() {
        return station;
    }

    public Date getHeur() {
        return heur;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setHeur(Date heur) {
        this.heur = heur;
    }

    @Override
    public String toString() {
      // Formater la date pour n'afficher que l'heure
         SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String heureFormatee = dateFormat.format(heur);
        return "(" + "" + this.getStation() + " à " + heureFormatee + ")";
    }
   
    
}
